package com.byval.asp_web.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String studentId;
    private String groupId;

    public User(String firstName, String lastName, String email, String groupId, String studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.groupId = groupId;
        this.studentId = studentId;
    }
}
