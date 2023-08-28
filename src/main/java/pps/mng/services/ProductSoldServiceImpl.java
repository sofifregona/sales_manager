package pps.mng.services;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pps.mng.repositories.IProductSoldRepo;
import pps.mng.entities.ProductSold;
import pps.mng.exception.Excep;

@Service
public class ProductSoldServiceImpl implements ProductSoldService {

	@Autowired
	IProductSoldRepo repo;

	@Override
	public List<ProductSold> getAll() {		
		return repo.findAll();
	}
	
	@Override
	public ProductSold getById(Long idProductSold) {
		return repo.findById(idProductSold).get();
	}

	@Override
	public List<ProductSold> filterByIdSale(Long idSale) {
		return repo.findByIdSale(idSale);
	}
	
	@Override
	public List<Object[]> filterDates(LocalDateTime from, LocalDateTime to, String filter, String order) throws Excep {
		
		if(from != null) {
			if(from.compareTo(LocalDate.now().plusDays(1).atTime(LocalTime.MIN)) > 0)
				throw new Excep("La fecha inicial no puede ser posterior al día de hoy.");
		} else {
			throw new Excep("La fecha inicial no puede quedar en blanco.");
		}
		if(to != null) {
			if(from.compareTo(to) > 0)
				throw new Excep("La fecha inicial no puede ser posterior a la fecha final.");
			if(to.compareTo(LocalDate.now().plusDays(1).atTime(LocalTime.MIN)) > 0)
				throw new Excep("La fecha final no puede ser posterior al día de hoy.");
		} else {
			throw new Excep("La fecha final no puede quedar en blanco.");
		}
		
		if(filter.equals("product")) {
			if(order.equals("profits"))
				return repo.filterByProductProfitsDates(from, to);
			else
				return repo.filterByProductUnitsDates(from, to);
		} else if(filter.equals("category")) {
			if(order.equals("profits"))
				return repo.filterByCategoryProfitsDates(from, to);
			else
				return repo.filterByCategoryUnitsDates(from, to);
		} else { 
			if(order.equals("profits"))
				return repo.filterByBrandProfitsDates(from, to);
			else
				return repo.filterByBrandUnitsDates(from, to);
		}
		/*
		if(to != null)
			if(filter == "product")
				return repo.filterProductRangeDates(from, to, order);
			else if(filter == "brand")
				return repo.filterBrandRangeDates(from, to, order);
			else
				return repo.filterCategoryRangeDates(from, to, order);
		else
			if(filter == "product")
				return repo.filterProductDate(from, order);
			else if(filter == "brand")
				return repo.filterBrandDate(from, order);
			else
				return repo.filterCategoryDate(from, order);*/
	}
	
	@Override
	public void deleteById(Long idProvider) {
		repo.deleteById(idProvider);
	}

	@Override
	public void save(ProductSold ps) {
		repo.save(ps);
	}

}