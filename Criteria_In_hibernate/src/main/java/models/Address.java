package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    public int adid;

    public String city;

    public int getAdid() {
        return adid;
    }

    public void setAdid(int adid) {
        this.adid = adid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "adid=" + adid +
                ", city='" + city + '\'' +
                '}';
    }
}
