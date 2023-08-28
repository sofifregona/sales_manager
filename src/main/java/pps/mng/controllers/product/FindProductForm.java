package pps.mng.controllers.product;

public class FindProductForm {

	private String name;
	private String code;
	private Long idBrand;
	private Long idCategory;
	
	public FindProductForm() {
		super();
	}
	public FindProductForm(String name, String code, Long idBrand, Long idCategory) {
		super();
		this.name = name;
		this.code = code;
		this.idBrand = idBrand;
		this.idCategory = idCategory;
	}
	public String getName() {
		if (name != null && name.length() > 0)
			return name;
		else
			return null;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		if (code != null && code.length() > 0)
			return code;
		else
			return null;
	}
	public void setCode(String code) {
		this.code= code;
	}
	public Long getIdBrand() {
		if (idBrand != null)
			return idBrand;
		else
			return null;
	}
	public void setIdBrand(Long idBrand) {
		this.idBrand = idBrand;
	}
	public Long getIdCategory() {
		if (idCategory != null)
			return idCategory;
		else
			return null;
	}
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}
}