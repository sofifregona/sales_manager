package pps.mng.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pps.mng.repositories.IPaymentRepo;
import pps.mng.entities.Payment;
import pps.mng.exception.Excep;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	IPaymentRepo repo;

	@Override
	public List<Payment> getAll() {		
		return repo.findAll();
	}
	
	@Override
	public Payment getById(Long idPayment) {
		return repo.findById(idPayment).get();
	}
	
	@Override
	public Payment getByName(String name) {
		return repo.findByName(name);
	}
	
	@Override
	public void delete(Payment pm) {
		pm.setActive(false);
		repo.save(pm);
	}

	@Override
	public void save(Payment pm) throws Excep {
		if (pm.getId() != null)  {
			if (repo.findByName(pm.getName()) != null) {
				if (repo.findByName(pm.getName()).getActive() == true) {
					throw new Excep("Ya existe un método de pago con este nombre");
				} else {
					Payment pm2 = repo.findByName(pm.getName());
					pm2.setActive(true);
					repo.save(pm2);
					pm = repo.findById(pm.getId()).get();
					pm.setActive(false);
					repo.save(pm);	
				}
			} else {
				repo.save(pm);
			}
		} else {
			if (repo.findByName(pm.getName()) != null) {
				if (repo.findByName(pm.getName()).getActive() == true) {
					throw new Excep("Ya existe un método de pago con este nombre");
				} else {
					Payment pm2 = repo.findByName(pm.getName());
					pm2.setActive(true);
					repo.save(pm2);	
				}
			} else {
				repo.save(pm);
			}
		}
	}

}