
document.addEventListener('DOMContentLoaded', function () {

    // ==============================================
    // BAGIAN UNTUK TOMBOL SUKA (HATI)
    // ==============================================
    const allLikeButtons = document.querySelectorAll('.like-btn');
    allLikeButtons.forEach(button => {
        button.addEventListener('mousedown', function (event) {
            event.stopPropagation();
            const novelId = event.currentTarget.dataset.novelId;
            const clickedButton = event.currentTarget;

            fetch(`/api/like/${novelId}`, { method: 'POST' })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Server response was not OK.');
                    }
                    return response.json();
                })
                .then(data => {
                    let message = "";
                    if (data.isLiked) {
                        clickedButton.classList.add('liked');
                        message = "Novel ditambahkan ke koleksi!";
                    } else {
                        clickedButton.classList.remove('liked');
                        message = "Novel dihapus dari koleksi.";

                        // --- LOGIKA BARU YANG LEBIH PINTAR ---
                        // HANYA jalankan penghapusan jika kita berada di halaman koleksi favorit
                        if (document.body.id === 'page-koleksi-favorit') {
                            const novelCardWrapper = clickedButton.closest('.col-lg-3.col-md-4.col-sm-6');
                            if (novelCardWrapper) {
                                novelCardWrapper.style.transition = 'opacity 0.4s ease';
                                novelCardWrapper.style.opacity = '0';

                                setTimeout(() => {
                                    novelCardWrapper.remove();
                                    const remainingCards = document.querySelectorAll('.book-card-koleksi');
                                    if (remainingCards.length === 0) {
                                        const emptyMessage = document.getElementById('empty-collection-message');
                                        if (emptyMessage) {
                                            emptyMessage.style.display = 'block';
                                        }
                                    }
                                }, 400);
                            }
                        }
                    }
                    showToast(message);
                })
                .catch(error => {
                    console.error('Error liking novel:', error);
                    showToast('Terjadi kesalahan.');
                });
        });
    });


    // ==============================================
    // BAGIAN UNTUK TOMBOL TAMBAH KE KERANJANG
    // ==============================================
    const cartNavIcon = document.getElementById('cart-icon-nav');
    const allAddToCartButtons = document.querySelectorAll('.add-to-cart-btn');

    allAddToCartButtons.forEach(button => {
        button.addEventListener('mousedown', function (event) {
            event.stopPropagation();

            const novelId = event.currentTarget.dataset.novelId;
            let novelImg = null;

            // Mencari gambar untuk animasi dengan cara yang lebih fleksibel
            const cardElement = event.currentTarget.closest('.novel-card, .book-card-koleksi');
            const detailContainer = event.currentTarget.closest('.detail-container'); // <<< PERBAIKAN 1

            if (cardElement) {
                // Jika tombol ada di dalam kartu (halaman utama/koleksi)
                novelImg = cardElement.querySelector('.novel-cover, .book-cover');
            } else if (detailContainer) {
                // Jika tombol ada di halaman detail
                novelImg = detailContainer.querySelector('.detail-cover img'); // <<< PERBAIKAN 2
            }

            // Hanya jalankan animasi jika gambar ditemukan
            if (novelImg) {
                flyToCart(novelImg);
            }

            // Tetap jalankan fungsi fetch untuk menambah ke keranjang
            fetch(`/api/keranjang/tambah/${novelId}`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' }
            })
                .then(response => response.json())
                .then(data => {
                    if (data.success) {
                        showToast(data.message);
                    } else {
                        showToast('Gagal menambahkan novel!');
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                    showToast('Terjadi kesalahan.');
                });
        });
    });


    function flyToCart(imgElement) {
        if (!imgElement || !cartNavIcon) {
            console.error("Elemen gambar atau ikon keranjang tidak ditemukan!");
            return;
        }
        const imgClone = imgElement.cloneNode(true);
        const startRect = imgElement.getBoundingClientRect();
        imgClone.classList.add('flying-novel-img');
        imgClone.style.top = startRect.top + 'px';
        imgClone.style.left = startRect.left + 'px';
        imgClone.style.width = startRect.width + 'px';
        imgClone.style.height = startRect.height + 'px';
        document.body.appendChild(imgClone);

        requestAnimationFrame(() => {
            const endRect = cartNavIcon.getBoundingClientRect();
            imgClone.style.top = (endRect.top + endRect.height / 2) + 'px';
            imgClone.style.left = (endRect.left + endRect.width / 2) + 'px';
            imgClone.style.width = '0px';
            imgClone.style.height = '0px';
            imgClone.style.opacity = '0';
        });

        setTimeout(() => { imgClone.remove(); }, 700);
    }

    function showToast(message) {
        const toast = document.getElementById('toast-notification');
        if (!toast) return;
        toast.textContent = message;
        toast.classList.add('show');
        setTimeout(() => { toast.classList.remove('show'); }, 3000);
    }

});