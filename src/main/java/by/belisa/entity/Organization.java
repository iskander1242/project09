package by.belisa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ORGANIZATION")
@SequenceGenerator(name="PK", sequenceName="SEQ_ORGANIZATION")
public class Organization implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1534080481178508955L;
	public Organization(){
		
	}
	public Organization(Integer id){
		this.id = id;
	}
	@Id
	@GeneratedValue(generator="PK")
	private Integer id;
	@Column(name="NAME")
	private String name;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="EMAIL")
	private String email;
	@Column(name="KOD_OLD")
	private String oldCode;
	@Column(name="UNP")
	private String unp;
	@Column(name="KOD_BOOKER")
	private String codeBooker;
	@ManyToOne
	@JoinColumn(name="OKOGU")
	private Okogu okogu;
	@Column(name="FULL_NAME_RUS")
	private String fullNameR;
	@Column(name="FULL_NAME_ENG")
	private String fullNameE;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VID_ORG_ID")
	private VidOrg vidOrg;
	
	
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOldCode() {
		return oldCode;
	}
	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
	}
	public String getUnp() {
		return unp;
	}
	public void setUnp(String unp) {
		this.unp = unp;
	}
	public String getCodeBooker() {
		return codeBooker;
	}
	public void setCodeBooker(String codeBooker) {
		this.codeBooker = codeBooker;
	}
	
	public Okogu getOkogu() {
		return okogu;
	}
	public void setOkogu(Okogu okogu) {
		this.okogu = okogu;
	}
	
	public String getFullNameR() {
		return fullNameR;
	}
	public void setFullNameR(String fullNameR) {
		this.fullNameR = fullNameR;
	}
	public String getFullNameE() {
		return fullNameE;
	}
	public void setFullNameE(String fullNameE) {
		this.fullNameE = fullNameE;
	}
	public VidOrg getVidOrg() {
		return vidOrg;
	}
	public void setVidOrg(VidOrg vidOrg) {
		this.vidOrg = vidOrg;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

}
