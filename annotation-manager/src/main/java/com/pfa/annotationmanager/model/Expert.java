package com.pfa.annotationmanager.model;

import com.pfa.annotationmanager.user.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "experts")
public class Expert extends User {
    private int rating;
    // Additional attributes specific to the expert role

    // Constructors, getters, and setters
    public Expert() {
    }

    public Expert(String firstname, String lastname, String email, String password, Role role, int rating) {
        super(firstname, lastname, email, password, role != null ? role : Role.EXPERT);

        this.rating = (rating != 0) ? 3 : rating ;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    // ...
}