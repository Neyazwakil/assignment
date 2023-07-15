package com.neyaz.MYSQLEcommerce.Service;


import com.neyaz.MYSQLEcommerce.Model.Product;

import com.neyaz.MYSQLEcommerce.Repository.IproductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    IproductRepo  iproductRepo;
    public void addproduct(Product product) {
        iproductRepo.save(product);
    }

    public List<Product> getallProducts() {
        return iproductRepo.findAll();
    }

    public List<Product> getproductsbycategory(String category) {
        return iproductRepo.findByproductCategory(category);
    }

    public void deletebyid(Integer id) {
        iproductRepo.deleteById(id);
    }
}
