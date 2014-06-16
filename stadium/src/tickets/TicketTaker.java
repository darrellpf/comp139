package tickets;

import static tickets.TicketConstants.SHIFTS;
import static tickets.TicketConstants.TICKETS_PER_SHIFT;

public class TicketTaker extends Thread {
	private static int currentUniqueIdentifier = 0;
	
	private int ticketsTaken;
	private ScoreBoard board;
	private int identifier;
	
	public TicketTaker(ScoreBoard inBoard) {
		ticketsTaken = 0;
		board = inBoard;
		identifier = currentUniqueIdentifier;
		currentUniqueIdentifier++;
	}
	
	public void run() {
		for(int shiftNumber = 0; shiftNumber < SHIFTS; shiftNumber++) {
			doOneShift();
			System.out.println(identifier + " : Did shift " + shiftNumber + " scoreboard says " + board.getAttendance() );
		}
	}
	
	private void doOneShift() {
		for(int ticketNumber = 0; ticketNumber < TICKETS_PER_SHIFT; ticketNumber++) {
			ticketsTaken++;
			board.tookATicket();
		}
	}
	
	public int getTicketsTaken() {
		return ticketsTaken;
	}
}
