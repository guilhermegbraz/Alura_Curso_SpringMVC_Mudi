package br.com.alura.mvc.mudi.dao;

import br.com.alura.mvc.mudi.model.Produto;
import br.com.alura.mvc.mudi.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByStatus(StatusPedido statusPedido);
}
