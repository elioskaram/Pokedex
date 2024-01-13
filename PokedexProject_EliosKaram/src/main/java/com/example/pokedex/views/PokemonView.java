package com.example.pokedex.views;


import com.example.pokedex.models.PokemonDet;
import com.example.pokedex.utilities.MultipleFormatGenerator;
import com.example.pokedex.utilities.OutputFormat;
import main.java.com.example.pokedex.utilities.DataSource;


/**
 * The {@code PokemonView} class represents a view for displaying Pokemon details
 * in various output formats. It implements the {@code MultipleFormatGenerator} interface.
 */
public class PokemonView implements MultipleFormatGenerator{
    public PokemonDet pokemon;
    public DataSource dataSource;

    /**
     * Constructs a new PokemonView with the specified Pokemon details and data source.
     *
     * @param pokemon    The Pokemon details.
     * @param dataSource The data source for the Pokemon details.
     */
    public PokemonView(PokemonDet pokemon, DataSource dataSource){
        this.pokemon = pokemon;
        this.dataSource = dataSource;
    }

    @Override
    public String generateHTML() {
        String des = "";
        if (dataSource == DataSource.LOCAL_DATABASE){
            des = "<li>Description : " + pokemon.getDescription() + "</li>\n";
        }
        return "<h1>" + pokemon.getNom() + "</h1>\n" +
                "<ul>\n" +
                "<li>Id : " + pokemon.getID() + "</li>\n" +
                "<li>Taille : " + pokemon.getTaille() + "</li>\n" +
                "<li>Poids : " + pokemon.getPoids() + "</li>\n" +
                des +
                "</ul>";
    }

    @Override
    public String generateCSV() {
        String des = "";
        if (dataSource == DataSource.LOCAL_DATABASE){
            des = ";\"" + pokemon.getDescription() + "\"";
        }
        return "Id;Name;Height;Weight;Description;\n" +
                pokemon.getID() + ";\"" + pokemon.getNom() + "\";" + pokemon.getTaille() + ";" +
                pokemon.getPoids() + des;
    }

    @Override
    public String generateHumanReadableText() {
        String des = "";
        if (dataSource == DataSource.LOCAL_DATABASE){
            des = "Description : " + pokemon.getDescription() + "\n";
        }
        return "=============================\n" +
                "Pokemon # " + pokemon.getID() + "\n" +
                "Nom : " + pokemon.getNom() + "\n" +
                "Taille : " + pokemon.getTaille() + "\n" +
                "Poids : " + pokemon.getPoids() + "\n" +
                 des +
                "=============================";
    }


}
