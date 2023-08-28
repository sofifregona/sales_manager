package pps.mng.controllers.brand;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import pps.mng.entities.Brand;

public class EditBrandForm {

	private Long id;
	@NotNull(message = "El nombre del proveedor no puede quedar en blanco.")
	@Size(min = 5, message = "El nombre del proveedor debe tener un mínimo de 5 caracteres.")
	private String name;
	
	public EditBrandForm() {
		super();
	}
	public EditBrandForm(Brand b) {
		super();
		this.id = b.getId();
		this.name = b.getName();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Brand toPojo()
	{
		Brand b = new Brand();
		b.setId(this.id);
		b.setName(this.getName());
		b.setActive(true);
		return b;
	}

}