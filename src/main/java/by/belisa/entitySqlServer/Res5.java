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
public class Res5 implements Serializable{

//	SectorId	Sector	        ProjectCount	IspCount	ZakCount
//	АКД         академический	362	               58	       12
	
	private static final long serialVersionUID = 3921240007259490792L;	
	
	@Id
	@Column(name="SectorId")
	private String sectorId;	
	@Column(name="Sector")
	private String sector;	
	@Column(name="ProjectCount")
	private Integer projectCount;	
	@Column(name="IspCount")
	private Integer ispCount;	
	@Column(name="ZakCount")
	private Integer zakCount;	
	
	public Res5() {
		super();
	}

/*	public String getSectorId() {
		return sectorId;
	}

	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}*/

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
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
		return "Res5 [sectorId=" + sectorId + ", sector=" + sector
				+ ", projectCount=" + projectCount + ", ispCount=" + ispCount
				+ ", zakCount=" + zakCount + "]";
	}
	
}
