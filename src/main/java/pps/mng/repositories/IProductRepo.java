package pps.mng.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import pps.mng.entities.Product;

@Repository
public interface IProductRepo extends JpaRepository<Product, Long> {
	
	@Query("SELECT p FROM Product p WHERE p.name like ?1%") //Fijarse si necesita lista realmente o no
	List<Product> findByName(String name);
	
	@Query("SELECT p FROM Product p WHERE p.code like ?1") //Fijarse si necesita lista realmente o no
	List<Product> findByCode(String code);
	
	@Query("SELECT p FROM Product p WHERE (:name IS NULL OR (p.name LIKE CONCAT('%',' ', :name, '%') OR p.name LIKE CONCAT(:name, '%'))) "
			+ "AND (:idBrand IS NULL OR p.brand.id = :idBrand) "
			+ "AND (:idCategory IS NULL OR p.category.id = :idCategory)"
			+ "AND (:code IS NULL OR p.code LIKE CONCAT(:code, '%'))"
			+ "ORDER BY p.code")
	List<Product> findByFilter(@Param("name") String name, @Param("code") String code, @Param("idBrand") Long idBrand, @Param("idCategory") Long idCategory);
	
	@Query("SELECT p FROM Product p ORDER BY p.code")
	List<Product> findAll();

}