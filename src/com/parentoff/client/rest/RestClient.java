package com.parentoff.client.rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.parentoff.rest.config.ConfigHelper;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;

/**
 * Created by mohit on 27/8/15.
 */
public class RestClient {

    static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(RestClient.class);

    public static Object sendPostRequest(String json, String url) {

        String apiResponse = null;
        ClientResponse response = null;
        try {
            Client client = Client.create();

            client.setReadTimeout(Integer.parseInt(ConfigHelper.getSpecificValue("read_timeout")) * 1000);
            client.setConnectTimeout(Integer.parseInt(ConfigHelper.getSpecificValue("connection_timeout")) * 1000);
            WebResource webResource = client.resource(url);

            response = webResource
                    .accept(MediaType.APPLICATION_JSON)
                    .header("content-type", "application/json")
                    .post(ClientResponse.class, json);

            if (response.getStatus() == 200) {
                apiResponse = response.getEntity(String.class);
                LOGGER.info("Response: " + apiResponse);
            } else {
                LOGGER.error("sendAgentUpdate() : Failed : HTTP error code : "
                        + response.getStatus() + ", " + json);
            }

        } catch (Exception e) {
            LOGGER.error("sendAgentUpdate() :: Exception occurred.. " + json + ",cause: ", e);
        } finally {
            try {
                LOGGER.info("Closing connection");
                if (response != null) {
                    response.close();
                }
                LOGGER.info("Connection closed successfully");
            } catch (Exception e) {
                LOGGER.error("Error closing connection");
            }
        }

        return apiResponse;

    }

    public static void main(String[] args) {
        String json = "{\"requests\":[{\"requestId\":\"16307820\",\"callDate\" : \"1440666058\"},{\"requestId\":\"16390398\",\"callDate\" : \"1440666058\"}]}";
        String url = "http://localhost:7575/recordings/recordingList";
    }
}
