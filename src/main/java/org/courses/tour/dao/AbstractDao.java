package org.courses.tour.dao;

import org.apache.log4j.Logger;
import org.courses.tour.connect.DataSourceFactory;
import org.courses.tour.dao.mapper.EntityMapper;
import org.courses.tour.dao.mapper.StatementMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T> implements EntityDao<T> {
    public static final Logger LOG = Logger.getLogger(AbstractDao.class);

    public List<T> getAll(String query, EntityMapper<T> mapper) {
        List<T> listEntity = new ArrayList<>();
        try (PreparedStatement preparedStatement = DataSourceFactory.getPreparedStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                T entity = mapper.map(resultSet);

                listEntity.add(entity);
            }
        } catch (SQLException e) {
            LOG.error("Exception while getting all entity", e);
        }
        return listEntity;
    }

    public boolean createUpdate(String query, StatementMapper<T> statementMapper) {
        try (PreparedStatement preparedStatement = DataSourceFactory.getPreparedStatement(query)) {
            statementMapper.map(preparedStatement);
            int result = preparedStatement.executeUpdate();

            return result == 1;

        } catch (SQLException e) {
            LOG.error("Exception while create entity");
            e.printStackTrace();
        }
        return false;
    }

    public T getEntityWithCondition(String query, StatementMapper<T> statementMapper, EntityMapper<T> mapper) {
        T getEntity = null;
        try (PreparedStatement preparedStatement = DataSourceFactory.getPreparedStatement(query)) {
            statementMapper.map(preparedStatement);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    getEntity = mapper.map(resultSet);
                }
            }
        } catch (SQLException e) {
            LOG.error("Exception while create entity");
            e.printStackTrace();
        }
        return getEntity;
    }

    public List<T> getListEntityWithCondition(String query, StatementMapper<T> statementMapper, EntityMapper<T> mapper) {
        List<T> listEntity = new ArrayList<>();
        try (PreparedStatement preparedStatement = DataSourceFactory.getPreparedStatement(query)) {
            statementMapper.map(preparedStatement);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    listEntity.add(mapper.map(resultSet));
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            LOG.error("Exception while create entity");
            e.printStackTrace();
        }
        return listEntity;
    }


}
