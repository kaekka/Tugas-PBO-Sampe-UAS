package Kelompok5.PBO.Novel_Web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kelompok5.PBO.Novel_Web.core.Main;
import Kelompok5.PBO.Novel_Web.models.Novel;

@RestController
public class SearchController {

    @GetMapping("/search")
    public List<Map<String, String>> searchNovels(@RequestParam(name = "query", required = false) String query) {
        List<Novel> allNovels = Main.getAllNovels();

        return allNovels.stream()
                .filter(novel -> query == null || query.isEmpty()
                        || novel.getJudul().toLowerCase().contains(query.toLowerCase())
                        || novel.getPenulis().toLowerCase().contains(query.toLowerCase())
                        || novel.getGenre().toLowerCase().contains(query.toLowerCase()))
                .map(novel -> {
                    Map<String, String> map = new HashMap<>();
                    map.put("judul", novel.getJudul());
                    map.put("cover", novel.getCoverUrl());
                    return map;
                })
                .collect(Collectors.toList());
    }
}

