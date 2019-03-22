package org.wpattern.frameworks.spring.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.wpattern.frameworks.spring.mvc.model.URLBean;
import org.wpattern.frameworks.spring.mvc.model.URLFormBean;

@Controller
@RequestMapping("/URL")

public class URLController {
	EntityManagerFactory emf;
	@PersistenceContext
	EntityManager em;
	EntityTransaction emt;
	private int MAX_DEPTH;
	private HashSet<String> links;
	List<URLBean> URLS;	
	
	@RequestMapping("/controller")
	public ModelAndView URL(@RequestParam("urlCrawler") String urlCrawler, @RequestParam("maxDepth") int maxDepth) {
		
		emf = Persistence.createEntityManagerFactory("webcrawler");
		em = emf.createEntityManager();
		emt = em.getTransaction();
		MAX_DEPTH = maxDepth; 
		links = new HashSet<>();
		URLS = new ArrayList<URLBean>();
				
		URLFormBean URLForm = new URLFormBean();
		getPageLinks(urlCrawler, 0, "", -1, true);	
		emf.close();	
		URLForm.setURLS(URLS);

		return new ModelAndView("/URL/URL.jsp", "URLForm", URLForm);
	}

	public int addURL(URLBean urlBD){			
		emt.begin();
		em.persist(urlBD);
		emt.commit();
		return urlBD.getId();
	}	
	

	public List<URLBean> checkForSons(String URLATUAL){	
		emt.begin();	
		Query consulta = em.createQuery("SELECT urls FROM URLBean urls WHERE urlpai = '" + URLATUAL + "'");
		List<URLBean> URLS = consulta.getResultList();
		emt.commit();
		return URLS;
	}
	
	public void getPageLinks(String URLCrawler, int depth, String URLPai, int id_URLpai, boolean create) {
		if ((!links.contains(URLCrawler) && (depth <= MAX_DEPTH)) && (!URLCrawler.isEmpty())) {
			System.out.println( " >> URL: " + URLCrawler +
								" >> Depth: " + depth +
								" >> URLPai: " + URLPai +
								" >> id_URLpai: " + id_URLpai );
			try {
				boolean foundSons = false;

				// evitar requisições a mais
				if(depth < MAX_DEPTH){
					List<URLBean> URLSFILHO = new ArrayList<URLBean>();
					URLSFILHO = checkForSons(URLCrawler);				
					if(URLSFILHO.size() > 0) {
						foundSons = true;

						URLBean newURL;		
						newURL = new URLBean(URLCrawler, depth, URLPai, id_URLpai);						
						URLS.add(newURL);

						links.add(URLCrawler);
						depth++;

						for (int i = 0; i < URLSFILHO.size(); i++){
							URLS.add(URLSFILHO.get(i));
							getPageLinks(URLSFILHO.get(i).getURL(), depth, URLCrawler, URLSFILHO.get(i).getId_pai(),false);
		                }					
					}
				}
				if(!foundSons){						
					if(create) {
						URLBean newURL;	
						newURL = new URLBean(URLCrawler, depth, URLPai, id_URLpai);					
						URLS.add(newURL);
						id_URLpai = addURL(newURL);
					}
					
					links.add(URLCrawler);
					depth++;

					if(depth-1 < MAX_DEPTH){
						Document document;
						Elements linksOnPage;	
						document = Jsoup.connect(URLCrawler).get();
						linksOnPage = document.select("a[href]");
										
						for (Element page : linksOnPage) {
							getPageLinks(page.attr("abs:href"), depth, URLCrawler, id_URLpai, true);
						}
					}
				}

			} catch (IOException e) {
				System.err.println("Error -  '" + URLCrawler + "': " + e.getMessage());
			}
		}
	}
}
