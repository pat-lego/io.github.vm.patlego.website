package io.github.vm.patlego.datasource.subscribe.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "subscribe")
@Table(name = "subscribe", schema = "patlegovm")
public class Subscribe {

    @Column(name = "\"firstName\"", nullable = true)
    private String firstName;

    @Column(name = "\"lastName\"", nullable = true)
    private String lastName;

    @Id
    @Column(name = "email", nullable = false)
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
