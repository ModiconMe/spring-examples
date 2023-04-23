package edu.modicon.infrastructure;

import edu.modicon.domain.Account;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

@Component
public class FindAllAccountMapSqlQuery extends MappingSqlQuery<Account> {

    private static final String sql = """
            SELECT id,
                   username,
                   email,
                   password,
                   bio, image,
                   created_at,
                   updated_at
              FROM account;
            """;

    public FindAllAccountMapSqlQuery(DataSource ds) {
        super(ds, sql);
    }

    @Override
    protected Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Account.builder()
                .id(rs.getLong("id"))
                .username(rs.getString("username"))
                .email(rs.getString("email"))
                .password(rs.getString("password"))
                .bio(rs.getString("bio"))
                .image(rs.getString("image"))
                .createdAt(Instant.ofEpochMilli(rs.getTimestamp("created_at").getTime()))
                .updatedAt(Instant.ofEpochMilli(rs.getTimestamp("updated_at").getTime()))
                .build();
    }
}
