package fr.fabien.rest;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;


@ApplicationPath("/rest/v1")  // utiliser pour le versioning
public class RestConfig extends Application {

}
