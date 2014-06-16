package tickets;

import static tickets.TicketConstants.SHIFTS;
import static tickets.TicketConstants.TICKETS_PER_SHIFT;

public class TicketTaker extends Thread {
	private static int currentUniqueIdentifier = 0;
	
	private int ticketsTaken;
	private ScoreBoard board;
	private int identifier;
	private StadiumTicketFrame theDisplay;
	
	public TicketTaker(ScoreBoard inBoard, StadiumTicketFrame inDisplay) {
		ticketsTaken = 0;
		board = inBoard;
		identifier = currentUniqueIdentifier;
		currentUniqueIdentifier++;
		
		theDisplay = inDisplay;
	}
	
	public void run() {
		for(int shiftNumber = 0; shiftNumber < SHIFTS; shiftNumber++) {
			doOneShift();
		}
	}
	
	private void doOneShift() {
		for(int ticketNumber = 0; ticketNumber < TICKETS_PER_SHIFT; ticketNumber++) {
			ticketsTaken++;
			board.tookATicket();
			theDisplay.counterReport(identifier, ticketsTaken);
		}
	}
	
	public int getTicketsTaken() {
		return ticketsTaken;
	}
}
