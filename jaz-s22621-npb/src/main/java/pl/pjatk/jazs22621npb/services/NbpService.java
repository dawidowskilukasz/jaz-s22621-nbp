package pl.pjatk.jazs22621npb.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.jazs22621npb.interfaces.NbpRepository;
import pl.pjatk.jazs22621npb.model.Nbp;
import pl.pjatk.jazs22621npb.model.Price;
import pl.pjatk.jazs22621npb.variations.Material;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NbpService {

    private final NbpRepository nbpRepository;
    private final RestTemplate restTemplate;

    public NbpService(NbpRepository nbpRepository, RestTemplate restTemplate) {
        this.nbpRepository = nbpRepository;
        this.restTemplate = restTemplate;
    }

    public static final String goldpriceUrl = "http://api.nbp.pl/api/cenyzlota/";

    public Nbp getAvargeValue(String datestart, String dateend) {
        ResponseEntity<List<Price>> response =
                restTemplate.exchange(goldpriceUrl + datestart + "/" + dateend + "/", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Price>>() {
                        }
                );
        List<Price> prices = response.getBody();
        prices.stream().map(Price::getData).collect(Collectors.toList());

        double Rate = prices.stream().mapToDouble(Price::getCena).average().orElse(0);

        Nbp querytoSave = new Nbp(Material.GOLD, datestart, dateend, Rate, new Timestamp(System.currentTimeMillis()));

        return nbpRepository.save((querytoSave));
    }
}
