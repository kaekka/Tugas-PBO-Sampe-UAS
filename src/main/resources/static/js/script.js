// Toggle class active
const navbarNav = document.querySelector('.navbar-nav');
// ketika hamburger menu di klik
document.querySelector('#hamburger-menu').onclick = () => {
  navbarNav.classList.toggle('active');
};

//Klik di luar sidebar untuk menghilangkan nav 
const hamburger = document.querySelector('#hamburger-menu');

document.addEventListener('click', function (e) {
  if (!hamburger.contains(e.target) && !navbarNav.contains(e.target)) {
    navbarNav.classList.remove('active');
  }
});

const container = document.getElementById('scrollContainer');

function scrollBooks(direction) {
  container.scrollBy({ left: direction * 600, behavior: 'smooth' });
}

let isDown = false;
let startX;
let scrollLeft;

container.addEventListener('mousedown', (e) => {
  isDown = true;
  container.classList.add('active');
  startX = e.pageX - container.offsetLeft;
  scrollLeft = container.scrollLeft;
});

container.addEventListener('mouseleave', () => {
  isDown = false;
  container.classList.remove('active');
});

container.addEventListener('mouseup', () => {
  isDown = false;
  container.classList.remove('active');
});

container.addEventListener('mousemove', (e) => {
  if (!isDown) return;
  e.preventDefault();
  const x = e.pageX - container.offsetLeft;
  const walk = x - startX;
  container.scrollLeft = scrollLeft - walk;
});

$(document).ready(function () {
  const input = $('.search-wrapper input');
  const suggestionBox = $('<ul class="list-group position-absolute w-100 mt-1 bg-white shadow" style="z-index: 999;"></ul>');
  $('.search-wrapper').append(suggestionBox);
  suggestionBox.hide();

  input.on('input', function () {
    const query = $(this).val().trim();

    if (query.length === 0) {
      suggestionBox.hide();
      return;
    }

    $.ajax({
      url: '/search',
      type: 'GET',
      data: { query: query },
      success: function (data) {
        suggestionBox.empty();

        if (!data || data.length === 0) {
          suggestionBox.hide();
          return;
        }

        data.forEach(function (novel) {
          const listItem = $(`
              <li class="list-group-item list-group-item-action d-flex align-items-center gap-2">
                <img src="${novel.cover}" alt="cover" width="40" height="60" style="object-fit: cover; border-radius: 4px;">
                <span>${novel.judul}</span>
              </li>
            `);

          // Isi input saat diklik
          listItem.on('click', function () {
            input.val(novel.judul);
            suggestionBox.hide();
          });

          suggestionBox.append(listItem);
        });

        suggestionBox.show();
      },
      error: function () {
        suggestionBox.hide();
      }
    });
  });

  // Tutup jika klik di luar
  $(document).on('click', function (e) {
    if (!$(e.target).closest('.search-wrapper').length) {
      suggestionBox.hide();
    }
  });
});
