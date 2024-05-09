package com.example.student;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String level;
    private String department;
}
