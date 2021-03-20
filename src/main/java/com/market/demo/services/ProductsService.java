package com.market.demo.services;


import com.market.demo.entities.Product;
import com.market.demo.exeptions.ProductNotFoundException;
import com.market.demo.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    public Product saveOrUpdate(Product product){
        return productsRepository.save(product);
    }

    public Product findById(Long id){
        return productsRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Cant find product with id = " + id));
    }

    public List<Product> findAll(){
        return productsRepository.findAll();
    }

    public Page<Product> findAll(Specification<Product> spec,Integer page){
        if(page< 1L){
            page = 1;
        }
        return productsRepository.findAll(spec.PageRequest.of(page - 1, 10));
    }
}
