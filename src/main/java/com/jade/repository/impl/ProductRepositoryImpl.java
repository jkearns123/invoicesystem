//package com.jade.repository.impl;
//
//import com.jade.domain.Product;
//import com.jade.repository.ProductRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Repository("InMemory6")
//public class ProductRepositoryImpl implements ProductRepository {
//
//    //changed from private static ProductRepository repository = null;
//    private static ProductRepositoryImpl repository = null;
//    private Set<Product> prouducts;
//
//    private ProductRepositoryImpl(){
//        this.prouducts = new HashSet<>();
//    }
//
//    //changed from public static ProductRepository getRepository(){
//    public static ProductRepositoryImpl getRepository(){
//        if(repository == null) repository = new ProductRepositoryImpl();
//        return repository;
//    }
//
//    private Product findProduct(final String productId){
//        for(Product p : this.prouducts){
//            if(p.getProductId().equals(productId)) return p;
//        }
//        return null;
//        //return this.prouducts.stream().filter(product -> product.getProductId().equals(productId)).findAny().orElse(null);
//    }
//
//    public Product create(Product product){
//        this.prouducts.add(product);
//        return product;
//    }
//
//
//    public void delete(String productId){
//        Product product = findProduct(productId);
//        if (product != null)
//        this.prouducts.remove(product);
//    }
//
//    public Product read(final String productId){
//        Product product = findProduct(productId);
//        return product;
//    }
//
//    public Product update(Product product){
//        Product toDelete = findProduct(product.getProductId());
//        if(toDelete != null){
//            this.prouducts.remove(toDelete);
//            return create(product);
//        }
//        return null;
//    }
//
//    public Set<Product> getAll(){
//        return this.prouducts;
//    }
//
//}
