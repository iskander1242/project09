package by.belisa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@SequenceGenerator(name="seq_zapros",sequenceName="SERVICES.SEQ_ZAPROS" )
@Table(schema="SERVICES", name="ZAPROS")
public class Zapros implements java.io.Serializable {
    
	/*
	"ID" NUMBER NOT NULL ENABLE, 
	"ID_USER" NUMBER, 
	"ID_SERVICE" NUMBER, 
	"START_DATE" DATE, 
	"FINISH_DATE" DATE, 
	"ZAPROS" VARCHAR2(2000 CHAR),*/
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_zapros")
	private Integer Id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SERVICE", nullable = false)
	private Services services;
	@Column(name="ID_USER")
	private Integer IdUser;
	@Column(name="START_DATE")
	private Date startDate;
	@Column(name="FINISH_DATE")
	private Date finishDate;	
	@Column(name="ZAPROS")	
	private String zapros; 	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="zapros")
	private Set<FileResult> fileResults= new HashSet<FileResult>(0);
	
	public Services getServices() {
		return services;
	}
	public void setServices(Services services) {
		this.services = services;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Integer getIdUser() {
		return IdUser;
	}
	public void setIdUser(Integer idUser) {
		IdUser = idUser;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public String getZapros() {
		return zapros;
	}
	public void setZapros(String zapros) {
		this.zapros = zapros;
	}
	public Set<FileResult> getFileResults() {
		return fileResults;
	}
	public void setFileResults(Set<FileResult> fileResults) {
		this.fileResults = fileResults;
	}
	@Override
	public String toString() {
		return "Zapros [Id=" + Id 
				//+ ", services=" + services.getId() 
				+ ", IdUser="
				+ IdUser + ", startDate=" + startDate + ", finishDate="
				+ finishDate + ", zapros=" + zapros 
				//+ ", fileResults="+ fileResults 
				+ "]";
	}	
}
