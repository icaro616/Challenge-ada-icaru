package com.icarus.adaicarus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class Questao7 {

	 

		  @GetMapping("/questao7")
		    public String Questao7() {
		        return "questao7";
		    }}