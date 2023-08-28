package pps.mng.controllers.brand;

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

import pps.mng.services.BrandService;
import pps.mng.exception.Excep;
import pps.mng.entities.Brand;


@Controller
@RequestMapping("/brand")
public class BrandController {
	@Autowired
    private BrandService brandService;
     
    @RequestMapping(path = {"", "/{id}/edit"}, method = RequestMethod.GET)
    public String prepareForms(Model model, @PathVariable("id") Optional<Long> id) throws Exception {
    	model.addAttribute("allBrands", brandService.getAll());
	 	EditBrandForm editFormBean = new EditBrandForm();
    	if (id.isPresent()) {
    		Brand entity = brandService.getById(id.get());
    		editFormBean = new EditBrandForm(entity);	
		} 
    	model.addAttribute("editFormBean", editFormBean);
    	return "brand";
    }
	
	@RequestMapping(path = "/{id}/delete", method = RequestMethod.GET)
	public String deleteById(Model model, @PathVariable("id") Long id) {
		Brand b = brandService.getById(id);
		brandService.delete(b);
		return "redirect:/brand";	
	}
 
	@RequestMapping(method = RequestMethod.POST, params = "edit")
	public String submitForEdit(@ModelAttribute("editFormBean") @Valid EditBrandForm editFormBean, BindingResult editResult, ModelMap model, @RequestParam("edit") String action) {
		if (action.equals("accept_forEdit")) {
			if(editResult.hasErrors()) {              
				model.addAttribute("editFormBean", editFormBean);
				model.addAttribute("allBrands", brandService.getAll());
				return "brand";
			} else {
				try {
					Brand b = editFormBean.toPojo();
					brandService.save(b);
					model.addAttribute("editFormBean", new EditBrandForm());
					return "redirect:/brand";
				} catch (Excep e) {
					if (e.getAtribute() == null) {
						ObjectError error = new ObjectError("globalError", e.getMessage());
			            editResult.addError(error);
					} else {
			    		FieldError error = new FieldError("editFormBean", e.getAtribute(), e.getMessage());
			            editResult.addError(error);
					}
		            model.addAttribute("editFormBean", editFormBean);
		            model.addAttribute("allBrands", brandService.getAll());
	    			return "brand";
				}
			}
		} else if (action.equals("return_forEdit")) {
			model.addAttribute("editFormBean", new EditBrandForm());
			return "redirect:/brand";
		} else {
			model.addAttribute("editFormBean", new EditBrandForm());
			return "redirect:/";
		}
	}
}
