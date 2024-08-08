import javax.swing.JOptionPane;
import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import view.MenuAluno;
import view.MenuDisciplina;
import view.MenuPrincipal;

public class Principal {

    static CadastroAluno cadAluno;
    static CadastroDisciplina cadDisciplina;

    public static void main(String[] args) {
        cadAluno = new CadastroAluno();
        cadDisciplina = new CadastroDisciplina(); // Inicializa o cadastro de disciplinas
        
        int opcao = 0; 
        
        do {
            opcao = MenuPrincipal.menuOpcoes(); 
            switch (opcao) {
                case 1: 
                    MenuAluno.menuAluno(cadAluno); 
                    break;
                case 2: 
                    JOptionPane.showMessageDialog(null, "Cadastro de professores a ser implementado");
                    break;
                case 3: 
                    MenuDisciplina menuDisciplina = new MenuDisciplina(cadDisciplina); // Cria o menu de disciplinas
                    menuDisciplina.menuDisciplina(); // Abre o menu principal de disciplinas
                    break;
                case 4: 
                    JOptionPane.showMessageDialog(null, "Cadastro de turmas a ser implementado");
                    break;
                case 0: 
                    JOptionPane.showMessageDialog(null, "Saindo do sistema.");
                    break;
                default: 
                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 0);
    }
}
