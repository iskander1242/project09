package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;



@Entity()
@AccessType("field")
@Table(schema="NEW_TECHNOLOGIES", name="NEW_TECHNOLOGIES")
public class NewTech implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3554154297822243981L;
	@Id
	private Integer id;
	@Column(name="REGISTRATION_NUMBER")
	private String regNum;
	@Column(name="SCIENCE_PRODUCTION_NAME_R")
	private String name;
	@Column(name="SCIENCE_LEVEL_R")
	private String advantages;
	@Column(name="CONTACT_PERSON_PERFORMER_R")
	private String contact;
	@Column(name="RIGHTHOLDER")
	private String rightholder;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRegNum() {
		return regNum;
	}
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdvantages() {
		return advantages;
	}
	public void setAdvantages(String advantages) {
		this.advantages = advantages;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getRightholder() {
		return rightholder;
	}
	public void setRightholder(String rightholder) {
		this.rightholder = rightholder;
	}
	
	

}
