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
@JsonPropertyOrder({"priority","projectCount","ispCount","zakCount","amount","budget"})
@Entity
public class ResExt7  extends Res7 implements Serializable{

//	PriorityId	Priority	                ProjectCount	IspCount	ZakCount
//	01.00.00   ЭНЕРГЕТИКА И ЭНЕРГОСБЕРЕЖЕНИЕ	43	          23	      18
	
/*	PriorityId	Priority	ProjectCount	IspCount	ZakCount	Amount	Budget
	01.00.00                        	ЭНЕРГЕТИКА И ЭНЕРГОСБЕРЕЖЕНИЕ	368	80	64	135893767,922	115080668,924
*/	
	private static final long serialVersionUID = 3921240007259490742L;
	
	
	@Column(name="Amount")
	private Float amount;	
	@Column(name="Budget")
	private Float budget;
	
	public ResExt7() {
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
		return "ResExt7 ["+super.toString()+"amount=" + amount + ", budget=" + budget + "]";
	}

}
