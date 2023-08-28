package pps.mng.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pps.mng.repositories.IBartableRepo;
import pps.mng.entities.Bartable;
import pps.mng.exception.Excep;

@Service
public class BartableServiceImpl implements BartableService {

	@Autowired
	IBartableRepo repo;

	@Override
	public List<Bartable> getAll() {		
		return repo.findAll();
	}
	
	@Override
	public Bartable getById(Long idBartable) {
		return repo.findById(idBartable).get();
	}
	
	@Override
	public Bartable getByNumber(Long number) {
		return repo.findByNumber(number);
	}
	
	@Override
	public void delete(Bartable b) {
		b.setActive(false);
		repo.save(b);
	}

	@Override
	public void save(Bartable b) throws Excep {
		if (b.getId() != null)  {
			if (repo.findByNumber(b.getNumber()) != null) {
				if (repo.findByNumber(b.getNumber()).getActive() == true) {
					throw new Excep("Ya existe una mesa con este número");
				} else {
					Bartable b2 = repo.findByNumber(b.getNumber());
					b2.setActive(true);
					repo.save(b2);
					b = repo.findById(b.getId()).get();
					b.setActive(false);
					repo.save(b);	
				}
			} else {
				repo.save(b);
			}
		} else {
			if (repo.findByNumber(b.getNumber()) != null) {
				if (repo.findByNumber(b.getNumber()).getActive() == true) {
					throw new Excep("Ya existe una mesa con este número");
				} else {
					Bartable b2 = repo.findByNumber(b.getNumber());
					b2.setActive(true);
					repo.save(b2);	
				}
			} else {
				repo.save(b);
			}
		}
	}

}