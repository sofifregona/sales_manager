package pps.mng.services;

import java.util.List;

import pps.mng.exception.Excep;
import pps.mng.entities.Bartable;

public interface BartableService {
	
	List<Bartable> getAll();
	
	Bartable getById(Long idBartable);
	
	Bartable getByNumber(Long number);
	
	void delete(Bartable b);
	
	void save(Bartable b) throws Excep;
}