package pps.mng.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pps.mng.repositories.IBrandRepo;
import pps.mng.entities.Brand;
import pps.mng.exception.Excep;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	IBrandRepo repo;

	@Override
	public List<Brand> getAll() {		
		return repo.findAll();
	}

	@Override
	public Brand getById(Long idBrand) {
		return repo.findById(idBrand).get();
	}
	
	@Override
	public Brand getByName(String name) {
		return repo.findByName(name);
	}
	
	@Override
	public void delete(Brand b) {
		b.setActive(false);
		repo.save(b);
	}

	@Override
	public void save(Brand b) throws Excep {
		if (b.getId() != null)  {
			if (repo.findByName(b.getName()) != null) {
				if (repo.findByName(b.getName()).getActive() == true) {
					throw new Excep("Ya existe una marca con este nombre");
				} else {
					Brand b2 = repo.findByName(b.getName());
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
			if (repo.findByName(b.getName()) != null) {
				if (repo.findByName(b.getName()).getActive() == true) {
					throw new Excep("Ya existe una marca con este nombre");
				} else {
					Brand b2 = repo.findByName(b.getName());
					b2.setActive(true);
					repo.save(b2);	
				}
			} else {
				repo.save(b);
			}
		}
	}

}