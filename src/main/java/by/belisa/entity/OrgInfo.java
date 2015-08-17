package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(schema="SPRAVOCHNIKI", name="ORG_INFO")
public class OrgInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -826324811721791261L;
	@Id
	@Column(name="ID_ORG")
	private Integer id;
	@Column(name="UNP")
	private String unp;
	@Column(name="NAME_OF_RUS")
	private String nameRus;
	@Column(name="DESCR_RUS")
	private String description;
	@Column(name="ADDRESS_RUS")
	private String addressRus;
	@Column(name="CITY")
	private String city;
	
	
	
	
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
	public String getNameRus() {
		return nameRus;
	}
	public void setNameRus(String nameRus) {
		this.nameRus = nameRus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddressRus() {
		return addressRus;
	}
	public void setAddressRus(String addressRus) {
		this.addressRus = addressRus;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
