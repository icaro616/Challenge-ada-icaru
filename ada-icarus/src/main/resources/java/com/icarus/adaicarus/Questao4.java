package com.icarus.adaicarus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Questao4 {
	   @RequestMapping("q4")
	    public String questao4() {
	        return "questao4";
	    }
}
