package com.ivan.sertic.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID externalId;

    private String name;

    private String manaCost;

    private String description;

    private String edition;

    @ManyToOne
    private Library library = new Library();

    public Card(String name, String manaCost, String description, String edition) {
        this.name = name;
        this.manaCost = manaCost;
        this.description = description;
        this.edition = edition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getExternalId() {
        return externalId;
    }

    public void setExternalId(UUID externalId) {
        this.externalId = externalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) &&
                Objects.equals(externalId, card.externalId) &&
                Objects.equals(name, card.name) &&
                Objects.equals(manaCost, card.manaCost) &&
                Objects.equals(description, card.description) &&
                Objects.equals(edition, card.edition) &&
                Objects.equals(library, card.library);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalId, name, manaCost, description, edition, library);
    }
}
