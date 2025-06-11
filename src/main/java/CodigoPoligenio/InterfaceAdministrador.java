/*-------------------PACOTE QUE PERTENCE A INTERFACE--------------------------*/
package CodigoPoligenio;

/*-----------INTERFACE PARA DEFINIÇÃO DE MÉTODOS DO ADMINISTRADOR-------------*/
public interface InterfaceAdministrador {
    
/*----------------------MÉTODO PARA REALIZAR LOGIN----------------------------*/
    boolean fazerLogin(String RA, String Senha);
    
/*----------------------MÉTODO PARA CADASTRAR JOGADOR-------------------------*/
    boolean cadastrarJogador(String nome,
            String raAluno,
            String email,
            String senha,
            String serieAluno,
            String turmaAluno);
    
/*----------------------MÉTODO PARA CRIAR SALA--------------------------------*/
    void criarSala(String idProfessor, String codigoSala);
}