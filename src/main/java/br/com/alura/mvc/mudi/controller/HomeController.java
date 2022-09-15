package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.dao.ProdutoDAO;
import br.com.alura.mvc.mudi.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProdutoDAO produtoDAO;

    @GetMapping("/home")
    public String home(Model model) {
        List<Produto> pedidos = produtoDAO.resgatarTodosProdutos();
        model.addAttribute("pedidos", pedidos);

        return "home";
    }
}
