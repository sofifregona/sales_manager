package pps.mng.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pps.mng.entities.Brand;

@Repository
public interface IBrandRepo extends JpaRepository<Brand, Long> {
	
	@Query("SELECT b FROM Brand b WHERE b.name like ?1")
	Brand findByName(String name);
	
	@Query("SELECT b FROM Brand b WHERE b.active = 1 ORDER BY b.name")
	List<Brand> findAll();
	
}