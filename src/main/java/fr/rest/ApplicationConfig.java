package fr.rest;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
@ApplicationPath("/rest/v1")
//← Cette URL sera la base de toutes nos URLS (il faut toujors
//versionner ses webservices)
public class ApplicationConfig extends Application {}
