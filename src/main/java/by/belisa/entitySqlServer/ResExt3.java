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
public class ResExt3 implements Serializable{

//	SubstantId	Substantiation	        ProjectCount	IspCount	ZakCount
//	НП          Национальная программа	     1	           1	       2
	
	private static final long serialVersionUID = 3921740007259490742L;
	
	@Id
	@Column(name="SubstantId")
	private String substantId;
	@Column(name="Substantiation")
	private String substantiation;	
	@Column(name="ProjectCount")
	private Integer projectCount;	
	@Column(name="IspCount")
	private Integer ispCount;	
	@Column(name="ZakCount")
	private Integer zakCount;
	
	
	public ResExt3() {
		super();
	}

/*	public String getSubstantId() {
		return substantId;
	}
	public void setSubstantId(String substantId) {
		this.substantId = substantId;
	}*/
	public String getSubstantiation() {
		return substantiation;
	}
	public void setSubstantiation(String substantiation) {
		this.substantiation = substantiation;
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
		return "ResExt3 [substantId=" + substantId + ", substantiation="
				+ substantiation + ", projectCount=" + projectCount
				+ ", ispCount=" + ispCount + ", zakCount=" + zakCount + "]";
	}
	
	
	
	



	
	
}
