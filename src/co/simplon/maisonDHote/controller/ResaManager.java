package co.simplon.maisonDHote.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResaManager {

	private final static ResaManager INSTANCE = new ResaManager();
	private final Map<String, ResaInterface> resas = new HashMap<String, ResaInterface>();
	
	private ResaManager(){
	}
	
	public static ResaManager getInstance() {
		return INSTANCE;
	}
	
	public Map<String, ResaInterface> getTickets(){
		return resas;
	}
	
//	public void addTicket(Ticket ticket) throws Exception{
//		if(tickets.containsKey(ticket.getTicketId()))
//			throw new Exception("Ce billet a déjà été enregistré !");
//		
//		ticket.setDateEnregistrement(new Date());
//		tickets.put(ticket.getTicketId(), ticket);
//	}
//	
}
