package servermanager;

public class URL {
	String url;

	URL(String theURL) {
		url = theURL;
	}

	@Override
	public String toString() {
		return url;
	}
}