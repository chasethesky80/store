package com.codewithmosh.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@Table(name = "profiles")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "bio")
    private String bio;

    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private Timestamp dateOfBirth;

    @Column(name = "loyalty_points")
    private Integer loyaltyPoints;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "id")
    @ToString.Exclude
    @MapsId
    private User user;
}
