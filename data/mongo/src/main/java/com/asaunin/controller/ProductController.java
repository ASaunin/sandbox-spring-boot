package com.asaunin.controller;

import com.asaunin.domain.Product;
import com.asaunin.mapper.ProductMapper;
import com.asaunin.model.ProductForm;
import com.asaunin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/")
    public String redirectToList(){
        return "redirect:/product/list";
    }

    @GetMapping({"/product/list", "/product"})
    public String listProducts(Model model){
        model.addAttribute("products", productService.listAll());
        return "product/list";
    }

    @GetMapping("/product/view/{id}")
    public String getProduct(@PathVariable String id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "product/view";
    }

    @GetMapping("product/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        final Product product = productService.getById(id);
        final ProductForm productForm = productMapper.formDomainToModel(product);

        model.addAttribute("productForm", productForm);
        return "product/edit";
    }

    @GetMapping("/product/new")
    public String newProduct(Model model) {
        model.addAttribute("productForm", new ProductForm());
        return "product/edit";
    }

    @PostMapping(value = "/product")
    public String saveOrUpdateProduct(@Valid ProductForm productForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "product/edit";
        }

        final Product product = productMapper.fromModelToDomain(productForm);
        final Product savedProduct = productService.saveOrUpdate(product);

        return "redirect:/product/view/" + savedProduct.getId();
    }

    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable String id) {
        productService.delete(id);
        return "redirect:/product/list";
    }

}
