package FuncPack;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Funcionarios{
	
	String PesquisarSalario(float salarioDado,JSONArray funcionarios) {
		String nomeCompleto = "";
		for(int i = 0; i < funcionarios.size(); i++) {
			
			String nome = ((JSONObject) funcionarios.get(i)).get("nome").toString();
			String sobrenome = ((JSONObject) funcionarios.get(i)).get("sobrenome").toString();
			
			String SalarioString = ((JSONObject) funcionarios.get(i)).get("salario").toString();
			float salario = Float.parseFloat(SalarioString);
			
			if(salario == salarioDado) {
				nomeCompleto = nome + " " + sobrenome;
			}
		}return nomeCompleto;
	}
	
	String PesquisarSalarioArea(float salarioDado,JSONArray funcionarios,String CodigoArea) {
		String nomeCompleto = "";
		for(int i = 0; i < funcionarios.size(); i++) {
			String CodigoAreaFuncionario = ((JSONObject) funcionarios.get(i)).get("area").toString();
			if(CodigoAreaFuncionario.equals(CodigoArea)) {
				
				String nome = ((JSONObject) funcionarios.get(i)).get("nome").toString();
				String sobrenome = ((JSONObject) funcionarios.get(i)).get("sobrenome").toString();
				
				String SalarioString = ((JSONObject) funcionarios.get(i)).get("salario").toString();
				float salario = Float.parseFloat(SalarioString);
				if(salario == salarioDado) {
					nomeCompleto = nome + " " + sobrenome;
				}
			}
		}return nomeCompleto;
	}
	
	void PesquisarMaiorArea(ArrayList<Area> ListaAreas) {
		int max = 0;
		for(Area a : ListaAreas) {
			if(a.getNumFuncionarios() > max) {
				max = a.getNumFuncionarios();
			}
		}
		for(Area a : ListaAreas) {
			if(a.getNumFuncionarios() == max) {
				System.out.printf("most_employees|%s|%d\n",a.getNome(),a.NumFuncionarios);
			}
		}
	}
	
	void PesquisarMenorArea(ArrayList<Area> ListaAreas) {
		int min = Integer.MAX_VALUE;
		for(Area a : ListaAreas) {
			if(a.getNumFuncionarios() < min && a.getNumFuncionarios() != 0) {
				min = a.getNumFuncionarios();
			}
		}
		for(Area a : ListaAreas) {
			if(a.getNumFuncionarios() == min) {
				System.out.printf("least_employees|%s|%d\n",a.getNome(),a.NumFuncionarios);
			}
		}
	}
	
	void PesquisarSobrenomeSalário(String sobrenomeInicial,JSONArray funcionarios) {
		float max = 0;
		for(int i = 0; i < funcionarios.size();i++) {
			
			String sobrenome = ((JSONObject) funcionarios.get(i)).get("sobrenome").toString();
			String SalarioString = ((JSONObject) funcionarios.get(i)).get("salario").toString();
			float salario = Float.parseFloat(SalarioString);
			
			if(sobrenome.equals(sobrenomeInicial) && salario > max) {
				max = salario;
			}
		}
		
		for(int i = 0; i < funcionarios.size();i++) {
			
			String nome = ((JSONObject) funcionarios.get(i)).get("nome").toString();
			String sobrenome = ((JSONObject) funcionarios.get(i)).get("sobrenome").toString();
			String SalarioString = ((JSONObject) funcionarios.get(i)).get("salario").toString();
			float salario = Float.parseFloat(SalarioString);
			
			if(sobrenome.equals(sobrenomeInicial) && salario == max) {
				System.out.printf("last_name_max|%s|%s %s|%.2f\n",sobrenome,nome,sobrenome,salario);
			}
		}
	}
}
