 package by.belisa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="ANKETA")
public class Anketa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4443436266052344647L;
	
	public Anketa(){
		
	}
	public Anketa(Long id){
		this.id = id;
	}
	@Id
	@Column(name = "id")  
	@GeneratedValue(generator = "gen")  
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	private Long id;
	@Column(name="FIO", length=60)
	private String fio;
	@Column(name="FIO_FULL", length=100)
	private String fullFio;
	@Column(name="NAME")
	private String name;
	@Column(name="SURNAME")
	private String surname;
	@Column(name="PATRONYMIC")
	private String patronymic;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORG_ID")
	private Organization org;
	@Column(name="BIRTHDAY", columnDefinition="DATE")
	private Date birthday;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="ANKETA_UCH_STEPENI")
	private List<UchStepeni> uchStepeniList = new ArrayList<UchStepeni>();
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="ANKETA_UCH_ZVANIY")
	private List<UchZvaniy> uchZvaniyList = new ArrayList<UchZvaniy>();
	@Column(name="POST")
	private String post;
	@Column(name="LAB")
	private String lab;
	@Column(name="JOB_PHONE")
	private String jobPhone;
	@Column(name="HOME_PHONE")
	private String homePhone;
	@Column(name="MOBILE_PHONE")
	private String mobilePhone;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="EMAIL")
	private String email;
	@Column(name="LS")
	private Long ls;
	@Lob
	@Column(name="BIOGRAPHY")
	private String biography;
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=false)  
	@PrimaryKeyJoinColumn()
	private User user;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	public String getFullFio() {
		return fullFio;
	}
	public void setFullFio(String fullFio) {
		this.fullFio = fullFio;
	}
	public Organization getOrg() {
		return org;
	}
	public void setOrg(Organization org) {
		this.org = org;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public List<UchStepeni> getUchStepeniList() {
		return uchStepeniList;
	}
	public void setUchStepeniList(List<UchStepeni> uchStepeniList) {
		this.uchStepeniList = uchStepeniList;
	}
	public List<UchZvaniy> getUchZvaniyList() {
		return uchZvaniyList;
	}
	public void setUchZvaniyList(List<UchZvaniy> uchZvaniyList) {
		this.uchZvaniyList = uchZvaniyList;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getLab() {
		return lab;
	}
	public void setLab(String lab) {
		this.lab = lab;
	}
	public String getJobPhone() {
		return jobPhone;
	}
	public void setJobPhone(String jobPhone) {
		this.jobPhone = jobPhone;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
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
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	public String getFio() {
		return fio;
	}
	public void setFio(String fio) {
		this.fio = fio;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getLs() {
		return ls;
	}
	public void setLs(Long ls) {
		this.ls = ls;
	}
	
}
