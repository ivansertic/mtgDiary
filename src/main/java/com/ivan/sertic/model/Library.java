package com.ivan.sertic.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID externalLibraryId;

    private String name;

    @ManyToOne
    private User user;

    @OneToMany(
            mappedBy = "library",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Card> cards = new HashSet<>();

    public void addCard(Card card){
        cards.add(card);
        card.setLibrary(this);
    }

    public void removeCard(Card card){
        cards.remove(card);
        card.setLibrary(null);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getExternalId() {
        return externalLibraryId;
    }

    public void setExternalId(UUID externalId) {
        this.externalLibraryId = externalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(id, library.id) &&
                Objects.equals(externalLibraryId, library.externalLibraryId) &&
                Objects.equals(name, library.name) &&
                Objects.equals(user, library.user) &&
                Objects.equals(cards, library.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalLibraryId, name, user, cards);
    }
}
