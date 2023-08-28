package pps.mng.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pps.mng.entities.Category;

@Repository
public interface ICategoryRepo extends JpaRepository<Category, Long> {
	
	@Query("SELECT c FROM Category c WHERE c.name like ?1")
	Category findByName(String name);
	
	@Query("SELECT c FROM Category c WHERE c.active = 1 ORDER BY c.name")
	List<Category> findAll();

}