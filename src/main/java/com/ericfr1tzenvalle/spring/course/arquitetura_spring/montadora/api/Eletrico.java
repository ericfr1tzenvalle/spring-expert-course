/*
 * Annotation personalizada - @Eletrico
 * Curso: Spring Boot Expert
 *
 * Aborda:
 *  - Annotation customizada para identificar o bean "motorEletrico"
 *  - Funciona da mesma forma que @Aspirado
 *  - Evita repetição de @Qualifier nos controllers
 */

package com.ericfr1tzenvalle.spring.course.arquitetura_spring.montadora.api;

import org.springframework.beans.factory.annotation.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Qualifier("motorEletrico")
public @interface Eletrico {
}

// ----------------------------------------------
// Funciona igual à annotation @Aspirado:
// - @Retention(RUNTIME) → disponível em tempo de execução
// - @Target(FIELD, METHOD) → aplicável em atributos e métodos
// - @Qualifier("motorEletrico") → define qual bean será injetado
// Boas práticas: apenas crie annotations personalizadas para evitar repetição de @Qualifier
