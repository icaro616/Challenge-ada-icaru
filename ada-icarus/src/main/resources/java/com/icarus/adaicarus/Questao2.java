package com.icarus.adaicarus;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class Questao2 {

    @GetMapping("/hello")
    public String form() {
        return "questao2";
    }
    
    @PostMapping("/test2/hello")
    public String alterarURL(@RequestParam("nome") String nome) {
        String novaURL = "/test/hello/" + nome; 

        // Redirecionar para a nova URL
        return "redirect:" + novaURL;
    }

    @GetMapping("/test/hello/{nome}")
    public String questao22(@PathVariable("nome") String nome, Model model) {
        String like = "<p align='center' style='color:#A6F750; font-size:50px;'>Hello, World! And " + nome + "</p>";
        model.addAttribute("nome", nome);
        model.addAttribute("like", like);
        return "questao22";
    }
}

