package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="INTD", name="GIR_PRODUCTS")
public class GirProducts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7193722939483048969L;
	@Id
	private Integer id;
	@Column(name="UNP")
	private String unp;
	@Column(name="DESCRIPTION")
	private String desc;
	@Column(name="OBL_PRIM")
	private String oblPrim;
	@Column(name="NAME")
	private String name;
	@Column(name="PRIZNAK")
	private Integer priznak;
	@Column(name="NAME_PRODUCT")
	private String nameProduct;

	
	
	
	
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public Integer getPriznak() {
		return priznak;
	}
	public void setPriznak(Integer priznak) {
		this.priznak = priznak;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUnp() {
		return unp;
	}
	public void setUnp(String unp) {
		this.unp = unp;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getOblPrim() {
		return oblPrim;
	}
	public void setOblPrim(String oblPrim) {
		this.oblPrim = oblPrim;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
