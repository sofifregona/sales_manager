package pps.mng.services;

import java.util.List;
import java.time.LocalDateTime;

import pps.mng.exception.Excep;
import pps.mng.entities.ProductSold;

public interface ProductSoldService {
	
	List<ProductSold> getAll();
	
	ProductSold getById(Long id);
	
	List<ProductSold> filterByIdSale(Long idSale);
	
	List<Object[]> filterDates(LocalDateTime from, LocalDateTime to, String filter, String order) throws Excep;
	
	void deleteById(Long idProduct);
	
	void save(ProductSold ps);
}