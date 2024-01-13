package com.example.pokedex;
import com.example.pokedex.controllers.PokemonController;
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.views.PokemonView;
import com.example.pokedex.models.PokemonDet;
import com.example.pokedex.services.*;
import com.example.pokedex.utilities.*;
import main.java.com.example.pokedex.utilities.DataSource;
import org.apache.commons.cli.*;

public class Pokedex {


    private static DataSource dataSource = DataSource.WEB_API;
    private static String databasePath;
    private static OutputFormat outputFormat = OutputFormat.TEXT;
    private static int pokemonId;

    public static void main(String[] args) throws ParseException {

        /* Parse the command line arguments, this is done for you, keep this code block */
        try {
            parseCommandLineArguments(args);
        } catch (PokemonCommandLineParsingException e) {
            System.err.println(e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("./Pokedex <PokemonId> [-d|--database <databaseFile>] [-f|--format <format>]", e.getOptions());
            System.exit(0);
        }


        /**
         * we get the arguments and work based on them
         * dataAccessService is the parent class of HTTPRequestExample and SQLLiteExample
         */
        try {
            DataAccessService dataSourceInstance = null;

            if(dataSource == DataSource.WEB_API){
                dataSourceInstance = new HTTPRequestExample();
            }
            else if(dataSource == DataSource.LOCAL_DATABASE){
                dataSourceInstance = new SQLLiteExample(databasePath);
            }
            // Initialize the controller
            PokemonController pokemonController = new PokemonController(dataSourceInstance);
            PokemonDet pokemon = pokemonController.getPokemonDetails(pokemonId);

            // Use a view to present the results to the user
            // View should know the dataSource in order to print the right format
            // with or without the details or else it will cancel some functionalities from part 2
            PokemonView pokemonView = new PokemonView(pokemon,dataSource);
            ConsoleOutputUtility consoleOutputUtility = new ConsoleOutputUtility(outputFormat, pokemonView);
            consoleOutputUtility.makeOutput();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void parseCommandLineArguments(String[] args) throws PokemonCommandLineParsingException, ParseException {
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("d", "database", true, "Path to a SQLite database containing pokemons");
        options.addOption("f", "format", true, "Specify the output format, between 'text', 'html' and 'csv'. By default 'text'.");

        // parse the command line arguments
        CommandLine line = parser.parse(options, args);
        if (line.hasOption("d")) {
            dataSource = DataSource.LOCAL_DATABASE;
            databasePath = line.getOptionValue("d");
        }

        if (line.hasOption("f")) {
            String formatArgValue = line.getOptionValue("f");
            if (formatArgValue.equals("html")) {
                outputFormat = OutputFormat.HTML;
            } else if (formatArgValue.equals("csv")) {
                outputFormat = OutputFormat.CSV;
            } else if (formatArgValue.equals("text")) {
                outputFormat = OutputFormat.TEXT;
            } else {
                throw new PokemonCommandLineParsingException("Invalid value for the option -f/--format", options);
            }
        }

        // Get pokemon ID from remaining arguments
        String[] remainingArgs = line.getArgs();
        if (remainingArgs.length < 1) {
            throw new PokemonCommandLineParsingException("You must provide a pokemon ID", options);
        }
        try {
            pokemonId = Integer.parseInt(remainingArgs[0]);
        } catch (NumberFormatException e) {
            throw new PokemonCommandLineParsingException("'" + remainingArgs[0] + "' is not a valid pokemon ID", options);
        }
    }


    static class PokemonCommandLineParsingException extends Exception {

        private Options options;

        public PokemonCommandLineParsingException(String msg, Options options) {
            super(msg);
            this.options = options;
        }

        public Options getOptions() {
            return options;
        }

    };
}
