package by.belisa.bean;

import java.io.Serializable;

import by.belisa.entity.Organization;

public class OrgDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3962334779407152977L;
	
	private Integer id;
	private String address;
	private String email;
	private String name;
	//Code in dictionary
	private String kod_old;
	private String unp;
	//Accounting code
	private String kod_booker;
	//Classifier  OKOGU code
	private Integer okoguId;
	private String okoguName;
	private String full_name_rus;
	private String full_name_eng;
	private int cityId;
	private Integer vidOrgId;
	private boolean approval;
	private int regionId;
	
	


	

	public OrgDTO(){
		
	}
	
	public OrgDTO(Organization org){
		this.id=org.getId();
		this.address=org.getAddress();
		this.email=org.getEmail();
		this.name=org.getName();
		this.okoguId = org.getOkogu()!=null ? org.getOkogu().getId() : null;
		this.okoguName = org.getOkogu()!=null ? org.getOkogu().getName() : "";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKod_old() {
		return kod_old;
	}

	public void setKod_old(String kod_old) {
		this.kod_old = kod_old;
	}

	public String getUnp() {
		return unp;
	}

	public void setUnp(String unp) {
		this.unp = unp;
	}

	public String getKod_booker() {
		return kod_booker;
	}

	public void setKod_booker(String kod_booker) {
		this.kod_booker = kod_booker;
	}


	
	public Integer getOkoguId() {
		return okoguId;
	}

	public void setOkoguId(Integer okoguId) {
		this.okoguId = okoguId;
	}

	public String getOkoguName() {
		return okoguName;
	}

	public void setOkoguName(String okoguName) {
		this.okoguName = okoguName;
	}

	public Integer getVidOrgId() {
		return vidOrgId;
	}

	public void setVidOrgId(Integer vidOrgId) {
		this.vidOrgId = vidOrgId;
	}

	public String getFull_name_rus() {
		return full_name_rus;
	}

	public void setFull_name_rus(String full_name_rus) {
		this.full_name_rus = full_name_rus;
	}

	public String getFull_name_eng() {
		return full_name_eng;
	}

	public void setFull_name_eng(String full_name_eng) {
		this.full_name_eng = full_name_eng;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	
	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	
	
	

}
