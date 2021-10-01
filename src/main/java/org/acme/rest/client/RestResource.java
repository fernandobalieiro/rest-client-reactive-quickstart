package org.acme.rest.client;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rest")
public class RestResource {

    @RestClient
    RestService restService;

    @GET
    @Path("/sendCookie")
    @Produces(MediaType.TEXT_PLAIN)
    public String sendCookie() {
        return restService.sendCookie("chocolate", "strawberry");
    }

    @GET
    @Path("/receiveCookie")
    @Produces(MediaType.TEXT_PLAIN)
    public String receiveCookie(@CookieParam("myCookie") String myCookie, @HeaderParam("myHeader") String myHeader) {
        if (myCookie == null || myCookie.length() == 0) {
            return String.format("Error: Cookie not received!%nReceived Header: %s", myHeader);
        }
        return String.format("Received Cookie: %s%nReceived Header: %s", myCookie, myHeader);
    }
}