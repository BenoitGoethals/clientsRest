package be.dragoncave.clients.presentationlayer.restControllers;

import be.dragoncave.clients.entitys.AddressClient;
import be.dragoncave.clients.entitys.Client;
import be.dragoncave.clients.entitys.Gender;
import be.dragoncave.clients.frameworklayer.Service.repositorys.ClientRepository;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ClientController.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ClientRepository clientRepository;

    public ClientControllerTest() {
    }

    @Test
    public void getAllClients() {
    }

    @Test
    public void getClient() throws Exception {


        Client client = new Client("benoit", "goet", Gender.FEMALE, new Date(), new AddressClient(), "0475981572", "0475981572", new Date(), true, false, "689899", "98797987");
        //   Client client2 = new Client("benoqssqdit", "gzzoet", Gender.FEMALE, new Date(), new AddressClient(), "0475981572", "0475981572", new Date(), true, false, "689899", "98797987");

        List<Client> allEmployees = Arrays.asList(client);

        given(clientRepository.findAll()).willReturn(allEmployees);

        mvc.perform(get("/api/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

    }

    @Test
    public void addClient() {
    }

    @Test
    public void updateClient() {
    }

    @Test
    public void deleteEmployee() {
    }
}