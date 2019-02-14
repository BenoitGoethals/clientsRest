package be.dragoncave.clients.entitys;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String forName;
    private Gender gender;
    private Date birthDate;
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)

    private AddressClient address;

    private String phone;
    private String gsm;

    private Date dateInscription;
    private boolean married;

    private boolean disabled;

    private String socialNbr;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "Client_Family")
    @OrderBy("id")
    private Set<Client> family = new HashSet<>();


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH}
            , fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client firstClient;

    private String clientNumber;

    public Client() {
    }

    public Client(String name, String forName, Gender gender, Date birthDate, AddressClient address, String phone, String gsm, Date dateInscription, boolean married, boolean disabled, String socialNbr, String clientNumber) {
        this.name = name;
        this.forName = forName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.gsm = gsm;
        this.dateInscription = dateInscription;
        this.married = married;
        this.disabled = disabled;
        this.socialNbr = socialNbr;

        this.clientNumber = clientNumber;
    }

    public void update(Client client) {
        this.name = client.name;
        this.forName = client.forName;
        this.gender = client.gender;
        this.birthDate = client.birthDate;
        this.address = client.address;
        this.phone = client.phone;
        this.gsm = client.gsm;
        this.dateInscription = client.dateInscription;
        this.married = client.married;
        this.disabled = client.disabled;
        this.socialNbr = client.socialNbr;

        this.clientNumber = client.clientNumber;
    }


    public void addclient(Client client) throws ClientAllReadyExistsExeception {
        if (!this.family.add(client))
            throw new ClientAllReadyExistsExeception();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForName() {
        return forName;
    }

    public void setForName(String forName) {
        this.forName = forName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public AddressClient getAddress() {
        return address;
    }

    public void setAddress(AddressClient address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getSocialNbr() {
        return socialNbr;
    }

    public void setSocialNbr(String socialNbr) {
        this.socialNbr = socialNbr;
    }

    public Set<Client> getFamily() {
        return family;
    }

    public void setFamily(Set<Client> family) {
        this.family = family;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Client getFirstClient() {
        return firstClient;
    }

    public void setFirstClient(Client firstClient) {
        this.firstClient = firstClient;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Client{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", forName='").append(forName).append('\'');
        sb.append(", gender=").append(gender);
        sb.append(", birthDate=").append(birthDate);
        sb.append(", address=").append(address);
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", gsm='").append(gsm).append('\'');
        sb.append(", dateInscription=").append(dateInscription);
        sb.append(", married=").append(married);
        sb.append(", disabled=").append(disabled);
        sb.append(", socialNbr='").append(socialNbr).append('\'');
        sb.append(", family=").append(family);
        sb.append(", firstClient=").append(firstClient);
        sb.append(", clientNumber='").append(clientNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
