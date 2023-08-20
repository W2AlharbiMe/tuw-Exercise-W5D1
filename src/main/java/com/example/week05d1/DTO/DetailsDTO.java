package com.example.week05d1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetailsDTO {

    private Integer customerId;

    private String gender;

    private String email;

    private Integer age;

}
