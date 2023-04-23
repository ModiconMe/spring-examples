package edu.modicon.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String bio;
    private String image;
    private Instant createdAt;
    private Instant updatedAt;
}
