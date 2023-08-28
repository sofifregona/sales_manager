package pps.mng.services;

import java.util.List;

import pps.mng.exception.Excep;
import pps.mng.controllers.product.FindProductForm;
import pps.mng.entities.Product;

public interface ProductService {
	
	List<Product> getAll();
	
	Product getById(Long idProduct) throws Excep;
	
	List<Product> filterByName(FindProductForm filter) throws Excep;
	
	List<Product> filter(FindProductForm filter) throws Excep;
	
	void deleteById(Long idProduct);
	
	void save(Product p) throws Excep;
}