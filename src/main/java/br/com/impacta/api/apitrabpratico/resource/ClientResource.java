package br.com.impacta.api.apitrabpratico.resource;

import br.com.impacta.api.apitrabpratico.controller.ClientController;
import br.com.impacta.api.apitrabpratico.model.Client;
import br.com.impacta.api.apitrabpratico.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn;

public class ClientResource {

    public static Client makeResources(Client client){
        client.removeLinks();
        Link linkSelf = linkTo(methodOn(ClientController.class).getClientById(client.getId())).withSelfRel();
        Link linkName = linkTo(methodOn(ClientController.class).getClientByName(client.getName())).withRel("find-by-name");
        Link deleteId = linkTo(methodOn(ClientController.class).deleteClientById(client.getId())).withRel("delete-by-id");
        Link deleteName = linkTo(methodOn(ClientController.class).deleteClientByName(client.getName())).withRel("delete-by-name");
        Link linkNew = linkTo(methodOn(ClientController.class).newClient(client)).withRel("client");
        client.add(linkSelf);
        client.add(linkName);
        client.add(deleteId);
        client.add(deleteName);
        client.add(linkNew);
        return client;
    }

}
