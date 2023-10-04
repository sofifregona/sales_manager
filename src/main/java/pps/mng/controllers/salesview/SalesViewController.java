package pps.mng.controllers.salesview;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.*;
import java.io.IOException;
import com.google.gson.Gson;

import pps.mng.controllers.product.FindProductForm;
import pps.mng.entities.Brand;
import pps.mng.entities.Payment;
import pps.mng.services.ProductSoldService;
import pps.mng.services.SaleService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Controller
@RequestMapping("/salesview")
public class SalesViewController {
	@Autowired
    private ProductSoldService productSoldService;
	
	@Autowired
    private SaleService saleService;
	
    @ModelAttribute("exportData")
    public String export(@RequestParam(value = "from", required = false) LocalDate from, @RequestParam(value = "to", required = false) LocalDate to) {
    	
    	LocalDateTime from_aux = LocalDate.now().atTime(LocalTime.MIN);
    	LocalDateTime to_aux = LocalDate.now().plusDays(1).atTime(LocalTime.MIN);
    	
    	if (from != null) {
    		from_aux = from.atTime(LocalTime.MIN);
        	to_aux = to.plusDays(1).atTime(LocalTime.MIN);	
    	}
    	
    	System.out.println("FROM: "+from_aux);
    	System.out.println("TO: "+to_aux);
    	
    	List<Object[]> export;
    	
    	export = this.productSoldService.export(from_aux, to_aux);
    	String data = "Nro. venta;Fecha y hora;Nro. mesa;Método de pago;Producto;Marca;Categoría;Precio unitario;Unidades;Descuento 20%;Subtotal\n";
    	
    	for (Object[] array_object: export) {
    		String row = "";
    		for (int i = 0; i < array_object.length; i++) {
    			if (i != array_object.length - 1) {
    				row += array_object[i]+";";	
    			} else {
    				row += array_object[i];
    			}
    		}
    		data += row+"\n";
    	}    	
    	return data;	
    }
     
    @RequestMapping(path = {"", "/filter"}, method = RequestMethod.GET)
    public String prepareForms(Model model, @PathVariable("id") Optional<Long> id, 
    		@RequestParam("from") Optional<LocalDate> from,
    		@RequestParam("to") Optional<LocalDate> to,
    		@RequestParam("filter") Optional<String> filter,
    		@RequestParam("order") Optional<String> order) throws Exception {
    	// Para encontrar
    	
    	FindSalesViewForm findFormBean = new FindSalesViewForm();
    	List<Object[]> salesFiltered;
    	List<Object[]> summaryFiltered;
    	List<Object[]> totalFiltered;
    	
    	String filter_aux = "product";
    	String order_aux = "profits";
    	LocalDateTime from_aux = LocalDate.now().atTime(LocalTime.MIN);
    	LocalDateTime to_aux = LocalDate.now().plusDays(1).atTime(LocalTime.MIN);
    	
    	if (from.isPresent())
    		from_aux = from.get().atTime(LocalTime.MIN);
    	if (to.isPresent())
    		to_aux = to.get().plusDays(1).atTime(LocalTime.MIN);
    	if(filter.isPresent() && filter.get() != "product")
    		filter_aux = filter.get();
    	if(order.isPresent() && order.get().split("_")[1] != "profits")
    		order_aux = order.get().split("_")[1];
    	
    	findFormBean.setFilter(filter_aux);
		findFormBean.setFrom(from_aux.toLocalDate());
		findFormBean.setTo(to_aux.toLocalDate());
		
		System.out.println(from_aux+" "+to_aux+" "+filter_aux+" "+order_aux);
    	salesFiltered = productSoldService.filterDates(from_aux, to_aux, filter_aux, order_aux);
    	totalFiltered = saleService.filterDates(from_aux, to_aux);
    	summaryFiltered = saleService.filterSummaryDates(from_aux, to_aux);
    	
    	model.addAttribute("findFormBean", findFormBean);
	 	model.addAttribute("allSalesFiltered", salesFiltered);
	 	model.addAttribute("totalFiltered", totalFiltered);
	 	model.addAttribute("summaryFiltered", summaryFiltered);
	 	System.out.println(findFormBean.getFrom());
		System.out.println(findFormBean.getTo());
    	return "salesview";
    }
    
    @RequestMapping(method = RequestMethod.POST, params = "filter_by")
	public String submitForFind(@ModelAttribute("findFormBean") @Valid FindSalesViewForm findFormBean, BindingResult findResult, ModelMap model, @RequestParam("filter_by") String action) {
		if (action.equals("filter_forFind")) {
			model.addAttribute("findFormBean", findFormBean);
			LocalDate from_aux = LocalDate.now();
	    	LocalDate to_aux = LocalDate.now();
	    	if(findFormBean.getFrom() != null)
	    		from_aux = findFormBean.getFrom(); 
	    	if(findFormBean.getTo() != null)
	    		to_aux = findFormBean.getTo(); 
			String url = "redirect:/salesview/filter?filter="+findFormBean.getFilter()+"&order="+findFormBean.getOrder()+"&from="+from_aux+"&to="+to_aux;
			System.out.println(url);
			return url;		
		} else {
			System.out.println("No funciona!");
			model.addAttribute("findFormBean", new FindProductForm());
			return "redirect:/salesview";
		}
	}
}