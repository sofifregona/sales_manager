package pps.mng.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pps.mng.repositories.ICategoryRepo;
import pps.mng.entities.Category;
import pps.mng.exception.Excep;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	ICategoryRepo repo;

	@Override
	public List<Category> getAll() {		
		return repo.findAll();
	}
	
	@Override
	public Category getById(Long idCategory) {
		return repo.findById(idCategory).get();
	}
	
	@Override
	public Category getByName(String name) {
		return repo.findByName(name);
	}
	
	@Override
	public void delete(Category c) {
		c.setActive(false);
		repo.save(c);
	}

	@Override
	public void save(Category c) throws Excep {
		if (c.getId() != null)  {
			if (repo.findByName(c.getName()) != null) {
				if (repo.findByName(c.getName()).getActive() == true) {
					throw new Excep("Ya existe una categoría con este nombre");
				} else {
					Category c2 = repo.findByName(c.getName());
					c2.setActive(true);
					repo.save(c2);
					c = repo.findById(c.getId()).get();
					c.setActive(false);
					repo.save(c);	
				}
			} else {
				repo.save(c);
			}
		} else {
			if (repo.findByName(c.getName()) != null) {
				if (repo.findByName(c.getName()).getActive() == true) {
					throw new Excep("Ya existe una categoría con este nombre");
				} else {
					Category c2 = repo.findByName(c.getName());
					c2.setActive(true);
					repo.save(c2);	
				}
			} else {
				repo.save(c);
			}
		}
	}

}