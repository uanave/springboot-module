package academy.everyonecodes.authorizedmarco.communication.client;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.POST;

@Controller
public class PoloClient {
    private final RestTemplate restTemplate;
    private final String url;

    public PoloClient(RestTemplate restTemplate, @Value("${polo.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public String post(String text) {
//        String credentials = "marcopolo:marcopolo";
//
//        byte[] credentialsBytes = credentials.getBytes();
//
//        byte[] base64credentialsBytes = Base64.encodeBase64(credentialsBytes);
//
//        String base64Credentials = new String(base64credentialsBytes);
//
//        HttpHeaders headers = new HttpHeaders();
//
//        headers.add("Authorization", "Basic " + base64Credentials);
//
//        HttpEntity<String> request = new HttpEntity<String>(text, headers);

        return restTemplate.postForObject(url, text, String.class);

    }
}
