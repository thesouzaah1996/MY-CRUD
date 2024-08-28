package com.learn2code.Startup;

import com.learn2code.Startup.model.Product;
import com.learn2code.Startup.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        List<Product> products = productService.listAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            productService.deleteProduct(id);

            redirectAttributes.addFlashAttribute("message", "The product with ID=" + id + " has been deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message" + e.getMessage());
        }

        return "redirect:/products";
    }
}
