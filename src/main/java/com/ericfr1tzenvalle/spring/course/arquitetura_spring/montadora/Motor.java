/*
 * Classe - Motor
 * Curso: Spring Boot Expert
 *
 * Aborda:
 *  - Representa o motor de um carro
 *  - Contém modelo, potência, cilindros, litragem e tipo
 */

package com.ericfr1tzenvalle.spring.course.arquitetura_spring.montadora;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Motor {
    private String modelo;
    private int cavalos;
    private int cilindroes;
    private double litragem;
    private TipoMotor tipo;
}
