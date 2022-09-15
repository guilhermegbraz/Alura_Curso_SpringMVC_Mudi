package br.com.alura.mvc.mudi.model.dto;

import br.com.alura.mvc.mudi.model.Produto;

public class RequisicaoProduto {

    String nome_produto;
    String url_produto;
    String url_imagem;
    String descricao_produto;

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getUrl_produto() {
        return url_produto;
    }

    public void setUrl_produto(String url_produto) {
        this.url_produto = url_produto;
    }

    public String getUrl_imagem() {
        return url_imagem;
    }

    public void setUrl_imagem(String url_imagem) {
        this.url_imagem = url_imagem;
    }

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

    public Produto getPedido() {
        Produto pedido = new Produto();
        pedido.setNomeProduto(this.nome_produto);
        pedido.setUrlProduto(this.url_produto);
        pedido.setUrlImagem(this.url_imagem);
        pedido.setDescricao(this.descricao_produto);

        return pedido;
    }
}
