package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {

        //teste:
        Produto xiaomi = new Produto("Xiaomi Redmi Note 10 Pro 128gb 6gb Glacier Blue - Versão Global",
                new BigDecimal(1572.4), LocalDate.now(),
                "https://arcus-www.amazon.com.br/Xiaomi-Redmi-Note-128gb-Glacier/dp/B08Z6ZJDCP",
                "https://m.media-amazon.com/images/I/61bO6CSYPrL._AC_SY355_.jpg",
                "SmartPhone redminote 10 marca Xiaomi");

        List<Produto> pedidos = new ArrayList<>(Arrays.asList(xiaomi));

        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
