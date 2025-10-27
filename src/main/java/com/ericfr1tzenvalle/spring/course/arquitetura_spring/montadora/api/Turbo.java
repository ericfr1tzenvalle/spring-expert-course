/*
 * Annotation personalizada - @Turbo
 * Curso: Spring Boot Expert
 *
 * Aborda:
 *  - Identifica o bean "motorTurbo"
 *  - Funciona igual às outras annotations de motor (@Aspirado, @Eletrico)
 */

package com.ericfr1tzenvalle.spring.course.arquitetura_spring.montadora.api;

import org.springframework.beans.factory.annotation.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Qualifier("motorTurbo")
public @interface Turbo {
}

// ---------------------------------------------
// Funciona igual à annotation @Aspirado:
// - @Retention(RUNTIME): disponível em tempo de execução
// - @Target(FIELD, METHOD): aplicável em atributos e métodos
// - @Qualifier("motorTurbo"): define qual bean será injetado
// Boas práticas: igual às outras annotations, apenas serve para diferenciar beans, evitando repetição de @Qualifier.
