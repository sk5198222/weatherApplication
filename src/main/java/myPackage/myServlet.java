package myPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class myServlet
 */
public class myServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			String city=request.getParameter("city");
			
			String apiKey="2f9745bfad41ce6b1f46728877c77605";
			
			String apiURL="https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+apiKey;
			
			URL url=new URL(apiURL);
			HttpURLConnection conn= (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			InputStream inpSt= conn.getInputStream();
			InputStreamReader reader=new InputStreamReader(inpSt);
			
			StringBuilder str=new StringBuilder();
			
			Scanner sc=new Scanner(reader);
			
			while(sc.hasNext()) {
				str.append(sc.nextLine());
			}
			
			sc.close();
			
			Gson gs=new Gson();
			JsonObject jsonObj = gs.fromJson(str.toString(), JsonObject.class);
			
			long dateTimestamp = jsonObj.get("dt").getAsLong() * 1000;
	        String date = new Date(dateTimestamp).toString();
	        
	        double temperatureKelvin = jsonObj.getAsJsonObject("main").get("temp").getAsDouble();
	        int temperatureCelsius = (int) (temperatureKelvin - 273.15);
	       
	        int humidity = jsonObj.getAsJsonObject("main").get("humidity").getAsInt();
	        
	        double windSpeed = jsonObj.getAsJsonObject("wind").get("speed").getAsDouble();
	        
	        String weatherCondition = jsonObj.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
	        
	        request.setAttribute("date", date);
	        request.setAttribute("temp", temperatureCelsius);
	        request.setAttribute("humidity", humidity);
	        request.setAttribute("wind", windSpeed);
	        request.setAttribute("wCond", weatherCondition);
	        
	        conn.disconnect();
	        
	        request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
