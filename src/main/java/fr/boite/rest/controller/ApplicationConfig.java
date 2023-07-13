package fr.boite.rest.controller;

import jakarta.faces.application.Application;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/rest/v1") //← Cette URL sera la base de toutes nos URLS (il faut toujors versionner ses webservices)
public abstract class ApplicationConfig  extends Application {

}
