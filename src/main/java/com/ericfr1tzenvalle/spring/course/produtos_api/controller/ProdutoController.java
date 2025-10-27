/*
 * Controlador REST - ProdutoController
 * Curso: Spring Boot Expert
 *
 * Aborda:
 *  - Criação de um controlador REST com Spring Boot
 *  - Uso de anotações @RestController e @RequestMapping
 *  - Implementação dos principais endpoints HTTP: GET, POST, PUT e DELETE
 *  - Uso do ResponseEntity para padronizar respostas HTTP
 *  - Injeção de dependência via construtor (ProdutoService)
 *
 * Conceito principal:
 *  O controlador é responsável por expor endpoints HTTP e orquestrar as chamadas ao serviço,
 *  recebendo requisições do cliente e retornando respostas apropriadas.
 */

package com.ericfr1tzenvalle.spring.course.produtos_api.controller;

import com.ericfr1tzenvalle.spring.course.produtos_api.model.Produto;
import com.ericfr1tzenvalle.spring.course.produtos_api.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta classe é um controlador REST (recebe requisições HTTP)
@RequestMapping("/produtos") // Define o endpoint base para todos os métodos
public class ProdutoController {

    private final ProdutoService produtoService;

    // Injeção de dependência via construtor
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // CREATE - Cadastra um novo produto
    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        Produto produtoSalvo = produtoService.salvarProduto(produto);
        return ResponseEntity.ok(produtoSalvo);
    }

    // READ - Busca um produto pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> obterProdutoPorId(@PathVariable Long id) {
        Produto produto = produtoService.obterProdutoPorId(id);
        return ResponseEntity.ok(produto);
    }

    // DELETE - Remove um produto pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProdutoPorId(@PathVariable Long id) {
        produtoService.deletarProdutoPorId(id);
        return ResponseEntity.noContent().build();
    }

    // UPDATE - Atualiza um produto existente
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        Produto produtoAtualizado = produtoService.atualizarProdutoPorId(id, produto);
        return ResponseEntity.ok(produtoAtualizado);
    }

    // SEARCH - Busca produtos pelo nome
    @GetMapping
    public ResponseEntity<List<Produto>> buscarProdutoNome(@RequestParam("nome") String nome) {
        List<Produto> produtos = produtoService.buscarProdutoNome(nome);
        return ResponseEntity.ok(produtos);
    }
}

/*
 * RESUMO E BOAS PRÁTICAS:
 * - Controladores devem apenas coordenar requisições e respostas (sem lógica de negócio pesada).
 * - Use @RestController para que os métodos retornem dados no formato JSON automaticamente.
 * - Centralize a lógica no service e mantenha o controller limpo.
 * - Utilize ResponseEntity para retornar status HTTP adequados (200, 204, 400, 404, etc.).
 * - Prefira injeção de dependência via construtor — facilita testes e manutenção.
 * - Mantenha o padrão de nomenclatura claro e consistente entre métodos e endpoints.
 */
