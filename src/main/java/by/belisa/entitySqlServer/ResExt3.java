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

import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"substantiation","projectCount","ispCount","zakCount","amount","budget"})
@Entity
public class ResExt3 extends  Res3 implements Serializable{

//	SubstantId	Substantiation	        ProjectCount	IspCount	ZakCount
//	НП          Национальная программа	     1	           1	       2

/*	SubstantId	Substantiation	        ProjectCount	IspCount	ZakCount	Amount	    Budget
	НП          Национальная программа	3	               1	       2	   2795960,75	2795960,75	
*/	
	private static final long serialVersionUID = 3921740007259090742L;	
	
	@Column(name="Amount")
	private Float amount;	
	@Column(name="Budget")
	private Float budget;
	
	public ResExt3() {
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
		return "ResExt3 ["+super.toString()+"amount=" + amount + ", budget=" + budget + "]";
	}
	
}
