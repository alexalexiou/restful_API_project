package com.example.rest_web_services_coding_assig;

public class ProductNotFoundException extends RuntimeException {



    public ProductNotFoundException(String name){
        super("Cannot find product by name: "+name);
      //  System.out.println("Cannot find product by name: "+name);
    }


    public ProductNotFoundException( String code, String al){
        super("Cannot find product by code: "+code);
        //  System.out.println("Cannot find product by name: "+name);
    }

    public ProductNotFoundException( long id){
        super("Cannot find product by id: "+id);
        //  System.out.println("Cannot find product by name: "+name);
    }
}
