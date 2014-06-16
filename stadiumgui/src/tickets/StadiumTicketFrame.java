package tickets;

import static tickets.TicketConstants.SHIFTS;
import static tickets.TicketConstants.TICKETS_PER_SHIFT;
import static tickets.TicketConstants.TICKET_TAKERS;

import java.util.*;

import javax.swing.*;

public class StadiumTicketFrame extends JFrame {

	private List<JProgressBar> allWorkers;

	private JLabel totalsJLabel;

	private JPanel totalJPanel;

	private JPanel ticketTakersJPanel;

	private JLabel individualsJLabel;

	private JProgressBar totalJProgressBar;

	public StadiumTicketFrame() {
		allWorkers = new ArrayList<>();
		initComponents();
		JProgressBar theProgressBar;

		int ticketsToTake = SHIFTS * TICKETS_PER_SHIFT;

		for (int i = 0; i < TICKET_TAKERS; i++) {
			theProgressBar = new JProgressBar(0, ticketsToTake);
			allWorkers.add(theProgressBar);
			ticketTakersJPanel.add(theProgressBar);
		}

		int expectedAttendance = ticketsToTake * TICKET_TAKERS;

		totalJProgressBar.setMaximum(expectedAttendance);
	}

	private void initComponents() {
		totalJPanel = new JPanel();
		totalsJLabel = new JLabel();
		totalJProgressBar = new JProgressBar();
		ticketTakersJPanel = new JPanel();
		individualsJLabel = new JLabel();

		setTitle("Stadium Ticket Takers");
		setResizable(false);

		totalJPanel.setBorder(new javax.swing.border.EtchedBorder());
		totalJPanel.setMinimumSize(new java.awt.Dimension(148, 60));
		totalJPanel.setPreferredSize(new java.awt.Dimension(286, 60));
		totalsJLabel.setText("Total Tickets Taken");
		totalJPanel.add(totalsJLabel);

		totalJPanel.add(totalJProgressBar);

		add(totalJPanel, java.awt.BorderLayout.NORTH);

		ticketTakersJPanel.setBorder(new javax.swing.border.EtchedBorder());
		ticketTakersJPanel.setToolTipText("Ticket Takers");
		ticketTakersJPanel.setName("null");
		individualsJLabel.setText("Individual Ticket Takers");
		ticketTakersJPanel.add(individualsJLabel);

		add(ticketTakersJPanel, java.awt.BorderLayout.CENTER);

		setSize(new java.awt.Dimension(200, 350));
		setLocationRelativeTo(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		new StadiumTicketFrame().setVisible(true);
	}

	public void counterReport(int who, int count) {
		JProgressBar theBar = (JProgressBar) allWorkers.get(who);
		theBar.setValue(count);
		theBar.setString("" + who);
		theBar.setStringPainted(true);
	}

	public void totalReport(int count) {
		totalJProgressBar.setValue(count);
	}
}
