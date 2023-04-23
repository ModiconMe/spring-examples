package edu.modicon.infrastructure;

import edu.modicon.domain.Account;

import java.util.List;

public interface AccountRepository {
    Account findById(Long id);
    List<Account> findAll();
    List<Account> findByUsername(String username);
    List<Account> findAllFollowers(Long id);
    List<Account> findAllFollowee(Long id);
    Long insert(Account account);
    Long update(Long id, Account account);
    boolean deleteById(Long id);
}
