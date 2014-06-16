package tickets;

import static tickets.TicketConstants.TICKET_TAKERS;
import static tickets.TicketConstants.SHIFTS;
import static tickets.TicketConstants.TICKETS_PER_SHIFT;

import java.util.ArrayList;
import java.util.List;

public class Stadium {

	public static void main(String[] args) throws InterruptedException {
		ScoreBoard board = new ScoreBoard();

		List<TicketTaker> takers = new ArrayList<>();

		for (int i = 0; i < TICKET_TAKERS; i++) {
			TicketTaker who = new TicketTaker(board);
			takers.add(who);
		}

		for (TicketTaker who : takers) {
			who.start();
		}

		for (TicketTaker who : takers) {
			who.join();
		}

		System.out.println("Scoreboard says " + board.getAttendance());

		int totalAttendance = 0;
		for (TicketTaker who : takers) {
			totalAttendance += who.getTicketsTaken();
		}

		System.out.println("Ticket takers took " + totalAttendance);
		
		int expectedAttendance = TICKET_TAKERS * SHIFTS * TICKETS_PER_SHIFT;
		System.out.println("Expected " + expectedAttendance);

	}

}
