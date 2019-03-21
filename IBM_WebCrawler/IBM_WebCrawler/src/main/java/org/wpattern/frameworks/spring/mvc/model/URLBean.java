package org.wpattern.frameworks.spring.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.wpattern.frameworks.spring.mvc.utils.BaseBean;

@Entity
@Table(name="urls")
public class URLBean extends BaseBean {

	private static final long serialVersionUID = -8936185892556396512L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
		
	@Column
	private String URL;
	
	@Column
	private int depth;

	@Column
	private String urlpai;
	
	@Column
	private int id_pai;

	public URLBean() {
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getURL() {
		return URL;
	}


	public void setURL(String uRL) {
		URL = uRL;
	}


	public int getDepth() {
		return depth;
	}


	public void setDepth(int depth) {
		this.depth = depth;
	}


	public String getUrlpai() {
		return urlpai;
	}


	public void setUrlpai(String urlpai) {
		this.urlpai = urlpai;
	}


	public int getId_pai() {
		return id_pai;
	}


	public void setId_pai(int id_pai) {
		this.id_pai = id_pai;
	}


	public URLBean(String uRL, int depth, String urlpai, int id_pai) {
		super();
		URL = uRL;
		this.depth = depth;
		this.urlpai = urlpai;
		this.id_pai = id_pai;
	}


	
}
