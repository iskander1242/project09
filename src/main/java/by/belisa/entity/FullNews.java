package by.belisa.entity;

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
@Table(schema="IR",name="IR")
public class FullNews implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7686265754170862414L;
	@Id
	@Column(name="ID_IR")
	private Integer id;
	@Column(name="SHORT_CONTENT_NEWS")
	private String shortText;
	@Column(name="SOURCE_NEWS")
	private String link;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COUNTRY")
	private Country country;
	
	@Column(name="DATE_PUBLICATION_NEWS")
	private Date date;
	@Column(name="TEXT")
	private String fullText;

	public String getFullText() {
		return fullText;
	}

	public void setFullText(String fullText) {
		this.fullText = fullText;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShortText() {
		return shortText;
	}

	public void setShortText(String shortText) {
		this.shortText = shortText;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

}
