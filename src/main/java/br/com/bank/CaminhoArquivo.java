package br.com.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CaminhoArquivo {


    private Path diretorio;

    private Path arquivo;

    private CaminhoArquivo(Path diretorio, Path arquivo) {
        super();
        this.diretorio = diretorio;
        this.arquivo = arquivo;
    }

    public Path getDiretorio() {
        return diretorio;
    }

    public Path getArquivo() {
        return arquivo;
    }

    public static CaminhoArquivo getInstance(Integer id) {     

        if(id == null){
            return null;

        }
        
        String caminho = "/tmp/";
        String arquivo = "";
        String diretorio = "";
        BigDecimal divisor = new BigDecimal(1000);
        BigDecimal  caminhoInterno = new BigDecimal(1);
        BigDecimal idArquivo = new BigDecimal(id);
       // BigDecimal divisor = new BigDecimal(1000);

        caminhoInterno = idArquivo.divide(divisor, 0, RoundingMode.UP);       
        diretorio =  caminho  + caminhoInterno.intValue();
      /*   if (idArquivo.compareTo(divisor)<0) {      
            //se for igual retorna 0
            //se o numero for menor que o comparado é negativo
            //se o numero for maior que o comparado é positivo      
           // diretorio = caminho + "1";
        } else {            
           
        }*/

        arquivo = diretorio + "/" + idArquivo.intValue();
        return new CaminhoArquivo(Paths.get(diretorio), Paths.get(arquivo));

    }

}
