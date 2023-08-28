package pps.mng.controllers.productsold;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

import pps.mng.entities.ProductSold;

public class EditProductSoldForm {

	private Long id;
	@NotNull(message = "Debe seleccionar un producto.")
	private Long idProduct;
	@NotNull(message = "Debe seleccionar la cantidad.")
	@Min(value = 1, message = "Las unidades no pueden ser inferiores a 1.")
	private Long units;
	@NotNull(message = "El subtotal no puede estar en blanco.")
	private Double subtotal;
	private Long idSale;
	
	public EditProductSoldForm() {
		super();
	}
	public EditProductSoldForm(ProductSold ps) {
		super();
		this.id = ps.getId();
		this.idProduct= ps.getProduct() != null ? ps.getProduct().getId() : null;
		this.units = ps.getUnits();
		this.subtotal = ps.getSubtotal();
		this.idSale= ps.getSale() != null ? ps.getSale().getId() : null;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public Long getUnits() {
		return units;
	}
	public void setUnits(Long units) {
		this.units = units;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Long getIdSale() {
		return idSale;
	}
	public void setIdSale(Long idSale) {
		this.idSale = idSale;
	}
	
	public ProductSold toPojo()
	{
		ProductSold ps = new ProductSold();
		ps.setId(this.id);
		ps.setUnits(this.getUnits());
		ps.setSubtotal(this.getSubtotal());
		return ps;
	}
	
}