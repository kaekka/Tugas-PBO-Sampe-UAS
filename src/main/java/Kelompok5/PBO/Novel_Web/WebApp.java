package Kelompok5.PBO.Novel_Web;

import Kelompok5.PBO.Novel_Web.core.Main;
import Kelompok5.PBO.Novel_Web.models.Novel;
import Kelompok5.PBO.Novel_Web.models.NovelView;
import Kelompok5.PBO.Novel_Web.services.LikeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class WebApp {

    @Autowired
    private LikeService likeService;

    // ... (method index dan root Anda tetap sama) ...
    @GetMapping({ "/index", "/home" })
    public String index(Model model, HttpSession session) {
        Map<Integer, Boolean> likedStatus = new HashMap<>();
        int[] idsOnIndexPage = {9, 10, 11, 12, 13}; 
        for (int id : idsOnIndexPage) {
            likedStatus.put(id, likeService.isLiked(session, id));
        }
        model.addAttribute("likedStatus", likedStatus);
        model.addAttribute("session", session);
        return "index";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/auth/login";
    }

    @GetMapping("/koleksi")
    public String showFavoriteCollection(Model model, HttpSession session) {
        List<NovelView> likedNovelViews = likeService.getLikedNovelViews(session);
        Map<Integer, Boolean> likedStatus = new HashMap<>();
        for(NovelView nv : likedNovelViews){
            likedStatus.put(nv.getId(), true);
        }

        model.addAttribute("novelViews", likedNovelViews);
        model.addAttribute("likedStatus", likedStatus);
        model.addAttribute("session", session);
        return "koleksi";
    }

    // METHOD BARU untuk menampilkan SEMUA novel
    @GetMapping("/koleksi-semua")
    public String showAllCollection(Model model, HttpSession session) {
        List<Novel> allNovels = Main.getAllNovels();
        List<NovelView> allNovelViews = new ArrayList<>();
        Map<Integer, Boolean> likedStatus = new HashMap<>();

        for (int i = 0; i < allNovels.size(); i++) {
            allNovelViews.add(new NovelView(i, allNovels.get(i)));
            likedStatus.put(i, likeService.isLiked(session, i));
        }

        model.addAttribute("novelViews", allNovelViews);
        model.addAttribute("selectedGenre", "Semua Novel");
        model.addAttribute("likedStatus", likedStatus);
        model.addAttribute("session", session);
        return "koleksi-genre";
    }

    // METHOD LAMA yang DIPERBAIKI untuk menampilkan novel per genre
    @GetMapping("/genre")
    public String showGenreCollection(@RequestParam(name = "tipe") String genre, Model model, HttpSession session) {
        List<Novel> allNovels = Main.getAllNovels();
        List<NovelView> filteredNovelViews = new ArrayList<>();
        Map<Integer, Boolean> likedStatus = new HashMap<>();

        for (int i = 0; i < allNovels.size(); i++) {
            Novel novel = allNovels.get(i);
            if (novel.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                filteredNovelViews.add(new NovelView(i, novel));
                likedStatus.put(i, likeService.isLiked(session, i));
            }
        }
        
        model.addAttribute("novelViews", filteredNovelViews);
        model.addAttribute("selectedGenre", genre);
        model.addAttribute("likedStatus", likedStatus);
        model.addAttribute("session", session);
        return "koleksi-genre";
    }

    // ... (method about, detail-novel, dll tetap sama) ...
    @GetMapping("/about")
    public String aboutPage(Model model, HttpSession session) {
        model.addAttribute("session", session);
        return "about";
    }

    @GetMapping("/about-content")
    public String aboutContent() {
        return "fragments/about-content";
    }

    @GetMapping("/detail-novel")
    public String detailNovel() {
        return "detail-novel";
    }
}