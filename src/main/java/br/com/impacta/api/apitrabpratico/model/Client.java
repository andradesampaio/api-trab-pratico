package br.com.impacta.api.apitrabpratico.model;

import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

public class Client extends RepresentationModel<Client> {
    private String id;
    private String name;
    private LocalDate birthdayDate;

    public Client(String id, String name, LocalDate birthdayDate) {
        this.id = id;
        this.name = name;
        this.birthdayDate = birthdayDate;
    }

    public Client() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(LocalDate birthdayDate) {
        this.birthdayDate = birthdayDate;
    }
}
