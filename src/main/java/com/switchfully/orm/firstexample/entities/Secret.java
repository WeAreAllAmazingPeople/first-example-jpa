package com.switchfully.orm.firstexample.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Secret {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "secret")
    private String secret;

    @ManyToOne
    @JoinColumn(name = "secret_owner_id", nullable = false)
    private Person secretOwner;

    public Secret() {
    }

    public Secret(String secret, Person secretOwner) {
        this.secret = secret;
        this.secretOwner = secretOwner;
    }
}
