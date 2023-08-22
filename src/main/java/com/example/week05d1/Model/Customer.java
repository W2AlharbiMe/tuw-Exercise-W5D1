package com.example.week05d1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.DETACH)
    @PrimaryKeyJoinColumn
    private CustomerDetail customerDetail;

    @ManyToMany
    @JsonIgnore
    private Set<Merchant> merchants;
}
