package cadastros;
import java.util.ArrayList;
import java.util.List;

import app.Disciplina;

public class CadastroDisciplina {
    private List<Disciplina> disciplinas;

    // Construtor
    public CadastroDisciplina() {
        this.disciplinas = new ArrayList<>();
    }

    // Método para adicionar disciplina
    public void adicionarDisciplina(Disciplina disciplina) throws CampoEmBrancoException {
        validarDisciplina(disciplina);
        // Verifica se já existe uma disciplina com o mesmo ID
        for (Disciplina d : disciplinas) {
            if (d.getId() == disciplina.getId()) {
                throw new RuntimeException("Disciplina com o mesmo ID já existe.");
            }
        }
        disciplinas.add(disciplina);
    }

    // Método para pesquisar disciplina por ID
    public Disciplina pesquisarDisciplina(int id) {
        for (Disciplina d : disciplinas) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null; // Retorna null se a disciplina não for encontrada
    }

    // Método para atualizar disciplina
    public void atualizarDisciplina(Disciplina disciplina) throws CampoEmBrancoException {
        validarDisciplina(disciplina);
        for (int i = 0; i < disciplinas.size(); i++) {
            if (disciplinas.get(i).getId() == disciplina.getId()) {
                disciplinas.set(i, disciplina);
                return;
            }
        }
        throw new RuntimeException("Disciplina não encontrada para atualização.");
    }

    // Método para remover disciplina
    public void removerDisciplina(int id) {
        disciplinas.removeIf(d -> d.getId() == id);
    }

    // Validação de disciplina
    private void validarDisciplina(Disciplina disciplina) throws CampoEmBrancoException {
        if (disciplina.getNome() == null || disciplina.getNome().trim().isEmpty()) {
            throw new CampoEmBrancoException("Nome");
        }
    }
}
