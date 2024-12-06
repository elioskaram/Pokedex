# Pokedex Java Project Overview

This project is a simple **Pokedex** application written in Java, structured with several components to follow the **Model-View-Controller (MVC)** design pattern. Its goal is to retrieve details about a Pokémon (based on an ID), using either a local database or a web API, and display the details in different formats (text, HTML, CSV).

## Project Structure

### 1. **Pokedex Class (Main Application)**

The **Pokedex** class serves as the entry point of the application. It handles the **command-line arguments** and initializes the necessary services and components based on the user's inputs.

- The program allows the user to specify:
  - **Pokemon ID**: The ID of the Pokémon to fetch details for.
  - **Database**: Whether to fetch data from a local SQLite database or a web API (default is Web API).
  - **Output format**: The output format for displaying Pokémon details (text, HTML, CSV).
  
  The `parseCommandLineArguments` method processes the command-line arguments to set up the data source (either web API or local database), the output format, and the Pokémon ID.
  
  After parsing the arguments, it initializes the corresponding **DataAccessService** (`HTTPRequestExample` for web API, `SQLLiteExample` for local database) and calls the **PokemonController** to fetch Pokémon details. The results are then passed to **PokemonView** to generate the desired output format.

### 2. **PokemonView Class**

The **PokemonView** class is responsible for presenting the Pokémon details in different formats: **HTML**, **CSV**, or **Human-readable Text**.

The class implements the **MultipleFormatGenerator** interface, which includes methods for generating these formats:

- **generateHTML()**: Generates HTML representation of the Pokémon details.
- **generateCSV()**: Generates CSV representation of the Pokémon details.
- **generateHumanReadableText()**: Generates a plain-text version of the Pokémon details.
  
Depending on the data source (either **local database** or **web API**), it fetches the required Pokémon data (name, ID, height, weight, description) and formats it accordingly.

### 3. **Pokemon and PokemonDet Classes (Model)**

- **Pokemon** is a simple class representing the basic information about a Pokémon: ID, name, height, and weight.
- **PokemonDet** extends **Pokemon** and adds an additional field: **description**. This class holds all the data necessary to describe a Pokémon in detail, and it is used by the **PokemonController** to store the fetched data.

### 4. **PokemonController Class**

The **PokemonController** is responsible for controlling the flow of data between the application and the data source. It uses the **DataAccessService** to fetch the raw data from either a **web API** or a **local database**.

The `getPokemonDetails()` method retrieves the details of a Pokémon (name, weight, height, description) based on the provided Pokémon ID and returns a **PokemonDet** object that contains this information.

### 5. **DataAccessService and Subclasses**

**DataAccessService** is an abstract class (or interface) that defines the contract for fetching Pokémon data. 

- **HTTPRequestExample** (for the web API) and **SQLLiteExample** (for the local database) are the concrete implementations of this service. These classes would be responsible for making requests to an API or querying a local database, respectively.
  
### 6. **ConsoleOutputUtility**

**ConsoleOutputUtility** is used to output the formatted Pokémon details to the console in the selected format (HTML, CSV, or text). It uses the **PokemonView** class to generate the appropriate output.

### 7. **Utilities**

- **PokemonCommandLineParsingException**: Custom exception to handle errors in command-line argument parsing.
- **MultipleFormatGenerator**: Interface implemented by **PokemonView** to allow for generating output in multiple formats.
- **DataSource**: Enum that defines the two types of data sources: `WEB_API` and `LOCAL_DATABASE`.
- **OutputFormat**: Enum that defines the different formats for output: `TEXT`, `HTML`, and `CSV`.

## Overall Flow:

1. The application starts and parses command-line arguments (Pokemon ID, database option, output format).
2. Based on the data source (`WEB_API` or `LOCAL_DATABASE`), the **PokemonController** fetches the Pokémon details.
3. The **PokemonView** formats the Pokémon data in the chosen format (text, HTML, or CSV).
4. The formatted result is then printed to the console.

## Key Technologies and Concepts Used:

- **MVC Pattern**: This structure allows for clean separation of concerns between model (data), view (presentation), and controller (logic).
- **Command-line arguments parsing**: Using Apache Commons CLI to handle user input.
- **Abstract Factory/Strategy Pattern**: To switch between different data sources (API vs. local database).
- **Exception Handling**: Proper handling of command-line errors and invalid input with custom exceptions.

## Conclusion

This project is a solid example of a small-scale Java application that is well-structured, modular, and flexible, allowing for easy addition of new data sources or output formats.
