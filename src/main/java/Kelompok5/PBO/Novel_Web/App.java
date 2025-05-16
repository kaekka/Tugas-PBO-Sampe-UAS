package Kelompok5.PBO.Novel_Web;

import java.util.ArrayList;
import java.util.Scanner;

import Kelompok5.PBO.Novel_Web.core.Main;
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

        
        while (true) {
            NovelFunction.tampilkanMenu();
            int pilihan = scanner.nextInt();

            
            switch (pilihan) {
                case 1 -> Main.cariNovelByJudul(scanner, listNovel, listBestSeller, listDigital);
                case 2 -> Main.cariNovelByGenre(scanner, listNovel, listBestSeller, listDigital); 
                case 4 -> Main.tampilkanDaftarNovelSorted(listNovel, listBestSeller, listDigital);
                case 5 -> Main.tampilkanDaftarNovelBestSeller(listBestSeller);
                case 6 -> Main.tampilakanDaftarNovelDigital(listDigital);
                case 7 -> Main.tampilkanNovelDiskon(listNovel, listBestSeller, listDigital);
                case 8 -> {
                NovelFunction.tampilkanFooter();
                return; 
                }
                default ->
                    System.out.println("Pilihan tidak ada di menu! Silakan masukkan angka 1-8.");
            }
        }
    }
}
