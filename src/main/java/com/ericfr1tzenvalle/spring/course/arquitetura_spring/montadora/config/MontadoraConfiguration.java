/*
 * Configuração - MontadoraConfiguration
 * Curso: Spring Boot Expert
 *
 * Aborda:
 *  - Criação de beans no Spring usando @Configuration e @Bean
 *  - Uso de @Primary para definir o bean padrão
 *  - Exemplo de injeção de dependência para diferentes tipos de Motor
 *  - Configuração modularizada do container Spring
 *
 * Conceito principal:
 *  @Configuration marca a classe como fonte de configuração de beans.
 *  @Bean registra objetos que serão gerenciados pelo container.
 *  @Primary indica qual bean usar por padrão quando houver múltiplas implementações.
 */

package com.ericfr1tzenvalle.spring.course.arquitetura_spring.montadora.config;

import com.ericfr1tzenvalle.spring.course.arquitetura_spring.montadora.Motor;
import com.ericfr1tzenvalle.spring.course.arquitetura_spring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration // Indica que esta classe fornece beans para o container Spring
public class MontadoraConfiguration {

    @Bean
    @Primary // Define este bean como padrão quando houver múltiplos beans do mesmo tipo
    public Motor motorAspirado() {
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindroes(4);
        motor.setModelo("XPT0-0");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.ASPIRADO);
        return motor;
    }

    @Bean
    public Motor motorEletrico() {
        var motor = new Motor();
        motor.setCavalos(110);
        motor.setCilindroes(3);
        motor.setModelo("TH-40");
        motor.setLitragem(1.4);
        motor.setTipo(TipoMotor.ELETRICO);
        return motor;
    }

    @Bean
    public Motor motorTurbo() {
        var motor = new Motor();
        motor.setCavalos(180);
        motor.setCilindroes(4);
        motor.setModelo("XPT0-1");
        motor.setLitragem(1.5);
        motor.setTipo(TipoMotor.TURBO);
        return motor;
    }
}

/*
 * RESUMO:
 * - Use @Configuration para centralizar a criação de beans.
 * - Cada metodo @Bean deve retornar um objeto totalmente configurado.
 * - Prefira @Primary para definir qual bean será usado por padrão.
 * - Se houver múltiplos beans do mesmo tipo, use @Qualifier na injeção para escolher explicitamente.
 * - Mantém o container Spring organizado e desacoplado da lógica de negócio.
 */
