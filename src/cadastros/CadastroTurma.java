package cadastros;

import java.util.ArrayList;
import java.util.List;

import app.Turma;

public class CadastroTurma {
    private List<Turma> turmas;

    public CadastroTurma() {
        turmas = new ArrayList<>();
    }

    public boolean cadastrarTurma(Turma turma) {
        return turmas.add(turma);
    }

    public Turma pesquisarTurma(String codigo) {
        for (Turma turma : turmas) {
            if (turma.getCodigoTurma().equalsIgnoreCase(codigo)) {
                return turma;
            }
        }
        return null;
    }

    public boolean atualizarTurma(String codigo, Turma novaTurma) {
        Turma turmaExistente = pesquisarTurma(codigo);
        if (turmaExistente != null) {
            turmas.remove(turmaExistente);
            turmas.add(novaTurma);
            return true;
        }
        return false;
    }

    public boolean removerTurma(Turma turma) {
        return turmas.remove(turma);
    }

    public List<Turma> getTurmas() {
        return turmas;
    }
}
