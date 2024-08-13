package view;

import javax.swing.JOptionPane;
import app.Disciplina;
import cadastros.CadastroDisciplina;
import cadastros.CampoEmBrancoException;

public class MenuDisciplina {

    private CadastroDisciplina cadastroDisciplina;

    // Construtor
    public MenuDisciplina(CadastroDisciplina cadastroDisciplina) {
        this.cadastroDisciplina = cadastroDisciplina;
    }

    // Método principal do menu
    public void menuDisciplina() {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar disciplina\n"
                + "2 - Pesquisar disciplina\n"
                + "3 - Atualizar disciplina\n"
                + "4 - Remover disciplina\n"
                + "0 - Voltar para menu anterior";
        
        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            if (strOpcao == null) return; // Cancelar o diálogo
            try {
                opcao = Integer.parseInt(strOpcao);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, insira um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    mostrarMenuCadastro();
                    break;
                    
                case 2:
                    mostrarMenuPesquisa();
                    break;
                    
                case 3:
                    mostrarMenuAtualizacao();
                    break;
                    
                case 4:
                    mostrarMenuRemocao();
                    break;
                    
                case 0:
                    JOptionPane.showMessageDialog(null, "Voltando para o menu anterior.");
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, escolha uma opção entre 0 e 4.");
                    break;
            }
        } while (opcao != 0);
    }

    // Método para exibir o menu de cadastro
    private void mostrarMenuCadastro() {
        try {
            String codigoInput = JOptionPane.showInputDialog("Menu de Cadastro de Disciplinas:\nCódigo da Disciplina:");
            if (codigoInput == null || codigoInput.trim().isEmpty()) {
                throw new CampoEmBrancoException("Código");
            }

            String nome = JOptionPane.showInputDialog("Nome:");
            if (nome == null || nome.trim().isEmpty()) {
                throw new CampoEmBrancoException("Nome");
            }
            
            Disciplina disciplina = new Disciplina(codigoInput, nome);
            cadastroDisciplina.adicionarDisciplina(disciplina);
            JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso.");
        } catch (CampoEmBrancoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Método para exibir o menu de pesquisa
    private void mostrarMenuPesquisa() {
        try {
            String codigoInput = JOptionPane.showInputDialog("Menu de Pesquisa de Disciplinas:\nCódigo da Disciplina:");
            if (codigoInput == null) return; // Cancelar o diálogo
            
            Disciplina disciplina = cadastroDisciplina.pesquisarDisciplina(codigoInput);
            if (disciplina != null) {
                JOptionPane.showMessageDialog(null, disciplina.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Disciplina não encontrada.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código deve ser um texto válido.");
        }
    }

    // Método para exibir o menu de atualização
    private void mostrarMenuAtualizacao() {
        try {
            String codigoInput = JOptionPane.showInputDialog("Menu de Atualização de Disciplinas:\nCódigo da Disciplina:");
            if (codigoInput == null) return; // Cancelar o diálogo

            String nome = JOptionPane.showInputDialog("Novo Nome:");
            if (nome == null || nome.trim().isEmpty()) {
                throw new CampoEmBrancoException("Nome");
            }
            
            Disciplina disciplina = new Disciplina(codigoInput, nome);
            cadastroDisciplina.atualizarDisciplina(disciplina);
            JOptionPane.showMessageDialog(null, "Disciplina atualizada com sucesso.");
        } catch (CampoEmBrancoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Método para exibir o menu de remoção
    private void mostrarMenuRemocao() {
        try {
            String codigoInput = JOptionPane.showInputDialog("Menu de Remoção de Disciplinas:\nCódigo da Disciplina:");
            if (codigoInput == null) return; // Cancelar o diálogo
            
            cadastroDisciplina.removerDisciplina(codigoInput);
            JOptionPane.showMessageDialog(null, "Disciplina removida com sucesso.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover disciplina: " + e.getMessage());
        }
    }
}
