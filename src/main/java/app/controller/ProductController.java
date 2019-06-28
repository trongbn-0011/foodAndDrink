package app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import app.model.Product;
import app.service.ProductService;

@Controller
@PropertySource("classpath:constants.properties")
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Value("${defaultProductPage}")
	private int defaultPage;
	@Value("${defaultProductPageSize}")
	private int defaultPageSize;
	
	@GetMapping(value = "/index")
	public String index(Model model, @RequestParam("search") Optional<String> search, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		int currentPage = page.orElse(defaultPage);
	    int pageSize = size.orElse(defaultPageSize);
	    String productName = search.orElse("");
	    
	    Page<Product> products = productService.loadProducts(productName, PageRequest.of(currentPage - 1, pageSize));
	    
	    model.addAttribute("search", productName);
	    model.addAttribute("products", products);
	    
	    int totalPages = products.getTotalPages();
        
	    if (totalPages > 0) {
            List<Integer> pages = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }
	    return "products/index";
	}
	
	@GetMapping(value = "/{id}")
	public String show(@PathVariable("id") int id, Model model) {
		Product product= productService.findById(id);
		model.addAttribute("product", product);
		return "products/product";
	}
	
}
