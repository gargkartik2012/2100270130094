package org.springbootdemo.ecommerceserver.Repository;

import org.springbootdemo.ecommerceserver.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {


    List<Product> findAllByPrice(Integer price);

    List<Product> findAllByAvailability(String availability);

    List<Product> findAllByName(String name);

}
