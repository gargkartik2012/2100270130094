package org.springbootdemo.ecommerceserver.Service;

import org.springbootdemo.ecommerceserver.Entity.Product;
import org.springbootdemo.ecommerceserver.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    private ProductRepo repository;


    @Autowired
    public ProductService(ProductRepo repository) {
        this.repository = repository;
    }

    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> saveAllProducts(List<Product> products){
        return repository.saveAll(products);

    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public List<Product> getAllProductByName(String name){
        return repository.findAllByName(name);
    }

    public List<Product> getAllProductByAvailability(String availability){
        return repository.findAllByAvailability(availability);
    }

    public List<Product> getAllProductByPrice(Integer price){
        return repository.findAllByPrice(price);
    }

    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product removed !!" +id;
    }

    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        assert existingProduct != null;
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setRating(product.getRating());
        existingProduct.setDiscount(product.getDiscount());
        existingProduct.setAvailability(product.getAvailability());
        return repository.save(existingProduct);
    }






}
