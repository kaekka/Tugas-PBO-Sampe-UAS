# 📚 NovelKu

Aplikasi berbasis Java untuk mengelola dan menampilkan data novel dengan berbagai fitur pencarian dan penyaringan.

---

## 🔍 Fitur

- 🔎 Cari berdasarkan **Judul**
- 🎭 Cari berdasarkan **Genre**
- 📋 Tampilkan **Semua Novel**
- 💰 Tampilkan Novel urut berdasarkan **Harga**
- 🌟 Daftar **Novel Best Seller**
- 📱 Daftar **Novel Digital**
- 🏷️ Daftar Novel yang sedang **Diskon**

---


## ▶️ Cara Menjalankan

1. Pastikan Java sudah terinstal di komputer Anda.
2. Buka terminal di folder root proyek.
3. Buat folder `bin` (hanya sekali):
   ```bash
   mkdir bin
   javac -d bin src/novel/*.java src/App/Main.java
   java -cp bin App.Main
