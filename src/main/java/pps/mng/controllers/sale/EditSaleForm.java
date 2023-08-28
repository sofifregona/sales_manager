package pps.mng.controllers.sale;

import pps.mng.entities.Sale;

public class EditSaleForm {

	private Long id;
	private Double total;
	private Long idBartable;
	private Boolean open;
	private Boolean discount;
	private Long idPayment;
	
	public EditSaleForm() {
		super();
	}
	public EditSaleForm(Sale s) {
		super();
		this.id = s.getId();
		this.total = s.getTotal();
		this.idBartable= s.getBartable() != null ? s.getBartable().getId() : null;
		this.open = s.getOpen();
		this.discount = s.getDiscount();
		this.idPayment = s.getPayment() != null ? s.getPayment().getId() : null;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Long getIdBartable() {
		return idBartable;
	}
	public void setIdBartable(Long idBartable) {
		this.idBartable = idBartable;
	}
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	public Boolean getDiscount() {
		return discount;
	}
	public void setDiscount(Boolean discount) {
		this.discount = discount;
	}
	public Long getIdPayment() {
		return idPayment;
	}
	public void setIdPayment(Long idPayment) {
		this.idPayment = idPayment;
	}
	
	public Sale toPojo()
	{
		Sale s = new Sale();
		s.setId(this.id);
		s.setTotal(this.getTotal());
		s.setOpen(this.getOpen());
		s.setDiscount(this.getDiscount());
		return s;
	}
	
}