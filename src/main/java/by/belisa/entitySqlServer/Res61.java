package by.belisa.entitySqlServer;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Res61 implements Serializable{

/*	OKOGU	Agency	                                      ProjectCount	IspCount	ZakCount
	32010   Администрация Президента Республики Беларусь	  7	           3	       2
*/	
	private static final long serialVersionUID = 3921240007259490742L;
	
	@Id
	@Column(name="OKOGU")
	private String oKOGU;	
	@Column(name="Agency")
	private String agency;	
	@Column(name="ProjectCount")
	private Integer projectCount;	
	@Column(name="IspCount")
	private Integer ispCount;	
	@Column(name="ZakCount")
	private Integer zakCount;	
	
	public Res61() {
		super();
	}

/*	public String getoKOGU() {
		return oKOGU;
	}

	public void setoKOGU(String oKOGU) {
		this.oKOGU = oKOGU;
	}*/

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public Integer getProjectCount() {
		return projectCount;
	}

	public void setProjectCount(Integer projectCount) {
		this.projectCount = projectCount;
	}

	public Integer getIspCount() {
		return ispCount;
	}

	public void setIspCount(Integer ispCount) {
		this.ispCount = ispCount;
	}

	public Integer getZakCount() {
		return zakCount;
	}

	public void setZakCount(Integer zakCount) {
		this.zakCount = zakCount;
	}

	@Override
	public String toString() {
		return "ResExt6 [oKOGU=" + oKOGU + ", agency=" + agency
				+ ", projectCount=" + projectCount + ", ispCount=" + ispCount
				+ ", zakCount=" + zakCount + "]";
	}
}
