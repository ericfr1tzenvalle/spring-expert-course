/*
 * Classe - Chave
 * Curso: Spring Boot Expert
 *
 * Aborda:
 *  - Representa uma chave de carro
 *  - Contém referência à montadora e tipo da chave
 */

package com.ericfr1tzenvalle.spring.course.arquitetura_spring.montadora;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chave {
    private Montadora montadora;
    private String tipo;
}
