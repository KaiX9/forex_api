package sg.edu.nus.iss.foreign_exchange.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sg.edu.nus.iss.foreign_exchange.model.Forex;
import sg.edu.nus.iss.foreign_exchange.model.Rates;

@Service
public class ForexService {

    @Value("${forex.currency.api.key}")
    private String forexApiKey;

    public Optional<Forex> getRates() throws IOException {
        Forex forex = new Forex();
        String url = "https://v6.exchangerate-api.com/v6/" + forexApiKey + "/latest/SGD";
        RequestEntity req = RequestEntity
                            .get(url)
                            .accept(MediaType.APPLICATION_JSON)
                            .header("Content-Type", "application/json")
                            .build();
        
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(req, String.class);
        forex = Forex.createFromJSON(resp.getBody());
        if (null == forex) {
            return Optional.empty();
        }
        return Optional.of(forex);
    }
}
