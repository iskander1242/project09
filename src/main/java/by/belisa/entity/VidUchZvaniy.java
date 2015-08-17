package by.belisa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="VID_UCH_ZVANIY")
@SequenceGenerator(name="PK", sequenceName="SEQ_VID_UCH_ZVANIY")
public class VidUchZvaniy implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8031866819427074197L;
	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	@Column(name="NAME", length=20)
	private String name;
	@Column(name="KOD_OLD", length=2)
	private String oldCode;
	public Integer getId() {
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
