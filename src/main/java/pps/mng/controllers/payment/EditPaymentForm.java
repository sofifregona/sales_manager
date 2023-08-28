package pps.mng.controllers.payment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import pps.mng.entities.Payment;

public class EditPaymentForm {
	
	private Long id;
	@NotNull(message = "La categoría de producto no puede estar en blanco")
	@Size(min = 3, message = "El nombre del proveedor debe tener un mínimo de 3 caracteres.")
	private String name;
	
	public EditPaymentForm() {
		super();
	}
	public EditPaymentForm(Payment pm) {
		super();
		this.id = pm.getId();
		this.name = pm.getName();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Payment toPojo()
	{
		Payment pm = new Payment();
		pm.setId(this.getId());
		pm.setName(this.getName());
		pm.setActive(true);
		return pm;
	}
	
}