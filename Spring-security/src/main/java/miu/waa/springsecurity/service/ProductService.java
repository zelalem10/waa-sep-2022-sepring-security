package miu.waa.springsecurity.service;


import miu.waa.springsecurity.entity.Product;
import miu.waa.springsecurity.entity.Review;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    void save(Product p);

    void delete(int id);

    Product getById(int id);

    List<Product> getAll();

}
