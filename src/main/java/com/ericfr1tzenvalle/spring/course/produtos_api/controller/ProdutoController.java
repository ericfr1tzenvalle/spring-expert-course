package com.ericfr1tzenvalle.spring.course.produtos_api.controller;

import com.ericfr1tzenvalle.spring.course.produtos_api.model.Produto;
import com.ericfr1tzenvalle.spring.course.produtos_api.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController //diz que essa classe é um controlador REST ou seja recebe requisições HTTP GET, POST, PUT, DELETE
@RequestMapping("/produtos") //diz que vai receber requisições no endpoint /produtos
public class ProdutoController {
    private final ProdutoService produtoService;
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
   @PostMapping
   public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
         Produto produtoSalvo = produtoService.salvarProduto(produto);
         return ResponseEntity.ok(produtoSalvo);
   }

   @GetMapping("/{id}")
   public ResponseEntity<Produto> obterProdutoPorId(@PathVariable Long id) {
       Produto produto = produtoService.obterProdutoPorId(id);
       return ResponseEntity.ok(produto);
   }
   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProdutoPorId(@PathVariable Long id) {
         produtoService.deletarProdutoPorId(id);
         return ResponseEntity.noContent().build();
   }
   @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        Produto produtoEnviado = produtoService.atualizarProdutoPorId(id,produto);
        return ResponseEntity.ok(produtoEnviado);
   }

   @GetMapping
    public ResponseEntity<List<Produto>> buscarProdutoNome(@RequestParam("nome") String nome) {
         List<Produto> produtos = produtoService.buscarProdutoNome(nome);
         return ResponseEntity.ok(produtos);
   }

   
}
