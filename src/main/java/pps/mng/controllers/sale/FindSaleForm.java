package pps.mng.controllers.sale;

import java.time.LocalDate;

public class FindSaleForm {

	private LocalDate date;
	private Long idBartable;
	
	public FindSaleForm() {
		super();
	}
	public FindSaleForm(LocalDate date, Long idBartable) {
		super();
		this.date = date;
		this.idBartable = idBartable;
	}
	public Long getIdBartable() {
		return idBartable;
	}
	public void setIdBartable(Long idBartable) {
		this.idBartable = idBartable;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}