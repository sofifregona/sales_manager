package pps.mng.controllers.product;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pps.mng.services.ProductService;
import pps.mng.services.BrandService;
import pps.mng.services.CategoryService;
import pps.mng.exception.Excep;
import pps.mng.entities.Product;
import pps.mng.entities.Brand;
import pps.mng.entities.Category;


@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
    private ProductService productService;
	
	@Autowired
    private BrandService brandService;
	
	@Autowired
    private CategoryService categoryService;
     
    @RequestMapping(path = {"", "/{id}/edit", "/filter"}, method = RequestMethod.GET)
    public String prepareForms(Model model, @PathVariable("id") Optional<Long> id, 
    		@RequestParam("name") Optional<String> name,
    		@RequestParam("code") Optional<String> code,
    		@RequestParam("brand") Optional<Long> idBrand,
    		@RequestParam("category") Optional<Long> idCategory) throws Exception {
    	// Para encontrar
    	FindProductForm findFormBean = new FindProductForm();
    	List<Product> products;
    	if (name.isPresent() || code.isPresent() || idBrand.isPresent() || idCategory.isPresent()) {
    		findFormBean = new FindProductForm(name.isPresent() ? name.get() : null, code.isPresent() ? code.get() : null, idBrand.isPresent() ? idBrand.get() : null, idCategory.isPresent() ? idCategory.get() : null);
    		products = productService.filter(findFormBean);
    	} else {
    		products = productService.getAll();
    	}
    	model.addAttribute("findFormBean", findFormBean);
	 	model.addAttribute("allProducts", products);
	 	// Para editar
	 	EditProductForm editFormBean = new EditProductForm();
    	if (id.isPresent()) {
    		Product entity = productService.getById(id.get());
    		editFormBean = new EditProductForm(entity);
		} 
    	// Si {idBrand} en "/{idBrand}/editByBrand is present -->
    	// Para cada producto de la lista de Products.getByBrand 
    	// Seteo precio *porcentaje (1.porc) y guardo
    	model.addAttribute("editFormBean", editFormBean);
    	return "product";
    }
    
    @ModelAttribute("allBrands")
    public List<Brand> getAllBrands() {
        return this.brandService.getAll();
    }
    
    @ModelAttribute("allCategories")
    public List<Category> getAllCategories() {
        return this.categoryService.getAll();
    }
	
	@RequestMapping(path = "/{id}/delete", method = RequestMethod.GET)
	public String deleteById(Model model, @PathVariable("id") Long id) {
		productService.deleteById(id);
		return "redirect:/product";
	}
 
	@RequestMapping(method = RequestMethod.POST, params = "edit")
	public String submitForEdit(@ModelAttribute("editFormBean") @Valid EditProductForm editFormBean, BindingResult editResult, ModelMap model, @RequestParam("edit") String action) {
		if (action.equals("accept_forEdit")) {
			System.out.println("inicio"+editFormBean.getCode()+"final");
			if (editResult.hasErrors()) {              
				model.addAttribute("editFormBean", editFormBean);
				model.addAttribute("findFormBean", new FindProductForm()); ///
				model.addAttribute("allProducts", productService.getAll()); ///
				return "product";
			} else {
				try {
					System.out.println(editFormBean.getCode());
					System.out.println(editFormBean.getIdBrand());
					System.out.println(editFormBean.getIdCategory());
					Product p = editFormBean.toPojo();
					if (editFormBean.getIdBrand() != null)
						p.setBrand(brandService.getById(editFormBean.getIdBrand()));
					if (editFormBean.getIdCategory() != null)
						p.setCategory(categoryService.getById(editFormBean.getIdCategory()));
					productService.save(p);
					model.addAttribute("editFormBean", new EditProductForm());
					return "redirect:/product";
				} catch (Excep e) {
					if (e.getAtribute() == null) {
						ObjectError error = new ObjectError("globalError", e.getMessage());
			            editResult.addError(error);
					} else {
			    		FieldError error = new FieldError("editFormBean", e.getAtribute(), e.getMessage());
			            editResult.addError(error);
					}
		            model.addAttribute("editFormBean", editFormBean);
		            model.addAttribute("findFormBean", new FindProductForm()); ///
		            model.addAttribute("allProducts", productService.getAll()); ///
	    			return "product";
				}
			}
		} else if (action.equals("return_forEdit")) {
			model.addAttribute("editFormBean", new EditProductForm());
			return "redirect:/product";
		} else {
			model.addAttribute("editFormBean", new EditProductForm());
			return "redirect:/";
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, params = "filter")
	public String submitForFind(@ModelAttribute("findFormBean") @Valid FindProductForm findFormBean, BindingResult findResult, ModelMap model, @RequestParam("filter") String action) {
		if (action.equals("filter_forFind")) {
			model.addAttribute("findFormBean", findFormBean);
			String url = "redirect:/product/filter?";
			if (findFormBean.getName() != null) {
				url += "name="+findFormBean.getName();
				if (findFormBean.getCode() != null || findFormBean.getIdBrand() != null || findFormBean.getIdCategory() != null)
					url += "&";
			}
			if (findFormBean.getCode() != null) {
				url += "code="+findFormBean.getCode();
				if (findFormBean.getIdBrand() != null || findFormBean.getIdCategory() != null)
					url += "&";
			}
			if (findFormBean.getIdBrand() != null) {
				url += "brand="+findFormBean.getIdBrand();
				if (findFormBean.getIdCategory() != null)
					url += "&";
			}
			if (findFormBean.getIdCategory() != null)
				url += "category="+findFormBean.getIdCategory();
			return url;
		} else {
			model.addAttribute("findFormBean", new FindProductForm());
			return "redirect:/product";
		}
	}
}
