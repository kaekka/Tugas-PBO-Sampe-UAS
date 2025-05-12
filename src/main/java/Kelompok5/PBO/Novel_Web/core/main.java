package Kelompok5.PBO.Novel_Web.core;

import java.util.ArrayList;
import java.util.Scanner;

import Kelompok5.PBO.Novel_Web.models.Novel;
import Kelompok5.PBO.Novel_Web.models.NovelBestSeller;
import Kelompok5.PBO.Novel_Web.models.NovelDigital;

public class main {
    static {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Novel> listNovel = new ArrayList<>();
            listNovel.add(new Novel("Solo Leveling", "fantasi", 95000, 10, 2021, 300));
            listNovel.add(new Novel("The Lord of the Rings", "adventure", 70000, 0, 1954, 450));
            listNovel.add(new Novel("The Godfather", "crime", 50000, 0, 1969, 400));
            listNovel.add(new Novel("Omniscient Reader's Viewpoint", "modern", 78000, 8, 2021, 450));
            listNovel.add(new Novel("3726 mdpl", "romance", 85000, 0, 2019, 350));
            listNovel.add(new Novel("Danur", "horror", 60000, 0, 2017, 320));
            listNovel.add(new Novel("The Chronicles of Narnia", "fantasi", 72000, 0, 1950, 420));
            listNovel.add(new Novel("Dilan: Dia adalah Dilanku tahun 1990", "romance", 55000, 0, 2018, 300));

            ArrayList<NovelBestSeller> listBestSeller = new ArrayList<>();
            listBestSeller.add(new NovelBestSeller("Harry Potter", "fantasi", 100000, 0, 1997, 500));
            listBestSeller.add(new NovelBestSeller("Laskar Pelangi", "inspiratif", 58000, 10, 2005, 400));

            ArrayList<NovelDigital> listDigital = new ArrayList<>();
            listDigital.add(new NovelDigital("Ebook Adventure", "fantasi", 60000, 0, 2022, 300));
            listDigital.add(new NovelDigital("Digital Mystery", "thriller", 55000, 15, 2021, 350));
            listDigital.add(new NovelDigital("Sci-Fi Saga", "science fiction", 70000, 0, 2023, 400));

            // Contoh panggilan metode jika kamu punya menu
            // tampilkanMenu(scanner, listNovel, listBestSeller, listDigital);
        }
    }
        public static void cariNovelByJudul(
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
        String judulDicari = scanner.nextLine().toLowerCase();

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
}
