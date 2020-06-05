package com.example.offload.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Offload implements Serializable {

    @Id
    private Integer id;
    private String barcode;
    private String offloadType;

    public Offload(Integer id, String barcode, String offloadType) {
        this.id = id;
        this.barcode = barcode;
        this.offloadType = offloadType;
    }

    public Offload() {
    }

    public Integer getId() {
        return id;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getOffloadType() {
        return offloadType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offload offload = (Offload) o;
        return Objects.equals(id, offload.id) &&
                Objects.equals(barcode, offload.barcode) &&
                Objects.equals(offloadType, offload.offloadType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, barcode, offloadType);
    }
}
