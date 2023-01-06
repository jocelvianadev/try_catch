
//import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;
import modelo.excecoes.ExcecoesDominio;

public class Main {

	public static void main(String[] args) throws ExcecoesDominio {
		// Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Informe o número do quarto: ");
			int numeroQuarto = scan.nextInt();
			System.out.print("Infrome a data de check-in (dd/MM/yyyy): ");
			Date checkin = sdf.parse(scan.next());
			System.out.print("Infrome a data de check-out (dd/MM/yyyy): ");
			Date checkout = sdf.parse(scan.next());

			Reserva reserva = new Reserva(numeroQuarto, checkin, checkout);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Dados de atualização de reserva:");
			System.out.print("Infrome a data de check-in (dd/MM/yyyy): ");
			checkin = sdf.parse(scan.next());
			System.out.print("Infrome a data de check-out (dd/MM/yyyy): ");
			checkout = sdf.parse(scan.next());
			
			reserva.atualizarData(checkout, checkin);
			System.out.println("Reserva: " + reserva);
		} 
		catch (ParseException e) {
			System.out.println("Formato inválido!");
		} 
		catch (ExcecoesDominio e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		} 
		catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		} 
		finally {
			scan.close();
		}

	}

}
