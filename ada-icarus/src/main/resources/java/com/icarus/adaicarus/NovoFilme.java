package com.icarus.adaicarus;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NovoFilme {

    private final JdbcTemplate jdbcTemplate;

    public NovoFilme(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @GetMapping("/filmes2")
    public ModelAndView getFilmesPage(@RequestParam(value = "id", required = false) Long id) {
        ModelAndView modelAndView = new ModelAndView();

        if (id != null) {
            return new ModelAndView("redirect:/filmes2/" + id);
        } else {
            return new ModelAndView("questao5");
        }
    }
    @GetMapping("/filmes2/{id}")
    public ModelAndView getFilmeById(@PathVariable("id") Long id) {
        String sql = "SELECT * FROM filmes WHERE id = ?";
        Filmes filme = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Filmes f = new Filmes(id, sql, sql);
            f.setId(rs.getLong("id"));
            f.setName(rs.getString("name"));
            f.setDescription(rs.getString("description"));
            // Defina os demais atributos do objeto Filme, se houver
            return f;
        });

        ModelAndView modelAndView = new ModelAndView("questao55");
        modelAndView.addObject("filme", filme);

        return modelAndView;
    }
   
}