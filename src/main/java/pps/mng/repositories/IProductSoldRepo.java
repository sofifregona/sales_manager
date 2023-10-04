package pps.mng.repositories;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pps.mng.entities.ProductSold;

@Repository
public interface IProductSoldRepo extends JpaRepository<ProductSold, Long> {

	@Query("SELECT ps FROM ProductSold ps WHERE ps.sale.id like ?1")
	List<ProductSold> findByIdSale(Long idSale);
	
	@Query("SELECT p.id, p.code, p.name, p.brand.name, p.category.name, SUM(ps.units) AS units, SUM(CASE WHEN s.discount = 0 THEN ps.subtotal ELSE 0 END) as profit_nd, SUM(CASE WHEN s.discount = 1 THEN ps.subtotal ELSE 0 END) as profit_d, SUM(ps.subtotal) AS profits " +
	       "FROM ProductSold ps " +
	       "JOIN ps.sale s " +
	       "JOIN ps.product p " +
	       "LEFT JOIN p.brand b " +
	       "LEFT JOIN p.category c " +
	       "WHERE s.dateTime >= ?1 AND s.dateTime < ?2 " +
	       "GROUP BY p.id " +
	       "ORDER BY profits DESC")
	List<Object[]> filterByProductProfitsDates(LocalDateTime from, LocalDateTime to);
		
	@Query("SELECT p.id, p.code, p.name, p.brand.name, p.category.name, SUM(ps.units) AS units, SUM(CASE WHEN s.discount = 0 THEN ps.subtotal ELSE 0 END) as profit_nd, SUM(CASE WHEN s.discount = 1 THEN ps.subtotal ELSE 0 END) as profit_d, SUM(ps.subtotal) AS profits " +
		       "FROM ProductSold ps " +
		       "JOIN ps.sale s " +
		       "JOIN ps.product p " +
		       "LEFT JOIN p.brand b " +
		       "LEFT JOIN p.category c " +
		       "WHERE s.dateTime >= ?1 AND s.dateTime < ?2 " +
		       "GROUP BY p.id " +
		       "ORDER BY units DESC")
	List<Object[]> filterByProductUnitsDates(LocalDateTime from, LocalDateTime to);
		
	@Query("SELECT p.category.id, p.category.name, SUM(ps.units) AS units, SUM(CASE WHEN s.discount = 0 THEN ps.subtotal ELSE 0 END) as profit_nd, SUM(CASE WHEN s.discount = 1 THEN ps.subtotal ELSE 0 END) as profit_d, SUM(ps.subtotal) AS profits " +
		       "FROM ProductSold ps " +
		       "JOIN ps.sale s " +
		       "JOIN ps.product p " +
		       "LEFT JOIN p.category c " +
		       "WHERE s.dateTime >= ?1 AND s.dateTime < ?2 " +
		       "GROUP BY p.category.id " +
		       "ORDER BY profits DESC")
	List<Object[]> filterByCategoryProfitsDates(LocalDateTime from, LocalDateTime to);	
	
	@Query("SELECT p.category.id, p.category.name, SUM(ps.units) AS units, SUM(CASE WHEN s.discount = 0 THEN ps.subtotal ELSE 0 END) as profit_nd, SUM(CASE WHEN s.discount = 1 THEN ps.subtotal ELSE 0 END) as profit_d, SUM(ps.subtotal) AS profits " +
		       "FROM ProductSold ps " +
		       "JOIN ps.sale s " +
		       "JOIN ps.product p " +
		       "LEFT JOIN p.category c " +
		       "WHERE s.dateTime >= ?1 AND s.dateTime < ?2 " +
		       "GROUP BY p.category.id " +
		       "ORDER BY units DESC")
	List<Object[]> filterByCategoryUnitsDates(LocalDateTime from, LocalDateTime to);	
	
	@Query("SELECT p.brand.id, p.brand.name, SUM(ps.units) AS units, SUM(CASE WHEN s.discount = 0 THEN ps.subtotal ELSE 0 END) as profit_nd, SUM(CASE WHEN s.discount = 1 THEN ps.subtotal ELSE 0 END) as profit_d, SUM(ps.subtotal) AS profits " +
		       "FROM ProductSold ps " +
		       "JOIN ps.sale s " +
		       "JOIN ps.product p " +
		       "LEFT JOIN p.brand b " +
		       "WHERE s.dateTime >= ?1 AND s.dateTime < ?2 " +
		       "GROUP BY p.brand.id " +
		       "ORDER BY profits DESC")
	List<Object[]> filterByBrandProfitsDates(LocalDateTime from, LocalDateTime to);	
	
	@Query("SELECT p.brand.id, p.brand.name, SUM(ps.units) AS units, SUM(CASE WHEN s.discount = 0 THEN ps.subtotal ELSE 0 END) as profit_nd, SUM(CASE WHEN s.discount = 1 THEN ps.subtotal ELSE 0 END) as profit_d, SUM(ps.subtotal) AS profits " +
		       "FROM ProductSold ps " +
		       "JOIN ps.sale s " +
		       "JOIN ps.product p " +
		       "LEFT JOIN p.brand b " +
		       "WHERE s.dateTime >= ?1 AND s.dateTime < ?2 " +
		       "GROUP BY p.brand.id " +
		       "ORDER BY units DESC")
	List<Object[]> filterByBrandUnitsDates(LocalDateTime from, LocalDateTime to);
	
	
	@Query("SELECT ps.sale.id, ps.sale.dateTime, ps.sale.bartable.number, ps.sale.payment.name, "
			+ "ps.product.name, ps.product.brand.name, ps.product.category.name, ps.product.price, "
			+ "ps.units, case when ps.sale.discount = 0 then 'no' else 'si' end, ps.subtotal "
			+ "FROM ProductSold ps "
			+ "WHERE ps.sale.dateTime >= ?1 AND ps.sale.dateTime < ?2 "
			+ "order by ps.sale.id")
	List<Object[]> export(LocalDateTime from, LocalDateTime to);
	
	
	/*
	@Query("select ps.sale.id, ps.sale.dateTime, ps.sale.bartable.number, ps.sale.payment.name, "
			+ "ps.product.name, ps.product.brand.name, ps.product.category.name, ps.product.price, "
			+ "ps.units, case when ps.sale.discount = 0 then 'no' else 'si' end, "
			+ "ps.subtotal from ProductSold ps "
			+ "order by s.id")
	List<Object[]> export();*/
	
	
}