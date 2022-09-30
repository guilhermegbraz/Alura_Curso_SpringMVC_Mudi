package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.dao.ProdutoDAO;
import br.com.alura.mvc.mudi.model.Produto;
import br.com.alura.mvc.mudi.model.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.OnError;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    ProdutoDAO produtoDAO;

    @GetMapping
    public String home(Model model) {

        List<Produto> pedidos = produtoDAO.resgatarTodosProdutos();
        pedidos.sort(Comparator.comparing(Produto::getNomeProduto));
        model.addAttribute("pedidos", pedidos);

        return "home";
    }

    @GetMapping("/{status}")
    public ModelAndView porStatus(@PathVariable("status") String status){

        List<Produto> pedidos = this.produtoDAO.consultarPorStatus(
                StatusPedido.valueOf(status.toUpperCase(Locale.ROOT)));
        pedidos.sort(Comparator.comparing(Produto::getNomeProduto));
        ModelAndView model = new ModelAndView("home");
        model.addObject("pedidos", pedidos);
        model.addObject("status", status);

        return model;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView onError() {
        ModelAndView mv = new ModelAndView("redirect:/home");
        return mv;
    }

}
