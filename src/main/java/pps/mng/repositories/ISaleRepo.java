package pps.mng.repositories;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pps.mng.entities.Sale;

@Repository
public interface ISaleRepo extends JpaRepository<Sale, Long> {
	
	@Query("SELECT s FROM Sale s WHERE s.bartable.id like ?1 and s.open = true")
	Sale findByOpenBartable(Long idBartable);
	
	@Query("SELECT s FROM Sale s WHERE DATE(s.dateTime) = ?1")
	List<Sale> findByDate(LocalDate date);
	
	@Query("SELECT s FROM Sale s WHERE s.open = 1")
	List<Sale> findAllOpen();
	
	@Query("SELECT s.discount, SUM(s.total) " +
		       "FROM Sale s " +
		       "WHERE s.dateTime >= ?1 AND s.dateTime < ?2 AND s.open = 0 " +
		       "GROUP BY s.discount " +
		       "ORDER BY s.discount DESC")
	List<Object[]> filterDates(LocalDateTime from, LocalDateTime to);
	
	@Query("SELECT s.payment.name, SUM(CASE WHEN s.dateTime >= ?1 AND s.dateTime < ?2 AND s.open = 0 THEN s.total ELSE 0 END) " +
			"FROM Sale s " +
			"GROUP BY s.payment.name " +
			"ORDER BY s.payment.name ASC")
	List<Object[]> filterSummaryDates(LocalDateTime from, LocalDateTime to);
	
}