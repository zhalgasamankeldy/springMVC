package kz.vev.app.controller;

import java.util.List;

import javax.annotation.Resource;

import kz.vev.app.domain.Product;
import kz.vev.app.service.ProductService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles and retrieves product request
 */
@Controller
public class ProductController {

	protected static Logger logger = Logger.getLogger("controller Product");

	@Resource(name = "productService")
	private ProductService productService;

	/**
	 * Handles and retrieves all products and show it in a JSP page
	 * 
	 * @return /app/productpage
	 * @throws CustomException
	 */
	@RequestMapping(value = "/")
	public String getProduct(Model model, @RequestParam(value = "filter", required=false) String name) {

		logger.debug("Received request to show all products");	
    	name = (name == null) ? "" : name;	

		// Retrieve all products by delegating the call to ProductService
		List<Product> product = productService.getProductByName(name);

		// Attach products to the Model
		model.addAttribute("products", product);

		// This will resolve to /WEB-INF/jsp/productpage.jsp
		return "/product/index";
	}

	/**
	 * Retrieves the add page for Product
	 * 
	 * @return /app/inspage
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd(Model model) {
		logger.debug("Received request to show add page");

		// Create new Product and add to model
		// This is the formBackingOBject
		model.addAttribute("productAttribute", new Product());

		// This will resolve to /WEB-INF/jsp/inspage.jsp
		return "/product/addPage";
	}

	/**
	 * Adds a new product by delegating the processing to ProductService.
	 * Displays a confirmation JSP page
	 * 
	 * @return if the validation error "/app/inspage" otherwise
	 *         "/app/productpage"
	 * @throws Exception 
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("productAttribute") Product product, Model model) throws Exception {
		logger.debug("Received request to add new product");

		// The "productAttribute" model has been passed to the controller from
		// the JSP
		// We use the name "productAttribute" because the JSP uses that name

		// Call ProductService to do the actual adding
		productService.addProduct(product);

		// This will resolve to /WEB-INF/jsp/productpage.jsp
		return "redirect:/";
	}

	/**
	 * Retrieves the edit page
	 * 
	 * @return /app/editpage
	 * @throws CustomException
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getEdit(@RequestParam(value = "id", required = true) Long id,
			Model model) {
		logger.debug("Received request to show edit page");

		// Retrieve existing Product and add to model
		// This is the formBackingOBject
		model.addAttribute("productAttribute",
				productService.getProductByID(id)); 

		// This will resolve to /WEB-INF/jsp/editpage.jsp
		return "/product/editPage";
	}

	/**
	 * Edits an existing product by delegating the processing to ProductService.
	 * Displays a confirmation JSP page
	 * 
	 * @return if the validation error "/app/editpage" otherwise
	 *         "/app/productpage"
	 * @throws CustomException
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String saveEdit(
			@ModelAttribute("productAttribute") Product product, Model model,
			@RequestParam(value = "id", required = true) Long id) {
		logger.debug("Received request to update product");


		// The "productAttribute" model has been passed to the controller from
		// the JSP
		// We use the name "productAttribute" because the JSP uses that name

		// We manually assign the id because we disabled it in the JSP page
		// When a field is disabled it will not be included in the
		// ModelAttribute
		product.setId(id);

		productService.updProduct(product);

		// Add id reference to Model
		model.addAttribute("id", id);

		// This will resolve to /WEB-INF/jsp/productpage.jsp
		return "redirect:/";
	}

	/**//**
	 * Deletes an existing product by delegating the processing to
	 * ProductService. Displays a confirmation JSP page
	 * 
	 * @return /app/productpage
	 * @throws CustomException
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "id", required = true) Long id,
			Model model){

		logger.debug("Received request to delete existing product");

		// Call ProductService to do the actual deleting
//		productService.delProduct(id); TODO

		productService.delProduct(id);

		// Add id reference to Model
		model.addAttribute("id", id);

		// This will resolve to /WEB-INF/jsp/productpage.jsp
		return "redirect:/";
	}

	/**
	 * We catch errors and redirect to JSP page
	 * 
	 * @return /error
	 *//*
	@ExceptionHandler(CustomException.class)
	public ModelAndView handleCustomException(CustomException ex) {

		logger.debug("Handling exception for Product");

		ModelAndView model = new ModelAndView("error");
		model.addObject("message", ex.getMessage());
		return model;

	}

	*//**
	 * 
	 * @param model
	 * @return
	 *//*
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String getAbout(Model model) {

		logger.debug("Received request to show all products");

		return "/about";
	}
*/
}
