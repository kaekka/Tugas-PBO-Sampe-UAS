package Kelompok5.PBO.Novel_Web.models;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Novel {
    protected String judul;
    private final String genre;
    private double harga;
    public int diskon;
    private final int tahunTerbit;
    private final int jumlahHalaman;

    public Novel(String judul, String genre, double harga, int diskon, int tahunTerbit, int jumlahHalaman) {
        this.judul = judul;
        this.genre = genre;
        this.harga = harga;
        this.diskon = diskon;
        this.tahunTerbit = tahunTerbit;
        this.jumlahHalaman = jumlahHalaman;
    }

    public String getJudul() {
        return judul;
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

    public String toStringWithoutDiscount() {
        DecimalFormat formatRupiah = new DecimalFormat("Rp#,###");
        return "Judul: " + judul + ", Genre: " + genre + ", Harga: " + formatRupiah.format(harga)
                + " (Tahun Terbit: " + tahunTerbit + ", Halaman: " + jumlahHalaman + ")";
    }

    public String toStringWithDiscount() {
        // Menghitung harga setelah diskon sebagai tipe double
        double hargaSetelahDiskon = harga - (harga * diskon / 100.0);

        // Gunakan formatRupiah untuk mencetak harga dengan format yang benar
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
}
