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
import org.hibernate.annotations.Columns;

@JsonPropertyOrder({"funding","projectCount","ispCount","zakCount","amount"})
@Entity
public class ResExt2 extends Res2 implements Serializable {
/*	FundingId	Funding	              ProjectCount	IspCount	ZakCount	Amount
	РЕСБ        республиканский бюджет	744	         164	        91	     308615718,558*/
	
/*	FundingId	Funding	                       ProjectCount	IspCount	ZakCount	Amount
	РЕСБ        республиканский бюджет	       6629	        372	        278	     2471916544,571	
*/	
	private static final long serialVersionUID = 3921240007159490742L;
	
	@Column(name="Amount")
	private Float amount;	
	
	public ResExt2(){
		super();
	}
	
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ResExt2 ["+super.toString() +" amount=" + amount + "]";
	}
	
	
}
