package pps.mng.services;

import java.util.List;

import pps.mng.exception.Excep;
import pps.mng.entities.Brand;

public interface BrandService {
	
	List<Brand> getAll();
	
	Brand getById(Long idBrand);
	
	Brand getByName(String name);
	
	void delete(Brand b);
	
	void save(Brand b) throws Excep;
}