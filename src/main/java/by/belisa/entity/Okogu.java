package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="OKOGU")
@SequenceGenerator(name="PK", sequenceName="SEQ_OKOGU")
public class Okogu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3292808143382897321L;
	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	@Column(name="NAME")
	private String name;
	@Column(name="FULL_NAME")
	private String fullName;
	@Column(name="KOD")
	private String code;
	@Column(name="KOD_P")
	private String codeP;
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeP() {
		return codeP;
	}
	public void setCodeP(String codeP) {
		this.codeP = codeP;
	}
	
	

}
