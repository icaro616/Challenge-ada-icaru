package com.icarus.adaicarus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class questao8 {
	 @GetMapping("/questao8")
	    public String Questao8() {
	        return "questao8";
	    }
}
