package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="VID_UCH_STEPENI")
@SequenceGenerator(name="PK", sequenceName="SEQ_VID_UCH_STEPENI")
public class VidUchStepeni implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 184472789072833563L;
	@Id
	@GeneratedValue(generator="PK")
	private int id;
	@Column(name="NAME", length=20)
	private String name;
	@Column(name="KOD_OLD", length=2)
	private String oldCode;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOldCode() {
		return oldCode;
	}
	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
	}
	
}
