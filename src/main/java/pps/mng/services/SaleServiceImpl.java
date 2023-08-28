package pps.mng.services;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pps.mng.repositories.ISaleRepo;
import pps.mng.controllers.sale.FindSaleForm;
import pps.mng.entities.Sale;
import pps.mng.exception.Excep;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	ISaleRepo repo;

	@Override
	public List<Sale> getAll() {		
		return repo.findAll();
	}
	
	@Override
	public List<Sale> getAllSalesOpen() {		
		return repo.findAllOpen();
	}
	
	@Override
	public Sale getById(Long idSale) {
		return repo.findById(idSale).get();
	}
	
	@Override
	public List<Object[]> filterDates(LocalDateTime from, LocalDateTime to) {
		return repo.filterDates(from, to);
	}
	
	@Override
	public List<Object[]> filterSummaryDates(LocalDateTime from, LocalDateTime to){
		return repo.filterSummaryDates(from, to);
	}
	
	@Override
	public Sale getByOpenAndBartable(FindSaleForm filter) throws Excep {
		if (filter.getIdBartable() == null)
			throw new Excep("Debe seleccionar una mesa.");
		else
			return repo.findByOpenBartable(filter.getIdBartable());
	}

	@Override
	public List<Sale> getByDate(FindSaleForm filter) throws Excep {
		if (filter.getDate() == null)
			return repo.findByDate(LocalDate.now());	
		else
			return repo.findByDate(filter.getDate());
	}
	
	@Override
	public void deleteById(Long idSale) {
		repo.deleteById(idSale);
	}

	@Override
	public void save(Sale s) throws Excep {
		if (repo.findByOpenBartable(s.getBartable().getId()) != null && repo.findByOpenBartable(s.getBartable().getId()).getId() != s.getId())
			throw new Excep("La mesa seleccionada ya tiene una venta activa");
		else
			repo.save(s);
	}

}