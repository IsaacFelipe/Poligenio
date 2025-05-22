package CodigoPoligenio;

//Classe Molde para outras classes do programa herdarem
public abstract class AbstractPessoa {
    //Set de variáveis
    protected String nome;
    protected String id;
    protected String email;
    protected String senha;

    //Criando construtor que será herdado
    public AbstractPessoa(String nome, String id, String email, String senha) {
        this.nome = nome;
        this.id = id;
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    //Criando método que será herdado
    public abstract void autenticarUsuario();

}