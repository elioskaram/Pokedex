package com.example.pokedex.utilities;

import main.java.com.example.pokedex.utilities.CSVGenerator;
import main.java.com.example.pokedex.utilities.HTMLGenerator;
import main.java.com.example.pokedex.utilities.TextGenerator;

/**
 * Interface for generating data in multiple formats, including text, HTML, and CSV.
 * Extends specific format generator interfaces: {@link TextGenerator}, {@link HTMLGenerator}, and {@link CSVGenerator}.
 */
public interface MultipleFormatGenerator extends TextGenerator, HTMLGenerator, CSVGenerator {

}
