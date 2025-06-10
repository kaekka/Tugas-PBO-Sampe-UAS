package Kelompok5.PBO.Novel_Web.models;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;

public class Novel {
    protected String judul;
    protected String penulis;
    private final String genre;
    private double harga;
    public int diskon;
    protected int tahunTerbit;
    protected int jumlahHalaman;
    private String coverurl;
    private String deskripsi;

    public Novel(String judul,String penulis, String genre, double harga, int diskon, int tahunTerbit, int jumlahHalaman, String coverUrl, String deskripsi) {
        this.judul = judul;
        this.penulis = penulis;
        this.genre = genre;
        this.harga = harga;
        this.diskon = diskon;
        this.tahunTerbit = tahunTerbit;
        this.jumlahHalaman = jumlahHalaman;
        this.coverurl = coverUrl;
        this.deskripsi = deskripsi;
    }

    public void displayInfo(){
        System.out.println("Judul       :" + judul);
        System.out.println("penulis     :" + penulis);
        System.out.println("harga       :" + harga);
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis(){
        return penulis;
    }

    public String getGenre() {
        return genre;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        if (harga > 0) {
            this.harga = harga;
        } else {
            throw new IllegalArgumentException("Harga tidak boleh negatif atau nol.");
        }
    }

    public int getDiskon() {
        return diskon;
    }

    public void setDiskon(int diskon) {
        if (diskon >= 0 && diskon <= 100) {
            this.diskon = diskon;
        } else {
            throw new IllegalArgumentException("Diskon harus antara 0-100%");
        }
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public int getJumlahHalaman() {
        return jumlahHalaman;
    }

    public String getCoverUrl() {
    return coverurl;
    }

    public double getHargaSetelahDiskon() {
        if (diskon <= 0) {
            return this.harga;
        }
        double potongan = this.harga * (this.diskon / 100.0);
        return this.harga - potongan;
    }

    public String getFormattedHargaSetelahDiskon() {
        Locale indonesianLocale = new Locale("in", "ID");
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(indonesianLocale);
        rupiahFormat.setMaximumFractionDigits(0); 
        return rupiahFormat.format(getHargaSetelahDiskon());
    }

    public String getDeskripsi() {
        return deskripsi;
    }


    public static Novel cariNovelByJudul(ArrayList<Novel> daftar, String judul) {
        for (Novel m : daftar) {
            if (m.getJudul().trim().equalsIgnoreCase(judul)) {
                return m;
            }
        }
        return null;
    }

    public static ArrayList<Novel> cariNovelByGenre(ArrayList<Novel> daftar, String genre) {
        ArrayList<Novel> hasil = new ArrayList<>();
        for (Novel m : daftar) {
            if (m.getGenre().trim().equalsIgnoreCase(genre)) {
                hasil.add(m);
            }
        }
        return hasil;
    }

        public String getFormattedOriginalHarga() {
        Locale indonesianLocale = new Locale("in", "ID");
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(indonesianLocale);
        rupiahFormat.setMaximumFractionDigits(0);
        return rupiahFormat.format(this.harga); 
    }

    public String toStringWithoutDiscount() {
        DecimalFormat formatRupiah = new DecimalFormat("Rp#,###");
        return "Judul: " + judul + ", Genre: " + genre + ", Harga: " + formatRupiah.format(harga)
                + " (Tahun Terbit: " + tahunTerbit + ", Halaman: " + jumlahHalaman + ")";
    }

    public String toStringWithDiscount() {
        
        double hargaSetelahDiskon = harga - (harga * diskon / 100.0);

        
        DecimalFormat formatRupiah = new DecimalFormat("Rp#,###");

        return String.format(
                "Judul: %s, Genre: %s, Harga: %s (Tahun Terbit: %d, Halaman: %d) (Harga Setelah Diskon: %s)",
                judul, genre, formatRupiah.format(harga), tahunTerbit, jumlahHalaman, formatRupiah.format(hargaSetelahDiskon)
        );
    }

    @Override
    public String toString() {
        return toStringWithoutDiscount() + " (Tahun Terbit: " + tahunTerbit + ", Halaman: " + jumlahHalaman + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Novel novel = (Novel) o;
        return judul.equals(novel.judul);
    }

    @Override
    public int hashCode() {
        return judul.hashCode();
    }
}
