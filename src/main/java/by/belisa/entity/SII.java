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
@Table(schema="SII_RII",name="ENTITY_II_ORG")
public class SII implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 412842143660058471L;
	@Id
	@Column(name="ID_ENTITY_II_ORG")
	private Integer id;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_ORG_SUBJECT")
	private OrgInfo subject;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_ORG_RESIDENT")
	private OrgInfo rezident;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_ENTITY_II")
	private SIIType siiType;
	@Column(name="PRIZNAK")
	private Integer priznak;
	
	
	
	
	
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
	public OrgInfo getSubject() {
		return subject;
	}
	public void setSubject(OrgInfo subject) {
		this.subject = subject;
	}
	public OrgInfo getRezident() {
		return rezident;
	}
	public void setRezident(OrgInfo rezident) {
		this.rezident = rezident;
	}
	public SIIType getSiiType() {
		return siiType;
	}
	public void setSiiType(SIIType siiType) {
		this.siiType = siiType;
	}
	
	

}
