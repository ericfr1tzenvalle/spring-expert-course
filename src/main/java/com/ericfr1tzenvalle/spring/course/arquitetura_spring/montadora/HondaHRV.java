/*
 * Classe - HondaHRV
 * Curso: Spring Boot Expert
 *
 * Aborda:
 *  - Extende Carro
 *  - Define valores padrão: modelo, cor e montadora
 *  - Recebe motor no construtor
 */

package com.ericfr1tzenvalle.spring.course.arquitetura_spring.montadora;

import java.awt.Color;

public class HondaHRV extends Carro{
    public HondaHRV(Motor motor) {
        super(motor);
        setColor(Color.BLACK);
        setModelo("HRV");
        setMontadora(Montadora.HONDA);
    }
}
