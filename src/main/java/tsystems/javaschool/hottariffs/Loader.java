package tsystems.javaschool.hottariffs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import lombok.extern.log4j.Log4j;
import tsystems.javaschool.hottariffs.model.Tariff;

import javax.ws.rs.core.MediaType;
import java.util.List;

@Log4j
public class Loader {
    private final String GET_TARIFF_LIST_URL = "http://localhost:8080/tariffs";
    private final Client client = new Client();
    private final GsonBuilder builder = new GsonBuilder();
    private final Gson gson = builder.create();
    private static Loader loader;

    public static Loader getInstance() {
        if (loader == null) {
            loader = new Loader();
        }
        return loader;
    }

    public List<Tariff> getTariffs() {
        String response = getResultResponse(GET_TARIFF_LIST_URL);
        List<Tariff> tariffs = null;
        try {
            tariffs = gson.fromJson(response, new TypeToken<List<Tariff>>(){}.getType());
        } catch (JsonSyntaxException e) {
            log.warn("Can't parse json. " + e.getMessage());
        }
        return tariffs;
    }

    private String getResultResponse(String URL) {
        WebResource webResource = client.resource(URL);
        return webResource
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class)
                .getEntity(String.class);
    }
}
