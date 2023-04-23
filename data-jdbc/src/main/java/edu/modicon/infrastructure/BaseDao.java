package edu.modicon.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@RequiredArgsConstructor
public class BaseDao {
    protected final NamedParameterJdbcTemplate jdbcTemplate;
}
