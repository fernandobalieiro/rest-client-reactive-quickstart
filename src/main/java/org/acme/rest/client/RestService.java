package org.acme.rest.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Set;

@Path("/rest")
@RegisterRestClient(baseUri = "http://localhost:8080/")
public interface RestService {

    @GET
    @Path("/receiveCookie")
    String sendCookie(@CookieParam("myCookie") String myCookie);
}