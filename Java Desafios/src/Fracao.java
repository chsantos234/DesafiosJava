import java.util.Scanner;
import java.io.*;

public class Fracao{
	
	public int MDC(int a,int b) { // retorna o mcd de dois n�meros
		int mdc = 1;
		int max = Math.max(a,b);
		
		for(int i = 2;i <= max;i++) {
			
			while(a%i == 0 && b%i == 0 ) {
				mdc = mdc * i;
				a = a/i;
				b = b/i;
			}
		}return mdc;
	}
	
	public static void main(String[] args) throws Throwable{
		Fracao obj = new Fracao();
		File arquivo = new File("C:\\Users\\camiq\\eclipse-workspace\\Java Desafios\\src\\frac.txt");
		Scanner scFile = new Scanner(arquivo);
		
		while(scFile.hasNext()) {
			
			String fracao = scFile.next();
			String[] arrayString = fracao.split("/");
			
			if(arrayString.length == 1) {
				System.out.println(arrayString[0]); // fra��o sem divisor
			}
			
			else {
				
				int a = Integer.parseInt(arrayString[0]);
				int b = Integer.parseInt(arrayString[1]);
				
				try {
					
					int resposta = a / b;
					int mdc = obj.MDC(a,b);
					
					if(a%b == 0) { // divis�o direta sem resto (exata)
						System.out.println(resposta); 
						
					}else if(a%b != 0) { // divis�o com resto 
						int resto = a%b;

						resto = resto/mdc; // simplifica��o da fra��o restante com mdc
						b = b/mdc;
						
						if(resposta != 0) { // divis�o ocorreu
							System.out.println(resposta +" "+resto+"/"+b);
						}else if(resposta == 0) {// divis�o n�o ocorreu
							System.out.println(resto+"/"+b);
						}
					}
				}catch(Exception e) { // divis�o por zero
					System.out.println("ERR");
				} 
			}	
		}scFile.close();
	}
}
