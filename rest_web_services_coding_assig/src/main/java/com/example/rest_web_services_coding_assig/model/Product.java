package com.example.rest_web_services_coding_assig.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="prod_Name", length = 100, nullable = false)
    private String name;

    @Column(name="price", nullable = false)
    private BigDecimal price;

    @Column(name = "prod_Code", nullable = false)
    private String code;

    @Column(name="avail_Date", nullable = false)
    private LocalDate availDate;

    @Column(name="exp_Date")
    private LocalDate expDate;


    public Product(){}

    public Product(String name, BigDecimal price, String code, LocalDate availDate) {
        this.name = name;
        this.price = price;
        this.code = code;
        this.availDate = availDate;
    }


    public Product(String name, BigDecimal price, String code, LocalDate availDate, LocalDate expDate) {
        this.name = name;
        this.price = price;
        this.code = code;
        this.availDate = availDate;
        this.expDate = expDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getAvailDate() {
        return availDate;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setAvailDate(LocalDate availDate) {
        this.availDate = availDate;
    }
    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", code='" + code + '\'' +
                ", availDate='" + availDate + '\'' +
                ", expDate='" + expDate + '\'' +
                '}';
    }
}
