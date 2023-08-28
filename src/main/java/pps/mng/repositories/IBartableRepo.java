package pps.mng.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pps.mng.entities.Bartable;

@Repository
public interface IBartableRepo extends JpaRepository<Bartable, Long> {
	
	@Query("SELECT b FROM Bartable b WHERE b.number = ?1")
	Bartable findByNumber(Long number);
	
	@Query("SELECT b FROM Bartable b WHERE b.active = 1 ORDER BY b.number")
	List<Bartable> findAll();

}