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
@JsonPropertyOrder({"agency","projectCount","ispCount","zakCount","amount","budget"})
@Entity
public class ResExt6  extends Res6 implements Serializable{

/*	OKOGU	Agency	                                      ProjectCount	IspCount	ZakCount
	32010   Администрация Президента Республики Беларусь	  7	           3	       2
	
	OKOGU	Agency	                                       ProjectCount	IspCount	ZakCount	Amount	    Budget
    32010   Администрация Президента Республики Беларусь	60	            4	         14	   7373248,2	6865788,3
*/	
	private static final long serialVersionUID = 3921240007259490742L;
	 
	@Column(name="Amount")
	private Float amount;	
	@Column(name="Budget")
	private Float budget;
	
	public ResExt6() {
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
		return "ResExt6 ["+super.toString()+"amount=" + amount + ", budget=" + budget + "]";
	}
	
	}
