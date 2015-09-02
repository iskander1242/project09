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

@JsonPropertyOrder({"result","fNIRCount","fNIRAmount","pNIRCount","pNIRAmount","oKTRCount","oKTRAmount"})
@Entity
public class ResExt4 extends Res4   implements Serializable{

/*	ResultId	Result	                               FNIRCount	PNIRCount	OKTRCount
	УСТ         стройство (машины, оборудование и др.)	  1	           21	       63*/
	
/*	ResultId	Result	                                FNIRCount	FNIRAmount	PNIRCount	PNIRAmount	    OKTRCount	OKTRAmount
	УСТ         Устройство (машины, оборудование и др.)	5	        3950590	    463	        217332659,752	786	        1567973805,976
*/	
	private static final long serialVersionUID = 3921240007209990742L;
    @Column(name="FNIRAmount")
    private Float fNIRAmount;
    @Column(name="PNIRAmount")
    private Float pNIRAmount;
    @Column(name="OKTRAmount")
    private Float oKTRAmount;
    	
	public ResExt4() {
		super();
	}

	public Float getfNIRAmount() {
		return fNIRAmount;
	}

	public void setfNIRAmount(Float fNIRAmount) {
		this.fNIRAmount = fNIRAmount;
	}

	public Float getpNIRAmount() {
		return pNIRAmount;
	}

	public void setpNIRAmount(Float pNIRAmount) {
		this.pNIRAmount = pNIRAmount;
	}

	public Float getoKTRAmount() {
		return oKTRAmount;
	}

	public void setoKTRAmount(Float oKTRAmount) {
		this.oKTRAmount = oKTRAmount;
	}

	@Override
	public String toString() {
		return "ResExt4 ["+super.toString()+"fNIRAmount=" + fNIRAmount + ", pNIRAmount="
				+ pNIRAmount + ", oKTRAmount=" + oKTRAmount + "]";
	}
	
	
	
}
