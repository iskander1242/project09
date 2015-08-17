 package by.belisa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(schema="SERVICES",name="SERVICES")
public class Services implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4143436266052344647L;
	
	public Services(){
		
	}
	public Services(Long id){
		this.id = id;
	}
	
/*	"ID" NUMBER NOT NULL ENABLE, 
	"NAME" VARCHAR2(4000 BYTE), 
	"DESCRIPTION" CLOB, 
	"NOTE" CLOB, 
	"LINK" VARCHAR2(100 BYTE), 
	"KOD" VARCHAR2(400 BYTE), 
	"ID_CLASS" NUMBER, 
	"AUTHORIZATION" NUMBER, 
	"PLATNOST" NUMBER, 
	"PUBLICATION" NUMBER, 
	"TEMPLATE" BLOB, 
	"MIMETYPE_TEMPLATE" VARCHAR2(255 CHAR), 
	"NAME_TEMPLATE" VARCHAR2(255 CHAR), 
	"MODERATION" NUMBER*/
	@Id
	@Column(name = "id")  	 
	private Long id;
	@Column(name="NAME")
	private String name;
	@Lob	
	@Column(name="DESCRIPTION")
	private String description;
	@Lob	
	@Column(name="NOTE")
	private String note;	
	@Column(name="LINK")
	private String link;
	@Column(name="KOD")
	private String kod;
	@Column(name="ID_CLASS")
	private Long id_class;
	@Column(name="AUTHORIZATION")
	private Long autorization;
	@Column(name="PLATNOST")
	private Long platnost;
	@Column(name="PUBLICATION")
	private Long publication;
	@Column(name="TEMPLATE")
	private byte[] template;	
	@Column(name="MIMETYPE_TEMPLATE")
	private String mimeTypeTemplate;	
	@Column(name="NAME_TEMPLATE")
	private String nameTemplate;
	@Column(name="MODERATION")
	private Long moderation;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getKod() {
		return kod;
	}
	public void setKod(String kod) {
		this.kod = kod;
	}
	public Long getId_class() {
		return id_class;
	}
	public void setId_class(Long id_class) {
		this.id_class = id_class;
	}
	public Long getAutorization() {
		return autorization;
	}
	public void setAutorization(Long autorization) {
		this.autorization = autorization;
	}
	public Long getPlatnost() {
		return platnost;
	}
	public void setPlatnost(Long platnost) {
		this.platnost = platnost;
	}
	public Long getPublication() {
		return publication;
	}
	public void setPublication(Long publication) {
		this.publication = publication;
	}
	public byte[] getTemplate() {
		return template;
	}
	public void setTemplate(byte[] template) {
		this.template = template;
	}
	public String getMimeTypeTemplate() {
		return mimeTypeTemplate;
	}
	public void setMimeTypeTemplate(String mimeTypeTemplate) {
		this.mimeTypeTemplate = mimeTypeTemplate;
	}
	public String getNameTemplate() {
		return nameTemplate;
	}
	public void setNameTemplate(String nameTemplate) {
		this.nameTemplate = nameTemplate;
	}
	public Long getModeration() {
		return moderation;
	}
	public void setModeration(Long moderation) {
		this.moderation = moderation;
	}

	

	
}
