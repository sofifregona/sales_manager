package pps.mng.controllers.salesview;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class FindSalesViewForm {

	@NotNull(message = "Debe seleccionar una fecha.")
	private LocalDate from;
	private LocalDate to;
	private String filter;
	private String order;
	
	public FindSalesViewForm() {
		super();
	}
	public FindSalesViewForm(LocalDate from, LocalDate to, String filter, String order) {
		super();
		this.from = from;
		this.to = to;
		this.filter = filter;
		this.order = order;
	}
	public LocalDate getFrom() {
		return from;
	}
	public void setFrom(LocalDate from) {
		this.from = from;
	}
	public LocalDate getTo() {
		return to;
	}
	public void setTo(LocalDate to) {
		this.to = to;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
}