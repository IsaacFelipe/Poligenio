/*----------------------PACOTE QUE PERTENCE A CLASSE--------------------------*/
package CodigoPoligenio;

/*----------------------CLASSE ABSTRATA BASE PARA PESSOA---------------------*/
public abstract class AbstractPessoa {
    
    /*----------------------DECLARAÇÃO DE VARIÁVEIS----------------------*/
    protected String nome;
    protected String id;
    protected String email;
    protected String senha;

    /*----------------------CONSTRUTOR DA CLASSE ABSTRATA-----------------*/
    public AbstractPessoa(String nome, String id, String email, String senha) {
        this.nome = nome;
        this.id = id;
        this.email = email;
    }

    /*----------------------MÉTODO PARA OBTER A SENHA--------------------*/
    public String getSenha() {
        return senha;
    }

    /*----------------------MÉTODO PARA DEFINIR A SENHA------------------*/
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    /*----------------------MÉTODO PARA OBTER O NOME---------------------*/
    public String getNome() {
        return nome;
    }

    /*----------------------MÉTODO PARA OBTER O ID-----------------------*/
    public String getId() {
        return id;
    }

    /*----------------------MÉTODO PARA OBTER O EMAIL--------------------*/
    public String getEmail() {
        return email;
    }

    /*----------------------MÉTODO PARA DEFINIR O NOME-------------------*/
    public void setNome(String nome) {
        this.nome = nome;
    }

    /*----------------------MÉTODO PARA DEFINIR O ID---------------------*/
    public void setId(String id) {
        this.id = id;
    }

    /*----------------------MÉTODO PARA DEFINIR O EMAIL------------------*/
    public void setEmail(String email) {
        this.email = email;
    }
    
    /*----------------------MÉTODO ABSTRATO PARA AUTENTICAÇÃO------------*/
    public abstract void autenticarUsuario();
}