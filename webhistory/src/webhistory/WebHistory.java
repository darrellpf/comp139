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
	
	public WebAddress getCurrentURL() {
		return currentURL;
	}
	
	
	public void hitsEnter(WebAddress addr) {
		back.push(currentURL);
		currentURL = addr;
		forward.clear();
		
	}
	
	public void hitsBackButton() {
		forward.push(currentURL);
		currentURL = back.pop();
	}
	
	public int getForwardSize() {
		return forward.size();
	}
	
	public int getBackwardSize() {
		return back.size();
	}
}
