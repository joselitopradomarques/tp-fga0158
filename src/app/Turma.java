package app;

public class Turma {
    private String codigoTurma;
    private Disciplina disciplina;
    private Professor professor;

    // Método Construtor
    public Turma(String codigoTurma, Disciplina disciplina, Professor professor) {
        this.codigoTurma = codigoTurma;
        this.disciplina = disciplina;
        this.professor = professor;
    }

    // Getters e Setters
    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String toString() {
        return codigoTurma + " - " + disciplina.getNome() + " - " + professor.getNome();
    }
}
