package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import modelo.excecoes.ExcecoesDominio;

public class Reserva {
	private Integer numeroQuarto;
	private Date checkin;
	private Date checkout;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva() {
	}

	public Reserva(Integer numeroQuarto, Date checkin, Date checkout) throws ExcecoesDominio{
		if(!checkout.after(checkin)) {
			throw new ExcecoesDominio("a data de check-out deve ser posterior à data de check-in!");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	
	public long duracao() {
		long diferenca = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void atualizarData(Date checkout, Date checkin)throws ExcecoesDominio {
		Date agora = new Date();
		if(checkin.before(agora)|| checkout.before(agora)) {
			throw new ExcecoesDominio("as datas de reserva para atualização devem ser datas futuras!");
		}if(!checkout.after(checkin)) {
			throw new ExcecoesDominio("a data de check-out deve ser posterior à data de check-in!");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public String toString() {
		return "Quarto: "
				+ numeroQuarto+
				", chech-in: "
				+ sdf.format(checkin)
				+ ", check-out: "
				+ sdf.format(checkout)
				+ ", duração: "
				+ duracao()
				+ " noites";
	}

}
