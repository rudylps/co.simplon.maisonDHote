package co.simplon.maisonDHote;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import co.simplon.maisonDHote.ResaManager;
import co.simplon.maisonDHote.Reservation;

public class ResaManager {
	private final static ResaManager INSTANCE = new ResaManager();
	private final Map<String, Reservation> resas = new HashMap<String, Reservation>();
	
	private ResaManager(){
	}
	
	public static ResaManager getInstance() {
		return INSTANCE;
	}
	
	public Map<String, Reservation> getResas(){
		return resas;
	}

	public void getResas(Reservation newReservation) {
		resas.put(newReservation.getNom(), newReservation);
	}
	
//	public void addTicket(Reservation reservation) throws Exception{
//		if(tickets.containsKey(reservation.getTicketId()))
//			throw new Exception("Ce billet a déjà été enregistré !");
//		
//		reservation.setDateEnregistrement(new Date());
//		tickets.put(ticket.getTicketId(), ticket);
//	}
	
}
