package Example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

//import aura.ReadJson;

public class Stacja_ISS {
	public static void main(String[] args) {
		
			
		//String opis=answer("http://api.open-notify.org/iss-now.json");
		JSONObject jsonOb = new JSONObject("{\"timestamp\": 1565700451, \"message\": \"success\", \"iss_position\": {\"latitude\": \"41.5111\", \"longitude\": \"58.7066\"}}");
		//String dataD_n= jsonOb.getJSONObject("data").getJSONArray("weather").getJSONObject(n).getString("date");
		String dataS = jsonOb.getString("timestamp"); 
		System.out.println(dataS);
	}

	private static String answer(String adres) throws Exception {
		URL url=new URL(adres) ;
		HttpURLConnection polaczenie = (HttpURLConnection) url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(polaczenie.getInputStream()));
		String napis="";
		napis=br.readLine();
		br.close();
		System.out.println(napis);
		return napis;
		
		
	}
}

//aplikacja pokazująca informacje o ruchu miedzynarodowej stacji kosm.
//http://open-notify.org/Open-Notify-API/ISS-Location-Now/
//predkosc ISS na podst 2 odczytow
//droga przebyta przez ISS od poczatku zapisanych odczytów
// github.com/SzczecinTech/zadania-rekrutacyjne