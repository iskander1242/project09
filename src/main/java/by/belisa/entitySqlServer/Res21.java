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
public class Res21 implements Serializable{

/*	FundingId	Funding	              ProjectCount	IspCount	ZakCount	Amount
	РЕСБ        республиканский бюджет	744	         164	        91	     308615718,558*/
	
	private static final long serialVersionUID = 3921240007259490742L;
	
	@Id
	@Column(name="FundingId")
	private String fundingId;	
	@Column(name="Funding")
	private String funding;	
	@Column(name="ProjectCount")
	private Integer projectCount;	
	@Column(name="IspCount")
	private Integer ispCount;	
	@Column(name="ZakCount")
	private Integer zakCount;
	/*	public String getFundingId() {
		return fundingId;
	}
	public void setFundingId(String fundingId) {
		this.fundingId = fundingId;
	}*/
	public String getFunding() {
		return funding;
	}
	public void setFunding(String funding) {
		this.funding = funding;
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
		return "Res [fundingId=" + fundingId + ", funding=" + funding
				+ ", projectCount=" + projectCount + ", ispCount=" + ispCount
				+ ", zakCount=" + zakCount + "]";
	}


	
	
}
