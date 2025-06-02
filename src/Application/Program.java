package Application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Número do quarto: ");
        int num = sc.nextInt();
        System.out.print("Check-in data (dd/MM/yyyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("Check-out data (dd/MM/yyyy): ");
        Date checkout = sdf.parse(sc.next());

        if (!checkout.after(checkin)) {
            System.out.println("Erro na reserva: a data de check-out deve ser posterior à data de check-in");
        }
        else {
            Reservation reservation = new Reservation(num, checkin, checkout);
            System.out.println("Reserva: " + reservation);

            System.out.println();
            System.out.print("Insira os dados para atualizar a reserva:");
            System.out.print("Check-in data (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Check-out data (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next());

            Date now = new Date();
            if (checkin.before(now) || checkout.before(now)) {
                System.out.println("Erro na reserva: as datas de reserva para atualização devem ser datas futuras");
            }
            else if (!checkout.after(checkin)) {
                System.out.println("Erro na reserva: a data de check-out deve ser posterior à data de check-in");
            }
            else {
                reservation.updateDates(checkin, checkout);
                System.out.println("Reserva: " + reservation);
            }
        }
        sc.close();
    }
}
