package com.mikefrancois.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class JsonReader {

  private static final String header = "{ \"atms\" : ";
  private static final String end = "}";

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    sb.append(header);
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    sb.append(end);
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      rd.readLine();
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }

  public static void main(String[] args) throws IOException, JSONException {
    JSONObject json = readJsonFromUrl("https://www.ing.nl/api/locator/atms/");
    System.out.println(json.toString());
  }
}