package Kelompok5.PBO.Novel_Web.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Kelompok5.PBO.Novel_Web.models.Novel;
import Kelompok5.PBO.Novel_Web.models.NovelBestSeller;
import Kelompok5.PBO.Novel_Web.models.NovelDigital;

public class Main {

    private static final List<Novel> allNovels = new ArrayList<>();

    static {
        // Novel biasa
        ArrayList<Novel> listNovel = new ArrayList<>();
        listNovel.add(new Novel("Seporsi Mie Ayam Sebelum mati", "Brian Khrisna", "romance", 60000, 0, 2025, 216, "https://cdn.gramedia.com/uploads/products/95ob5m98ur.jpg"));
        listNovel.add(new Novel("The Lord of the Rings", "J. R. R. Tolkien.", "adventure", 70000, 0, 1954, 450, "https://i.harperapps.com/hcanz/covers/9780008537760/y648.jpg"));
        listNovel.add(new Novel("The Godfather", "Mario Puzo", "crime", 50000, 0, 1969, 400, "https://th.bing.com/th/id/OIP.0VOP2vdDOkr9DwOV2nT85QHaKh?w=113&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"));
        listNovel.add(new Novel("Omniscient Reader's Viewpoint", "Sing Shong", "modern", 78000, 8, 2021, 450, "https://th.bing.com/th/id/OIP.APIAdyguMRyPxxTETVQ9sQHaKn?w=208&h=299&c=7&r=0&o=5&dpr=1.3&pid=1.7"));
        listNovel.add(new Novel("3726 mdpl", "Nurwina Sari", "romance", 85000, 0, 2019, 350, "https://th.bing.com/th/id/OIP.gRA4vBrWl1TX3RU8dC5unwAAAA?w=118&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"));
        listNovel.add(new Novel("Danur", "Risa Saraswati", "horror", 60000, 0, 2017, 320, "https://th.bing.com/th/id/OIP.1noJKVtSEZyAzPwqeVi2IwHaKs?w=130&h=187&c=7&r=0&o=5&dpr=1.3&pid=1.7"));
        listNovel.add(new Novel("The Chronicles of Narnia", "Clive Staples Lewis", "fantasi", 72000, 0, 1950, 420, "https://www.themoviedb.org/t/p/original/44dKzGtSDw0oFHEvAduduwjyVSZ.jpg"));
        listNovel.add(new Novel("Dilan: Dia adalah Dilanku tahun 1990", "Pidi Baiq", "romance", 55000, 0, 2018, 300,"https://th.bing.com/th/id/OIP.66WliD2UszlNkpNs8ZTqBwHaKs?w=135&h=195&c=7&r=0&o=5&dpr=1.3&pid=1.7"));
        listNovel.add(new Novel("Charlie dan Pabrik Coklat", "Roald Dahl", "adventure", 75555, 5, 1964, 215, "https://th.bing.com/th/id/OIP.-SgsKMGoRV7B1xyeCoJmWgHaLJ?w=119&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"));

        // Novel Best Seller
        ArrayList<NovelBestSeller> listBestSeller = new ArrayList<>();
        listBestSeller.add(new NovelBestSeller("Harry Potter and the Sorcerer's Stone", "J. K. Rowling", "fantasi", 100000, 0, 1997, 500, 0, "https://th.bing.com/th/id/OIP.dE3s91kmIVSPXmZ3ZdF2owHaFj?w=234&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"));
        listBestSeller.add(new NovelBestSeller("Laskar Pelangi", "Andrea Hirata", "inspiratif", 58000, 10, 2005, 400, 0, "https://th.bing.com/th/id/OIP.Ctt7dvydYLCRrnmrFBEPxQHaLw?w=115&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"));
        listBestSeller.add(new NovelBestSeller("Solo Leveling", "Chugong", "fantasi", 95000, 10, 2021, 300, 0, "https://upload.wikimedia.org/wikipedia/id/thumb/9/99/Solo_Leveling_Webtoon.png/500px-Solo_Leveling_Webtoon.png"));
        listBestSeller.add(new NovelBestSeller("Bumi", "Tere Liye", "fantasi", 80000, 5, 2014, 440, 0, "https://th.bing.com/th/id/OIP.-evealEHjqsYVlWN7fv82AHaK-?w=146&h=217&c=7&r=0&o=5&dpr=1.3&pid=1.7"));
        listBestSeller.add(new NovelBestSeller("Laut Bercerita", "Leila S. Chudori", "romance", 78000, 0, 2017, 394, 0, "https://static.diksia.com/media/id/2024/02/Resensi-Novel-Laut-Bercerita-karya-Leila-S-Chudori.webp"));

        // Novel Digital
        ArrayList<NovelDigital> listDigital = new ArrayList<>();
        listDigital.add(new NovelDigital("Johnny Star The Most Wanted", "Nitin Nain Singh", "fiksi", 60000, 0, 2022, 300, "https://th.bing.com/th/id/OIP.6zce8mYXATMjx0WXTOqu9gAAAA?w=115&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"));
        listDigital.add(new NovelDigital("Salvation of a Saint", "Keigo Higashino", "misteri", 55000, 15, 2021, 350, "https://th.bing.com/th/id/OIP.x2Yq8YUS4rsa0vYiUNp4RAHaKy?w=118&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"));
        listDigital.add(new NovelDigital("Negeri 5 Menara", "Ahmad Fuadi", "fiksi", 70000, 0, 2023, 400, "https://th.bing.com/th/id/OIP.3y07_XDORlyEP7OgumG5-wHaK5?w=123&h=181&c=7&r=0&o=5&dpr=1.3&pid=1.7"));

        // Gabungkan semua ke allNovels
        allNovels.addAll(listNovel);
        allNovels.addAll(listBestSeller);
        allNovels.addAll(listDigital);
    }

