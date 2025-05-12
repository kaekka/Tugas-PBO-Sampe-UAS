package Kelompok5.PBO.Novel_Web.utils;

public class NovelFunction  {
    public static void tampilkanHeader() {
        System.out.println("╔" + "═".repeat(40) + "╗");
        System.out.println("║           WELCOME TO NOVELKU           ║");
        System.out.println("║     By : Muhammad Dwi Saputra          ║");
        System.out.println("║             (24111814080)              ║");

        System.out.println("╚" + "═".repeat(40) + "╝");
        
    }

    public static void tampilkanFooter() {
        System.out.println("\n╔" + "═".repeat(40) + "╗");
        System.out.println("║       Terima Kasih Sampai Jumpa!       ║");
        System.out.println("╚" + "═".repeat(40) + "╝\n");
    }

    public static void tampilkanMenu() {
        System.out.println("\n╔" + "═".repeat(40) + "╗");
        System.out.println("║              MENU NOVELKU              ║");
        System.out.println("╠" + "═".repeat(40) + "╣");
        System.out.println("║ 1. Cari berdasarkan Judul              ║");
        System.out.println("║ 2. Cari berdasarkan Genre              ║");
        System.out.println("║ 3. Daftar Semua Novel                  ║");
        System.out.println("║ 4. Daftar Novel Urut Harga             ║");
        System.out.println("║ 5. Daftar Novel Best Seller            ║");
        System.out.println("║ 6. Daftar Novel Digital                ║");
        System.out.println("║ 7. Novel yang Sedang Diskon            ║");
        System.out.println("║ 8. Keluar                              ║");
        System.out.println("╚" + "═".repeat(40) + "╝");
    }
}
