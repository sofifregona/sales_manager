package pps.mng.services;

import java.util.List;

import pps.mng.exception.Excep;
import pps.mng.entities.Payment;

public interface PaymentService {
	
	List<Payment> getAll();
	
	Payment getById(Long idPayment);
	
	Payment getByName(String name);
	
	void delete(Payment pm);
	
	void save(Payment pm) throws Excep;
}