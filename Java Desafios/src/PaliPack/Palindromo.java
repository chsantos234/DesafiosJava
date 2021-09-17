package PaliPack;
import java.util.Scanner;

public class Palindromo{
	
	int reverter(int numero) {
		String string = "";
		while (numero > 0) {
		    int inversion = numero % 10;
		    numero = numero / 10;
		    string += inversion;
		}
		int resposta = Integer.parseInt(string);
		return resposta;
	}
	
	void PalindromoNumero(int inicio , int fim) {
		for(int i = inicio; i <= fim;i++) {
			int invertido = reverter(i);
			if(i == invertido) {
				System.out.printf("%d,",i);
			}
		}
	}
	
	public static void main(String args[]) throws Exception{
		Palindromo object = new Palindromo();
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Digite o início e o fim da contagem separadamente:");
		int inicio = sc1.nextInt();
		int fim = sc1.nextInt();
		
		object.PalindromoNumero(inicio,fim);
		sc1.close();
	}
}