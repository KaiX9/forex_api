package sg.edu.nus.iss.foreign_exchange.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Forex {
    
    private String lastUpdated;

    private String nextUpdate;

    private String baseCode;

    private Rates rates;

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getNextUpdate() {
        return nextUpdate;
    }

    public void setNextUpdate(String nextUpdate) {
        this.nextUpdate = nextUpdate;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }
    
    public static Forex createFromJSON(String json) throws IOException {
        Forex forex = new Forex();
        try (InputStream is = new ByteArrayInputStream(json.getBytes())) {
            JsonReader r = Json.createReader(is);
            JsonObject o = r.readObject();
            forex.setBaseCode(o.getString("base_code"));
            forex.setLastUpdated(o.getString("time_last_update_utc"));
            forex.setNextUpdate(o.getString("time_next_update_utc"));
            JsonObject rates = o.getJsonObject("conversion_rates");
            forex.setRates(Rates.createFromJSON(rates));
        }
        return forex;
    }
}
