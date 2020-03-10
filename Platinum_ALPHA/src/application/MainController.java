package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.controlsfx.control.textfield.TextFields;

public class MainController implements Initializable {

	@FXML
	private WebView webView;
	private WebEngine engine;
	@FXML
	private TextField searchbar;
	    
	@Override		//Entry Point
	public void initialize(URL location, ResourceBundle resources) {
			String[] possibleWords = { "google.com","youtube.com","facebook.com","wikipedia.org","reddit.com","yahoo.com","amazon.com","twitter.com","instagram.com","netflix.com","twitch.tv","linkedin.com","microsoft.com","ebay.com","web.whatsapp.com","spotify.com", "amazon.in", "in.bookmyshow.com","cricbuzz.com","devfolio.co","gmail.com","hotstar.com","primevideo.com","quora.com","zomato.com"}; //autocomplete data
			engine = webView.getEngine();	//Webkit engine
			homeMethod();		//WannabeMomentum call
			TextFields.bindAutoCompletion(searchbar, possibleWords);		//searchbar autocomplete
	}
	
	//Home
	public void btn1(ActionEvent event) {
		homeMethod();
		searchbar.setText(engine.getLocation());
	}
	//Reload
	public void btnRel(ActionEvent event) {
		engine.reload();
		searchbar.setText(engine.getLocation());
	}
	//Back
	public void goBack() {
	    Platform.runLater(() -> {
	        engine.executeScript("history.back()");
	        searchbar.setText(engine.getLocation());
	    });
	}
	//FWD
	public void goForward() {
	    Platform.runLater(() -> {
	        engine.executeScript("history.forward()");
	        searchbar.setText(engine.getLocation());
	    });
	}
	//Go Button Methods
	public void goGo(ActionEvent event) {
		String txtchk = searchbar.getText();
		if (txtchk.equals("")) {
			return ;		//nothing happen
		}
		else if ((txtchk.contains("https://") || txtchk.contains("http://"))&& (txtchk.contains(".com")	||txtchk.contains(".org") ||txtchk.contains(".tv") ||txtchk.contains(".io") ||txtchk.contains(".net"))) {
			engine.load(txtchk);		//use raw textfield content
			return;	// will stop the next else if
		}
		else if(txtchk.contains(".com")	||txtchk.contains(".org") ||txtchk.contains(".tv") ||txtchk.contains(".io") ||txtchk.contains(".net") || txtchk.contains(".in") || txtchk.contains(".info") ||txtchk.contains(".uk") ||txtchk.contains(".xyz"))
		{
			String search = "https://" + txtchk;		//concat https
			engine.load(search);
			searchbar.setText(search);
		}
		else {
			String gQuery = "https://www.google.co.in/search?q=";		//google search query
			//Sign Replacements
			if(txtchk.contains("+"))
		  	  {
		  		  txtchk = txtchk.replace("+", "%2B");
		  	  }
		  	  if(txtchk.contains("#"))
		  	  {
		  		  txtchk = txtchk.replace("#", "%23");
		  	  }
			String search = gQuery + txtchk;		
			engine.load(search);
			searchbar.setText(search);
		}
	}
	
	//Tabbs
	
	//Autofill

	public void homeMethod() {	//Load WannabeMomentum
		engine.loadContent("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"	<title>Home</title>\r\n" + 
				"	<link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\r\n" + 
				"\r\n" + 
				"	<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">\r\n" + 
				"	<link href=\"https://fonts.googleapis.com/css?family=Lato\" rel=\"stylesheet\">\r\n" + 
				"<style type=\"text/css\">\r\n" + 
				"	body{\r\n" + 
				"	background-color: #191970;\r\n" + 
				"	background-size: cover;\r\n" + 
				"	background-position: center;\r\n" + 
				"	font-family: Lato;\r\n" + 
				"	color: white;\r\n" + 
				"	}\r\n" + 
				"	#content{\r\n" + 
				"		text-align: center;\r\n" + 
				"		padding-top: 25%;\r\n" + 
				"		text-shadow: 0px 4px 3px rgba(0,0,0,0.4),\r\n" + 
				"					 0px 8px 13px rgba(0,0,0,0.1),\r\n" + 
				"					 0px 18px 13px rgba(0,0,0,0.1);\r\n" + 
				"	}\r\n" + 
				"	h1{\r\n" + 
				"		font-weight: 700;\r\n" + 
				"		font-size: 5em;\r\n" + 
				"	}\r\n" + 
				"	html{\r\n" + 
				"		height: 100%;\r\n" + 
				"	}\r\n" + 
				"	hr{\r\n" + 
				"		width: 400px;\r\n" + 
				"		border-top: 1px solid #f8f8f8;\r\n" + 
				"		border-bottom: 1px solid rgba(0,0,0,0.2);\r\n" + 
				"	}\r\n" + 
				"</style>\r\n" + 
				"</head>\r\n" + 
				"<body onload=\"startTime()\">\r\n" + 
				"	<div class=\"container\">\r\n" + 
				"		<div class=\"row\">\r\n" + 
				"			<div class=\"col-lg-12\">\r\n" + 
				"				<div id=\"content\">\r\n" + 
				"					<h1><div id=\"txt\"></div></h1>\r\n" + 
				"					<h3>Hi There! Lets Begin Your Journey On Internet</h3><sub>Powered By Google. Manthan Tupe & Rohit Jere All Rights Reserved.</sub>\r\n" + 
				"					<hr>\r\n" + 
				"					<a href=\"https://google.com\"><button class=\"btn btn-default btn-lg\" onclick=\"https://google.com\">Get Started!</button></a>\r\n" + 
				"				</div>\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<script type=\"text/javascript\"></script>\r\n" + 
				"	<script\r\n" + 
				"	  src=\"https://code.jquery.com/jquery-3.3.1.js\"\r\n" + 
				"	  integrity=\"sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=\"\r\n" + 
				"	  crossorigin=\"anonymous\">\r\n" + 
				"	</script>\r\n" + 
				"\r\n" + 
				"	<script \r\n" + 
				"		src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\">\r\n" + 
				"	</script>\r\n" + 
				"	<script>\r\n" + 
				"function startTime() {\r\n" + 
				"    var today = new Date();\r\n" + 
				"    var h = today.getHours();\r\n" + 
				"    var m = today.getMinutes();\r\n" + 
				"    var s = today.getSeconds();\r\n" + 
				"    m = checkTime(m);\r\n" + 
				"    s = checkTime(s);\r\n" + 
				"    document.getElementById('txt').innerHTML =\r\n" + 
				"    h + \":\" + m + \":\" + s;\r\n" + 
				"    var t = setTimeout(startTime, 500);\r\n" + 
				"}\r\n" + 
				"function checkTime(i) {\r\n" + 
				"    if (i < 10) {i = \"0\" + i};  // add zero in front of numbers < 10\r\n" + 
				"    return i;\r\n" + 
				"}\r\n" + 
				"</script\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}
}
// All Rights Reserved By Rohit Jere & Manthan Tupe