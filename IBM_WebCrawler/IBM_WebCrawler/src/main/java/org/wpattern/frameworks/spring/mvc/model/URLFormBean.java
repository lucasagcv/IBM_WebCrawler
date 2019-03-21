package org.wpattern.frameworks.spring.mvc.model;

import java.util.List;

import org.wpattern.frameworks.spring.mvc.utils.BaseBean;

public class URLFormBean extends BaseBean {

	private static final long serialVersionUID = -8779295804278814832L;
	
	private List<URLBean> URLS;
	
	public URLFormBean() {
		
	}

	public List<URLBean> getURLS() {
		return URLS;
	}

	public void setURLS(List<URLBean> uRLS) {
		URLS = uRLS;
	}
		
	
}
