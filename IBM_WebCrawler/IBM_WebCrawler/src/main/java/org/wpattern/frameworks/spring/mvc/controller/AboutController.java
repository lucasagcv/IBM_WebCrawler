package org.wpattern.frameworks.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/about")
public class AboutController {

	@RequestMapping("/controller")
	public ModelAndView about() {
		String message = "Developed by Lucas Cavenaghi";

		return new ModelAndView("/about/about.jsp", "message", message);
	}

}
