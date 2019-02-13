package be.dragoncave.clients.entitys;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "addressClient")
public class AddressClient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String street;
    private String nbr;
    private String zip;
    private String country;


    public AddressClient(String street, String nbr, String zip, String country) {
        this.street = street;
        this.nbr = nbr;
        this.zip = zip;
        this.country = country;
    }

    public AddressClient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNbr() {
        return nbr;
    }

    public void setNbr(String nbr) {
        this.nbr = nbr;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressClient that = (AddressClient) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AddressClient{");
        sb.append("id=").append(id);
        sb.append(", street='").append(street).append('\'');
        sb.append(", nbr='").append(nbr).append('\'');
        sb.append(", zip='").append(zip).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
