package by.belisa.entitySqlServer;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class ResultNTI implements Serializable{
	
	private static final long serialVersionUID = 3921240007259491742L;	
	
/*	ProjectId	Title	        rganizationName	                    CompletionDate	    ApprovalDate	     InvId	IntelProperty	        Amount	NCIPReport
	20102010    Разработать 	Государственное научное учреждение 	2011-05-30 00:00:00	2010-12-20 00:00:00	 61316  полезная модель: 6477	75000	NULL	
*/
	@Id
	@Column(name="ProjectId")
	private Integer projectId;	
	@Column(name="Title")
	private String title;
	@Column(name="OrganizationName")
	private String organizationName;
	@Column(name="CompletionDate")
	private String сompletionDate;
	@Column(name="ApprovalDate")
	private String approvalDate;
	@Column(name="InvId")
	private String invId;
	@Column(name="IntelProperty")
	private String intelProperty;
	@Column(name="Amount")
	private Float amount;
	@Column(name="NCIPReport")
	private String nCIPReport;
	
	
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getСompletionDate() {
		return сompletionDate;
	}
	public void setСompletionDate(String сompletionDate) {
		this.сompletionDate = сompletionDate;
	}
	public String getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}
	public String getInvId() {
		return invId;
	}
	public void setInvId(String invId) {
		this.invId = invId;
	}
	public String getIntelProperty() {
		return intelProperty;
	}
	public void setIntelProperty(String intelProperty) {
		this.intelProperty = intelProperty;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getnCIPReport() {
		return nCIPReport;
	}
	public void setnCIPReport(String nCIPReport) {
		this.nCIPReport = nCIPReport;
	}
	@Override
	public String toString() {
		return "ResultNTI [projectId=" + projectId + ", title=" + title
				+ ", organizationName=" + organizationName
				+ ", сompletionDate=" + сompletionDate + ", approvalDate="
				+ approvalDate + ", invId=" + invId + ", intelProperty="
				+ intelProperty + ", amount=" + amount + ", nCIPReport="
				+ nCIPReport + "]";
	}		
	
}
