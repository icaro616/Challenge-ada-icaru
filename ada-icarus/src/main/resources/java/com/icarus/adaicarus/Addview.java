package com.icarus.adaicarus;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class Addview {
	private final JdbcTemplate jdbcTemplate;

    public Addview(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @GetMapping("/icaro")
    public ModelAndView exibirFormulario() {
        ModelAndView modelAndView = new ModelAndView("fly");
        modelAndView.addObject("filme", new FilmeForm()); // Initialize with empty filme object
        return modelAndView;
    }

    
    @PostMapping("/add2")
    public ModelAndView criarFilme(@RequestParam("name") String name, @RequestParam("description") String description) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            inserirFilme(name, description);
            modelAndView.setViewName("sucesso");
            modelAndView.addObject("mensagem", "Filme criado com sucesso!");
        } catch (FilmeDuplicadoException ex) {
            modelAndView.setViewName("erro");
            modelAndView.addObject("mensagem", ex.getMessage());
        }

        return modelAndView;
    }

    private void inserirFilme(String name, String description) {
        String selectSql = "SELECT COUNT(*) FROM FILMES WHERE name = ?";
        int count = jdbcTemplate.queryForObject(selectSql, Integer.class, name);

        if (count == 0) {
            String insertSql = "INSERT INTO FILMES (name, description) VALUES (?, ?)";
            jdbcTemplate.update(insertSql, name, description);
            System.out.println("Filme inserido com sucesso!");
        } else {
            throw new FilmeDuplicadoException("Filme com o mesmo nome já existe no banco de dados.");
        }
    }}