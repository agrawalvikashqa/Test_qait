package com.qait.automation.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
 
 
public class SimpleTest {
 
	public static String getHostName(SessionId session) throws UnknownHostException
	{
		String hostDetail = null;
		String hostName ="localhost";
		int port = 4444;
		String errorMsg = "Failed to acquire remote webdriver node and port info. Root cause: ";
                
		try {
			HttpHost host = new HttpHost(hostName, port);
			DefaultHttpClient client = new DefaultHttpClient();
			URL sessionURL = new URL("http://" + hostName + ":" + port + "/grid/api/testsession?session=" + session);
			System.out.println("URL is : "+sessionURL);
			BasicHttpEntityEnclosingRequest r = new BasicHttpEntityEnclosingRequest("POST", sessionURL.toExternalForm());
			HttpResponse response = client.execute(host, r);
			//JSONObject object = extractObject(response);
			//URL myURL = new URL(object.getString("proxyId"));
			JsonObject myjsonobject =extractObject(response);
			JsonElement url = myjsonobject.get("proxyId");
			System.out.println(url.getAsString());
			URL myURL = new URL(url.getAsString());
			if ((myURL.getHost() != null) && (myURL.getPort() != -1)) {
				hostDetail = myURL.getHost();
			}
 
		} catch (Exception e) {
			//logger.log(Level.SEVERE, errorMsg, e);
			throw new RuntimeException(errorMsg, e);
		}
		return hostDetail;
	}
 
	private static JsonObject extractObject(HttpResponse resp) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
		StringBuffer s = new StringBuffer();
		String line;
		while ((line = rd.readLine()) != null) {
			s.append(line);
		}
		rd.close();
		JsonParser parser = new JsonParser();
		JsonObject objToReturn = (JsonObject)parser.parse(s.toString());
		System.out.println(objToReturn.toString());
		System.out.println(objToReturn.get("proxyId"));
		return objToReturn;
	}
 
 
	public static void main(String[] args) throws MalformedURLException, UnknownHostException {
		// TODO Auto-generated method stub
		DesiredCapabilities dc = new DesiredCapabilities();
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.161.128.31:4444/wd/hub"),dc.chrome());
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		String hostname = getHostName(driver.getSessionId());
		System.out.println("hostname" +hostname);
		driver.quit();
	}
 
}