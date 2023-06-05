package com.icarus.adaicarus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class questao5 {

	  @GetMapping("/q5")
	    public String Questao5() {
	        return "q5";
	    }}