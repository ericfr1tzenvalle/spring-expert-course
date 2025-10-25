package com.ericfr1tzenvalle.spring.course.produtos_api.service;

import com.ericfr1tzenvalle.spring.course.produtos_api.model.Produto;
import com.ericfr1tzenvalle.spring.course.produtos_api.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    public Produto salvarProduto(Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    public Produto obterProdutoPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
    @Transactional
    public void deletarProdutoPorId(Long id) {
        Produto produto = obterProdutoPorId(id);
        produtoRepository.delete(produto);
    }
    @Transactional
    public Produto atualizarProdutoPorId(Long id, Produto produto) {
        Produto produtoExistente = obterProdutoPorId(id);
        produtoExistente.setNome(produto.getNome());
        produtoExistente.setPreco(produto.getPreco());
        return produtoExistente;
    }

    public List<Produto> buscarProdutoNome(String nome) {
        return produtoRepository.findAll().stream()
                .filter(produto -> produto.getNome().equalsIgnoreCase(nome))
                .toList();
    }
}
