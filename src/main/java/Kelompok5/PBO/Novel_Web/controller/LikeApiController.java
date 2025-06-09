package Kelompok5.PBO.Novel_Web.controller;

import Kelompok5.PBO.Novel_Web.services.LikeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/like")
public class LikeApiController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/{novelId}")
    public ResponseEntity<Map<String, Boolean>> toggleLike(@PathVariable int novelId, HttpSession session) {
        // Melakukan toggle like dan mendapatkan status terbarunya
        boolean isLiked = likeService.toggleLike(session, novelId);
        // Mengembalikan status baru dalam format JSON
        return ResponseEntity.ok(Map.of("isLiked", isLiked));
    }
}