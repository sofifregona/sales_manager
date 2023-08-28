package pps.mng.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pps.mng.repositories.IProductRepo;
import pps.mng.controllers.product.FindProductForm;
import pps.mng.entities.Product;
import pps.mng.exception.Excep;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	IProductRepo repo;

	@Override
	public List<Product> getAll() {		
		return repo.findAll();
	}

	@Override
	public Product getById(Long idProduct) throws Excep {
		if (idProduct != null)
			return repo.findById(idProduct).get();
		else 
			throw new Excep("Producto inválido");
	}
	
	@Override
	public List<Product> filterByName(FindProductForm filter) throws Excep
	{
		if (filter.getName() == null) {
			throw new Excep("Escriba el nombre del producto");
		} else {
			return repo.findByName(filter.getName());	
		}
	}
	
	@Override
	public List<Product> filter(FindProductForm filter) throws Excep
	{
		if (filter.getName() == null && filter.getCode() == null && filter.getIdBrand() == null && filter.getIdCategory() == null) {
			throw new Excep("Debe aplicar un filtro");
		} else {
			return repo.findByFilter(filter.getName(), filter.getCode(), filter.getIdBrand(), filter.getIdCategory());	
		}
	}

	@Override
	public void deleteById(Long idBrand) {
		repo.deleteById(idBrand);
	}

	@Override
	public void save(Product p) throws Excep {
		System.out.println("ID:"+p.getId());
		if (p.getId() == null) {
			if(!repo.findByCode(p.getCode()).isEmpty())
				throw new Excep("Ya existe un producto con ese código");
			if(!repo.findByName(p.getName()).isEmpty())
				throw new Excep("Ya existe un producto con ese nombre");
			else
				repo.save(p);
		} else if (!repo.findByCode(p.getCode()).isEmpty() && repo.findByCode(p.getCode()).get(0).getId() != p.getId()){
			System.out.println("Error 1");
			throw new Excep("Ya existe un producto con ese código");
		} else if (!repo.findByName(p.getName()).isEmpty() && repo.findByName(p.getName()).get(0).getId() != p.getId()) {
			System.out.println("Error 2");
			throw new Excep("Ya existe un producto con ese nombre");
		} else {
			System.out.println("LLega al guardado");
			repo.save(p);
		}
	}

}