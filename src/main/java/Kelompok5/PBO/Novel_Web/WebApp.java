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

    @GetMapping({ "/index", "/home" })
    public String index(Model model, HttpSession session) {
        // Menyiapkan data 'liked' di sini, di dalam controller
        Map<Integer, Boolean> likedStatus = new HashMap<>();
        int[] idsOnIndexPage = {9, 10, 11, 12, 13}; // ID novel yang ada di index.html
        for (int id : idsOnIndexPage) {
            likedStatus.put(id, likeService.isLiked(session, id));
        }
        // Kirim data yang sudah jadi ke template
        model.addAttribute("likedStatus", likedStatus);

        model.addAttribute("session", session); // Untuk info user di navbar
        return "index";
    }

    @GetMapping("/koleksi")
    public String showFavoriteCollection(Model model, HttpSession session) {
        model.addAttribute("novelViews", likeService.getLikedNovelViews(session));
        model.addAttribute("session", session); // Untuk info user di navbar
        return "koleksi";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/auth/login";
    }

@GetMapping("/aboutus")
public String aboutUs(HttpSession session, Model model) {
    model.addAttribute("session", session);
    return "fragments/aboutus";
}

    @GetMapping("/detail-novel")
    public String detailNovel() {
        return "detail-novel";
    }

    @GetMapping("/genre")
    public String showGenreCollection(@RequestParam(name = "tipe") String genre, Model model, HttpSession session) {
        List<Novel> allNovels = Main.getAllNovels();
        List<NovelView> filteredNovelViews = new ArrayList<>();
        for (int i = 0; i < allNovels.size(); i++) {
            Novel novel = allNovels.get(i);
            if (novel.getGenre().equalsIgnoreCase(genre)) {
                filteredNovelViews.add(new NovelView(i, novel));
            }
        }
        model.addAttribute("novelViews", filteredNovelViews);
        model.addAttribute("selectedGenre", genre);
        model.addAttribute("session", session);
        return "koleksi-genre";
    }
}