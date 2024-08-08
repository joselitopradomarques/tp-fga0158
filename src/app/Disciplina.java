package app;
public class Disciplina {
    private int id;
    private String nome;

    // Construtor
    public Disciplina(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método toString para exibir as informações da disciplina
    @Override
    public String toString() {
        return "Disciplina [ID=" + id + ", Nome=" + nome + "]";
    }
}
