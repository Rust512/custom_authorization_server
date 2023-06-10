package com.unique.authorization_server_jpa.entity.authorization_server;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "client_name", unique = true)
    private String clientName;

    @Column(name = "client_id", unique = true)
    private String clientId;

    @Column(name = "client_secret")
    private String clientSecret;
}
