package com.unique.authorization_server_jpa.entity.authorization_server;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "token_settings")
public class ClientTokenSettings {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "time_to_live_in_hours")
    private Long timeToLiveInHours;

    @Column(name = "format")
    private String tokenFormat;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
}
