package Kelompok5.PBO.Novel_Web.services;
import Kelompok5.PBO.Novel_Web.core.Main;
import Kelompok5.PBO.Novel_Web.models.Novel;
import Kelompok5.PBO.Novel_Web.models.NovelView;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LikeService {
    private static final String LIKE_SESSION_KEY = "likedNovels";

    @SuppressWarnings("unchecked")
    private Set<Integer> getLikedIds(HttpSession session) {
        Set<Integer> likedIds = (Set<Integer>) session.getAttribute(LIKE_SESSION_KEY);
        if (likedIds == null) {
            likedIds = new HashSet<>();
            session.setAttribute(LIKE_SESSION_KEY, likedIds);
        }
        return likedIds;
    }
    public boolean toggleLike(HttpSession session, int novelId) {
        Set<Integer> likedIds = getLikedIds(session);
        if (likedIds.contains(novelId)) {
            likedIds.remove(novelId);
            return false;
        } else {
            likedIds.add(novelId);
            return true;
        }
    }
    public boolean isLiked(HttpSession session, int novelId) {
        return getLikedIds(session).contains(novelId);
    }
    public List<NovelView> getLikedNovelViews(HttpSession session) {
        Set<Integer> likedIds = getLikedIds(session);
        List<Novel> allNovels = Main.getAllNovels();
        List<NovelView> likedNovelViews = new ArrayList<>();
        for (int id : likedIds) {
            if (id >= 0 && id < allNovels.size()) {
                likedNovelViews.add(new NovelView(id, allNovels.get(id)));
            }
        }
        return likedNovelViews;
    }
}