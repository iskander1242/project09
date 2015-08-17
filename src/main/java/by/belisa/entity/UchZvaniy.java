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
@Table(name="UCH_ZVANIY")
@SequenceGenerator(name="PK", sequenceName="SEQ_SPR_UCH_ZVANIY")
public class UchZvaniy implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7675657014294710276L;
	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	@Column(name="NAME")
	private String name;
	@Column(name="KOD_OLD",length=3)
	private String code;
	@Column(name="FULL_NAME")
	private String fullName;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VID_UCH_ZVANIY_ID")
	private VidUchZvaniy vidUchZvaniy;
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public VidUchZvaniy getVidUchZvaniy() {
		return vidUchZvaniy;
	}
	public void setVidUchZvaniy(VidUchZvaniy vidUchZvaniy) {
		this.vidUchZvaniy = vidUchZvaniy;
	}
	
	

}
