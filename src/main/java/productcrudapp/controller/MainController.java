package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao productdao;

	@RequestMapping(value = { "/", "/home" })
	public String home(Model model) {

		List<Product> products = productdao.getProducts();
		model.addAttribute("products", products);
		model.addAttribute("title", "Home");
		System.out.println("home url");
		return "index";
	}

	@RequestMapping("/add-product")
	public String addProduct(Model model) {
		model.addAttribute("title", "Add Product");
		System.out.println("Add product url");
		return "add_product_form";
	}

	@RequestMapping(path = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleForm(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);

		RedirectView redirectView = new RedirectView();

		productdao.createProdect(product);

		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}

	@RequestMapping(path = "/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request) {

		RedirectView redirectView = new RedirectView();
		this.productdao.deleteProdect(productId);

		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;

	}
	@RequestMapping(path = "/update/{productId}")
	public String updateForm(@PathVariable("productId") int productId,Model model) {
		
		Product product = this.productdao.getProduct(productId);
		model.addAttribute("product", product);
		model.addAttribute("title", "Update Product");
		
		return "update_form";
	}

}
