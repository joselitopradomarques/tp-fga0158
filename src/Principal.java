import javax.swing.JOptionPane;
import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import cadastros.CadastroProfessor;
import cadastros.CadastroTurma;
import view.MenuAluno;
import view.MenuDisciplina;
import view.MenuPrincipal;
import view.MenuProfessor;
import view.MenuTurma;


public class Principal {

    static CadastroAluno cadAluno;
    static CadastroDisciplina cadDisciplina;
    static CadastroProfessor cadProf;
    static CadastroTurma cadTurma;

    public static void main(String[] args) {
        cadAluno = new CadastroAluno();
        cadDisciplina = new CadastroDisciplina(); // Inicializa o cadastro de disciplinas
        cadProf = new CadastroProfessor();
        cadTurma = new CadastroTurma();
        
        
        int opcao = 0; 
        
        do {
            opcao = MenuPrincipal.menuOpcoes(); 
            switch (opcao) {
                case 1: 
                    MenuAluno.menuAluno(cadAluno); 
                    break;
                case 2: 
                    MenuProfessor.menuProfessores(cadProf);
                    break;
                case 3: 
                    MenuDisciplina menuDisciplina = new MenuDisciplina(cadDisciplina); // Cria o menu de disciplinas
                    menuDisciplina.menuDisciplina(); // Abre o menu principal de disciplinas
                    break;
                case 4: 
                    MenuTurma menuTurma = new MenuTurma(cadTurma, cadDisciplina, cadProf); //Cria o menu de Turmas
                    menuTurma.menuTurma(); // Abre o menu principal de turmas
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
