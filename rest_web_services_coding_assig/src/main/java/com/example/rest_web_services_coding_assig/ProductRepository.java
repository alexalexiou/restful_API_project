package com.example.rest_web_services_coding_assig;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


//@RepositoryRestResource(collectionResourceRel="products",path="products")
public interface ProductRepository extends JpaRepository<Product, Long>{


    List<Product> findByName(String name);

    List<Product> findAllByOrderByPriceAsc();

    List<Product> findAllByOrderByPriceDesc();

    List<Product> findByCode(String code);


}
