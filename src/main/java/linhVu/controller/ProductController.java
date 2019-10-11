package linhVu.controller;

import linhVu.model.Product;
import linhVu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ModelAndView listEmployees(@RequestParam("searchName") Optional<String> name, @PageableDefault(value =1) Pageable pageable){
        Page<Product> products;
        if(name.isPresent()){
            products= productService.findAllByNameContaining(name.get(),pageable);
        }else{
            products = productService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }
    @GetMapping("/view-product/{id}")
    public String viewProduct(@PathVariable Long id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "product/view";
    }
}
