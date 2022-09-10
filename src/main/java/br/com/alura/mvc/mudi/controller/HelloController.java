package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String Hello(Model model) {
        String cumprimento = "Ola Guilherme, seja bem vindo!";
        model.addAttribute("frase", cumprimento);
        return "hello";
    }

    @PostMapping("/hello")
    public String bye(HttpServletRequest req, HttpServletResponse resp){
        String cumprimento = "Até mais Guilherme, volte logo!";
        req.setAttribute("frase", cumprimento);
        return "hello";
    }
}
