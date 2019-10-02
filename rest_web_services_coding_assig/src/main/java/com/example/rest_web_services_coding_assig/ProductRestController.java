package com.example.rest_web_services_coding_assig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductRestController {

    @Autowired
    private ProductRepository prodRepository;

    @GetMapping("/products")
    public List<Product> getAll(){
        return prodRepository.findAll();
    }

    @GetMapping("/products/name/{name}")
    public List<Product> getProductByName(@PathVariable("name") String name){
        List<Product> products = prodRepository.findByName(name);
        if(!products.isEmpty())
            return prodRepository.findByName(name);
        else
            throw new ProductNotFoundException(name);
    }

    //find by price ascending
    @GetMapping("/products/price/asc")
    public List<Product> getProductByPriceAsc(){
        return prodRepository.findAllByOrderByPriceAsc();
    }

    //find by price descending
    @GetMapping("/products/price/desc")
    public List<Product> getProductByPriceDesc(){
        return prodRepository.findAllByOrderByPriceDesc();
    }

    @GetMapping("/products/code/{code}")
    public List<Product> getProductByCode(@PathVariable("code") String code) {
        List<Product> products = prodRepository.findByCode(code);
        if(!products.isEmpty())
            return prodRepository.findByCode(code);
        else
            throw new ProductNotFoundException(code, code);
    }


    //insert product
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return prodRepository.save(product);
    }


    //update/save product
    @PutMapping("/products")
    public List<Product> saveOrUpdate(@RequestBody Product product){
        prodRepository.save(product);
        return Collections.singletonList(product);
    }


    //delete product by id
    @DeleteMapping("products/{id}")
    public String delete(@PathVariable("id") long id) {
        Product product =  prodRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException(id));
        prodRepository.delete(product);
        return "Success";
    }
}
