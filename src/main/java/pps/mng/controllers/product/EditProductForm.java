package pps.mng.controllers.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMin;

import pps.mng.entities.Product;

public class EditProductForm {

	private Long id;
	@NotBlank(message = "El código del producto no puede quedar en blanco.")
	private String code;
	@NotNull(message = "El nombre del producto no puede quedar en blanco.")
	@Size(min = 5, message = "El nombre del producto debe tener un mínimo de 5 caracteres.")
	private String name;
	@NotNull(message = "El precio del producto no puede quedar en blanco.")
	@DecimalMin(value = "0.01", message = "El precio del producto debe ser mayor a 0.")
	private Double price;
	private Long idBrand;
	private Long idCategory;
	
	public EditProductForm() {
		super();
	}
	public EditProductForm(Product p) {
		super();
		this.id = p.getId();
		this.code = p.getCode();
		this.name= p.getName();
		this.price= p.getPrice();
		this.idBrand= p.getBrand() != null ? p.getBrand().getId() : null;
		this.idCategory= p.getCategory() != null ? p.getCategory().getId() : null;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getIdBrand() {
		return idBrand;
	}
	public void setIdBrand(Long idBrand) {
		this.idBrand = idBrand;
	}
	public Long getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}
	
	public Product toPojo()
	{
		Product p = new Product();
		p.setId(this.id);
		p.setCode(this.getCode());
		p.setName(this.getName());
		p.setPrice(this.getPrice());
		p.setActive(true);
		return p;
	}
}