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
public class Res11 implements Serializable{

//	 ProjectCount	RejectCount	  RegCount	 ZakCount	IspCount	ReportCount
//    1150	          4	      1146	      281	     219	      1867 
	
	private static final long serialVersionUID = 3921240007259490742L;
	@Id
	@Column(name="ProjectCount")
	private Integer projectCount;

	@Column(name="RejectCount")
	private Integer rejectCount;	
	@Column(name="RegCount")
	private Integer regCount;	
	@Column(name="ZakCount")
	private Integer zakCount;	
	@Column(name="IspCount")
	private Integer ispCount;
	//@Column(name="ReportCount")
	private Integer reportCount;
	
	
	public Integer getProjectCount() {
		return projectCount;
	}
	public void setProjectCount(Integer projectCount) {
		this.projectCount = projectCount;
	}
	public Integer getRejectCount() {
		return rejectCount;
	}
	public void setRejectCount(Integer rejectCount) {
		this.rejectCount = rejectCount;
	}
	public Integer getRegCount() {
		return regCount;
	}
	public void setRegCount(Integer regCount) {
		this.regCount = regCount;
	}
	public Integer getZakCount() {
		return zakCount;
	}
	public void setZakCount(Integer zakCount) {
		this.zakCount = zakCount;
	}
	public Integer getIspCount() {
		return ispCount;
	}
	public void setIspCount(Integer ispCount) {
		this.ispCount = ispCount;
	}
/*	public Integer getReportCount() {
		return reportCount;
	}
	public void setReportCount(Integer reportCount) {
		this.reportCount = reportCount;
	}*/
	
	
	@Override
	public String toString() {
		return "Res1 [projectCount=" + projectCount + ", rejectCount="
				+ rejectCount + ", regCount=" + regCount + ", zakCount="
				+ zakCount + ", ispCount=" + ispCount + ", reportCount="
				+ reportCount + "]";
	}

	
	
}
