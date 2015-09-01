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
public class ResExt7 implements Serializable{

//	PriorityId	Priority	                ProjectCount	IspCount	ZakCount
//	01.00.00   ЭНЕРГЕТИКА И ЭНЕРГОСБЕРЕЖЕНИЕ	43	          23	      18
	
	private static final long serialVersionUID = 3921240007259490742L;
	
	@Id
	@Column(name="PriorityId")
	private String priorityId;	
	@Column(name="Priority")
	private String priority;	
	@Column(name="ProjectCount")
	private Integer projectCount;	
	@Column(name="IspCount")
	private Integer ispCount;	
	@Column(name="ZakCount")
	private Integer zakCount;	
	
	public ResExt7() {
		super();
	}

/*	public String getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(String priorityId) {
		this.priorityId = priorityId;
	}*/

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
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
		return "ResExt7 [priorityId=" + priorityId + ", priority=" + priority
				+ ", projectCount=" + projectCount + ", ispCount=" + ispCount
				+ ", zakCount=" + zakCount + "]";
	}
}
