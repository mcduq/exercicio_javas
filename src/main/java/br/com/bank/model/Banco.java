package br.com.bank.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Banco {

    private String nome;

    public Banco(String nome) {
        this.nome = nome;
    }

    //private List<Conta> contas = new ArrayList<>();
    private HashMap<String, Conta> contas = new HashMap<>();

    public List<Conta> getContas() {
        return contas.values().stream().toList();
    }
    public void adicionarConta(Conta conta) {
        contas.put(conta.getCpf(),conta);
        
    }
    public Conta pesquisarContaDoCliente(String cpf) {
        Conta contaRetorno =  contas.get(cpf);
       
        return contaRetorno;
    }

    public List<Conta> listarContasAltaRenda() {

          List<Conta> contasAltaRenda =  filtrarContas(c -> c.getSaldo() >= 10000);

         int intt ;
       
        System.out.print("chegou no for");
       for(intt=0; intt<5; intt++)
      {
          
            System.out.println(contasAltaRenda.get(intt).getCpf() + " possui saldo:" + contasAltaRenda.get(intt).getSaldo());
             System.out.println(intt);
           
       }
       System.out.print("chegou no while");


        return contasAltaRenda;

       
    }

    private List<Conta> filtrarContas(Predicate<Conta> filtro) {
        return contas.values().stream().filter(filtro).collect(Collectors.toList());
        
    }

    public void ordenarContas(){

        System.out.println("teste");

        int[]  lista = {10,2,3,5,11,22,25,14};

        int n = lista.length;

        for(int i=0; i<n; i++){
            for(int j=1;i<n-i;j++){
                if(lista[j]>lista[j+1]){
                    int aux1 = lista[j];                    
                    lista[j]=lista[j+1];
                    lista[j+1]=aux1;
                    System.out.println("meio");
                }
            }
        }


        System.out.println(lista);


    }

    public void busca_binaria(){
        /*  List lista<Integer> = new ArrayList<>();
         
         (10,2,3,5,11,22,25,14);


         lista = lista.sort();
*/


    }

}

