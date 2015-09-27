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
public class Funding implements Serializable{
	
/*	FundingId	Funding	                Amount
	РЕСБ        республиканский бюджет	1750000*/
	
	private static final long serialVersionUID = 3921240097259490742L;
	
	@Id
	@Column(name="FundingId")
	private String fundingId;
	@Column(name="Funding")
	private String funding;	
	@Column(name="Amount")
	private Float  amount;	
	
	public String getFundingId() {
		return fundingId;
	}
	public void setFundingId(String fundingId) {
		this.fundingId = fundingId;
	}
	public String getFunding() {
		return funding;
	}
	public void setFunding(String funding) {
		this.funding = funding;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Funding [fundingId=" + fundingId + ", funding=" + funding
				+ ", amount=" + amount + "]";
	}	
	
}
