package org.springbootdemo.ecommerceserver.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT_TBL")
public class Product {


    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String name;
    private Integer price;
    private double rating;
    private Integer discount;
    private String availability;
}
