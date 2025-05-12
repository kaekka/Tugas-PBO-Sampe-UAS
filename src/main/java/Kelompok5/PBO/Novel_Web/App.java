package Kelompok5.PBO.Novel_Web;

import java.util.ArrayList;
import java.util.Scanner;

import Kelompok5.PBO.Novel_Web.models.Novel;
import Kelompok5.PBO.Novel_Web.models.NovelBestSeller;
import Kelompok5.PBO.Novel_Web.models.NovelDigital;
import Kelompok5.PBO.Novel_Web.utils.NovelFunction;

public class App {
    static ArrayList<Novel> listNovel = new ArrayList<>(); 
    static ArrayList<NovelBestSeller> listBestSeller = new ArrayList<>();
    static ArrayList<NovelDigital> listDigital = new ArrayList<>();

    public static void main(String[] args) {
        NovelFunction.tampilkanMenu();
        Scanner scanner = new Scanner(System.in);

        // Contoh data untuk listNovel, listBestSeller, listDigital
        listNovel.add(new Novel("Solo Leveling", "fantasi", 95000, 10, 2021, 300));
        listBestSeller.add(new NovelBestSeller("Harry Potter", "fantasi", 100000, 0, 1997, 500));
        listDigital.add(new NovelDigital("Ebook Adventure", "fantasi", 60000, 0, 2022, 300));

        while (true) {
            System.out.print("Pilih menu: ");
            String pilihanInput = scanner.nextLine();

            // Mengubah input menjadi integer
            int pilihan = 0;
            try {
                pilihan = Integer.parseInt(pilihanInput); // Parse input menjadi int
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid!");
                continue; // Kembali ke awal loop jika input tidak valid
            }

            NovelFunction.tampilkanMenu();

            switch (pilihan) {  // Menggunakan int dalam switch
                case 1:
                    cariNovelByJudul(scanner, listNovel, listBestSeller, listDigital);
                case 2:
                    // Panggil method lain yang sesuai
                    break;
                case 3:
                    // Panggil method lain yang sesuai
                    break;
                case 8:
                    NovelFunction.tampilkanFooter();
                    return;
                default:
                    System.out.println("Pilihan tidak ada di menu! Silakan masukkan angka 1-8.");
            }
        }
    }

    private static void cariNovelByJudul(Scanner scanner, ArrayList<Novel> listNovel2,
            ArrayList<NovelBestSeller> listBestSeller2, ArrayList<NovelDigital> listDigital2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cariNovelByJudul'");
    }
}
