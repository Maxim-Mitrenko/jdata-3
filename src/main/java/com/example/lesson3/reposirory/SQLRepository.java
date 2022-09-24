package com.example.lesson3.reposirory;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class SQLRepository {

    private final NamedParameterJdbcTemplate template;
    private static final String script = script();

    public SQLRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    private static String script() {
        try (InputStream is = new ClassPathResource("script.sql").getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines()
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getNameProduct(String nameCustomer) {
        List<String> list = new ArrayList<>();
        var set = template.queryForRowSet(script, Map.of("name", nameCustomer));
        while (set.next()) {
            list.add(set.getString("product_name"));
        }
        return list;
    }
}
