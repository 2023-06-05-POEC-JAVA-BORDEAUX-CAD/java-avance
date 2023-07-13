package fr.maboite.correction.rest.controller;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * Fournit une URL de base de toutes nos URLS 
 * Inclut une version (il faut toujors versionner ses webservices)
 */
@ApplicationPath("/rest/v1") 
public class ApplicationConfig extends Application {
    
}
