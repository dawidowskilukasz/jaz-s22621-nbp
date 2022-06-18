package pl.pjatk.jazs22621npb.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.jazs22621npb.model.Nbp;
import pl.pjatk.jazs22621npb.variations.Material;

public interface NbpRepository extends JpaRepository {

    Nbp save(Nbp nbpToSave);
}
