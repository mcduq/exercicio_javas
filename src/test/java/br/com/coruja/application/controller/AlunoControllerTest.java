package br.com.coruja.application.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.coruja.domain.model.Aluno;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AlunoControllerTest {
    @Autowired
    protected WebTestClient web;

    @BeforeEach
    public void setUp() {
        web = web.mutate().responseTimeout(Duration.ofMillis(10000)).build();
    }

    @Test
    public void deve_dizer_ola_mundo() {

        web.get().uri("/api/ola").accept(MediaType.ALL).exchange().expectStatus().isOk().expectBody(String.class)
                .value(c -> assertEquals("Olá Mundo!", c));
    }


    @Test
    public void teste_inserindo_aluno() {

        Aluno alunoTeste = new Aluno();
        
        alunoTeste.setNome("Fulano Teste");
        alunoTeste.setEmail("emaildefunalo@fulnar.com");

        web.post().uri("/aluno").contentType(MediaType.APPLICATION_JSON).bodyValue(alunoTeste)
            .exchange().expectStatus().isCreated().expectBody(Aluno.class)
            .value(c -> assertEquals(alunoTeste.getNome(), c));
    }
    

}