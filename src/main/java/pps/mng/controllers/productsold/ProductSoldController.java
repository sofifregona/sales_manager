package pps.mng.controllers.productsold;

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

import pps.mng.services.ProductSoldService;
import pps.mng.services.ProductService;
import pps.mng.services.SaleService;
import pps.mng.entities.ProductSold;
import pps.mng.controllers.sale.EditSaleForm;
import pps.mng.entities.Product;
import pps.mng.entities.Sale;
import pps.mng.exception.Excep;

@Controller
@RequestMapping("/sale")
public class ProductSoldController {
	@Autowired
    private SaleService saleService;
	
	@Autowired
	private ProductSoldService productSoldService;
	
	@Autowired
	private ProductService productService;
    
	@RequestMapping(path = "/{idSale}/delete", method = RequestMethod.GET)
	public String deleteById(Model model, @PathVariable("idSale") Long idSale, @RequestParam("idProductSold") Long idProductSold) {
		ProductSold ps = productSoldService.getById(idProductSold);
		Sale s = saleService.getById(idSale);
		s.setTotal(s.getTotal()-ps.getSubtotal());
		productSoldService.deleteById(idProductSold);
		return "redirect:/sale";	
	}
 
	@RequestMapping(method = RequestMethod.POST, params = "editProducts")
	public String submitForEditProductSold(@ModelAttribute("editProductFormBean") @Valid EditProductSoldForm editProductFormBean, BindingResult editResult, ModelMap model, @RequestParam("editProducts") String action) {
		//EditSaleForm editSaleFormBean = new EditSaleForm();
		Sale s = saleService.getById(editProductFormBean.getIdSale());
		EditSaleForm editSaleFormBean = new EditSaleForm(s);	
		if (action.equals("add")) {
			if (editResult.hasErrors()) { 
				model.addAttribute("editProductFormBean", editProductFormBean);
				model.addAttribute("editSaleFormBean", editSaleFormBean);
				//model.addAttribute("allProducts", productService.getAll());
				return "sale";
			} else {
				try {
					productService.getById(editProductFormBean.getIdProduct());
					ProductSold ps = editProductFormBean.toPojo();
					Product p = productService.getById(editProductFormBean.getIdProduct());
					//Sale s = saleService.getById(editProductFormBean.getIdSale());
					//editSaleFormBean = new EditSaleForm(s);
					ps.setSale(s);
					ps.setProduct(p);
					ps.setSubtotal(ps.getUnits()*p.getPrice());
					s.setTotal(s.getTotal()+ps.getSubtotal());
					productSoldService.save(ps);
					try {
						saleService.save(s);
						model.addAttribute("editProductFormBean", new EditProductSoldForm());
						//model.addAttribute("editSaleFormBean", editSaleFormBean);
						return "redirect:/sale/"+s.getId()+"/edit";
					} catch (Excep e) {
						if (e.getAtribute() == null) {
							ObjectError error = new ObjectError("globalError", e.getMessage());
				            editResult.addError(error);
						} else {
				    		FieldError error = new FieldError("editFormBean", e.getAtribute(), e.getMessage());
				            editResult.addError(error);
						}
						return "sale/"+s.getId()+"/edit";
					}
				} catch (Excep e) {
					System.out.println("SALEEEEEEE "+s.getId());
					if (e.getAtribute() == null) {
						ObjectError error = new ObjectError("globalError", e.getMessage());
			            editResult.addError(error);
					} else {
			    		FieldError error = new FieldError("editFormBean", e.getAtribute(), e.getMessage());
			            editResult.addError(error);
					}
					return "sale/"+s.getId()+"/edit";
				}
			}
		} else {
			return "redirect:/sale/"+s.getId()+"/edit";
		}
		//model.addAttribute("editSaleFormBean", editSaleFormBean);
	}
	
}