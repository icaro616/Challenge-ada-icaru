package com.icarus.adaicarus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcIndex {
	   @RequestMapping("/")
	    public String index() {
	        return "index";
	    }
	   
}
