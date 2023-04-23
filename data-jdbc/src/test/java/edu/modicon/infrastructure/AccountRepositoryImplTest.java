package edu.modicon.infrastructure;

import edu.modicon.domain.Account;
import edu.modicon.integration.IntegrationTestBase;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
class AccountRepositoryImplTest extends IntegrationTestBase {

    private final AccountRepository accountRepository;

    @Test
    void findById() {
        // when
        long id = 2L;
        Account account = accountRepository.findById(id);

        // then
        assertThat(account.getId()).isEqualTo(id);
        assertThat(account.getUsername()).isEqualTo("username2");
        assertThat(account.getEmail()).isEqualTo("email2@mail.com");
        assertThat(account.getPassword()).isEqualTo("password2");
        assertThat(account.getBio()).isEqualTo("long bio2");
        assertThat(account.getImage()).isEqualTo("/cloud/photos/2");
        assertThat(account.getCreatedAt()).isBefore(Instant.now());
        assertThat(account.getUpdatedAt()).isBefore(Instant.now());
    }

    @Test
    void findAll() {
        // when
        List<Account> accounts = accountRepository.findAll();

        // then
        assertThat(accounts).hasSize(5);
        System.out.println(accounts);
    }

    @Test
    void findByUsername() {
        // when
        List<Account> accounts = accountRepository.findByUsername("username");

        // then
        assertThat(accounts).hasSize(5);
        System.out.println(accounts);
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}