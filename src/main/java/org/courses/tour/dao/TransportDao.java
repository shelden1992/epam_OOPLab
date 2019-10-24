package org.courses.tour.dao;

import org.apache.log4j.Logger;
import org.courses.tour.entity.Transport;

import java.util.List;

public class TransportDao extends AbstractDao<Transport> {
    private static final Logger LOG = Logger.getLogger(TransportDao.class);
    private static final String ID_TRANSPORT = "idTransport";
    private static final String NAME_TRANSPORT = "name_transport";
    private static final String SELECT_FROM_TRANSPORT = "SELECT * FROM Transport";
    private static final String INSERT_INTO_TRANSPORT = "INSERT INTO Transport(name_transport) VALUE (?)";
    private static final String DELETE_TRANSPORT = "DELETE FROM Transport WHERE " + ID_TRANSPORT + " = ?";
    private static final String UPDATE_TRANSPORT = "UPDATE Transport SET"
            + NAME_TRANSPORT + " = ? WHERE "
            + ID_TRANSPORT + " = ?";
    private static final String SELECT_WHERE_ID = "SELECT * FROM Transport WHERE "
            + ID_TRANSPORT + " LIKE ?";

    @Override
    public List<Transport> getAll() {

        List<Transport> allEntity = getAll(SELECT_FROM_TRANSPORT, resultSet -> new Transport(resultSet.getInt(ID_TRANSPORT), resultSet.getString(NAME_TRANSPORT)));
        LOG.debug("Get all Transport size = " + allEntity.size());
        return allEntity;
    }

    @Override
    public boolean create(Transport entity) {
        LOG.debug("Try create entity = " + entity.getNameTransport() + " idEntity = " + entity.getIdTransport());
        return createUpdate(INSERT_INTO_TRANSPORT, preparedStatement -> preparedStatement.setString(1, entity.getNameTransport()));
    }

    @Override
    public boolean update(int idChange, Transport entity) {
        LOG.debug("Try update entity = " + entity.getNameTransport() + " idEntity = " + entity.getIdTransport() + " where id =" + idChange);

        return createUpdate(UPDATE_TRANSPORT, preparedStatement -> {
            preparedStatement.setString(1, entity.getNameTransport());
            preparedStatement.setInt(2, idChange);
        });
    }

    @Override
    public boolean remove(Transport entity) {
        LOG.debug("Try delete entity = " + entity.getNameTransport() + " idEntity = " + entity.getIdTransport());
        return createUpdate(DELETE_TRANSPORT, preparedStatement -> preparedStatement.setInt(1, entity.getIdTransport()));
    }

    public Transport getTransportById(int id) {
        Transport transport = getEntityWithCondition(SELECT_WHERE_ID, ps -> {
            ps.setInt(1, id);
        }, resultSet -> new Transport(resultSet.getInt(ID_TRANSPORT), resultSet.getString(NAME_TRANSPORT)));
        LOG.debug("Get Transport with name = " + transport.getNameTransport() + " and id = " + transport.getIdTransport());
        return transport;

    }


}
