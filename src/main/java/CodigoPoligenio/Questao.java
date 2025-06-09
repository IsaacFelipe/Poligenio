package CodigoPoligenio;

public class Questao {
    private int id;
    private String pergunta;
    private int serie;
    private int sala;
    private String materia;
    private String alternativaA;
    private String alternativaB;
    private String alternativaC;
    private String alternativaD;
    private int respostaCorreta;

    public Questao(int id, String pergunta, int serie, int sala, String materia,
                   String alternativaA, String alternativaB, String alternativaC, String alternativaD, int respostaCorreta) {
        this.id = id;
        this.pergunta = pergunta;
        this.serie = serie;
        this.sala = sala;
        this.materia = materia;
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        this.alternativaD = alternativaD;
        this.respostaCorreta = respostaCorreta;
    }

    public int getId() { 
        return id; 
    }
    
    public String getPergunta() { 
        return pergunta; 
    }
    
    public int getSerie() { 
        return serie; 
    }
    
    public int getSala() { 
        return sala; 
    }
    
    public String getMateria() { 
        return materia; 
    }
    
    public String getAlternativaA() { 
        return alternativaA; 
    }
    
    public String getAlternativaB() { 
        return alternativaB; 
    }
    
    public String getAlternativaC() { 
        return alternativaC; 
    }
    
    public String getAlternativaD() { 
        return alternativaD; 
    }
    
    public int getRespostaCorreta() { 
        return respostaCorreta; 
    }
}
