/*
 * Controller - TesteFabricaController
 * Curso: Spring Boot Expert
 *
 * Aborda:
 *  - Criação de um controller REST para simular a ligação de um carro
 *  - Uso de @Autowired para injeção de dependência de beans
 *  - Uso de @Qualifier para escolher qual bean injetar
 *  - Demonstração prática de @Primary e criação de annotations personalizadas para beans
 *  - Recebe requisições POST e retorna o status do carro
 *
 * Conceito principal:
 *  Controllers são responsáveis por lidar com requisições HTTP (API REST ou Web)
 *  e interagir com a lógica de negócio (Services ou componentes configurados).
 */

package com.ericfr1tzenvalle.spring.course.arquitetura_spring.montadora.api;

import com.ericfr1tzenvalle.spring.course.arquitetura_spring.montadora.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indica que esta classe vai expor endpoints REST
@RequestMapping("/carros") // Define o endpoint base para este controller
public class TesteFabricaController {

    @Autowired // Injeção automática de dependência
    //@Primary → caso o bean padrão seja usado
    //@Aspirado → annotation personalizada para selecionar motor aspirado
    @Qualifier("motorEletrico") // Escolhe explicitamente qual bean injetar
    private Motor motor; // Para fins do exercício, usamos injeção direta; ideal é via construtor

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave){
        var carro = new HondaHRV(motor); // Cria instância do carro com o motor injetado
        return carro.darIgnicao(chave); // Retorna o status do carro após ligar
    }
}

/*
 * RESUMO E BOAS PRÁTICAS:
 * - Prefira injeção de dependência via construtor em vez de @Autowired direto no campo.
 * - Use @Qualifier para diferenciar beans quando houver múltiplas implementações.
 * - @Primary define o bean padrão, facilitando a injeção sem precisar de @Qualifier.
 * - Controllers devem ser finos: apenas lidar com requisições e repassar para a lógica de negócio.
 * - Criação de annotations personalizadas (@Aspirado) pode simplificar escolha de beans.
 * - Evite lógica de negócio complexa diretamente no controller; delegue a Services ou componentes configurados.
 */
