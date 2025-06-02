package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer numeroQuarto;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer numeroQuarto, Date checkout, Date checkin) throws DomainException {

        if (!checkout.after(checkin)) {
            throw new DomainException("a data de Check-Out deve ser posterior à data de Check-In");
        }

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

    public void updateDates (Date checkin, Date checkout) throws DomainException {

        Date now = new Date();
        if (checkin.before(now) || checkout.before(now)) {
            throw new DomainException("as datas de reserva para atualização devem ser datas futuras");
        }
        if (!checkout.after(checkin)) {
            throw new DomainException("a data de Check-Out deve ser posterior à data de Check-In");
        }
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Quarto "
                + numeroQuarto + ", check-in: " +
                sdf. format(checkin) + ", check-out: " +
                sdf.format(checkout) + ", " + duracao() + " noites";
    }
}
