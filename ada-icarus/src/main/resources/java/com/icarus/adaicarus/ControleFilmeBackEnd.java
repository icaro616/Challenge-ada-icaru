package com.icarus.adaicarus;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
@RestController
public class ControleFilmeBackEnd {

    private final JdbcTemplate jdbcTemplate;

    public ControleFilmeBackEnd(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/filmes/{id}")
    public Filmes getFilmeById(@PathVariable Long id) {
        String sql = "SELECT * FROM filmes WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Filmes filme = new Filmes(id, sql, sql);
            filme.setId(rs.getLong("id"));
            filme.setName(rs.getString("name"));
            filme.setDescription(rs.getString("description"));
            // Defina os demais atributos do objeto Filme, se houver
            return filme;
        });
    }

    @PostMapping("/add")
    public String criarFilme(@RequestParam("name") String name, @RequestParam("description") String description) {
        inserirFilme(name, description);
        return "Filme criado com sucesso!";
        
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
    }
    }
