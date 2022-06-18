package pl.pjatk.jazs22621npb.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.jazs22621npb.interfaces.NbpRepository;

import java.util.stream.Collectors;

@Service
public class NbpService {

    private final NbpRepository nbpRepository;
    private final RestTemplate restTemplate;

    public NbpService(NbpRepository nbpRepository, RestTemplate restTemplate){
        this.nbpRepository = nbpRepository;
        this.restTemplate = restTemplate;
    }

    public static final String goldpriceUrl = "http://api.nbp.pl/api/cenyzlota/";

    public NbpQuery getAvargeValue(String datestart, String dateend) {
        ResponseEntity<List<Price>> response =
                restTemplate.exchange(goldpriceUrl + datestart + "/" + dateend + "/", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Price>>() {
                        }
                );
    List<Price> prices = response.getBody();
    prices.stream().map(Price:getData).collect(Collectors)

}
