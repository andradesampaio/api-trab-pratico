package br.com.impacta.api.apitrabpratico.controller;

import br.com.impacta.api.apitrabpratico.model.Client;
import br.com.impacta.api.apitrabpratico.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static br.com.impacta.api.apitrabpratico.resource.ClientResource.makeResources;

@RestController
@RequestMapping(value = "/api")
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/client/id/{clientId}", produces = { "application/hal+json" })
    public ResponseEntity<Client> getClientById(@PathVariable final String clientId) {
        Optional<Client> client = clientService.findById(clientId);
        if(client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(makeResources(client.get()));
    }

    @GetMapping(value = "/client/name/{clientName}", produces = { "application/hal+json" })
    public ResponseEntity<Client> getClientByName(@PathVariable final String clientName) {
        Optional<Client> client = clientService.findByName(clientName);
        if(client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(makeResources(client.get()));
    }

    @PutMapping(value = "/client", produces = { "application/hal+json" })
    public ResponseEntity<Client> updateClient(@RequestBody final Client client) {
        Optional<Client> newClient = clientService.updateClient(client);
        if(newClient.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(makeResources(newClient.get()));
    }

    @PostMapping(value = "/client", produces = { "application/hal+json" })
    public ResponseEntity<Client> newClient(@RequestBody final Client client) {
        Client newClient = clientService.addClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(makeResources(newClient));
    }

    @DeleteMapping(value = "/client", produces = { "application/hal+json" })
    public ResponseEntity<Client> deleteClient(@RequestBody final Client client) {
        Optional<Client> newClient = clientService.removeClient(client.getId());
        if(newClient.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(makeResources(newClient.get()));
    }

    @DeleteMapping(value = "/client/id/{clientId}", produces = { "application/hal+json" })
    public ResponseEntity<Client> deleteClientById(@PathVariable final String clientId) {
        Optional<Client> client = clientService.removeClient(clientId);
        if(client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(makeResources(client.get()));
    }

    @DeleteMapping(value = "/client/name/{clientName}", produces = { "application/hal+json" })
    public ResponseEntity<Client> deleteClientByName(@PathVariable final String clientName) {
        Optional<Client> client = clientService.deleteByName(clientName);
        if(client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(makeResources(client.get()));
    }

}
