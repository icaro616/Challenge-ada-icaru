package com.icarus.adaicarus;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class Questao3 {
	   @GetMapping("/test/hello2")
	    public ModelAndView hello() {
	        ModelAndView modelAndView = new ModelAndView("questao3");
	        modelAndView.addObject("request", new HelloRequest());
	        return modelAndView;
	    }

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(value = "/test/hello2/body", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView helloBody(@ModelAttribute("request") HelloRequest request) {
        String name = request.getName();
        String message;
        LocalDateTime processedAt = LocalDateTime.now();

        if (name.equals("Ada")) {
            message = " message: “Hello, Ada!” processedAt: " + processedAt;
        } else {
            message = "Você digitou o nome errado";
        }

        String html = "<p style=\" color:#A6F750;\">"
        +message+"</p>";

        HelloResponse response = new HelloResponse(message, processedAt, html);

        ModelAndView modelAndView = new ModelAndView("questao33");
        modelAndView.addObject("response", response);

        return modelAndView;
    }
    public static class HelloRequest {
        private String name;

        // Getters e Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class HelloResponse {
        private String message;
        private LocalDateTime processedAt;
        private String html;

        public HelloResponse(String message, LocalDateTime processedAt, String html) {
            this.message = message;
            this.processedAt = processedAt;
            this.html = html;
        }

        // Getters e Setters
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public LocalDateTime getProcessedAt() {
            return processedAt;
        }

        public void setProcessedAt(LocalDateTime processedAt) {
            this.processedAt = processedAt;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }
    }
}