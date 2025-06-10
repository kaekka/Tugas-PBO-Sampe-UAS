package Kelompok5.PBO.Novel_Web.services;

import Kelompok5.PBO.Novel_Web.models.CartItem;
import Kelompok5.PBO.Novel_Web.models.Novel;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    private static final String CART_SESSION_KEY = "cart";

    @SuppressWarnings("unchecked")
    public Map<Integer, CartItem> getCart(HttpSession session) {
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute(CART_SESSION_KEY);
        if (cart == null) {
            cart = new HashMap<>();
            session.setAttribute(CART_SESSION_KEY, cart);
        }
        return cart;
    }

    public void addItem(HttpSession session, int novelId, Novel novel) {
        Map<Integer, CartItem> cart = getCart(session);
        CartItem cartItem = cart.get(novelId);
        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        } else {
            cart.put(novelId, new CartItem(novel, 1));
        }
        session.setAttribute(CART_SESSION_KEY, cart);
    }

    public void removeItem(HttpSession session, int novelId) {
        Map<Integer, CartItem> cart = getCart(session);
        cart.remove(novelId);
        session.setAttribute(CART_SESSION_KEY, cart);
    }

    public void updateItemQuantity(HttpSession session, int novelId, int quantity) {
    }

    public void tambahSatuItem(HttpSession session, int novelId) {
        Map<Integer, CartItem> cart = getCart(session);
        CartItem cartItem = cart.get(novelId);
        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        }
    }

    public void kurangSatuItem(HttpSession session, int novelId) {
        Map<Integer, CartItem> cart = getCart(session);
        CartItem cartItem = cart.get(novelId);
        if (cartItem != null) {
            int newQuantity = cartItem.getQuantity() - 1;
            if (newQuantity > 0) {
                cartItem.setQuantity(newQuantity);
            } else {

                cart.remove(novelId);
            }
        }
    }

    public List<CartItem> getAllItems(HttpSession session) {
        Map<Integer, CartItem> cart = getCart(session);
        return new ArrayList<>(cart.values());
    }

    public double getTotal(HttpSession session) {
        System.out.println("\n--- MEMULAI KALKULASI TOTAL KERANJANG ---");
        Map<Integer, CartItem> cart = getCart(session);
        double total = 0.0;

        for (CartItem item : cart.values()) {
            double subtotal = item.getSubtotal();
            System.out.println("Judul: " + item.getNovel().getJudul() +
                    " | Harga: " + item.getNovel().getHargaSetelahDiskon() +
                    " | Qty: " + item.getQuantity() +
                    " | Subtotal: " + subtotal);
            total += subtotal;
        }

        System.out.println("--- TOTAL AKHIR KALKULASI: " + total + " ---");
        return total;
    }
}