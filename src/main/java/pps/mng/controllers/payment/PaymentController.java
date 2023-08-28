package pps.mng.controllers.payment;

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

import pps.mng.services.PaymentService;
import pps.mng.exception.Excep;
import pps.mng.entities.Payment;


@Controller
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
    private PaymentService paymentService;
     
    @RequestMapping(path = {"", "/{id}/edit"}, method = RequestMethod.GET)
    public String prepareForms(Model model, @PathVariable("id") Optional<Long> id) throws Exception {
    	EditPaymentForm editFormBean = new EditPaymentForm();
    	if (id.isPresent()) {
    		Payment entity = paymentService.getById(id.get());
    		editFormBean = new EditPaymentForm(entity);	
		} 
    	model.addAttribute("editFormBean", editFormBean);
    	return "payment";
    }
	
    @ModelAttribute("allPaymentMethods")
    public List<Payment> getAllCategories() {
        return this.paymentService.getAll();
    }
    
	@RequestMapping(path = "/{id}/delete", method = RequestMethod.GET)
	public String deleteById(Model model, @PathVariable("id") Long id) {
		Payment c = paymentService.getById(id);
		paymentService.delete(c);
		return "redirect:/payment";	
	}
 
	@RequestMapping(method = RequestMethod.POST, params = "edit")
	public String submitForEdit(@ModelAttribute("editFormBean") @Valid EditPaymentForm editFormBean, BindingResult editResult, ModelMap model, @RequestParam("edit") String action) {
		if (action.equals("accept_forEdit")) {
			if(editResult.hasErrors()) {              
				model.addAttribute("editFormBean", editFormBean);
				return "payment";
			} else {
				try {
					Payment pm = editFormBean.toPojo();
					paymentService.save(pm);
					model.addAttribute("editFormBean", new EditPaymentForm());
					return "redirect:/payment";
				} catch (Excep e) {
					if (e.getAtribute() == null) {
						ObjectError error = new ObjectError("globalError", e.getMessage());
			            editResult.addError(error);
					} else {
			    		FieldError error = new FieldError("editFormBean", e.getAtribute(), e.getMessage());
			            editResult.addError(error);
					}
		            model.addAttribute("editFormBean", editFormBean);
	    			return "payment";
				}
			}
		} else if (action.equals("return_forEdit")) {
			model.addAttribute("editFormBean", new EditPaymentForm());
			return "redirect:/payment";
		} else {
			model.addAttribute("editFormBean", new EditPaymentForm());
			return "redirect:/";
		}
	}
}