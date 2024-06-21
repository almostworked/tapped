package tapped;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Scanner;

// Simple data entry/search query optimization program
// Searches venue queries across multiple sites simultaneously


public class OptimizedSearch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Venue: ");	
		String venueName = scanner.nextLine();
		
		searchFacebook(venueName);
		searchInstagram(venueName);
		searchGoogleMaps(venueName);
		searchGoogle(venueName);
		
		scanner.close();
	}
	public static void searchFacebook(String query) {
		try {
			String url = "https://www.facebook.com/search/pages/?q=" + URLEncoder.encode(query, "UTF-8");
			openWebpage(url);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public static void searchInstagram(String query) {
		try {
			String url = "ttps://www.instagram.com/explore/tags/" + URLEncoder.encode(query, "UTF-8"); // TO DO
			openWebpage(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void searchGoogleMaps(String query) {
		try {
			String url = "https://www.google.com/maps/search/" + URLEncoder.encode(query, "UTF-8");
			openWebpage(url);
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		
	}
	public static void searchGoogle(String query) {
		try {
			String url = "https://www.google.com/search?q=" + URLEncoder.encode(query, "UTF-8");
			openWebpage(url);
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		
	}
	public static void openWebpage(String url) throws IOException, URISyntaxException {
		// Checks if Desktop class and BROWSE action are supported 
		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
			// Opens given URI in default web browser
			Desktop.getDesktop().browse(new URI(url));
		} else {
			System.out.println("Desktop not supported");
		}
	}
}
