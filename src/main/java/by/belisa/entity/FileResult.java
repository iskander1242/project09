package by.belisa.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Basic;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;

@JsonIgnoreProperties({"documents","zapros"})
@Entity
@SequenceGenerator(name="seq_file_result",sequenceName="SERVICES.SEQ_FILE_RESULT", allocationSize=1 )
@Table(schema="SERVICES", name="FILE_RESULT")
public class FileResult implements java.io.Serializable {
	
	private static final long serialVersionUID = -4443436276052344647L;
    
	/*
	 CREATE TABLE "SERVICES"."FILE_RESULT" 
   (	"ID_RESULT" NUMBER, 
	"DOCUMENTS" BLOB, 
	"DESCRIPTION" VARCHAR2(255 CHAR), 
	"ID" NUMBER NOT NULL ENABLE, 
	 CONSTRAINT "FILE_RESULT_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "ID_RESULT" FOREIGN KEY ("ID_RESULT")
	  REFERENCES "SERVICES"."ZAPROS" ("ID") ENABLE
   ) SEGMENT CREATION DEFERRED    
   
    private String fileName;
	private String fileSize;
	private String fileType;
	*/	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_file_result")
	private Integer Id;		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_RESULT", nullable = false)
	private Zapros zapros;	
	@Basic(fetch=FetchType.LAZY)
	@Column(name="DOCUMENTS")
	private byte[] documents;
	@Column(name="DESCRIPTION")
	private String fileType;
	@Column(name="NAME")
	private String fileName;
	@Column(name="FILE_SIZE")
	private Integer fileSize;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Zapros getZapros() {
		return zapros;
	}
	public void setZapros(Zapros zapros) {
		this.zapros = zapros;
	}
	public byte[] getDocuments() {
		return documents;
	}
	public void setDocuments(byte[] documents) {
		this.documents = documents;
	}
	
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getFileSize() {
		return fileSize;
	}
	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}
	@Override
	public String toString() {
		return "FileResult [Id=" + Id 
/*				+ ", zapros=" + zapros 	*/			
				//+ ", documents="+ Arrays.toString(documents)
				+ ", description=" + fileType
				+ ", name=" + fileName + "]";
	}
	
	
	
}
