package kz.vev.app.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kz.vev.app.domain.Category;
import kz.vev.app.domain.Product;
import kz.vev.app.service.CategoryService;
import kz.vev.app.service.ProductService;

@Controller
public class CategoryController {
	

	protected static Logger logger = Logger.getLogger("controller Product");

	@Resource(name = "categoryService")
	private CategoryService categoryService;
	
	@RequestMapping(value = "/category/")
	public String getPCategory(Model model, @RequestParam(value = "filter", required=false) String name) {

		logger.debug("Received request to show all products");	
    	name = (name == null) ? "" : name;	

		// Retrieve all products by delegating the call to ProductService
		List<Category> category = categoryService.getCategoryByName(name);

		// Attach products to the Model
		model.addAttribute("categories", category);

		// This will resolve to /WEB-INF/jsp/productpage.jsp
		return "/category/index";
	}
	
	@RequestMapping(value = "/category/add", method = RequestMethod.GET)
	public String getAdd(Model model) {
		logger.debug("Received request to show add page");

		// Create new Product and add to model
		// This is the formBackingOBject
		model.addAttribute("categoryAttribute", new Category());

		// This will resolve to /WEB-INF/jsp/inspage.jsp
		return "/category/addPage";
	}
	
	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("productAttribute") Category category, Model model) throws Exception {
		logger.debug("Received request to add new product");

		// The "productAttribute" model has been passed to the controller from
		// the JSP
		// We use the name "productAttribute" because the JSP uses that name

		// Call ProductService to do the actual adding
		categoryService.addCategory(category);

		// This will resolve to /WEB-INF/jsp/productpage.jsp
		return "redirect:/category/";
	}
	

	@RequestMapping(value = "/category/edit", method = RequestMethod.GET)
	public String getEdit(@RequestParam(value = "id", required = true) Long id,
			Model model) {
		logger.debug("Received request to show edit page");

		// Retrieve existing Product and add to model
		// This is the formBackingOBject
		model.addAttribute("categoryAttribute",
				categoryService.getCategoryByID(id)); 

		// This will resolve to /WEB-INF/jsp/editpage.jsp
		return "/category/editPage";
	}
	
	@RequestMapping(value = "/category/edit", method = RequestMethod.POST)
	public String saveEdit(
			@ModelAttribute("categoryAttribute") Category category, Model model,
			@RequestParam(value = "id", required = true) Long id) {
		logger.debug("Received request to update product");

		category.setId(id);

		categoryService.updCategory(category);

		// Add id reference to Model
		model.addAttribute("id", id);

		// This will resolve to /WEB-INF/jsp/productpage.jsp
		return "redirect:/category/";
	}
	
	
	@RequestMapping(value = "/category/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "id", required = true) Long id,
			Model model){

		logger.debug("Received request to delete existing product");

		// Call ProductService to do the actual deleting
//		productService.delProduct(id); TODO

		categoryService.delCategory(id);

		// Add id reference to Model
		model.addAttribute("id", id);

		// This will resolve to /WEB-INF/jsp/productpage.jsp
		return "redirect:/category/";
	}

}
