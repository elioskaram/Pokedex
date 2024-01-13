package com.example.pokedex.services;

import java.sql.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
* Retrieves raw data from the DataBase.
* Returns a JSON object representing the obtained data.
*/
public class SQLLiteExample implements DataAccessService {
    /**
     * we add an attribute path so we can give the data base path as an argument
     */
    String DBpath;
    public SQLLiteExample(String DBpath){
        this.DBpath = DBpath;
    }
    @Override
    public JSONObject run(Integer id)  {
        /* Connect to the database */
        Connection conn = null;
        JSONObject obj = new JSONObject();
        try {
            // db parameters
            String url = "jdbc:sqlite:"+DBpath;
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            PreparedStatement stmt  = conn.prepareStatement("SELECT name, height, weight, description FROM pokemons WHERE id = ?");
            stmt.setInt(1,id); // Sets the value "id" for parameter at position 1
            ResultSet rs = stmt.executeQuery();
            rs.next();
            obj.put("name", rs.getString("name"));
            obj.put("height", rs.getString("height"));
            obj.put("weight", rs.getString("weight"));
            obj.put("description", rs.getString("description"));

            return obj;


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return obj;
    }
}
