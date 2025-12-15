package io.github.garnaalpak.backend.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    @ToString.Exclude
    private String password;

    @Column(name = "email", nullable = false,unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRole role;

}