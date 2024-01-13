package com.example.pokedex.models;

/**
 * The {@code Pokemon} class represents the model of a Pokemon in the application.
 * It includes information such as ID, name, height, and weight. This class follows
 * the Model-View-Controller (MVC) pattern, where it serves as the model.
 *
 * <p>
 * <strong>Encapsulation:</strong><br>
 * The class encapsulates the details of a Pokemon by providing private fields
 * and public getter and setter methods to access and modify the information.
 * </p>
 *
 * <p>
 * <strong>Immutable:</strong><br>
 * While this class is mutable, meaning its state can be changed through setters,
 * consider making it immutable (if applicable) for better predictability and thread safety.
 * </p>
 *
 * @author Elios Karam
 * @version 1.0.0
 * @since 2024-01-13
 */
public class Pokemon {
    private Integer ID;
    private String Nom;
    private String Taille;
    private String Poids;

    /**
     * Gets the weight of the Pokemon.
     *
     * @return The weight of the Pokemon.
     */
    public String getPoids() {
        return Poids;
    }

    /**
     * Sets the weight of the Pokemon.
     *
     * @param poids The weight to set.
     */
    public void setPoids(String poids) {
        Poids = poids;
    }

    /**
     * Gets the ID of the Pokemon.
     *
     * @return The ID of the Pokemon.
     */
    public Integer getID() {
        return ID;
    }

    /**
     * Gets the name of the Pokemon.
     *
     * @return The name of the Pokemon.
     */
    public String getNom() {
        return Nom;
    }

    /**
     * Gets the height of the Pokemon.
     *
     * @return The height of the Pokemon.
     */
    public String getTaille() {
        return Taille;
    }

    /**
     * Sets the ID of the Pokemon.
     *
     * @param ID The ID to set.
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * Sets the name of the Pokemon.
     *
     * @param nom The name to set.
     */
    public void setNom(String nom) {
        Nom = nom;
    }

    /**
     * Sets the height of the Pokemon.
     *
     * @param taille The height to set.
     */
    public void setTaille(String taille) {
        Taille = taille;
    }
}