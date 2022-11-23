package com.example.rest_web_services_coding_assig.controller;

import com.example.rest_web_services_coding_assig.ProductNotFoundException;
import com.example.rest_web_services_coding_assig.model.AuthenticationRequest;
import com.example.rest_web_services_coding_assig.model.AuthenticationResponse;
import com.example.rest_web_services_coding_assig.model.Product;
import com.example.rest_web_services_coding_assig.repository.ProductRepository;
import com.example.rest_web_services_coding_assig.service.MyUserDetailsService;
import com.example.rest_web_services_coding_assig.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    private ProductRepository prodRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    //performing changes 2...


    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or Password", e);
        }
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

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
    public HttpStatus addProduct(@RequestBody Product product){
         prodRepository.save(product);
         return HttpStatus.OK;
    }


    //update/save product
    @PutMapping("/products")
    public List<Product> saveOrUpdate(@RequestBody Product product){
        prodRepository.save(product);
        return Collections.singletonList(product);
    }


    //delete product by id
    @DeleteMapping("products/{id}")
    public HttpStatus delete(@PathVariable("id") long id) {
        Product product =  prodRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException(id));
        prodRepository.delete(product);
        return HttpStatus.OK;
    }
}
