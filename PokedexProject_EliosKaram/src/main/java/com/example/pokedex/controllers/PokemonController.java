package com.example.pokedex.controllers;

import com.example.pokedex.models.Pokemon;
import com.example.pokedex.models.PokemonDet;
import com.example.pokedex.services.*;
import org.json.simple.JSONObject;

/**
 * The {@code PokemonController} class is responsible for controlling the flow of Pokemon data
 * between the application and different data sources. It follows several SOLID principles.
 *
 * <p>
 * <strong>Single Responsibility Principle (SRP):</strong><br>
 * This class adheres to SRP by having a single responsibility - managing the retrieval
 * and processing of Pokemon details from different data sources.
 * </p>
 *
 * <p>
 * <strong>Open/Closed Principle (OCP):</strong><br>
 * The class supports extension without modification, following the OCP. It can be easily
 * extended to work with new data sources by implementing the {@code DataAccessService} interface.
 * </p>
 *
 * <p>
 * <strong>Dependency Inversion Principle (DIP):</strong><br>
 * The class follows DIP by depending on abstractions (interfaces) rather than concrete implementations.
 * The constructor takes a {@code DataAccessService} as a parameter, allowing different data access
 * services to be injected, promoting flexibility and easier testing.
 * </p>
 *
 * <p>
 * <strong>Interface Segregation Principle (ISP):</strong><br>
 * The class does not directly implement interfaces, but it depends on an interface
 * ({@code DataAccessService}). This ensures that the class is not forced to implement
 * methods it does not use, adhering to the ISP.
 * </p>
 *
 * @author Elios Karam
 * @version 1.2.1
 * @since 2024-01-13
 */

public class PokemonController {

    private DataAccessService DataAccessed;

    /**
     * Constructs a new {@code PokemonController} with the specified data access service.
     *
     * @param dataAccessService The data access service used to retrieve raw Pokemon data.
     */
    public PokemonController(DataAccessService DataAccessed) {
        //If we needed to change the data it happens here.
        this.DataAccessed = DataAccessed;
    }

    /**
     * Retrieves detailed information about a Pokemon based on its ID.
     *
     * @param id The ID of the Pokemon to retrieve details for.
     * @return A {@code PokemonDet} object containing details of the specified Pokemon.
     */
    public PokemonDet getPokemonDetails(Integer id) {
        String name;
        String weight;
        String height;
        String description="";
        // Use the service class to get raw data
        JSONObject obj = DataAccessed.run(id);

        PokemonDet pokemon = new PokemonDet();

        name = obj.get("name").toString();
        height = obj.get("height").toString();
        weight = obj.get("weight").toString();
        // Check if the "description" key exists in the JSON object
        if (obj.containsKey("description")) {
            description = obj.get("description").toString();
        }

        pokemon.setID(id);
        pokemon.setNom(name); // Set Pokemon name
        pokemon.setTaille(height); // Set Pokemon size
        pokemon.setPoids(weight); // Set Pokemon weight
        pokemon.setDescription(description); // Set Pokemon description

        return pokemon;
    }



}
