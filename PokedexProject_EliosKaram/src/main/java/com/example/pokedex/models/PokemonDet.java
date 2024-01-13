package com.example.pokedex.models;

/**
 * The {@code PokemonDet} class represents detailed information about a Pokemon,
 * extending the base {@code Pokemon} class. It adds functionality related to the database.
 *
 * <p>
 * <strong>Inheritance:</strong><br>
 * This class extends the base {@code Pokemon} class, inheriting its properties and behavior.
 * </p>
 *
 * <p>
 * <strong>Database Functionality:</strong><br>
 * The class introduces a new functionality related to the database, providing a
 * {@code description} field along with getter and setter methods.
 * </p>
 *
 * <p>
 * <strong>Getter and Setter:</strong><br>
 * In addition to the properties inherited from the base class, this class provides
 * a getter and setter for the new {@code description} field, allowing access and modification.
 * </p>
 *
 * @author Elios Karam
 * @version 1.0.1
 * @since 2024-01-13
 */
public class PokemonDet extends Pokemon{
    private String description = "";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
