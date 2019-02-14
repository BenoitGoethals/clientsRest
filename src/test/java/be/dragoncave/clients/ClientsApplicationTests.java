package be.dragoncave.clients;

import be.dragoncave.clients.entitys.AddressClient;
import be.dragoncave.clients.entitys.Client;
import be.dragoncave.clients.entitys.ClientAllReadyExistsExeception;
import be.dragoncave.clients.entitys.Gender;
import be.dragoncave.clients.frameworklayer.Service.repositorys.ClientRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
@TestPropertySource(locations = "classpath:application.properties")
public class ClientsApplicationTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ClientRepository clientRepository;


    @Test
    public void clientAddTest() {
        //  Client(String name, String forName, Gender gender, Date birthDate, AddressClient address, String phone, String gsm, Date dateInscription, boolean married, boolean disabled, String socialNbr, Set<Client> family, String clientNumber) {
        Client client = new Client("benoit", "goet", Gender.FEMALE, new Date(), new AddressClient(), "0475981572", "0475981572", new Date(), true, false, "689899", "98797987");

        Client save = clientRepository.save(client);
        Assert.assertNotNull(save.getId());

        Optional<Client> cm = clientRepository.findById(save.getId());
        Assert.assertEquals(save, cm.get());
    }

    @Test
    public void updateClientTest() {
        //  Client(String name, String forName, Gender gender, Date birthDate, AddressClient address, String phone, String gsm, Date dateInscription, boolean married, boolean disabled, String socialNbr, Set<Client> family, String clientNumber) {
        Client client = new Client("benoit", "goet", Gender.FEMALE, new Date(), new AddressClient(), "0475981572", "0475981572", new Date(), true, false, "689899", "98797987");
        Client save = clientRepository.save(client);
        Assert.assertNotNull(save.getId());
        client.setName("test");
        Client update = clientRepository.save(client);
        Assert.assertEquals("test", update.getName());
    }


    @Test(expected = Exception.class)
    public void deleteClientTest() {
        //  Client(String name, String forName, Gender gender, Date birthDate, AddressClient address, String phone, String gsm, Date dateInscription, boolean married, boolean disabled, String socialNbr, Set<Client> family, String clientNumber) {
        Client client = new Client("benoit", "goet", Gender.FEMALE, new Date(), new AddressClient(), "0475981572", "0475981572", new Date(), true, false, "689899", "98797987");

        Client save = clientRepository.save(client);
        Assert.assertNotNull(save.getId());
        Long id = save.getId();
        clientRepository.delete(client);
        Assert.assertNull(clientRepository.getOne(id));

    }


    @Test
    public void getClientNotFoungTest() {
        //  Client(String name, String forName, Gender gender, Date birthDate, AddressClient address, String phone, String gsm, Date dateInscription, boolean married, boolean disabled, String socialNbr, Set<Client> family, String clientNumber) {
        Client client = new Client("benoit", "goet", Gender.FEMALE, new Date(), new AddressClient(), "0475981572", "0475981572", new Date(), true, false, "689899", "98797987");

        Client save = clientRepository.save(client);
        Assert.assertNotNull(save.getId());
    }



    @Test
    public void clientAddwithFamilyTest() {
        //  Client(String name, String forName, Gender gender, Date birthDate, AddressClient address, String phone, String gsm, Date dateInscription, boolean married, boolean disabled, String socialNbr, Set<Client> family, String clientNumber) {
        Client client = new Client("benoit", "g333et", Gender.FEMALE, new Date(), new AddressClient(), "0475981572", "0475981572", new Date(), true, false, "689899", "98797987");

        Client save = clientRepository.save(client);

        Client client2 = new Client("benoit1", "gofdfet", Gender.FEMALE, new Date(), new AddressClient(), "0475981572", "0475981572", new Date(), true, false, "689899", "98797987");

        Client save2 = clientRepository.save(client2);

        Client client3 = new Client("beno3it", "gosffet", Gender.FEMALE, new Date(), new AddressClient("sfdf", "sfsdf", "sfsdf", "sffsfs"), "0475981572", "0475981572", new Date(), true, false, "689899", "98797987");

        Client save3 = clientRepository.save(client3);

        Assert.assertNotNull(save.getId());
        Assert.assertNotNull(save2.getId());
        Assert.assertNotNull(save3.getId());

        try {
            save.addclient(save2);
            save.addclient(save3);
            final Client save1 = clientRepository.save(save);
            Assert.assertNotNull(save1);
            Assert.assertEquals(2, save1.getFamily().size());
            System.out.println(save1);
        } catch (ClientAllReadyExistsExeception clientAllReadyExistsExeception) {
            clientAllReadyExistsExeception.printStackTrace();
        }
    }
}
