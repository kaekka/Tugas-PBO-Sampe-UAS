package App;

import java.util.ArrayList;
import java.util.Scanner;
import novel.Novel; // import kelas Novel
import novel.NovelBestSeller; // import kelas NovelBestSeller
import novel.NovelDigital;  // Import kelas NovelDigital

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Novel> listNovel = new ArrayList<>();
            // Menambahkan novel biasa
            listNovel.add(new Novel("Solo Leveling", "fantasi", 95000, 10, 2021, 300));
            listNovel.add(new Novel("The Lord of the Rings", "adventure", 70000, 0, 1954, 450));
            listNovel.add(new Novel("The Godfather", "crime", 50000, 0, 1969, 400));
            listNovel.add(new Novel("Omniscient Reader's Viewpoint", "modern", 78000, 8, 2021, 450));
            listNovel.add(new Novel("3726 mdpl", "romance", 85000, 0, 2019, 350));
            listNovel.add(new Novel("Danur", "horror", 60000, 0, 2017, 320));
            listNovel.add(new Novel("The Chronicles of Narnia", "fantasi", 72000, 0, 1950, 420));
            listNovel.add(new Novel("Dilan: Dia adalah Dilanku tahun 1990", "romance", 55000, 0, 2018, 300));

            // Menambahkan novel best seller
            ArrayList<NovelBestSeller> listBestSeller = new ArrayList<>();
            listBestSeller.add(new NovelBestSeller("Harry Potter", "fantasi", 100000, 0, 1997, 500));
            listBestSeller.add(new NovelBestSeller("Laskar Pelangi", "inspiratif", 58000, 10, 2005, 400));

            // Menambahkan novel digital
            ArrayList<NovelDigital> listDigital = new ArrayList<>();
            listDigital.add(new NovelDigital("Ebook Adventure", "fantasi", 60000, 0, 2022, 300));
            listDigital.add(new NovelDigital("Digital Mystery", "thriller", 55000, 15, 2021, 350));
            listDigital.add(new NovelDigital("Sci-Fi Saga", "science fiction", 70000, 0, 2023, 400));

            tampilkanHeader();

            while (true) {
                tampilkanMenu();
                System.out.print("Masukkan pilihan (1-8): ");

                // Mengecek apakah input adalah angka
                if (!scanner.hasNextInt()) {
                    System.out.println("Pilihan tidak valid! Harap masukkan angka antara 1-8.");
                    scanner.next(); // Membersihkan input jika salah
                    continue;
                }

                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 ->
                        cariNovelByJudul(scanner, listNovel, listBestSeller, listDigital);
                    case 2 ->
                        cariNovelByGenre(scanner, listNovel, listBestSeller, listDigital);
                    case 3 ->
                        tampilkanDaftarNovel(listNovel, listBestSeller, listDigital);
                    case 4 ->
                        tampilkanDaftarNovelSorted(listNovel, listBestSeller, listDigital);
                    case 5 ->
                        tampilkanDaftarNovelBestSeller(listBestSeller);
                    case 6 ->
                        tampilakanDaftarNovelDigital(listDigital);
                    case 7 ->
                        tampilkanNovelDiskon(listNovel, listBestSeller, listDigital);
                    case 8 -> {
                        tampilkanFooter();
                        return;
                    }
                    default ->
                        System.out.println("Pilihan tidak ada di menu! Silakan masukkan angka 1-8.");
                }
            }
        }
    }

    private static void tampilkanHeader() {
        System.out.println("╔" + "═".repeat(40) + "╗");
        System.out.println("║           WELCOME TO NOVELKU           ║");
        System.out.println("║     By : Muhammad Dwi Saputra          ║");
        System.out.println("║             (24111814080)              ║");

        System.out.println("╚" + "═".repeat(40) + "╝");
    }

    private static void tampilkanFooter() {
        System.out.println("\n╔" + "═".repeat(40) + "╗");
        System.out.println("║       Terima Kasih Sampai Jumpa!       ║");
        System.out.println("╚" + "═".repeat(40) + "╝\n");
    }

    private static void tampilkanMenu() {
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

    //case 1
    private static void cariNovelByJudul(
            Scanner scanner,
            ArrayList<Novel> listNovel,
            ArrayList<NovelBestSeller> listBestSeller,
            ArrayList<NovelDigital> listDigital) {

        String garisAtas = "╔" + "═".repeat(93) + "╗";
        String garisTengah = "╠" + "═".repeat(93) + "╣";
        String garisBawah = "╚" + "═".repeat(93) + "╝";
        String judulTabel = " MASUKKAN JUDUL NOVEL YANG INGIN DICARI ";
        int padding = (93 - judulTabel.length()) / 2;

        // Tampilan input dalam tabel
        System.out.println("\n" + garisAtas);
        System.out.printf("║%" + padding + "s%s%" + (93 - padding - judulTabel.length()) + "s║\n", "", judulTabel, "");
        System.out.println(garisTengah);
        System.out.printf("║ %-91s ║\n", "Masukkan judul novel yang dicari:");
        System.out.println(garisBawah);
        System.out.print(">> ");
        String judulDicari = scanner.nextLine();

        // Gabungkan semua novel
        ArrayList<Novel> semuaNovel = new ArrayList<>(listNovel);
        semuaNovel.addAll(listBestSeller);
        semuaNovel.addAll(listDigital);

        Novel hasil = Novel.cariNovelByJudul(semuaNovel, judulDicari);

        // Tampilkan hasil
        String hasilHeader = " HASIL PENCARIAN NOVEL BERDASARKAN JUDUL ";
        int hasilPadding = (93 - hasilHeader.length()) / 2;

        System.out.println("\n" + garisAtas);
        System.out.printf("║%" + hasilPadding + "s%s%" + (93 - hasilPadding - hasilHeader.length()) + "s║\n", "", hasilHeader, "");
        System.out.println(garisTengah);
        System.out.printf("║ %-38s │ %-15s │ %-13s │ %-6s │ %-6s ║\n",
                "Judul", "Genre", "Harga", "Tahun", "Halaman");
        System.out.println(garisTengah);

        if (hasil != null) {
            System.out.printf("║ %-38s │ %-15s │ Rp %,10.0f │ %-6d │ %-7d ║\n",
                    hasil.getJudul(),
                    hasil.getGenre(),
                    hasil.getHarga(),
                    hasil.getTahunTerbit(),
                    hasil.getJumlahHalaman());
            System.out.println(garisBawah);
        } else {
            System.out.printf("║ %-38s │ %-15s │ %-13s │ %-6s │ %-7s ║\n",
                    "-", "-", "-", "-", "-");
            System.out.println(garisTengah);
            String keterangan = "Novel dengan judul \"" + judulDicari + "\" tidak ditemukan.";
            System.out.printf("║ %-91s ║\n", keterangan);
            System.out.println(garisBawah);
        }
    }

    //case 2
    private static void cariNovelByGenre(
            Scanner scanner,
            ArrayList<Novel> listNovel,
            ArrayList<NovelBestSeller> listBestSeller,
            ArrayList<NovelDigital> listDigital) {

        String garisAtas = "╔" + "═".repeat(93) + "╗";
        String garisTengah = "╠" + "═".repeat(93) + "╣";
        String garisBawah = "╚" + "═".repeat(93) + "╝";
        String judulTabel = " MASUKKAN GENRE NOVEL YANG INGIN DICARI ";
        int padding = (93 - judulTabel.length()) / 2;

        // Tampilan input dalam tabel
        System.out.println("\n" + garisAtas);
        System.out.printf("║%" + padding + "s%s%" + (93 - padding - judulTabel.length()) + "s║\n", "", judulTabel, "");
        System.out.println(garisTengah);
        System.out.printf("║ %-91s ║\n", "Masukkan genre novel yang dicari:");
        System.out.println(garisBawah);
        System.out.print(">> ");
        String genreDicari = scanner.nextLine().toLowerCase();

        // Gabungkan semua novel
        ArrayList<Novel> semuaNovel = new ArrayList<>(listNovel);
        semuaNovel.addAll(listBestSeller);
        semuaNovel.addAll(listDigital);

        // Filter berdasarkan genre
        ArrayList<Novel> hasilGenre = new ArrayList<>();
        for (Novel novel : semuaNovel) {
            if (novel.getGenre().toLowerCase().contains(genreDicari)) {
                hasilGenre.add(novel);
            }
        }

        // Tampilkan hasil
        String hasilHeader = " HASIL PENCARIAN NOVEL BERDASARKAN GENRE ";
        int hasilPadding = (93 - hasilHeader.length()) / 2;

        System.out.println("\n" + garisAtas);
        System.out.printf("║%" + hasilPadding + "s%s%" + (93 - hasilPadding - hasilHeader.length()) + "s║\n", "", hasilHeader, "");
        System.out.println(garisTengah);
        System.out.printf("║ %-15s │ %-38s │ %-13s │ %-6s │ %-6s ║\n",
                "Genre", "Judul", "Harga", "Tahun", "Halaman");
        System.out.println(garisTengah);

        if (!hasilGenre.isEmpty()) {
            for (Novel novel : hasilGenre) {
                System.out.printf("║ %-15s │ %-38s │ Rp %,10.0f │ %-6d │ %-7d ║\n",
                        novel.getGenre(),
                        novel.getJudul(),
                        novel.getHarga(),
                        novel.getTahunTerbit(),
                        novel.getJumlahHalaman());
            }
            System.out.println(garisBawah);
        } else {
            System.out.printf("║ %-15s │ %-38s │ %-13s │ %-6s │ %-7s ║\n",
                    "-", "-", "-", "-", "-");
            System.out.println(garisTengah);
            String keterangan = "Novel dengan genre \"" + genreDicari + "\" tidak ditemukan.";
            System.out.printf("║ %-91s ║\n", keterangan);
            System.out.println(garisBawah);
        }
    }

    //case 3
    private static void tampilkanDaftarNovel(
            ArrayList<Novel> listNovel,
            ArrayList<NovelBestSeller> listBestSeller,
            ArrayList<NovelDigital> listDigital) {

        ArrayList<Novel> semuaNovel = new ArrayList<>();
        semuaNovel.addAll(listNovel);
        semuaNovel.addAll(listBestSeller);
        semuaNovel.addAll(listDigital);

        String garisAtas = "╔" + "═".repeat(93) + "╗";
        String garisTengah = "╠" + "═".repeat(93) + "╣";
        String garisBawah = "╚" + "═".repeat(93) + "╝";

        System.out.println("\n" + garisAtas);

        String judul = " DAFTAR NOVEL ";
        int lebarKolom = 93;
        int paddingKiri = (lebarKolom - judul.length()) / 2;
        int paddingKanan = lebarKolom - paddingKiri - judul.length();
        System.out.printf("║%" + paddingKiri + "s%s%" + paddingKanan + "s║\n", "", judul, "");

        System.out.println(garisTengah);
        System.out.printf("║ %-38s │ %-15s │ %-13s │ %-6s │ %-6s ║\n",
                "Judul", "Genre", "Harga", "Tahun", "Halaman");
        System.out.println(garisTengah);

        for (Novel novel : semuaNovel) {
            System.out.printf("║ %-38s │ %-15s │ Rp %,10.0f │ %-6d │ %-7d ║\n",
                    novel.getJudul(),
                    novel.getGenre(),
                    novel.getHarga(),
                    novel.getTahunTerbit(),
                    novel.getJumlahHalaman());
        }

        System.out.println(garisBawah);
    }

    //case 4
    private static void tampilkanDaftarNovelSorted(
            ArrayList<Novel> listNovel,
            ArrayList<NovelBestSeller> listBestSeller,
            ArrayList<NovelDigital> listDigital) {

        ArrayList<Novel> semuaNovel = new ArrayList<>();
        semuaNovel.addAll(listNovel);
        semuaNovel.addAll(listBestSeller);
        semuaNovel.addAll(listDigital);

        // Sorting berdasarkan harga
        semuaNovel.sort((n1, n2) -> Double.compare(n1.getHarga(), n2.getHarga()));

        String garisAtas = "╔" + "═".repeat(93) + "╗";
        String garisTengah = "╠" + "═".repeat(93) + "╣";
        String garisBawah = "╚" + "═".repeat(93) + "╝";

        System.out.println("\n" + garisAtas);
        String judul = " DAFTAR NOVEL ";
        int lebarKolom = 93;
        int paddingKiri = (lebarKolom - judul.length()) / 2;
        int paddingKanan = lebarKolom - paddingKiri - judul.length();
        System.out.printf("║%" + paddingKiri + "s%s%" + paddingKanan + "s║\n", "", judul, "");

        System.out.println(garisTengah);
        System.out.printf("║ %-38s │ %-15s │ %-13s │ %-6s │ %-6s ║\n",
                "Judul", "Genre", "Harga", "Tahun", "Halaman");

        System.out.println(garisTengah);

        for (Novel novel : semuaNovel) {
            System.out.printf("║ %-38s │ %-15s │ Rp %,10.0f │ %-6d │ %-7d ║\n",
                    novel.getJudul(),
                    novel.getGenre(),
                    novel.getHarga(),
                    novel.getTahunTerbit(),
                    novel.getJumlahHalaman());
        }

        System.out.println(garisBawah);
    }

    //case 5
    private static void tampilkanDaftarNovelBestSeller(ArrayList<NovelBestSeller> listBestSeller) {
        String garisAtas = "╔" + "═".repeat(93) + "╗";
        String garisTengah = "╠" + "═".repeat(93) + "╣";
        String garisBawah = "╚" + "═".repeat(93) + "╝";

        System.out.println("\n" + garisAtas);

        String judul = "DAFTAR NOVEL BEST SELLER";
        int padding = (93 - judul.length()) / 2;
        String judulTengah = " ".repeat(padding) + judul + " ".repeat(93 - padding - judul.length());
        System.out.printf("║%s║\n", judulTengah);

        System.out.println(garisTengah);
        System.out.printf("║ %-38s │ %-15s │ %-13s │ %-6s │ %-6s ║\n",
                "Judul", "Genre", "Harga", "Tahun", "Halaman");
        System.out.println(garisTengah);

        for (NovelBestSeller novel : listBestSeller) {
            System.out.printf("║ %-38s │ %-15s │ Rp %,10.0f │ %-6d │ %-7d ║\n",
                    novel.getJudul(),
                    novel.getGenre(),
                    novel.getHarga(),
                    novel.getTahunTerbit(),
                    novel.getJumlahHalaman());
        }

        System.out.println(garisBawah);
    }

    //case 6
    private static void tampilakanDaftarNovelDigital(ArrayList<NovelDigital> listDigital) {
        String garisAtas = "╔" + "═".repeat(93) + "╗";
        String garisTengah = "╠" + "═".repeat(93) + "╣";
        String garisBawah = "╚" + "═".repeat(93) + "╝";

        System.out.println("\n" + garisAtas);
        String judul = "DAFTAR NOVEL DIGITAL";
        int totalWidth = 93;
        int padding = (totalWidth - judul.length()) / 2;
        System.out.printf("║%" + padding + "s%s%" + (totalWidth - padding - judul.length()) + "s║\n", "", judul, "");
        System.out.println(garisTengah);
        System.out.printf("║ %-38s │ %-15s │ %-13s │ %-6s │ %-6s ║\n",
                "Judul", "Genre", "Harga", "Tahun", "Halaman");
        System.out.println(garisTengah);

        for (NovelDigital novel : listDigital) {
            System.out.printf("║ %-38s │ %-15s │ Rp %,10.0f │ %-6d │ %-7d ║\n",
                    novel.getJudul(),
                    novel.getGenre(),
                    novel.getHarga(),
                    novel.getTahunTerbit(),
                    novel.getJumlahHalaman());
        }

        System.out.println(garisBawah);
    }

    //case 7
    private static void tampilkanNovelDiskon(
            ArrayList<Novel> listNovel,
            ArrayList<NovelBestSeller> listBestSeller,
            ArrayList<NovelDigital> listDigital) {

        ArrayList<Novel> semuaDiskon = new ArrayList<>();
        listNovel.stream().filter(n -> n.getDiskon() > 0).forEach(semuaDiskon::add);
        listBestSeller.stream().filter(n -> n.getDiskon() > 0).forEach(semuaDiskon::add);
        listDigital.stream().filter(n -> n.getDiskon() > 0).forEach(semuaDiskon::add);

        String garisAtas = "╔" + "═".repeat(105) + "╗";
        String garisTengah = "╠" + "═".repeat(105) + "╣";
        String garisBawah = "╚" + "═".repeat(105) + "╝";

        System.out.println("\n" + garisAtas);
        String judul = "DAFTAR NOVEL DISKON";
        int totalWidth = 105;
        int padding = (totalWidth - judul.length()) / 2;
        System.out.printf("║%" + padding + "s%s%" + (totalWidth - padding - judul.length()) + "s║\n", "", judul, "");
        System.out.println(garisTengah);
        System.out.printf("║ %-30s │ %-10s │ %-12s │ %-6s │ %-7s │ %-7s │ %-13s ║\n",
                "Judul", "Genre", "Harga Normal", "Tahun", "Halaman", "Diskon", "Harga Diskon");
        System.out.println(garisTengah);

        for (Novel novel : semuaDiskon) {
            double harga = novel.getHarga();
            int diskon = novel.getDiskon();
            double hargaSetelahDiskon = harga - (harga * diskon / 100.0);

            System.out.printf("║ %-30s │ %-10s │ Rp %,9.0f │ %-6d │ %-7d │ %5d%% │ Rp %,11.0f ║\n",
                    novel.getJudul(),
                    novel.getGenre(),
                    harga,
                    novel.getTahunTerbit(),
                    novel.getJumlahHalaman(),
                    diskon,
                    hargaSetelahDiskon);
        }

        System.out.println(garisBawah);
    }

}
