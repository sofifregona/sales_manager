package pps.mng.services;

import java.util.List;

import pps.mng.exception.Excep;
import pps.mng.entities.Category;

public interface CategoryService {
	
	List<Category> getAll();
	
	Category getById(Long idCategory);
	
	Category getByName(String name);
	
	void delete(Category c);
	
	void save(Category c) throws Excep;
}