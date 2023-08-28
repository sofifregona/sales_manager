package pps.mng.controllers.sale;

import java.time.LocalDateTime;
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
import pps.mng.services.ProductService;
import pps.mng.services.ProductSoldService;
import pps.mng.services.SaleService;
import pps.mng.services.PaymentService;
import pps.mng.controllers.productsold.EditProductSoldForm;
import pps.mng.entities.Bartable;
import pps.mng.entities.Product;
import pps.mng.entities.ProductSold;
import pps.mng.entities.Sale;
import pps.mng.entities.Payment;
import pps.mng.exception.Excep;

@Controller
@RequestMapping("/sale")
public class SaleController {
	@Autowired
    private SaleService saleService;
	
	@Autowired
	private ProductSoldService productSoldService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private BartableService bartableService;
	
	@Autowired
	private PaymentService paymentService;

    @RequestMapping(path = {"", "/{id}/edit"}, method = RequestMethod.GET)
    public String prepareFormEditSale(Model model, @PathVariable("id") Optional<Long> id) throws Exception {
    	// Para encontrar
	 	// Para editar
	 	EditSaleForm editSaleFormBean;
	 	EditProductSoldForm editProductFormBean = new EditProductSoldForm();
    	if (id.isPresent()) {
    		editProductFormBean.setIdSale(id.get());
    		Sale s = saleService.getById(id.get());
    		model.addAttribute("bartable", s.getBartable().getNumber());
    		if (s.getOpen()) {
    			List <ProductSold> allProductsSold = productSoldService.filterByIdSale(id.get());
        		model.addAttribute("allProductsSold", allProductsSold);
        		model.addAttribute("total", s.getTotal());
        		editSaleFormBean = new EditSaleForm(s);	
    		} else {
    			editSaleFormBean = new EditSaleForm();	
    		}
		} else {
			 editSaleFormBean = new EditSaleForm();
		}
    	model.addAttribute("editSaleFormBean", editSaleFormBean);
    	model.addAttribute("editProductFormBean", editProductFormBean);
    	return "sale";
    }
    
    @ModelAttribute("allSalesOpen")
    public List<Sale> getAllSalesOpen() {
        return this.saleService.getAllSalesOpen();
    }
    
    @ModelAttribute("allBartables")
    public List<Bartable> getAllBartables() {
        return this.bartableService.getAll();
    }
    
    @ModelAttribute("allProducts")
    public List<Product> getAllProducts() {
        return this.productService.getAll();
    }
    
    @ModelAttribute("allPaymentMethods")
    public List<Payment> getAllPaymentMethods() {
        return this.paymentService.getAll();
    }

	@RequestMapping(method = RequestMethod.POST, params = "editSale")
	public String submitForEditSale(@ModelAttribute("editSaleFormBean") @Valid EditSaleForm editSaleFormBean, BindingResult editResult, ModelMap model, @RequestParam("editSale") String action) {
		//model.addAttribute("editProductFormBean", new EditProductSoldForm());
		if (action.equals("open")) {
			if (editResult.hasErrors()) {              
				model.addAttribute("editSaleFormBean", editSaleFormBean);
				//model.addAttribute("findFormBean", new FindProductForm());
				//model.addAttribute("allProducts", productService.getAll());
				return "sale";
			} else {
				Sale s = editSaleFormBean.toPojo();
				s.setBartable(bartableService.getById(editSaleFormBean.getIdBartable()));
				s.setOpen(true);
				s.setTotal(0.00);
				s.setDateTime(LocalDateTime.now());
				try {
					saleService.save(s);
					model.addAttribute("editSaleFormBean", new EditSaleForm());
					return "redirect:/sale";
				} catch (Excep e) {
					if (e.getAtribute() == null) {
						ObjectError error = new ObjectError("globalError", e.getMessage());
			            editResult.addError(error);
					} else {
			    		FieldError error = new FieldError("editFormBean", e.getAtribute(), e.getMessage());
			            editResult.addError(error);
					}
		            model.addAttribute("editSaleFormBean", editSaleFormBean);
	    			return "sale";
				}
			}
		} else if (action.equals("close")) {
			System.out.println(editSaleFormBean.getDiscount());
			System.out.println(editSaleFormBean.getIdPayment());
			if (editResult.hasErrors()) {              
				model.addAttribute("editSaleFormBean", editSaleFormBean);
				return "sale";
			} else {
				Sale s = saleService.getById(editSaleFormBean.getId());
				Payment pm = paymentService.getById(editSaleFormBean.getIdPayment());
				s.setOpen(false);
				s.setDiscount(editSaleFormBean.getDiscount());
				s.setPayment(pm);
				if (editSaleFormBean.getDiscount() == true) {
					List<ProductSold> new_subtotals = productSoldService.filterByIdSale(s.getId());
					Double new_total = 0.00;
					for(ProductSold productSold : new_subtotals) {
						productSold.setSubtotal(productSold.getSubtotal()*0.8);
						new_total += productSold.getSubtotal();
					}
					s.setTotal(new_total);
				}
				try {
					saleService.save(s);
					model.addAttribute("editSaleFormBean", new EditSaleForm());
					return "redirect:/sale";
				} catch(Excep e) { 
					if (e.getAtribute() == null) {
						ObjectError error = new ObjectError("globalError", e.getMessage());
			            editResult.addError(error);
					} else {
			    		FieldError error = new FieldError("editFormBean", e.getAtribute(), e.getMessage());
			            editResult.addError(error);
					}
		            model.addAttribute("editSaleFormBean", editSaleFormBean);
	    			return "sale";
				}
			}
		} else {
			return "redirect:/sale";
		}
	}
}
