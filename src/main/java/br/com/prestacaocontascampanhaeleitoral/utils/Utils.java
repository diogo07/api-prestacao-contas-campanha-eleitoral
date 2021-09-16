package br.com.prestacaocontascampanhaeleitoral.utils;

public class Utils {
	
	
	
	
	public static String cpfWithMask(String cpf) {
		
		String mask = "";
		
		if(cpf.length() == 11) {
			mask = cpf.substring(0, 3) + "."
					+ cpf.substring(3, 5) + "..." 
					+ cpf.substring(8, 9) 
					+ "-" + cpf.substring(9, 11);
		} else if(cpf.length() >= 8){
			mask = cpf.substring(0, 3) + "."
					+ cpf.substring(3, 5) + "..." 
					+ "-" + cpf.substring(cpf.length()-2, cpf.length());
		} else {
			mask = "Não informado";
		}	
		
		return mask;
	}
	
	
public static String cpfOrCnpjWithMask(String cpfOrCnpj) {
		String mask = "";
		
		if(cpfOrCnpj.length() == 14) {
			mask = cpfOrCnpj.substring(0, 2) + "."
					+ cpfOrCnpj.substring(2, 5) + "." 
					+ cpfOrCnpj.substring(5, 8) + "/" 
					+ cpfOrCnpj.substring(8, 12) + "-"
					+ cpfOrCnpj.substring(12, 14);
		} else if(cpfOrCnpj.length() == 11) {
			mask = cpfOrCnpj.substring(0, 3) + "."
					+ cpfOrCnpj.substring(3, 5) + "..." 
					+ cpfOrCnpj.substring(8, 9) 
					+ "-" + cpfOrCnpj.substring(9, 11);
		} else if(cpfOrCnpj.length() >= 8){
			mask = cpfOrCnpj.substring(0, 3) + "."
					+ cpfOrCnpj.substring(3, 5) + "..." 
					+ "-" + cpfOrCnpj.substring(cpfOrCnpj.length()-2, cpfOrCnpj.length());
		} else {
			mask = "Não informado";
		}	
		
		return mask;
	}

}
