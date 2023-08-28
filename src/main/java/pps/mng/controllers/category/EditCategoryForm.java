package pps.mng.controllers.category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import pps.mng.entities.Category;

public class EditCategoryForm {
	
	private Long id;
	@NotNull(message = "La categoría de producto no puede estar en blanco")
	@Size(min = 3, message = "El nombre del proveedor debe tener un mínimo de 3 caracteres.")
	private String name;
	
	public EditCategoryForm() {
		super();
	}
	public EditCategoryForm(Category t) {
		super();
		this.id = t.getId();
		this.name = t.getName();
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
	
	public Category toPojo()
	{
		Category c = new Category();
		c.setId(this.getId());
		c.setName(this.getName());
		c.setActive(true);
		return c;
	}
	
}