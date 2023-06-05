package com.icarus.adaicarus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Questao10 {
	 @GetMapping("/ultimo")
	    public String Questao10() {
	        return "questao10";
	    }
}
