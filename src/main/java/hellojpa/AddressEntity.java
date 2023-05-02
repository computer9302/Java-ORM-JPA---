package hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ADDRESS")
public class AddressEntity {

    @Id @GeneratedValue
    private Long Id;

    private Address adsress;

    public AddressEntity() {
    }

    public AddressEntity(Address adsress) {
        this.adsress = adsress;
    }

    public AddressEntity(String city, String street, String zipcode) {
        this.adsress = new Address(city, street, zipcode);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Address getAdsress() {
        return adsress;
    }

    public void setAdsress(Address adsress) {
        this.adsress = adsress;
    }
}
