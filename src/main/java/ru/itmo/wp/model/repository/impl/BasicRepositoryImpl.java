package ru.itmo.wp.model.repository.impl;

import ru.itmo.wp.model.database.DatabaseUtils;
import ru.itmo.wp.model.exception.RepositoryException;
import ru.itmo.wp.model.repository.BasicRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class BasicRepositoryImpl implements BasicRepository {
    private final DataSource DATA_SOURCE = DatabaseUtils.getDataSource();

    public <T> T find(String tableName, Function<MetaDataAndResultSet, T> func, long id) {
        try (Connection connection = DATA_SOURCE.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Talk6 WHERE id=?")) {
                statement.setLong(1,id);
                try(ResultSet resultSet = statement.executeQuery()) {
                    return toObject(statement.getMetaData(), resultSet, func);
                }
            }
        } catch (SQLException e) {
            throw new RepositoryException("Can't find Message.", e);
        }
    }

    public <T> List<T> findAll(T object, Function<MetaDataAndResultSet, T> func) {
        List<T> objects = new ArrayList<>();
        try (Connection connection = DATA_SOURCE.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Talk6")) {
                try(ResultSet resultSet = statement.executeQuery()) {
                    T newObject;
                    while ((newObject = toObject(statement.getMetaData(), resultSet, func)) != null) {
                        objects.add(newObject);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RepositoryException("Can't find Message.", e);
        }
        return objects;
    }

    public <T> T toObject(ResultSetMetaData metaData, ResultSet resultSet, Function<MetaDataAndResultSet, T> func) {
        return func.apply(new MetaDataAndResultSet(metaData, resultSet));
    }
}
