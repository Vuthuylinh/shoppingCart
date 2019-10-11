package linhVu.service.impl;

import linhVu.model.Product;
import linhVu.repository.ProductRepositoryPagingAndSorting;
import linhVu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ProductServiceImpl implements ProductService {
@Autowired
    ProductRepositoryPagingAndSorting productRepositoryPagingAndSorting;
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepositoryPagingAndSorting.findAll(pageable);
    }

    @Override
    public Page<Product> findAllByNameContaining(String name, Pageable pageable) {
        return productRepositoryPagingAndSorting.findAllByNameContaining(name,pageable);
    }

    @Override
    public Product findById(Long id) {
        return productRepositoryPagingAndSorting.findOne(id);
    }

}
