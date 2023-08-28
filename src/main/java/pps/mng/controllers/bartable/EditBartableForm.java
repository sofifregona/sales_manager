package pps.mng.controllers.bartable;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

import pps.mng.entities.Bartable;

public class EditBartableForm {
	
	private Long id;
	@NotNull(message = "El número de mesa no puede estar vacío.")
	@Min(value = 0, message = "El número de mesa no puede ser menor a 0.")
	private Long number;
	
	public EditBartableForm() {
		super();
	}
	public EditBartableForm(Bartable b) {
		super();
		this.id = b.getId();
		this.number = b.getNumber();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	
	public Bartable toPojo()
	{
		Bartable b = new Bartable();
		b.setId(this.id);
		b.setNumber(this.getNumber());
		b.setActive(true);
		return b;
	}
}