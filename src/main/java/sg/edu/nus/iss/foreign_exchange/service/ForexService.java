package sg.edu.nus.iss.foreign_exchange.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import sg.edu.nus.iss.foreign_exchange.model.Forex;

@Service
public class ForexService {

    @Value("${forex.currency.url}")
    private String forexUrl;

    public Optional<Forex> getRates(String baseCode) throws IOException {
        Forex forex = new Forex();
        String url = UriComponentsBuilder
                    .fromUriString(forexUrl + baseCode)
                    .toUriString();                    
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
