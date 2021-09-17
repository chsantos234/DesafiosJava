package FuncPack;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main{
	public static void main(String[] args) {
		ArrayList<Area> listaAreas = new ArrayList<Area>();
		JSONParser Parser = new JSONParser();
		Funcionarios object = new Funcionarios();
		
		try {
			JSONObject jsonObject = (JSONObject) Parser.parse(new FileReader("C:\\Users\\camiq\\eclipse-workspace\\Java Desafios\\src\\Funcionarios-10K.json"));
			JSONArray funcionarios = (JSONArray)jsonObject.get("funcionarios");
			JSONArray areas = (JSONArray)jsonObject.get("areas");
			
			// retirando os valores do maio e menor salário mais a média
			int numSalarios = 0;
			float avgSalario = 0;
			float minSalario = Float.MAX_VALUE;
			float maxSalario = 0;
			for(int i = 0; i < funcionarios.size(); i++) {
				
				String SalarioString = ((JSONObject) funcionarios.get(i)).get("salario").toString();
				float salario = Float.parseFloat(SalarioString);
				
				if(salario > maxSalario) {
					maxSalario = salario;
				}
				else if(salario < minSalario) {
					minSalario = salario;
				}
				avgSalario += salario;
				numSalarios++;
			}
			avgSalario = avgSalario/numSalarios;
			
			// retornando o nome dos funcionários com estes salários mais a média geral
			String maxNomeCompleto = object.PesquisarSalario(maxSalario, funcionarios);
			String minNomeCompleto = object.PesquisarSalario(minSalario, funcionarios);
			System.out.printf("global_max|%s|%.2f%n",maxNomeCompleto, maxSalario);
			System.out.printf("global_min|%s|%.2f%n",minNomeCompleto, minSalario);
			System.out.printf("global_avg|%.2f%n",avgSalario);
			
			
			for(int a = 0; a < areas.size();a++) {
				numSalarios = 0;
				avgSalario = 0;
				minSalario = Float.MAX_VALUE;
				maxSalario = 0;
				
				String CodigoArea = ((JSONObject) areas.get(a)).get("codigo").toString();
				String NomeArea = ((JSONObject) areas.get(a)).get("nome").toString();
				
				Area area = new Area(CodigoArea,NomeArea); // criando um objeto area para iterações na próxima questão
				listaAreas.add(area);
				for(int f = 0; f < funcionarios.size(); f++) {
					
					String CodigoAreaFuncionario = ((JSONObject) funcionarios.get(f)).get("area").toString();
					
					if(CodigoAreaFuncionario.equals(CodigoArea)) {
						
						String SalarioString = ((JSONObject) funcionarios.get(f)).get("salario").toString();
						float salario = Float.parseFloat(SalarioString);
		
						if(salario > maxSalario) {
							maxSalario = salario;
						}
						else if(salario < minSalario) {
							minSalario = salario;
						}
						avgSalario += salario;
						numSalarios++;
					}
				}
				avgSalario = avgSalario/numSalarios;
				
				String AreaMaxNomeCompleto = object.PesquisarSalarioArea(maxSalario, funcionarios, CodigoArea);
				String AreaMinNomeCompleto = object.PesquisarSalarioArea(minSalario, funcionarios, CodigoArea);
				if(AreaMaxNomeCompleto.equals("")) {
					continue;
				}else {
					System.out.printf("area_max|%s|%s|%.2f%n",NomeArea,AreaMaxNomeCompleto, maxSalario);
					System.out.printf("area_min|%s|%s|%.2f%n",NomeArea,AreaMinNomeCompleto, minSalario);
					System.out.printf("area_avg|%s|%.2f%n",NomeArea,avgSalario);
				}
			}
			
			for(Area a : listaAreas) {
				for(int f = 0; f < funcionarios.size();f++) {
					String CodigoAreaFuncionario = ((JSONObject) funcionarios.get(f)).get("area").toString();
					String AreaCodigo = a.getCodigo();
					if(CodigoAreaFuncionario.equals(AreaCodigo)) {
						a.AdicionarFuncionario();
					}
				}
			}
			
			object.PesquisarMaiorArea(listaAreas);
			object.PesquisarMenorArea(listaAreas);
			
			ArrayList<String> ignoreSobrenome = new ArrayList<String>();
			
			for(int i = 0; i < funcionarios.size(); i++) {
				
				String sobrenomeInicial = ((JSONObject) funcionarios.get(i)).get("sobrenome").toString();
				String nomeInicial = ((JSONObject) funcionarios.get(i)).get("nome").toString();
				
				for(int f = 0; f < funcionarios.size(); f++) {
					
					String sobrenome = ((JSONObject) funcionarios.get(f)).get("sobrenome").toString();
					String nome = ((JSONObject) funcionarios.get(f)).get("nome").toString();
					
					if(sobrenomeInicial.equals(sobrenome) && nomeInicial.equals(nome) == false) {
						boolean teste = ignoreSobrenome.contains(sobrenome);
						if(teste == true) {
							continue;
						}else {
							ignoreSobrenome.add(sobrenome);
							object.PesquisarSobrenomeSalário(sobrenome,funcionarios);
						}
					}
				}
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(ParseException e) {
			e.printStackTrace();
			
		}
	}
}