package novel;

import java.text.DecimalFormat;

public class NovelDigital extends Novel {

    public NovelDigital(String judul, String genre, double harga, int diskon, int tahunTerbit, int jumlahHalaman) {
        super(judul, genre, harga, diskon, tahunTerbit, jumlahHalaman);
    }

    @Override
    public String toString() {
        DecimalFormat formatRupiah = new DecimalFormat("Rp#,###.##");
        double hargaDiskon = getHarga() - (getHarga() * getDiskon() / 100.0);

        return "Judul: " + getJudul() + ", Genre: " + getGenre()
                + ", Harga: " + formatRupiah.format(getHarga())
                + " (Tahun Terbit: " + getTahunTerbit() + ", Halaman: " + getJumlahHalaman() + ")"
                + (getDiskon() > 0 ? " (Harga Setelah Diskon: " + formatRupiah.format(hargaDiskon) + ")" : "");
    }

}
