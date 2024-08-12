package view;

import javax.swing.JOptionPane;


import app.Turma;
import app.Disciplina;
import app.Professor;
import cadastros.CadastroDisciplina;
import cadastros.CadastroProfessor;
import cadastros.CadastroTurma;
import cadastros.CampoEmBrancoException;

public class MenuTurma {
    private CadastroTurma cadastroTurma;
    private CadastroDisciplina cadastroDisciplina;
    private CadastroProfessor cadastroProfessor;

    // Construtor que recebe o CadastroTurma, CadastroDisciplina e CadastroProfessor
    public MenuTurma(CadastroTurma cadastroTurma, CadastroDisciplina cadastroDisciplina, CadastroProfessor cadastroProfessor) {
        this.cadastroTurma = cadastroTurma;
        this.cadastroDisciplina = cadastroDisciplina;
        this.cadastroProfessor = cadastroProfessor;

    }

    public Turma dadosNovaTurma() {
        String codigo = lerCodigo();

        String codigoDisciplina = lerCodigoDisciplina();
        Disciplina disciplina = cadastroDisciplina.pesquisarDisciplina(codigoDisciplina);
        if (disciplina == null) {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada. Certifique-se de que a disciplina foi cadastrada.");
            return null;
        }

        String codigoProfessor = lerCodigoProfessor();
        Professor professor = cadastroProfessor.pesquisarProf(codigoProfessor);
        if (professor == null) {
            JOptionPane.showMessageDialog(null, "Professor não encontrado. Certifique-se de que o professor foi cadastrado.");
            return null;
        }

        return new Turma(codigo, disciplina, professor);
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

    private static String lerCodigoDisciplina() {
        String codigoDisciplina = null;
        boolean formval = false;
        while (!formval) {
            try {
                codigoDisciplina = JOptionPane.showInputDialog("Informe o código da disciplina:");
                if (codigoDisciplina.trim().isEmpty()) {
                    throw new CampoEmBrancoException("código da disciplina");
                }
                formval = true;
            } catch (CampoEmBrancoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return codigoDisciplina;
    }

    private static String lerCodigoProfessor() {
        String codigoProfessor = null;
        boolean formval = false;
        while (!formval) {
            try {
                codigoProfessor = JOptionPane.showInputDialog("Informe o código do professor:");
                if (codigoProfessor.trim().isEmpty()) {
                    throw new CampoEmBrancoException("código do professor");
                }
                formval = true;
            } catch (CampoEmBrancoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return codigoProfessor;
    }

    public void menuTurma() {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar turma\n"
                + "2 - Pesquisar turma\n"
                + "3 - Atualizar turma\n"
                + "4 - Remover turma\n"
                + "5 - Imprimir lista de presença\n"
                + "0 - Voltar para menu anterior";

        int opcao;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Turma novaTurma = dadosNovaTurma();
                    if (novaTurma != null) {
                        boolean cadastrada = cadastroTurma.cadastrarTurma(novaTurma);
                        if (cadastrada) {
                            JOptionPane.showMessageDialog(null, "Turma cadastrada com sucesso.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Falha ao cadastrar turma.");
                        }
                    }
                    break;

                case 2:
                    String codigo = lerCodigo();
                    Turma t = cadastroTurma.pesquisarTurma(codigo);
                    if (t != null) {
                        JOptionPane.showMessageDialog(null, "Turma encontrada: " + t.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                    }
                    break;

                case 3:
                    String codigoAtualizar = lerCodigo();
                    Turma novaTurmaAtualizada = dadosNovaTurma();
                    if (novaTurmaAtualizada != null) {
                        boolean atualizado = cadastroTurma.atualizarTurma(codigoAtualizar, novaTurmaAtualizada);
                        if (atualizado) {
                            JOptionPane.showMessageDialog(null, "Turma atualizada com sucesso.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar turma.");
                        }
                    }
                    break;

                case 4:
                    String codigoRemover = lerCodigo();
                    Turma turmaRemover = cadastroTurma.pesquisarTurma(codigoRemover);
                    if (turmaRemover != null) {
                        boolean removido = cadastroTurma.removerTurma(turmaRemover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Turma removida com sucesso.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Falha ao remover turma.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                    }
                    break;
                case 5:
                    imprimirListaPresenca();
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
    }

    private void imprimirListaPresenca() {
        String codigoTurma = JOptionPane.showInputDialog("Informe o código da turma:");
        if (codigoTurma == null || codigoTurma.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Código da turma não pode ser vazio.");
            return;
        }

        Turma turma = cadastroTurma.pesquisarTurma(codigoTurma);
        if (turma != null) {
            String resultado = "Lista de Presença\n";
            resultado += "Disciplina: " + turma.getDisciplina().getNome() + "\n";
            resultado += "Professor: " + turma.getProfessor().getNome() + "\n";
            resultado += "Código da Turma: " + turma.getCodigoTurma() + "\n";

            JOptionPane.showMessageDialog(null, resultado);
        } else {
            JOptionPane.showMessageDialog(null, "Turma não encontrada.");
        }
    }
}
