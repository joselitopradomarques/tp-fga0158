package cadastros;

import java.util.ArrayList;
import java.util.List;
import app.Professor;

public class CadastroProfessor {
	private int numProfessores;
	private List<Professor> professores;
	
	public CadastroProfessor() {
		numProfessores = 0;
		professores = new ArrayList<Professor>();
	}
	
	public int cadastrarProf(Professor a) {
		boolean cadastrou = professores.add(a);
		if (cadastrou) {
			numProfessores = professores.size();
		}
		return  numProfessores;
	}
	public Professor pesquisarProf (String matriculaFUB) {
		for(Professor a: professores) {
			if (a.getMatriculaFUB().equalsIgnoreCase(matriculaFUB)) {
				return a;
			}
		}
		return null;
}
	
	public boolean removerProf(Professor a) {
		boolean removeu = false;
		if (professores.contains(a)) {
			removeu = professores.remove(a);
		}
		return removeu;
	}
	public boolean atualizarProf(String matriculaFUB, Professor a ) {
		boolean resposta = false;
		Professor remover = pesquisarProf(matriculaFUB);
		if (remover != null) {
			professores.remove(remover);
			resposta = professores.add(a);
		}
		return resposta;
	}
}