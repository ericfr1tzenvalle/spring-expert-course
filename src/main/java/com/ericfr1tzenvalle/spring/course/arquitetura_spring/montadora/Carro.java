/*
 * Classe - Carro
 * Curso: Spring Boot Expert
 *
 * Aborda:
 *  - Modelo de carro com atributos principais
 *  - Construtor com motor
 *  - Metodo darIgnicao para ligar o carro com uma chave
 */

package com.ericfr1tzenvalle.spring.course.arquitetura_spring.montadora;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.Color;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carro {
    private String modelo;
    private Color color;
    private Motor motor;
    private Montadora montadora;

    public Carro(Motor motor){
        this.motor = motor;
    }

    public CarroStatus darIgnicao(Chave chave) {
        if(chave.getMontadora() != this.montadora){
            return new CarroStatus("Não é possível iniciar carro com essa chave");
        }
        return new CarroStatus("Carro Ligado! " + motor.toString());
    }
}
