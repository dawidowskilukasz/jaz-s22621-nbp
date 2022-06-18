package pl.pjatk.jazs22621npb.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pl.pjatk.jazs22621npb.variations.Material;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@ApiModel(value = "nbp", description = "gold value change")
public class Nbp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "identificator of gold change")
    private Long id;
    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value = "Material")
    private Material material;
    @ApiModelProperty(value = "Starting date of calculations")
    private String datestart;
    @ApiModelProperty(value = "Ending date of calculations")
    private String datend;
    @ApiModelProperty(value = "Calculated average value")
    private double average;
    @ApiModelProperty(value = "Date and time of making query")
    private Timestamp timestamp;


    public Nbp(Long id, Material material, String datestart, String dateend, double average, Timestamp timestamp) {
        this.id = id;
        this.material = material;
        this.datestart = datestart;
        this.datend = dateend;
        this.average = average;
        this.timestamp = timestamp;
    }

    public Nbp(Material material, String datestart, String dateend, double average, Timestamp timestamp) {
        this.material = material;
        this.datestart = datestart;
        this.datend = dateend;
        this.average = average;
        this.timestamp = timestamp;
    }

    public Nbp() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getStartDate() {
        return datestart;
    }

    public void setStartDate(String startDate) {
        this.datestart = startDate;
    }

    public String getEndDate() {
        return datend;
    }

    public void setEndDate(String endDate) {
        this.datend = endDate;
    }

    public double getMid() {
        return average;
    }

    public void setMid(double mid) {
        this.average = mid;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
