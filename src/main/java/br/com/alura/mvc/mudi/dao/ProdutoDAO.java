package br.com.alura.mvc.mudi.dao;

import br.com.alura.mvc.mudi.model.Produto;
import br.com.alura.mvc.mudi.model.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoDAO {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> resgatarTodosProdutos() {
        return this.produtoRepository.findAll();
    }

    public List<Produto> consultarPorStatus(StatusPedido statusPedido) {
        return this.produtoRepository.findByStatus(statusPedido);
    }

    public void cadastrarPedido(Produto produto) {
        this.produtoRepository.save(produto);
    }
}
