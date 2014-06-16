package tickets;

public class ScoreBoard {
	private int currentAttendance;
	
	public ScoreBoard() {
		currentAttendance = 0;
	}
	
	public int getAttendance() {
		return currentAttendance;
	}
	
//	public synchronized void  tookATicket() {
	public void  tookATicket() {
		currentAttendance++;
	}
}
