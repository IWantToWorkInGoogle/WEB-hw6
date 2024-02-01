package ru.itmo.wp.model.repository;

import ru.itmo.wp.model.repository.impl.MetaDataAndResultSet;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.function.Function;

public interface BasicRepository {
    public <T> T find(String tableName, Function<MetaDataAndResultSet, T> func, long id);

    public <T> List<T> findAll(T object, Function<MetaDataAndResultSet, T> func);

    public <T> T toObject(ResultSetMetaData metaData, ResultSet resultSet, Function<MetaDataAndResultSet, T> func);
}
