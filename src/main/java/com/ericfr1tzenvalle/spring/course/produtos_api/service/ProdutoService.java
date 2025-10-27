/*
 * Serviço - ProdutoService
 * Curso: Spring Boot Expert
 *
 * Aborda:
 *  - Criação de um serviço para encapsular a lógica de negócio
 *  - Injeção de dependência do ProdutoRepository
 *  - Implementação de métodos para CRUD (create, read, update, delete)
 *  - Uso da anotação @Transactional para garantir consistência nas operações de escrita
 *  - Filtragem de dados usando Streams do Java
 *
 * Conceito principal:
 *  O service atua como camada intermediária entre o controller e o repositório,
 *  garantindo que regras de negócio sejam aplicadas antes de persistir ou recuperar dados.
 */

package com.ericfr1tzenvalle.spring.course.produtos_api.service;

import com.ericfr1tzenvalle.spring.course.produtos_api.model.Produto;
import com.ericfr1tzenvalle.spring.course.produtos_api.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Indica que esta classe é um componente de serviço do Spring
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    // Injeção de dependência via construtor
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // CREATE - Salva um novo produto
    public Produto salvarProduto(Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    // READ - Busca um produto pelo ID
    public Produto obterProdutoPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    // DELETE - Remove um produto pelo ID
    @Transactional
    public void deletarProdutoPorId(Long id) {
        Produto produto = obterProdutoPorId(id);
        produtoRepository.delete(produto);
    }

    // UPDATE - Atualiza os dados de um produto existente
    @Transactional
    public Produto atualizarProdutoPorId(Long id, Produto produto) {
        Produto produtoExistente = obterProdutoPorId(id);
        produtoExistente.setNome(produto.getNome());
        produtoExistente.setPreco(produto.getPreco());
        return produtoExistente;
    }

    // SEARCH - Busca produtos pelo nome
    public List<Produto> buscarProdutoNome(String nome) {
        // Filtra a lista completa pelo nome (case-insensitive)
        // Alternativa: criar metodo findByNome() no ProdutoRepository
        return produtoRepository.findAll().stream()
                .filter(produto -> produto.getNome().equalsIgnoreCase(nome))
                .toList();
    }
}

/*
 * RESUMO E BOAS PRÁTICAS:
 * - Serviços devem conter apenas lógica de negócio, sem se preocupar com detalhes de HTTP ou banco.
 * - Use @Transactional em métodos que alteram o banco de dados para manter a consistência.
 * - Prefira lançar exceções customizadas ou RuntimeException quando algo não for encontrado.
 * - Evite lógica complexa no controller; deixe o service responsável por regras de negócio.
 * - Streams do Java podem ser usadas para filtragem e transformação de dados, mas para grandes volumes é melhor delegar ao banco.
 * - Mantenha nomes de métodos claros e consistentes com a operação que realizam.
 */
