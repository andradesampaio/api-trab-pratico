package br.com.impacta.api.apitrabpratico.service;

import br.com.impacta.api.apitrabpratico.model.Client;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Optional;

@Service
public class ClientService {

    private HashMap<String, Client> clientMap;

    public ClientService() {

        clientMap = new HashMap<>();

        final Client clientOne = new Client("100", "Paolo", LocalDate.of(1987, Month.NOVEMBER, 6));
        final Client clientTwo = new Client("200", "Marilia", LocalDate.of(1987, Month.NOVEMBER, 6));
        final Client clientThree = new Client("300", "Irai", LocalDate.of(1987, Month.NOVEMBER, 6));
        final Client clientFour = new Client("400", "Andrade", LocalDate.of(1987, Month.NOVEMBER, 6));
        final Client clientFive = new Client("500", "David", LocalDate.of(1987, Month.NOVEMBER, 6));

        clientMap.put("100", clientOne);
        clientMap.put("200", clientTwo);
        clientMap.put("300", clientThree);
        clientMap.put("400", clientFour);
        clientMap.put("500", clientFive);

    }

    public Client addClient(Client client){
        clientMap.put(client.getId(), client);
        return client;
    }

    public Optional<Client> updateClient(Client client){
        if (clientMap.containsKey(client.getId())){
            clientMap.get(client.getId()).setName(client.getName());
            clientMap.get(client.getId()).setBirthdayDate(client.getBirthdayDate());

            return Optional.of(clientMap.get(client.getId()));
        }
        return Optional.empty();
    }

    public Optional<Client> removeClient(String id){
        return Optional.ofNullable(clientMap.remove(id));
    }

    public Optional<Client> findById(String clientId){
        return Optional.ofNullable(clientMap.get(clientId));
    }

    public Optional<Client> findByName(String name){
        for(Client client : clientMap.values()){
            if (client.getName().equals(name)){
                return Optional.of(client);
            }
        }
        return Optional.empty();
    }

    public Optional<Client> deleteByName(String name){
        for(Client client : clientMap.values()){
            if (client.getName().equals(name)){
                return Optional.of(clientMap.remove(client.getId()));
            }
        }
        return Optional.empty();
    }

}
