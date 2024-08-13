package view;

import javax.swing.JOptionPane;


import app.Professor;
import cadastros.CadastroProfessor;
import cadastros.CampoemBranco;

public class MenuProfessor {

	
	public static Professor dadosNovoProfessor() {
		String nome = lerNome();
		String cpf = lerCPF();
		String email = lerEmail();
		String matriculaFUB = lerMatriculaFUB(); 
		String areadeform = lerAreaform();
		return new Professor(nome, cpf, email, matriculaFUB, areadeform);
		
	}
	
	private static String lerAreaform() {
		Boolean formval = false;
		String learea = null;
		while(!formval) {
			try {
				learea = JOptionPane.showInputDialog("Informe a area de formação do professor: ");	
				if( learea.trim().isEmpty() ) {
					throw new CampoemBranco("area de formação");
				}
				formval = true;
				
			}catch(CampoemBranco e) {
				 JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
			
					
		}
		return learea;
	}
	
	private static String lerEmail() {
		String emailval = null;
		boolean formval = false;
		while(!formval) {
			try {
				emailval = JOptionPane.showInputDialog("Informe o email do professor: ");	
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
		String cpfval = null;
		boolean formval = false;
		while(!formval) {
			try {
				cpfval = JOptionPane.showInputDialog("Informe o cpf do professor: ");	
				if( cpfval.trim().isEmpty()) {
					throw new CampoemBranco("cpf");
				}
				formval = true;
			}catch(CampoemBranco e) {
				 JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
	     }
		return cpfval;
	}
	
	private static String lerNome() {
		String nomeval = null;
		boolean formval = false;
		while(!formval) {
			try {
				nomeval = JOptionPane.showInputDialog("Informe o nome do professor: ");	
				if( nomeval.trim().isEmpty()) {
					throw new CampoemBranco("nome");
				}
				formval = true;
			}catch(CampoemBranco e) {
				 JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
	     }
		return nomeval;

	}

	private static String lerMatriculaFUB() {
		String matrival = null;
		boolean formval = false;
		while(!formval) {
			try {
				matrival = JOptionPane.showInputDialog("Informe a matriculaFUB do professor: ");	
				if( matrival.trim().isEmpty()) {
					throw new CampoemBranco("matricula");
				}
				formval = true;
			}catch(CampoemBranco e) {
				 JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
	     }
		return matrival;
	}


	public static void menuProfessores(CadastroProfessor cadProf) {
		String txt = "Informe a opção desejada \n"
				+ "1 - Cadastrar professor\n"
				+ "2 - Pesquisar professor\n"
				+ "3 - Atualizar professor\n"
				+ "4 - Remover professor\n"
				+ "0 - Voltar para menu anterior";
		
		
		int opcao=-1;
		do {
			String strOpcao = JOptionPane.showInputDialog(txt);
			opcao = Integer.parseInt(strOpcao);

			switch (opcao) {
			case 1:
				Professor novoProf = dadosNovoProfessor();
				cadProf.cadastrarProf(novoProf);
				break;
				
			case 2: 
				String matriculaFUB = lerMatriculaFUB();
				Professor a = cadProf.pesquisarProf(matriculaFUB);
				if (a != null)
					JOptionPane.showMessageDialog(null, a.toString());
				else {
					JOptionPane.showMessageDialog(null,"professor não encontrado");
				}
				break;
				
			case 3: 
				matriculaFUB = lerMatriculaFUB(); 
				Professor novoCadastro = dadosNovoProfessor();
				boolean atualizado = cadProf.atualizarProf(matriculaFUB, novoCadastro);
				if (atualizado) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
				}
				break;
				
			case 4: 
				matriculaFUB = lerMatriculaFUB();
				Professor remover = cadProf.pesquisarProf(matriculaFUB);
				boolean removido = cadProf.removerProf(remover);
				if (removido) {
					JOptionPane.showMessageDialog(null, "Professor removido do cadastro");
					System.gc();
				}

			default:
				break;
			}
		} while (opcao != 0);
		return;
}
	
	
	
	
}