    public static List<Novel> getAllNovels() {
        return allNovels;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Jumlah total novel: " + allNovels.size());
            // Di sini bisa ditambahkan menu pencarian atau fitur lainnya
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

        
        System.out.println("\n" + garisAtas);
        System.out.printf("║%" + padding + "s%s%" + (93 - padding - judulTabel.length()) + "s║\n", "", judulTabel, "");
        System.out.println(garisTengah);
        System.out.printf("║ %-91s ║\n", "Masukkan judul novel yang dicari:");
        System.out.println(garisBawah);
        System.out.print(">> ");
        String judulDicari = scanner.nextLine().toLowerCase();

        
        ArrayList<Novel> semuaNovel = new ArrayList<>(listNovel);
        semuaNovel.addAll(listBestSeller);
        semuaNovel.addAll(listDigital);

        Novel hasil = Novel.cariNovelByJudul(semuaNovel, judulDicari);

        
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

    
    public static void cariNovelByGenre(
            Scanner scanner,
            ArrayList<Novel> listNovel,
            ArrayList<NovelBestSeller> listBestSeller,
            ArrayList<NovelDigital> listDigital) {

        String garisAtas = "╔" + "═".repeat(93) + "╗";
        String garisTengah = "╠" + "═".repeat(93) + "╣";
        String garisBawah = "╚" + "═".repeat(93) + "╝";
        String judulTabel = " MASUKKAN GENRE NOVEL YANG INGIN DICARI ";
        int padding = (93 - judulTabel.length()) / 2;

        
        System.out.println("\n" + garisAtas);
        System.out.printf("║%" + padding + "s%s%" + (93 - padding - judulTabel.length()) + "s║\n", "", judulTabel, "");
        System.out.println(garisTengah);
        System.out.printf("║ %-91s ║\n", "Masukkan genre novel yang dicari:");
        System.out.println(garisBawah);
        System.out.print(">> ");
        String genreDicari = scanner.nextLine().toLowerCase();

        
        ArrayList<Novel> semuaNovel = new ArrayList<>(listNovel);
        semuaNovel.addAll(listBestSeller);
        semuaNovel.addAll(listDigital);

        
        ArrayList<Novel> hasilGenre = new ArrayList<>();
        for (Novel novel : semuaNovel) {
            if (novel.getGenre().toLowerCase().contains(genreDicari)) {
                hasilGenre.add(novel);
            }
        }

        
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

    
    public static void tampilkanDaftarNovel(
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

    
    public static void tampilkanDaftarNovelSorted(
            ArrayList<Novel> listNovel,
            ArrayList<NovelBestSeller> listBestSeller,
            ArrayList<NovelDigital> listDigital) {

        ArrayList<Novel> semuaNovel = new ArrayList<>();
        semuaNovel.addAll(listNovel);
        semuaNovel.addAll(listBestSeller);
        semuaNovel.addAll(listDigital);

        
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

    
    public static void tampilkanDaftarNovelBestSeller(ArrayList<NovelBestSeller> listBestSeller) {
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

    
    public static void tampilakanDaftarNovelDigital(ArrayList<NovelDigital> listDigital) {
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

    
    public static void tampilkanNovelDiskon(
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