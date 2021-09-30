package org.acme.rest.client;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rest")
public class RestResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestResource.class);

    @RestClient
    RestService restService;

    @GET
    @Path("/sendCookie")
    @Produces(MediaType.TEXT_PLAIN)
    public String sendCookie() {
        return restService.sendCookie("chocolate");
    }

    @GET
    @Path("/receiveCookie")
    @Produces(MediaType.TEXT_PLAIN)
    public String receiveCookie(@CookieParam("myCookie") String myCookie) {
        if (myCookie == null || myCookie.length() == 0) {
            return "Error: Cookie not received!";
        }
        return String.format("Received Cookie: %s", myCookie);
    }
}