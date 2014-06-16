package tickets;

public class ScoreBoard {
	private int currentAttendance;
	private StadiumTicketFrame theDisplay;	
	
	public ScoreBoard(StadiumTicketFrame inDisplay) {
		currentAttendance = 0;
		theDisplay = inDisplay;
	}
	
	public int getAttendance() {
		return currentAttendance;
	}
	
//	public synchronized void  tookATicket() {
	public void  tookATicket() {
		currentAttendance++;
		theDisplay.totalReport(currentAttendance);
	}
}
