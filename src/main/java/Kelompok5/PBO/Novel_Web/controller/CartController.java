package Kelompok5.PBO.Novel_Web.controller;

import Kelompok5.PBO.Novel_Web.core.Main;
import Kelompok5.PBO.Novel_Web.models.Novel;
import Kelompok5.PBO.Novel_Web.services.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/keranjang")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public String showCart(HttpSession session, Model model) {
        model.addAttribute("cartItems", cartService.getAllItems(session));
        
        double total = cartService.getTotal(session);
        Locale indonesianLocale = new Locale("in", "ID");
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(indonesianLocale);
        model.addAttribute("totalFormatted", rupiahFormat.format(total));
        
        // Menambahkan pesan debug (opsional, bisa dihapus jika sudah tidak perlu)
        model.addAttribute("debugMessage", "Versi Controller SUDAH TERBARU.");

        return "shop/keranjang";
    }

    @PostMapping("/tambah/{novelId}")
    public String addToCart(@PathVariable("novelId") int novelId, HttpSession session) {
        List<Novel> allNovels = Main.getAllNovels();
        if (novelId >= 0 && novelId < allNovels.size()) {
            Novel novel = allNovels.get(novelId);
            cartService.addItem(session, novelId, novel);
        }
        return "redirect:/keranjang";
    }
    
    // [ENDPOINT BARU] Untuk tombol +
    @PostMapping("/tambahSatu/{novelId}")
    public String tambahSatu(@PathVariable("novelId") int novelId, HttpSession session) {
        cartService.tambahSatuItem(session, novelId);
        return "redirect:/keranjang";
    }

    // [ENDPOINT BARU] Untuk tombol -
    @PostMapping("/kurangSatu/{novelId}")
    public String kurangSatu(@PathVariable("novelId") int novelId, HttpSession session) {
        cartService.kurangSatuItem(session, novelId);
        return "redirect:/keranjang";
    }

    @PostMapping("/hapus/{novelId}")
    public String removeFromCart(@PathVariable("novelId") int novelId, HttpSession session) {
        cartService.removeItem(session, novelId);
        return "redirect:/keranjang";
    }

}