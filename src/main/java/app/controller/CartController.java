package app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.bean.CartItem;
import app.bean.ProductInfo;
import app.service.ProductService;

@Controller
@RequestMapping("cart")
public class CartController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value="/index") 
	public String index() {
		return "cart/index";
	}
	
	@GetMapping(value="/add")
	public String add(@RequestParam("productId") Integer productId, 
			@RequestParam("quantity") Integer quantity,
			HttpSession session) {
		ProductInfo product = new ProductInfo(productService.findById(productId));
		List<CartItem> cart = new ArrayList<CartItem>();
		if (session.getAttribute("cart") == null) {
			cart.add(new CartItem(product, 1));
		} else {
			cart = (List<CartItem>) session.getAttribute("cart");
			int index = this.exists(productId, cart);
			if (index == -1) {
				cart.add(new CartItem(product, 1));
			} else {
				int quantityInCart = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantityInCart);
			}
		}
		session.setAttribute("cart", cart);
		session.setAttribute("totalCart", this.totalCart(cart));
		return "redirect:index";
	}
	
	private int exists(int productId, List<CartItem> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId()== productId) {
				return i;
			}
		}
		return -1;
	}
	
	private float totalCart(List<CartItem> items) {
		float total = 0;
		for(CartItem item : items) {
			total += item.getProduct().getPrice() * item.getQuantity();
		}
		return total;
	}
	
}