package pps.mng.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pps.mng.entities.Payment;

@Repository
public interface IPaymentRepo extends JpaRepository<Payment, Long> {
	
	@Query("SELECT pm FROM Payment pm WHERE pm.name like ?1")
	Payment findByName(String name);

	@Query("SELECT pm FROM Payment pm WHERE pm.active = 1 ORDER BY pm.name")
	List<Payment> findAll();
	
}