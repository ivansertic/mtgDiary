package com.ivan.sertic.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID externalId;
    private String name;

    @ManyToOne
    private User user;

    @OneToMany(
            mappedBy = "diary",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Entry> entries = new HashSet<>();


    public void addEntry(Entry entry){
        entries.add(entry);
        entry.setDiary(this);
    }

    public void removeEntry(Entry entry){
        entries.remove(entry);
        entry.setDiary(null);
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Entry> getEntries() {
        return entries;
    }

    public void setEntries(Set<Entry> entries) {
        this.entries = entries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diary diary = (Diary) o;
        return Objects.equals(id, diary.id) &&
                Objects.equals(externalId, diary.externalId) &&
                Objects.equals(name, diary.name) &&
                Objects.equals(user, diary.user) &&
                Objects.equals(entries, diary.entries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalId, name, user, entries);
    }
}
