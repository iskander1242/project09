package by.belisa.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import by.belisa.entity.Anketa;
import by.belisa.entity.UchStepeni;
import by.belisa.entity.UchZvaniy;

public class AnketaDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5556610303426905342L;
	
	public AnketaDTO(){
		
	}
	public AnketaDTO(Anketa anketa){
		if (anketa!=null){
			this.address = anketa.getAddress();
			this.biography = anketa.getBiography();
			this.birthday = anketa.getBirthday()!=null ? dateFormat.format(anketa.getBirthday()): null;
			this.email = anketa.getEmail();
			this.fio = anketa.getFio();
			this.fullFio = anketa.getFullFio();
			this.homePhone = anketa.getHomePhone();
			this.id = anketa.getId();
			this.jobPhone = anketa.getJobPhone();
			this.lab = anketa.getLab();
			this.mobilePhone = anketa.getMobilePhone();
			this.orgId = anketa.getOrg()!=null ? anketa.getOrg().getId() : null;
			this.orgName = anketa.getOrg()!=null ? anketa.getOrg().getName() : "";
			this.post = anketa.getPost();
			this.name = anketa.getName();
			this.surname = anketa.getSurname();
			this.patronymic = anketa.getPatronymic();
			this.uchZvaniyIdArr = new Integer[anketa.getUchZvaniyList().size()];
			this.ls = anketa.getLs();
			int n=0;
			for (UchZvaniy i : anketa.getUchZvaniyList()){
				this.uchZvaniyIdArr[n]=i.getId();
				n++;
			}
			this.uchStepeniIdArr = new Integer[anketa.getUchStepeniList().size()];
			n=0;
			for (UchStepeni i : anketa.getUchStepeniList()){
				this.uchStepeniIdArr[n]=i.getId();
				n++;
			}
			
		}
		
	}
	
	
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private long id;
	private String fio;
	private String fullFio;
	private String orgName;
	private Integer orgId;
	private String birthday;
	private String uchStepenName;
	private Integer[] uchStepeniIdArr;
	private Integer[] uchZvaniyIdArr;
	private String post;
	private String lab;
	private String jobPhone;
	private String homePhone;
	private String mobilePhone;
	private String address;
	private String email;
	private String biography;
	private String name;
	private String surname;
	private String patronymic;
	private Long ls;
	
	public Long getLs() {
		return ls;
	}
	public void setLs(Long ls) {
		this.ls = ls;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
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
	public String getFio() {
		return fio;
	}
	public void setFio(String fio) {
		this.fio = fio;
	}
	public String getFullFio() {
		return fullFio;
	}
	public void setFullFio(String fullFio) {
		this.fullFio = fullFio;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	

	public Integer[] getUchStepeniIdArr() {
		return uchStepeniIdArr;
	}
	public void setUchStepeniIdArr(Integer[] uchStepeniIdArr) {
		this.uchStepeniIdArr = uchStepeniIdArr;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getUchStepenName() {
		return uchStepenName;
	}
	public void setUchStepenName(String uchStepenName) {
		this.uchStepenName = uchStepenName;
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
	public Integer[] getUchZvaniyIdArr() {
		return uchZvaniyIdArr;
	}
	public void setUchZvaniyIdArr(Integer[] uchZvaniyIdArr) {
		this.uchZvaniyIdArr = uchZvaniyIdArr;
	}
	
	
}
