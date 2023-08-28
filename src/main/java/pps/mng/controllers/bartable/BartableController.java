package pps.mng.controllers.bartable;

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

import pps.mng.services.BartableService;
import pps.mng.exception.Excep;
import pps.mng.entities.Bartable;


@Controller
@RequestMapping("/bartable")
public class BartableController {
	@Autowired
    private BartableService bartableService;
     
    @RequestMapping(path = {"", "/{id}/edit"}, method = RequestMethod.GET)
    public String prepareForms(Model model, @PathVariable("id") Optional<Long> id) throws Exception {
    	EditBartableForm editFormBean = new EditBartableForm();
    	if (id.isPresent()) {
    		Bartable entity = bartableService.getById(id.get());
    		editFormBean = new EditBartableForm(entity);	
		}
    	model.addAttribute("editFormBean", editFormBean);
    	return "bartable";
    }
	
    @ModelAttribute("allBartables")
    public List<Bartable> getAllBartables() {
        return this.bartableService.getAll();
    }
    
    @RequestMapping(path = "/{id}/delete", method = RequestMethod.GET)
	public String deleteById(Model model, @PathVariable("id") Long id) {
    	Bartable b = bartableService.getById(id);
		bartableService.delete(b);
		return "redirect:/bartable";
	}
    
 
	@RequestMapping(method = RequestMethod.POST, params = "edit")
	public String submitForEdit(@ModelAttribute("editFormBean") @Valid EditBartableForm editFormBean, BindingResult editResult, ModelMap model, @RequestParam("edit") String action) {
		if (action.equals("accept_forEdit")) {
			if(editResult.hasErrors()) {              
				model.addAttribute("editFormBean", editFormBean);
				return "bartable";
			} else {
				try {
					Bartable b = editFormBean.toPojo();
					bartableService.save(b);
					model.addAttribute("editFormBean", new EditBartableForm());
					return "redirect:/bartable";
				} catch (Excep e) {
					if (e.getAtribute() == null) {
						ObjectError error = new ObjectError("globalError", e.getMessage());
			            editResult.addError(error);
					} else {
			    		FieldError error = new FieldError("editFormBean", e.getAtribute(), e.getMessage());
			            editResult.addError(error);
					}
		            model.addAttribute("editFormBean", editFormBean);
	    			return "bartable";
				}
			}
		} else if (action.equals("return_forEdit")) {
			model.addAttribute("editFormBean", new EditBartableForm());
			return "redirect:/bartable";
		} else {
			model.addAttribute("editFormBean", new EditBartableForm());
			return "redirect:/";
		}
	}
}