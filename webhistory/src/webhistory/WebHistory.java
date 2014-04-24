package webhistory;

import java.util.Stack;

public class WebHistory {
	private Stack<WebAddress> forward;
	private Stack<WebAddress> back;
	private WebAddress currentURL;
	
	public WebHistory() {
		forward = new Stack<>();
		back = new Stack<>();
		currentURL = new WebAddress("");
	}
}
