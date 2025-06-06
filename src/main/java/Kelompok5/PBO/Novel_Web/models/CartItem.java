package Kelompok5.PBO.Novel_Web.models;

import java.text.NumberFormat; // <-- TAMBAHKAN IMPORT
import java.util.Locale;       // <-- TAMBAHKAN IMPORT

public class CartItem {
    private Novel novel;
    private int quantity;

    public CartItem(Novel novel, int quantity) {
        this.novel = novel;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Novel getNovel() {
        return novel;
    }

    public void setNovel(Novel novel) {
        this.novel = novel;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return novel.getHargaSetelahDiskon() * quantity;
    }
    
    public String getFormattedHarga() {
        Locale indonesianLocale = new Locale("in", "ID");
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(indonesianLocale);
        return rupiahFormat.format(this.novel.getHargaSetelahDiskon());
    }
}