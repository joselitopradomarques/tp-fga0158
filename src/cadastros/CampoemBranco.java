package cadastros;



public class CampoemBranco extends Exception{
	public CampoemBranco(String campo) {
        super("O campo '" + campo + "' não pode estar em branco.");
    }
		
}
