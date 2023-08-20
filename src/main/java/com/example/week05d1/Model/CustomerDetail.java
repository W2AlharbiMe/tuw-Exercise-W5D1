package com.example.week05d1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customers_details")
public class CustomerDetail {
    @Id
    private Integer id;

    @OneToOne()
    @MapsId
    @JsonIgnore
    private Customer customer;

    private String gender;

    private String email;

    private Integer age;
}
