package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import app.model.Product;
import app.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/{id}")
	public String show(@PathVariable("id") int id, Model model) {
		Product product= productService.findById(id);
		model.addAttribute("product", product);
		return "products/product";
	}
}
