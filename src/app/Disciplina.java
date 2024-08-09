package app;

public class Disciplina {
    private String codigoDisciplina;
    private String nome;

    // Método Construtor
    public Disciplina(String codigoDisciplina, String nome) {
        this.codigoDisciplina = codigoDisciplina;
        this.nome = nome;
    }

    // Getters e Setters
    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return "Disciplina [Código=" + codigoDisciplina + ", Nome=" + nome + "]";
    }
}
