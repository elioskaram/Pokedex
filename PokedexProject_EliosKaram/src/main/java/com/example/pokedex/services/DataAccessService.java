package com.example.pokedex.services;
import org.json.simple.JSONObject;

/**
 * abstraction of the services to access data.
 * So that we can easily replace a concrete low-level implementation with another.
 * This respects the principle of open close.
 */
public interface DataAccessService {
    JSONObject run(Integer id);
}
