package pps.mng.services;

import java.time.LocalDateTime;
import java.util.List;

import pps.mng.exception.Excep;
import pps.mng.controllers.sale.FindSaleForm;
import pps.mng.entities.Sale;

public interface SaleService {
	
	List<Sale> getAll();
	
	List<Sale> getAllSalesOpen();
	
	Sale getById(Long idSale);
	
	List<Sale> getByDate(FindSaleForm filter) throws Excep;
	
	List<Object[]> filterDates(LocalDateTime from, LocalDateTime to);
	
	List<Object[]> filterSummaryDates(LocalDateTime from, LocalDateTime to);
	
	Sale getByOpenAndBartable(FindSaleForm filter) throws Excep;
	
	void deleteById(Long idSale);
	
	void save(Sale s) throws Excep;
}