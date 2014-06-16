package tickets;

import static tickets.TicketConstants.TICKET_TAKERS;

import java.util.*;

public class StadiumDriver {
	private ScoreBoard aMachine;

	private StadiumTicketFrame theDisplay;

	private List<TicketTaker> allTicketTakers;

	public static void main(String[] args) {
		new StadiumDriver();
	}

	public StadiumDriver() {
		allTicketTakers = new ArrayList<>();

		theDisplay = new StadiumTicketFrame();
		theDisplay.setVisible(true);
		
		aMachine = new ScoreBoard(theDisplay);

		for (int i = 0; i < TICKET_TAKERS; i++) {
			allTicketTakers.add(new TicketTaker(aMachine, theDisplay));
		}

		for (TicketTaker who : allTicketTakers) {
			who.start();
		}

		try {
			for (TicketTaker who : allTicketTakers) {
				who.join();
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

}