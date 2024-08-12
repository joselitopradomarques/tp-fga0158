package view;

import javax.swing.JOptionPane;


import app.Turma;
import app.Disciplina;
import app.Professor;
import cadastros.CadastroTurma;
import cadastros.CampoEmBrancoException;

public class MenuTurma {

    public static Turma dadosNovaTurma() {
        String codigo = lerCodigo();
        String nomeDisciplina = lerDescricao();
        String nomeProfessor = lerNomeProfessor();
        return new Turma(codigo, new Disciplina("DISC01", nomeDisciplina), new Professor(nomeProfessor));
    }

    private static String lerCodigo() {
        String codigoVal = null;
        boolean formval = false;
        while (!formval) {
            try {
                codigoVal = JOptionPane.showInputDialog("Informe o código da turma:");
                if (codigoVal.trim().isEmpty()) {
                    throw new CampoEmBrancoException("código");
                }
                formval = true;
            } catch (CampoEmBrancoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return codigoVal;
    }

    private static String lerDescricao() {
        String descricaoVal = null;
        boolean formval = false;
        while (!formval) {
            try {
                descricaoVal = JOptionPane.showInputDialog("Informe o nome da disciplina:");
                if (descricaoVal.trim().isEmpty()) {
                    throw new CampoEmBrancoException("descrição");
                }
                formval = true;
            } catch (CampoEmBrancoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return descricaoVal;
    }

    private static String lerNomeProfessor() {
        String nomeProfessorVal = null;
        boolean formval = false;
        while (!formval) {
            try {
                nomeProfessorVal = JOptionPane.showInputDialog("Informe o nome do professor:");
                if (nomeProfessorVal.trim().isEmpty()) {
                    throw new CampoEmBrancoException("nome do professor");
                }
                formval = true;
            } catch (CampoEmBrancoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return nomeProfessorVal;
    }

    public static void menuTurma(CadastroTurma cadTurma) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar turma\n"
                + "2 - Pesquisar turma\n"
                + "3 - Atualizar turma\n"
                + "4 - Remover turma\n"
                + "5 - Imprimir lista de presença\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Turma novaTurma = dadosNovaTurma();
                    boolean cadastrada = cadTurma.cadastrarTurma(novaTurma);
                    if (cadastrada) {
                        JOptionPane.showMessageDialog(null, "Turma cadastrada com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha ao cadastrar turma.");
                    }
                    break;

                case 2:
                    String codigo = lerCodigo();
                    Turma t = cadTurma.pesquisarTurma(codigo);
                    if (t != null) {
                        JOptionPane.showMessageDialog(null, "Turma encontrada: " + t.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                    }
                    break;

                case 3:
                    String codigoAtualizar = lerCodigo();
                    Turma novaTurmaAtualizada = dadosNovaTurma();
                    boolean atualizado = cadTurma.atualizarTurma(codigoAtualizar, novaTurmaAtualizada);
                    if (atualizado) {
                        JOptionPane.showMessageDialog(null, "Turma atualizada com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar turma.");
                    }
                    break;

                case 4:
                    String codigoRemover = lerCodigo();
                    Turma turmaRemover = cadTurma.pesquisarTurma(codigoRemover);
                    boolean removido = cadTurma.removerTurma(turmaRemover);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Turma removida com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha ao remover turma.");
                    }
                    break;

                case 5:
                    imprimirListaPresenca(cadTurma);
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
    }

    private static void imprimirListaPresenca(CadastroTurma cadTurma) {
        String codigoTurma = JOptionPane.showInputDialog("Informe o código da turma:");
        if (codigoTurma == null || codigoTurma.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Código da turma não pode ser vazio.");
            return;
        }

        Turma turma = cadTurma.pesquisarTurma(codigoTurma);
        if (turma != null) {
            String resultado = "Lista de Presença\n";
            resultado += "Disciplina: " + turma.getDisciplina().getNome() + "\n";
            resultado += "Professor: " + turma.getProfessor().getNome() + "\n";
            resultado += "Código da Turma: " + turma.getCodigoTurma() + "\n";
            resultado += "Alunos Matriculados:\n";

            JOptionPane.showMessageDialog(null, resultado);
        } else {
            JOptionPane.showMessageDialog(null, "Turma não encontrada.");
        }
    }
}
