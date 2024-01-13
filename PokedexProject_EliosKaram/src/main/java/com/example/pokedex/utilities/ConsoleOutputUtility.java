package com.example.pokedex.utilities;
import com.example.pokedex.models.PokemonDet;
import com.example.pokedex.views.PokemonView;

/**
 * Utility class for generating and displaying Pokemon information in different output formats.
 */
public class ConsoleOutputUtility {
    OutputFormat outputFormat;
    MultipleFormatGenerator formatsGenerator;

    /**
     * Constructs a new ConsoleOutputUtility with the specified output format and format generator.
     *
     * @param outputFormat     The selected output format.
     * @param formatsGenerator The format generator strategy.
     */
    public ConsoleOutputUtility(OutputFormat outputFormat, MultipleFormatGenerator formatsGenerator) {
        this.outputFormat = outputFormat;
        this.formatsGenerator = formatsGenerator;
    }

    /**
     * Generates and prints Pokemon information to the console based on the selected format.
     */
    public void makeOutput() {
        if (this.outputFormat == OutputFormat.TEXT) {
            System.out.println(formatsGenerator.generateHumanReadableText());
        } else if (this.outputFormat == OutputFormat.HTML) {
            System.out.println(formatsGenerator.generateHTML());
        } else if (this.outputFormat == OutputFormat.CSV) {
            System.out.println(formatsGenerator.generateCSV());
        }
    }
}
