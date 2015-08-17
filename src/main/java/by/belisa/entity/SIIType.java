package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(schema="SII_RII",name="ENTITY_II")
public class SIIType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3008248618606476472L;
	@Id
	@Column(name="ID_ENTITY_II")
	private Integer id;
	@Column(name="NAME_ENTITY_II_RUS")
	private String name;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
