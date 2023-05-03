package hellojpa.jpql;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private String street;
    private String zipcodie;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcodie() {
        return zipcodie;
    }

    public void setZipcodie(String zipcodie) {
        this.zipcodie = zipcodie;
    }
}
