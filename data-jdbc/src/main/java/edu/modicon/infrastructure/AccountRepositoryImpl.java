package edu.modicon.infrastructure;

import edu.modicon.domain.Account;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Repository
public class AccountRepositoryImpl extends BaseDao implements AccountRepository {

    private final FindAllAccountMapSqlQuery findAllAccountMapSqlQuery;
    private final FilterAccountByUsernameMapSqlQuery filterAccountByUsernameMapSqlQuery;

    public AccountRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate,
                                 FindAllAccountMapSqlQuery findAllAccountMapSqlQuery,
                                 FilterAccountByUsernameMapSqlQuery filterAccountByUsernameMapSqlQuery) {
        super(jdbcTemplate);
        this.findAllAccountMapSqlQuery = findAllAccountMapSqlQuery;
        this.filterAccountByUsernameMapSqlQuery = filterAccountByUsernameMapSqlQuery;
    }

    @Override
    public Account findById(Long id) {
        String sql = """
                SELECT id, username, email, password, bio, image, created_at, updated_at
                  FROM account
                 WHERE id = :id;
                """;
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) ->
            Account.builder()
                    .id(rs.getLong("id"))
                    .username(rs.getString("username"))
                    .email(rs.getString("email"))
                    .password(rs.getString("password"))
                    .bio(rs.getString("bio"))
                    .image(rs.getString("image"))
                    .createdAt(Instant.ofEpochMilli(rs.getTimestamp("created_at").getTime()))
                    .updatedAt(Instant.ofEpochMilli(rs.getTimestamp("updated_at").getTime()))
                    .build());
    }

    @Override
    public List<Account> findAll() {
        return findAllAccountMapSqlQuery.execute();
    }

    @Override
    public List<Account> findByUsername(String username) {
        return filterAccountByUsernameMapSqlQuery.executeByNamedParam(Map.of("username", username));
    }

    @Override
    public List<Account> findAllFollowers(Long id) {
        return null;
    }

    @Override
    public List<Account> findAllFollowee(Long id) {
        return null;
    }

    @Override
    public Long insert(Account account) {
        return null;
    }

    @Override
    public Long update(Long id, Account account) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
