import java.rmi.registry.*;
import java.util.Scanner;

public class HelloClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		double a, b, c, delta;
		try {
			// Procura o registro do RMI no Servidor
			// Se o servidor estiver em outro host basta substituir pelo seu IP
			Registry registry = LocateRegistry.getRegistry("localhost");

			// Procura a stub do servidor
			Hello stub= (Hello) registry.lookup("Servidor");

			// Chama o m�todo do servidor e imprime a mensagem
			System.out.println("Invocando metodo do servidor");
			System.out.println("Digite o primeiro n�mero: ");
			a = Double.parseDouble(sc.next());
			
			System.out.println("Digite o segundo n�mero: ");
			b = Double.parseDouble(sc.next());
			
			System.out.println("Digite o terceiro n�mero: ");
			c = Double.parseDouble(sc.next());
			
			delta = stub.calc(a, b, c);
			System.out.println("Mensagem retornada pelo Servidor: O resultado de delta � " + delta);
			
			sc.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}
}