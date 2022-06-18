package pl.pjatk.jazs22621npb.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pl.pjatk.jazs22621npb.variations.Material;

import javax.persistence.*;

@Entity
@ApiModel(value = "nbp", description ="gold value change")
public class Nbp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "identificator of gold change")
    private Long id;
    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value = "Material")
    private Material material;
    @ApiModelProperty

}
