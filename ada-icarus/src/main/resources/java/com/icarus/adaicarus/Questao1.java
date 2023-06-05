package com.icarus.adaicarus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Questao1 {
	
	@GetMapping("/test/hello")

    public String questao1(Model model) {
    	String jer = "<p aling='center' style='color:#A6F750; font-size:50px;'>Hello,World!</p> ";
    	model.addAttribute("jer", jer);
        return "questao1";
    }
}
