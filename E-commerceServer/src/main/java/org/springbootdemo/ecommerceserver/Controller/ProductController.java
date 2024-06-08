package org.springbootdemo.ecommerceserver.Controller;


import org.springbootdemo.ecommerceserver.Entity.Product;
import org.springbootdemo.ecommerceserver.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }


    @PostMapping("/addProduct")
    public Product addProduct(@Validated @RequestBody Product product){
        return service.saveProduct(product);
    }


    @PostMapping("/addProducts")
    public List<Product> addProducts(@Validated @RequestBody List<Product> products){
        return service.saveAllProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }


    @GetMapping("/product/name/{name}")
    public List<Product> findProductByName(@PathVariable String name){
        return service.getAllProductByName(name);
    }


    @GetMapping("/product/price/{price}")
    public List<Product> findProductByPrice(@PathVariable Integer price){
        return service.getAllProductByPrice(price);

    }

    @GetMapping("/product/availability/{availability}")
    public List<Product> findProductByAvailability(@PathVariable String availability){
        return service.getAllProductByAvailability(availability);
    }

    @PutMapping("/update")
    public Product updateProduct( @Validated @RequestBody Product product){
        return service.updateProduct(product);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }

}
