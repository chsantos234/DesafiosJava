import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.math.BigInteger;

public class Potencias{
	
	void PotenciaDe2(long x) {
		double res = 0;
		int pot = 0;
		while(true) {
			res = Math.pow(2,pot);
			if(res == x) {
				System.out.printf("%d true %d%n",x,pot);
				break;
			}else if(res > x) {
				System.out.printf("%d false%n",x);
				break;
			}
			pot++;
		}
	}
	
	void BigPotenciaDe2(BigInteger x) {
		double res = 0;
		int pot = 0;
		while(true) {
			res = Math.pow(2,pot);
			long LongRes = (long)res;
			BigInteger BigRes = BigInteger.valueOf(LongRes);
			if(x.equals(BigRes)) {
				System.out.printf("%d true %d%n",x.abs(),pot);
				break;
			}else if(x.compareTo(BigRes) < 0) {
				System.out.printf("%d false%n",x.abs());
				break;
			}
			pot++;
		}
	}
	
	public static void main(String args[]) throws Exception{
		Potencias object = new Potencias();
		File arquivo = new File("C:\\Users\\camiq\\eclipse-workspace\\Java Desafios\\src\\d12.txt");
		Scanner scFile = new Scanner(arquivo);
		while(scFile.hasNext()) {
			
			try {
				int num = scFile.nextInt();
				object.PotenciaDe2(num);
			}catch(InputMismatchException e){
				BigInteger bigNum = new BigInteger(scFile.nextLine());
				object.BigPotenciaDe2(bigNum);
			}
		}
		scFile.close();
	}
}