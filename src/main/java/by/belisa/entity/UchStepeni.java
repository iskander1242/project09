package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="UCH_STEPENI")
@SequenceGenerator(sequenceName="SEQ_UCH_STEPENI", name="PK")
public class UchStepeni implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5600921919307660243L;
	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	@Column(name="NAME",length=10)
	private String name;
	@Column(name="FULL_NAME", length=40)
	private String fullName;
	@Column(name="KOD_OLD", length=3)
	private String oldCode;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VID_UCH_STEPENI_ID")
	private VidUchStepeni vidUchStepeni;
	public Integer getId() {
		return id;
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
	public String getOldCode() {
		return oldCode;
	}
	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
	}
	public VidUchStepeni getVidUchStepeni() {
		return vidUchStepeni;
	}
	public void setVidUchStepeni(VidUchStepeni vidUchStepeni) {
		this.vidUchStepeni = vidUchStepeni;
	}
	
}
