package br.com.coruja.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.coruja.domain.model.Aluno;
import br.com.coruja.domain.service.AlunoService;


@RestController
@RequestMapping("/aluno")
public class AlunoController {
    
    @Autowired 
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> save (@RequestBody Aluno alunoNovo){
        Aluno alunoSalvo = alunoService.salvarAluno(alunoNovo);

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);        
    }

    @GetMapping("/id")
    public ResponseEntity<Aluno> buscarAluno (@PathVariable Long id){
        Aluno alunoResultado = new Aluno();
            if(id != null){
                alunoResultado = alunoService.buscarAluno(id);                
            }

            return ResponseEntity.status(HttpStatus.FOUND).body(alunoResultado);

    } 



    


}
