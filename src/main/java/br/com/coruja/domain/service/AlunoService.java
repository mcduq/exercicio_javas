package br.com.coruja.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.coruja.domain.model.Aluno;
import br.com.coruja.domain.repository.AlunoRepository;


@Service
public class AlunoService {

    @Autowired 
    private AlunoRepository alunoRepository;

    public Aluno buscarAluno(Long id){
        /*
         *  find deve buscar por um aluno específico recebendo o ID no path param - GET
            retornar 200 como status code
         */
        return alunoRepository.findById(id).orElse(null);
    }

    public List<Aluno> listarAlunos(){
        /*
         *  list deve listar todos os alunos - GET
             retornar 200 como status code
         */
        return alunoRepository.findAll();
    }

    public Aluno salvarAluno(Aluno aluno){
        /*
        save deve salvar um novo aluno - POST
        retornar 201 como status code
         */
        return alunoRepository.save(aluno);
    }

    public void atualizarAluno(Aluno aluno, Long id){

       /*  Optional<Aluno> alunoAtualizado = alunoRepository.findById(id);        

        alunoAtualizado.stream().values.setNome(aluno.getNome());*/

        /*
         * put deve atualizar todos os atributos de um aluno recebendo o ID no path param - PUT
           retornar 200 como status code
         */

        Aluno alunoAtt = alunoRepository.getById(id);

        if(aluno.getNome() != null && !aluno.equals("")){
            alunoAtt.setNome(aluno.getNome());
        }
        if(aluno.getEmail() != null && !aluno.equals("")){
            alunoAtt.setEmail(aluno.getEmail());
        }
            alunoRepository.saveAndFlush(alunoAtt);

    }
        
  


    public void remover(Aluno aluno){
        /*
         * 
    delete deve remover um aluno - DELETE
        retornar 200 como status code
         */

        
        if(aluno.getId() != null){
            alunoRepository.deleteById(aluno.getId());
        }
       
    }

    

}


/**
 * A sua classe de controller AlunoController deve ser:

    Ter o método find, list, save, update e delete.
   
   
    
    

    Atenção no método FIND, caso não exista um aluno o valor retornado deve ser 404. Já no mesmo LIST, deve retornar uma colleção vazia com o status code 200.

 */
