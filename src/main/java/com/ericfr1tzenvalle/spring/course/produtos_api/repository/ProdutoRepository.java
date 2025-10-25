package com.ericfr1tzenvalle.spring.course.produtos_api.repository;

import com.ericfr1tzenvalle.spring.course.produtos_api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
