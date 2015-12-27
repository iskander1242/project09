package by.belisa.bean;

import java.util.ArrayList;
import java.util.List;

import by.belisa.entitySqlServer.Funding;
import by.belisa.entitySqlServer.Res1;
import by.belisa.entitySqlServer.Res11;
import by.belisa.entitySqlServer.Res2;
import by.belisa.entitySqlServer.Res21;
import by.belisa.entitySqlServer.Res3;
import by.belisa.entitySqlServer.Res31;
import by.belisa.entitySqlServer.Res4;
import by.belisa.entitySqlServer.Res41;
import by.belisa.entitySqlServer.Res5;
import by.belisa.entitySqlServer.Res51;
import by.belisa.entitySqlServer.Res6;
import by.belisa.entitySqlServer.Res61;
import by.belisa.entitySqlServer.Res7;
import by.belisa.entitySqlServer.Res71;
import by.belisa.entitySqlServer.ResultNTI;

public class ServiceDataNTD {
	private  List<ResultNTI> resultNTIList;
	private  List<Funding> fundingList;	
	private  List<ResultNTI> copyResultNTIList;
	

	
	public List<Funding> getFundingList() {
		return fundingList;
	}
	public void setFundingList(List<Funding> fundingList) {
		this.fundingList = fundingList;
	}
	public List<ResultNTI> getResultNTIList() {
		return resultNTIList;
	}
	public void setResultNTIList(List<ResultNTI> resultNTIList) {
		this.resultNTIList = resultNTIList;	
	}
	public List<ResultNTI> getCopyResultNTIList() {
		return copyResultNTIList;
	}
	public void setCopyResultNTIList(List<ResultNTI> copyResultNTIList) {
		this.copyResultNTIList = copyResultNTIList;
	}
	@Override
	public String toString() {
		return "ServiceDataNTD [resultNTIList=" + resultNTIList
				+  ", copyResultNTIList="
				+ copyResultNTIList + "]";
	}	
	
	
}
