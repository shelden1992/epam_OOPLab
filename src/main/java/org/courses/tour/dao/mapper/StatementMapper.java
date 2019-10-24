package org.courses.tour.dao.mapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface StatementMapper<T> {
    void map(PreparedStatement preparedStatement) throws SQLException;
}
