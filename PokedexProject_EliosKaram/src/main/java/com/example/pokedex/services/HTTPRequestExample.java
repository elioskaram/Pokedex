package com.example.pokedex.services;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Retrieves raw data from the server using an HTTP request.
 * Returns a JSON object representing the obtained data.
 */
public class HTTPRequestExample implements DataAccessService {
    @Override
    public JSONObject run(Integer id) {
        String jsonResponse = "";
        JSONObject obj = new JSONObject();
        try {

            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/"+id);
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");

            //instead of printing raw JSON response we have to return the object
            //this way we can lin better with the model view
            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(jsonResponse);
            if (resultObject instanceof JSONObject) {
                obj =(JSONObject)resultObject;
                return obj;
            } else {
                System.err.println("Error, we expected a JSON Object from the API");
            }



        } catch (IOException  e) {
            e.printStackTrace();
            return obj;
        } catch (ParseException e) {
            System.err.println("Could not parse the response given by the API as JSON");
            System.err.println("Response body is :");
            System.err.println(jsonResponse);
            e.printStackTrace();
            return obj;

        }
        return obj;
    }
}
