package miu.waa.springsecurity.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
//    @JsonIgnore
    private String password;
    private String firstname;
    private String lastname;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL , mappedBy = "user")
    private Product product;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;
}
