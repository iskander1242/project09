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
public class ResExt4 implements Serializable{

/*	ResultId	Result	                               FNIRCount	PNIRCount	OKTRCount
	УСТ         стройство (машины, оборудование и др.)	  1	           21	       63*/
	
	private static final long serialVersionUID = 3921240007259990742L;
	
	@Id
	@Column(name="ResultId")
	private String resultId;	
	@Column(name="Result")
	private String result;	
	@Column(name="FNIRCount")
	private Integer fNIRCount;	
	@Column(name="PNIRCount")
	private Integer pNIRCount;	
	@Column(name="OKTRCount")
	private Integer oKTRCount;	
	
	public ResExt4() {
		super();
	}	
	
	/*public String getResultId() {
		return resultId;
	}
	public void setResultId(String resultId) {
		this.resultId = resultId;
	}*/
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Integer getfNIRCount() {
		return fNIRCount;
	}
	public void setfNIRCount(Integer fNIRCount) {
		this.fNIRCount = fNIRCount;
	}
	public Integer getpNIRCount() {
		return pNIRCount;
	}
	public void setpNIRCount(Integer pNIRCount) {
		this.pNIRCount = pNIRCount;
	}
	public Integer getoKTRCount() {
		return oKTRCount;
	}
	public void setoKTRCount(Integer oKTRCount) {
		this.oKTRCount = oKTRCount;
	}

	@Override
	public String toString() {
		return "ResExt4 [resultId=" + resultId + ", result=" + result
				+ ", fNIRCount=" + fNIRCount + ", pNIRCount=" + pNIRCount
				+ ", oKTRCount=" + oKTRCount + "]";
	}	
	
}
