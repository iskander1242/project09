package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="OKSM", name="NET_COUNTRY")
public class Country implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5353508330274909994L;
	@Id
	@Column(name="NUMBER_CODE")
	private String id;
	@Column(name="NAME_RU")
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

}
