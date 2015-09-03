package by.belisa.entitySqlServer;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;


@JsonPropertyOrder({"projectCount","rejectCount","amount","ispCount","zakCount","regCount" })
@Entity
@DiscriminatorValue("L")
public class ResExt1 extends Res1 implements Serializable {

//	 ProjectCount	RejectCount	  RegCount	 ZakCount	IspCount	ReportCount
//    1150	          4	      1146	      281	     219	      1867 

/*	ProjectCount	RejectCount	RegCount	ZakCount	IspCount	Amount	            Budget	  ReportCount
	9212	              14	  9198	      930	       490	   4134918309,393	2685333316,795	 8429*/	
	
	
	private static final long serialVersionUID = 3921240097259490742L;
	
	@Column(name="Amount")
	private Float amount;
	@JsonIgnore
	@Column(name="Budget")
	private Float budget;
	

	public ResExt1(){
		super();
	}
	
	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Float getBudget() {
		return budget;
	}

	public void setBudget(Float budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "ResExt1 [amount=" + amount + ", budget=" + budget +super.toString()+ "]";
	}		
}
