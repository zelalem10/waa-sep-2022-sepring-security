package miu.waa.springsecurity.service.impl;

import lombok.RequiredArgsConstructor;
import miu.waa.springsecurity.entity.Product;
import miu.waa.springsecurity.entity.User;
import miu.waa.springsecurity.repository.ProductRepo;
import miu.waa.springsecurity.security.AwesomeUserDetails;
import miu.waa.springsecurity.service.ProductService;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public void save(Product p) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AwesomeUserDetails awesomeUserDetails = (AwesomeUserDetails) authentication.getPrincipal();
        int userId = awesomeUserDetails.getId();
        Product product = new Product();
        product.setName(p.getName());
        product.setPrice(p.getPrice());
        product.setUser(p.getUser());
        product.getUser().setId(userId);
        productRepo.save(product);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product getById(int id) {
        return productRepo.findById(id).get();
    }

//    @PreAuthorize("hasRole('ROLE_GOLD')")
    public List<Product> getAll() {
        var result = new ArrayList<Product>();
        productRepo.findAll().forEach(result::add);
        return result;
    }
}
