package com.market.demo.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "title")
    private String title;

    @Column
    private int price;

    public Product(Long id, String title, int price){
        this.id= id;
        this.title = title;
        this.price = price;
    }
}
