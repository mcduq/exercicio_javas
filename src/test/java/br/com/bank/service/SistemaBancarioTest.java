package br.com.bank.service;

import br.com.bank.gateway.Bacen;
import br.com.bank.model.Conta;
import javassist.bytecode.Descriptor.Iterator;
import br.com.bank.model.Banco;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.quality.Strictness;
import org.springframework.test.context.TestExecutionListeners;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@TestInstance(Lifecycle.PER_CLASS)
class SistemaBancarioTest {

//    @InjectMocks
//    private SistemaBancario sistemaBancario;
//    @Mock
//    private Bacen bacen;

/*
 * * Fazer os testes de unidade da classe banco para os métodos
  - adicionarConta
  - pesquisarContaDoCliente
  - listarContasAltaRenda
* Refatorar o método pesquisarContaDoCliente para resolver os problemas de lentidão
 */
    
   private final Banco banco = new Banco("nome");
   
  
    @Test
    public void metodo_ordenacao_bolha(){
        banco.ordenarContas();
    }


   @BeforeAll
    public void deve_verificar_adicionar_contas(){        
        
        
        banco.adicionarConta(new Conta("22222222222",10000));
        banco.adicionarConta(new Conta("33333333333",20000));
        banco.adicionarConta(new Conta("12345678911",203));
        banco.adicionarConta(new Conta("55555555555",203));
        banco.adicionarConta(new Conta("66666666666",203));
      

      
    }

    @Test
    public void deve_verificar_pesquisa_conta_do_cliente(){
        banco.adicionarConta(new Conta("12345678911",203));
        banco.adicionarConta(new Conta("55555555555",203));
       Conta retorno =  banco.pesquisarContaDoCliente("55555555555");
        System.out.println(retorno);

    }

    @Test
    public void deve_verificar_listar_contas_altaRenda(){

        banco.adicionarConta(new Conta("22222222222",10000));
        banco.adicionarConta(new Conta("33333333333",20000));
        banco.adicionarConta(new Conta("12345678911",203));
        banco.adicionarConta(new Conta("55555555555",203));
        banco.adicionarConta(new Conta("66666666666",203));
        List<Conta> contasAltaRenda =  banco.listarContasAltaRenda();

       
        

    }


}