package Application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Número do quarto: ");
            int num = sc.nextInt();
            System.out.print("Check-in data (dd/MM/yyyy): ");
            Date checkin = sdf.parse(sc.next());
            System.out.print("Check-out data (dd/MM/yyyy): ");
            Date checkout = sdf.parse(sc.next());

            Reservation reservation = new Reservation(num, checkin, checkout);
            System.out.println("Reserva: " + reservation);

            System.out.println();
            System.out.print("Insira os dados para atualizar a reserva:");
            System.out.print("Check-in data (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Check-out data (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next());

            reservation.updateDates(checkin, checkout);
            System.out.println("Reserva: " + reservation);
        }
        catch (ParseException e) {
            System.out.println("Data inválida");
        }
        catch (DomainException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("erro inesperado");
        }

        sc.close();
    }
}
