package com.icarus.adaicarus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

	@Controller
	public class Questao9 {
		 @GetMapping("/questao99")
		    public String Questao9() {
		        return "questao99";
		    }
	}
