/*
 * Classe de Modelo - Produto
 * Curso: Spring Boot Expert
 *
 * Aborda:
 *  - Definição de uma entidade JPA (mapeamento objeto-relacional)
 *  - Uso das anotações @Entity, @Id e @GeneratedValue
 *  - Criação de atributos com restrições usando @Column
 *  - Integração com Lombok para geração automática de getters, setters e construtores
 *
 * Conceito principal:
 *  O modelo representa uma entidade do domínio da aplicação, que será persistida no banco de dados.
 *  Aqui, "Produto" é uma entidade que mapeia uma tabela de mesmo nome, com campos id, nome e preço.
 */
package com.ericfr1tzenvalle.spring.course.produtos_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // Indica que a classe é uma entidade JPA (será mapeada para uma tabela)
@Getter @Setter // Lombok - gera automaticamente os métodos getters e setters
@NoArgsConstructor // Lombok - gera construtor padrão sem argumentos
@AllArgsConstructor // Lombok - gera construtor com todos os argumentos
public class Produto {

    @Id // Define o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera IDs automaticamente no banco
    private Long id;

    @Column(nullable = false) // Campo obrigatório (não pode ser nulo)
    private String nome;

    @Column(nullable = false) // Campo obrigatório
    private double preco;
}

/*
 * RESUMO E BOAS PRÁTICAS:
 * - Entidades devem representar o domínio da aplicação.
 * - Use @Entity para indicar que a classe será persistida.
 * - Utilize Lombok para reduzir código repetitivo (mas entenda o que ele faz).
 * - A anotação @Column ajuda a aplicar restrições diretamente no modelo.
 * - Mantenha o modelo simples, sem regras de negócio complexas dentro da entidade.
 */
