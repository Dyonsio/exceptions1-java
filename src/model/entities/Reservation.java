package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer numeroQuarto;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer numeroQuarto, Date checkout, Date checkin) {
        this.numeroQuarto = numeroQuarto;
        this.checkout = checkout;
        this.checkin = checkin;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getCheckout() {
        return checkout;
    }

    public Date getCheckin() {
        return checkin;
    }

    public long duracao(){
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDates (Date checkin, Date checkout) {

        Date now = new Date();
        if (checkin.before(now) || checkout.before(now)) {
            return "Erro na reserva: as datas de reserva para atualização devem ser datas futuras";
        }
        if (!checkout.after(checkin)) {
            return "Erro na reserva: a data de check-out deve ser posterior à data de check-in";
        }
        this.checkin = checkin;
        this.checkout = checkout;
        return null;
    }

    @Override
    public String toString() {
        return "Quarto "
                + numeroQuarto + ", check-in: " +
                sdf. format(checkin) + ", check-out: " +
                sdf.format(checkout) + ", " + duracao() + " noites";
    }
}
