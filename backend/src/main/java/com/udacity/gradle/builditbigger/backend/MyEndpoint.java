package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import gradle.shaladi.de.jokelib.JokeTeller;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * Endpoint for receiving a joke from a joke teller.
     */
    @ApiMethod(name = "tellJoke")
    public MyBean tellJoke() {

        JokeTeller jokeTeller = new JokeTeller();
        String joke = jokeTeller.tellJoke();

        MyBean response = new MyBean();
        response.setJoke(joke);

        return response;
    }

}
