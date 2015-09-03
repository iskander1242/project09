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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"sector","projectCount","ispCount","zakCount","amount"})
@Entity
public class ResExt5 extends Res5  implements Serializable{

//	SectorId	Sector	        ProjectCount	IspCount	ZakCount
//	АКД         академический	362	               58	       12
	
/*	SectorId	Sector	        ProjectCount	IspCount	ZakCount	Amount	     Budget
	АКД         академический	3431	           84	       483	  1451582573,57	1226119631,57	
*/	
	private static final long serialVersionUID = 3921240007259490792L;	
	
	
	@Column(name="Amount")
	private Float amount;
	@JsonIgnore
	@Column(name="Budget")
	private Float budget;
	
	public ResExt5() {
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
		return "ResExt5 ["+super.toString()+"amount=" + amount + ", budget=" + budget + "]";
	}
	
	
	
}
