package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.dao.ProdutoDAO;
import br.com.alura.mvc.mudi.model.Produto;
import br.com.alura.mvc.mudi.model.dto.RequisicaoProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
//Todas as requisições para "/pedido" virão para esse controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    ProdutoDAO produtoDAO;

    @GetMapping(value = "/formulario")
    public ModelAndView formNovoPedido(){
        ModelAndView mv = new ModelAndView("pedido/form");
        mv.addObject("requisicaoProduto", new RequisicaoProduto());
        return mv;
    }
    @PostMapping(value = "/novo")
    public ModelAndView cadastrarPedido(@Valid RequisicaoProduto requisicaoProduto, BindingResult result) {
        if(result.hasErrors()){
            return new ModelAndView("pedido/form");
        }
        Produto produto = requisicaoProduto.getPedido();
        this.produtoDAO.cadastrarPedido(produto);
        ModelAndView mv = new ModelAndView("redirect:/home");

        return mv;
    }

}
