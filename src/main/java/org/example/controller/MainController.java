package org.example.controller;

import org.example.service.HorizonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private final HorizonService horizonService;
//    @Autowired
    public MainController(HorizonService horizonService) {
        this.horizonService = horizonService;
    }

    @GetMapping
    public String mainPage() {
        return "index"; // Главная страница с выбором
    }

    @GetMapping("/horizons/{id}")
    public String horizonDetailsPage(@PathVariable Long id, Model model) {
        Object[] horizon = horizonService.getHorizonById(id)
                .orElseThrow(() -> new IllegalArgumentException("Horizon not found with ID: " + id));

        // Добавляем объект Horizon в модель для передачи данных на страницу
        model.addAttribute("horizon", horizon);

        return "horizon-details"; // Это имя HTML-шаблона, например, horizon-details.html
    }



}
