package Kelompok5.PBO.Novel_Web.controller;

import Kelompok5.PBO.Novel_Web.core.Main;
import Kelompok5.PBO.Novel_Web.models.Novel;
import Kelompok5.PBO.Novel_Web.services.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/keranjang")
public class CartApiController {

    @Autowired
    private CartService cartService;

    @PostMapping("/tambah/{novelId}")
    public ResponseEntity<Map<String, Object>> addToCart(@PathVariable("novelId") int novelId, HttpSession session) {
        List<Novel> allNovels = Main.getAllNovels();
        if (novelId >= 0 && novelId < allNovels.size()) {
            Novel novel = allNovels.get(novelId);
            cartService.addItem(session, novelId, novel);
            
            // Mengembalikan respons JSON sebagai konfirmasi
            return ResponseEntity.ok(Map.of("success", true, "message", "Novel berhasil ditambahkan!"));
        }
        
        return ResponseEntity.badRequest().body(Map.of("success", false, "message", "Novel tidak ditemukan."));
    }
}