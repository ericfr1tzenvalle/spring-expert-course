/*
 * Repositório - ProdutoRepository
 * Curso: Spring Boot Expert
 *
 * Aborda:
 *  - Criação de um repositório com Spring Data JPA
 *  - Extensão da interface JpaRepository para operações de CRUD automáticas
 *  - Uso da anotação @Repository para indicar um componente de persistência
 *
 * Conceito principal:
 *  O repositório é responsável por interagir diretamente com o banco de dados,
 *  fornecendo métodos prontos para salvar, buscar, atualizar e excluir entidades.
 *  O Spring Data JPA elimina a necessidade de implementar manualmente essas operações.
 */

package com.ericfr1tzenvalle.spring.course.produtos_api.repository;

import com.ericfr1tzenvalle.spring.course.produtos_api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indica que esta interface é um componente de acesso a dados
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // JpaRepository já fornece métodos prontos como:
    // - save()
    // - findById()
    // - findAll()
    // - deleteById()
    // Métodos personalizados podem ser adicionados aqui, por exemplo:
    // List<Produto> findByNomeContaining(String nome);
}

/*
 * RESUMO E BOAS PRÁTICAS:
 * - Repositórios devem ser interfaces, não classes.
 * - Estenda JpaRepository<T, ID> para ter acesso às operações básicas de CRUD.
 * - Utilize @Repository para indicar ao Spring que a interface é um componente de persistência.
 * - Evite colocar lógica de negócio aqui — mantenha-a no service.
 * - Use nomes de métodos descritivos caso crie consultas personalizadas (query methods).
 */
