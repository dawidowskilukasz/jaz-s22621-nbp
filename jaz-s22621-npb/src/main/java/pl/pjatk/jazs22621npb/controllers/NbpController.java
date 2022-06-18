package pl.pjatk.jazs22621npb.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.jazs22621npb.model.Nbp;
import pl.pjatk.jazs22621npb.services.NbpService;

@RestController
@RequestMapping("/nbp")
public class NbpController {

    private final NbpController nbpController;

    public NbpController(NbpController nbpController) {
        this.nbpController = nbpController;
    }


  //  @GetMapping("/average/{datestart}/{dateend}/")
//        //return ResponseEntity.ok(NbpService.(datestart, dateend));
 //   }
}



