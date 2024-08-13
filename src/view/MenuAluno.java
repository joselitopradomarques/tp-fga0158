package view;

import javax.swing.JOptionPane;

import app.Aluno;
import cadastros.CadastroAluno;
import cadastros.CampoemBranco;

public class MenuAluno {

	public static Aluno dadosNovoAluno() {
		String nome = lerNome();
		String cpf = lerCPF();
		String email = lerEmail();
		String matricula = lerMatricula(); 
		String curso = lerCurso();
		return new Aluno(nome, cpf, email, matricula, curso);
	}

	private static String lerCurso() {
		String emailval = null;
		boolean formval = false;
		while(!formval) {
			try {
				emailval = JOptionPane.showInputDialog("Informe o curso do aluno: ");	
				if( emailval.trim().isEmpty()) {
					throw new CampoemBranco("Curso");
				}
				formval = true;
				
			}catch(CampoemBranco e) {
				 JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
			
					
		}
		return emailval;
	}

	private static String lerEmail() {
		String emailval = null;
		boolean formval = false;
		while(!formval) {
			try {
				emailval = JOptionPane.showInputDialog("Informe o email do aluno: ");	
				if( emailval.trim().isEmpty()) {
					throw new CampoemBranco("email");
				}
				formval = true;
				
			}catch(CampoemBranco e) {
				 JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
			
					
		}
		return emailval;
	}

	private static String lerCPF() {
		String emailval = null;
		boolean formval = false;
		while(!formval) {
			try {
				emailval = JOptionPane.showInputDialog("Informe o CPF do aluno: ");	
				if( emailval.trim().isEmpty()) {
					throw new CampoemBranco("CPF");
				}
				formval = true;
				
			}catch(CampoemBranco e) {
				 JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
			
					
		}
		return emailval;
	}

	private static String lerNome() {
		String emailval = null;
		boolean formval = false;
		while(!formval) {
			try {
				emailval = JOptionPane.showInputDialog("Informe o nome do aluno: ");	
				if( emailval.trim().isEmpty()) {
					throw new CampoemBranco("nome");
				}
				formval = true;
				
			}catch(CampoemBranco e) {
				 JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
			
					
		}
		return emailval;
	}

	private static String lerMatricula() {
		String emailval = null;
		boolean formval = false;
		while(!formval) {
			try {
				emailval = JOptionPane.showInputDialog("Informe a matricula do aluno: ");	
				if( emailval.trim().isEmpty()) {
					throw new CampoemBranco("matricula");
				}
				formval = true;
				
			}catch(CampoemBranco e) {
				 JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
			
					
		}
		return emailval;
	}

	public static void menuAluno(CadastroAluno cadAluno) {
		String txt = "Informe a opção desejada \n"
				+ "1 - Cadastrar aluno\n"
				+ "2 - Pesquisar aluno\n"
				+ "3 - Atualizar aluno\n"
				+ "4 - Remover aluno\n"
				+ "0 - Voltar para menu anterior";
		
		int opcao=-1;
		do {
			String strOpcao = JOptionPane.showInputDialog(txt);
			opcao = Integer.parseInt(strOpcao);

			switch (opcao) {
			case 1:
				Aluno novoAluno = dadosNovoAluno();
				cadAluno.cadastrarAluno(novoAluno);
				break;
				
			case 2: 
				String matricula = lerMatricula();
				Aluno a = cadAluno.pesquisarAluno(matricula);
				if (a != null)
					JOptionPane.showMessageDialog(null, a.toString());
				else {
					JOptionPane.showMessageDialog(null, "aluno nao encontrado");
				}
				break;
				
			case 3: 
				matricula = lerMatricula(); 
				Aluno novoCadastro = dadosNovoAluno();
				boolean atualizado = cadAluno.atualizarAluno(matricula, novoCadastro);
				if (atualizado) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
				}
				break;
				
			case 4: 
				matricula = lerMatricula();
				Aluno remover = cadAluno.pesquisarAluno(matricula);
				boolean removido = cadAluno.removerAluno(remover);
				if (removido) {
					JOptionPane.showMessageDialog(null, "Aluno removido do cadastro");
					System.gc();
				}

			default:
				break;
			}
		} while (opcao != 0);
		return;
	}


}
