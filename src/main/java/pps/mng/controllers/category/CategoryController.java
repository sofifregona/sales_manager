package pps.mng.controllers.category;

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

import pps.mng.services.CategoryService;
import pps.mng.exception.Excep;
import pps.mng.entities.Category;


@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
    private CategoryService categoryService;
     
    @RequestMapping(path = {"", "/{id}/edit"}, method = RequestMethod.GET)
    public String prepareForms(Model model, @PathVariable("id") Optional<Long> id) throws Exception {
    	EditCategoryForm editFormBean = new EditCategoryForm();
    	if (id.isPresent()) {
    		Category entity = categoryService.getById(id.get());
    		editFormBean = new EditCategoryForm(entity);	
		} 
    	model.addAttribute("editFormBean", editFormBean);
    	return "category";
    }
	
    @ModelAttribute("allCategories")
    public List<Category> getAllCategories() {
        return this.categoryService.getAll();
    }
    
	@RequestMapping(path = "/{id}/delete", method = RequestMethod.GET)
	public String deleteById(Model model, @PathVariable("id") Long id) {
		Category c = categoryService.getById(id);
		categoryService.delete(c);
		return "redirect:/category";	
	}
 
	@RequestMapping(method = RequestMethod.POST, params = "edit")
	public String submitForEdit(@ModelAttribute("editFormBean") @Valid EditCategoryForm editFormBean, BindingResult editResult, ModelMap model, @RequestParam("edit") String action) {
		if (action.equals("accept_forEdit")) {
			if(editResult.hasErrors()) {              
				model.addAttribute("editFormBean", editFormBean);
				return "category";
			} else {
				try {
					Category c = editFormBean.toPojo();
					categoryService.save(c);
					model.addAttribute("editFormBean", new EditCategoryForm());
					return "redirect:/category";
				} catch (Excep e) {
					if (e.getAtribute() == null) {
						ObjectError error = new ObjectError("globalError", e.getMessage());
			            editResult.addError(error);
					} else {
			    		FieldError error = new FieldError("editFormBean", e.getAtribute(), e.getMessage());
			            editResult.addError(error);
					}
		            model.addAttribute("editFormBean", editFormBean);
	    			return "category";
				}
			}
		} else if (action.equals("return_forEdit")) {
			model.addAttribute("editFormBean", new EditCategoryForm());
			return "redirect:/category";
		} else {
			model.addAttribute("editFormBean", new EditCategoryForm());
			return "redirect:/";
		}
	}
}
