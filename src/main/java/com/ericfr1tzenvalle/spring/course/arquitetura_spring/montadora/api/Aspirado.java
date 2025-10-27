/*
 * Annotation personalizada - @Aspirado
 * Curso: Spring Boot Expert
 *
 * Aborda:
 *  - Criação de annotations customizadas no Spring
 *  - Uso de @Qualifier para diferenciar beans
 *  - Configuração de RetentionPolicy e Target para controlar onde e por quanto tempo a annotation existe
 *
 * Conceito principal:
 *  Annotations personalizadas podem ser usadas para simplificar a escolha de beans
 *  em projetos Spring, tornando o código mais legível e modular.
 */

package com.ericfr1tzenvalle.spring.course.arquitetura_spring.montadora.api;

import org.springframework.beans.factory.annotation.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Qualifier("motorAspirado")
public @interface Aspirado {
}

// ----------------------- NOTAS EXPLICATIVAS -----------------------
// @Retention(RUNTIME):
// - Define que a annotation estará disponível em tempo de execução.
// - Necessário para que o Spring consiga ler via reflexão e realizar a injeção de dependência.
//
// @Target({ElementType.FIELD, ElementType.METHOD}):
// - Define onde a annotation pode ser aplicada.
// - ElementType.FIELD: pode ser usada em atributos/variáveis de classe.
// - ElementType.METHOD: pode ser usada em métodos, como setters ou métodos de beans.
//
// @Qualifier("motorAspirado"):
// - Indica ao Spring qual bean específico deve ser injetado.
// - Permite criar annotations personalizadas como @Aspirado para facilitar a leitura e reduzir repetição.
//
// Boas práticas:
// - Use annotations personalizadas para diferenciar beans quando houver múltiplas implementações.
// - Combine sempre @Retention(RUNTIME) para que o Spring consiga processar a annotation em runtime.
// - Limite o uso com @Target para deixar claro onde a annotation pode ser aplicada.
// - Mantém o código mais limpo, legível e menos propenso a erros de injeção.
