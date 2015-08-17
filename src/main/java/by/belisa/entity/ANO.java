package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="ANO",name="ANO")
public class ANO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6902650623811646314L;
	
	@Id
	@Column(name="ID_ANO")
	private Integer id;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_ORG_INFO")
	private OrgInfo org;
	@Column(name="PRIZNAK")
	private Integer priznak;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public OrgInfo getOrg() {
		return org;
	}
	public void setOrg(OrgInfo org) {
		this.org = org;
	}
	public Integer getPriznak() {
		return priznak;
	}
	public void setPriznak(Integer priznak) {
		this.priznak = priznak;
	}
	
	
}
