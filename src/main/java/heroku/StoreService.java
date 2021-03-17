package heroku;

import java.util.Collections;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StoreService {

    private int count = 0;

    private final RestTemplate restTemplate;

    public StoreService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void store(final String input) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.set("kvstoreio_api_key", "89eed999b7581e7dcf3a78e60bba52d1d4c0bff03ab543001aa77bf3cfa88d17");
        HttpEntity<String> entity = new HttpEntity<>(input, headers);
        String url = "https://api.kvstore.io/collections/storage/items/" + count;
        count++;
        this.restTemplate.put(url, entity);
    }
}