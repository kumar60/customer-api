package in.javahome.customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class OrdersClientAPI {
	private static final String ORDER_HOST_NAME = "ORDER_HOST_NAME";
	public static String callOrderApi(int customerId) {
		System.out.println("OrderHostName "+System.getenv(ORDER_HOST_NAME));
		String orderHost = System.getenv(ORDER_HOST_NAME);
		String URL = "http://"+orderHost+":8080/order/" + customerId;
		try {

			URL url = new URL(URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				return "Failed to connect to order application : HTTP error code : " + conn.getResponseCode();
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			StringBuffer result = new StringBuffer();
			String data;
			while ((data = br.readLine()) != null) {
				result.append(data);
			}
			conn.disconnect();
			return result.toString();

		} catch (MalformedURLException e) {
			return "Failed to connect to order application";

		} catch (IOException e) {
			return "Failed to connect to order application";

		}
	}

	public static void main(String[] args) {
		System.out.println(callOrderApi(1));
	}

}
