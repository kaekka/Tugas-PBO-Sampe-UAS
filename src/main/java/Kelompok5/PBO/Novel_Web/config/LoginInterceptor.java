package Kelompok5.PBO.Novel_Web.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        String uri = request.getRequestURI();

        // Cek jika pengguna belum login
        if (request.getSession().getAttribute("loggedInUser") == null) {
            
            // Cek apakah ini adalah permintaan ke API
            if (uri.startsWith("/api/")) {
                // Untuk API, jangan redirect. Cukup kirim status error 401 (Unauthorized).
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false; // Hentikan permintaan
            } else {
                // Untuk halaman biasa, alihkan ke halaman login.
                response.sendRedirect("/auth/login");
                return false; // Hentikan permintaan
            }
        }

        // Jika pengguna sudah login, izinkan permintaan untuk melanjutkan.
        return true;
    }
}