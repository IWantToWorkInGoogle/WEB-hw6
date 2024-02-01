package ru.itmo.wp.model.repository.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class MetaDataAndResultSet {
    private ResultSetMetaData metaData;
    private ResultSet resultSet;

    public MetaDataAndResultSet(ResultSetMetaData metaData, ResultSet resultSet) {
        this.metaData = metaData;
        this.resultSet = resultSet;
    }

    public void setMetaData(ResultSetMetaData metaData) {
        this.metaData = metaData;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public ResultSetMetaData getMetaData() {
        return metaData;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }
}
