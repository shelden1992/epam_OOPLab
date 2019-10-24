package org.courses.tour.dao;

import org.apache.log4j.Logger;
import org.courses.tour.entity.City;
import org.courses.tour.entity.Transport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CityDao extends AbstractDao<City> {
    private static final Logger LOG = Logger.getLogger(CityDao.class);
    private static final String NAME_CITY = "name_city";
    private static final String SELECT_FROM_CITY = "SELECT * FROM City";
    private static final String ID_CITY = "idCity";
    private static final String INSERT_INTO_CITY = "INSERT INTO City(" + ID_CITY + ", " + NAME_CITY + ") VALUE(?, ?)";
    private static final String UPDATE_CITY = "UPDATE City "
            + "SET "
            + NAME_CITY + " = ? WHERE "
            + ID_CITY + " = ?";
    private static final String DELETE_CITY = "DELETE FROM City "
            + "WHERE " + ID_CITY + " = ?";
    private static final String SELECT_FROM_TOUR_TYPE_CITY = "SELECT ttac.idCity, c.name_city FROM `Tour_type_and_city` AS ttac " +
            "JOIN `City`AS c ON ttac.`idCity` = c.`idCity` " +
            "WHERE ttac.`idTour` like ?;";

    @Override
    public List<City> getAll() {
        List<City> allEntity = getAll(SELECT_FROM_CITY, this::getCity);
        LOG.debug("Get all City size = " + allEntity.size());
        return allEntity;
    }

    private City getCity(ResultSet resultSet) throws SQLException {
        return new City(resultSet.getInt(ID_CITY), resultSet.getString(NAME_CITY), CityTransportDao.getCityTransport().getAllTransportInCurrentCity(resultSet.getInt(ID_CITY)));
    }

    public List<City> getListCityByIdTour(int id) {
        return getListEntityWithCondition(SELECT_FROM_TOUR_TYPE_CITY, preparedStatement -> preparedStatement.setInt(1, id), this::getCity);
    }

    @Override
    public boolean create(City entity) {
        LOG.debug("Try create entity = " + entity.getNameCity() + " idEntity = " + entity.getIdCity());
        boolean update = createUpdate(INSERT_INTO_CITY, preparedStatement -> {
            preparedStatement.setInt(1, entity.getIdCity());
            preparedStatement.setString(2, entity.getNameCity());
        });
        CityTransportDao.getCityTransport().createDependencyCityAndTransport(entity);
        return update;
    }

    @Override
    public boolean update(int idChange, City entity) {
        LOG.debug("Try update entity = " + entity.getNameCity() + " idEntity = " + entity.getIdCity() + " where id =" + idChange);
        return createUpdate(UPDATE_CITY, ps -> {
            ps.setString(1, entity.getNameCity());
            ps.setInt(2, idChange);
        });
    }

    @Override
    public boolean remove(City entity) {
        CityTransportDao.getCityTransport().deleteDependencyCityAndTransport(entity);
        LOG.debug("Try delete entity = " + entity.getNameCity() + " idEntity = " + entity.getIdCity());
        return createUpdate(DELETE_CITY, ps -> {
            ps.setInt(1, entity.getIdCity());
        });
    }


    private static class CityTransportDao extends CityDao {
        private static final Logger LOG = Logger.getLogger(CityTransportDao.class);
        private static final String ID_TRANSPORT = "idTransport";
        private static final String NAME_TRANSPORT = "name_transport";
        private static final String INSERT_INTO_CITY_AND_TRANSPORT = "INSERT INTO City_and_Transport("
                + ID_CITY + ", "
                + ID_TRANSPORT
                + ") VALUES (?,?)";
        private static final String DELETE_FROM_CITY_AND_TRANSPORT = "DELETE FROM City_and_Transport WHERE " + ID_CITY + " = ?";
        private static final String SELECT_NAME_TRANSPORT_FROM_CITY_AND_TRANSPORT = "SELECT cat.idTransport, name_transport " +
                "FROM City_and_Transport cat " +
                "LEFT JOIN City ON cat.idCity = City.`idCity` " +
                "LEFT JOIN  Transport  ON cat.`idTransport` = Transport.idTransport " +
                "WHERE cat.idCity LIKE ";
        private static final CityTransportDao INSTANCE = new CityTransportDao();

        private CityTransportDao() {
        }

        private static CityTransportDao getCityTransport() {
            return INSTANCE;
        }

        // TODO: 2019-10-24 add to City_and_Transport only already exist Transport in table Transport,
        //  but if transport is missing in table don't add to table City_and_Transport
        private void createDependencyCityAndTransport(City entity) {
            List<Transport> transports = entity.getTransports();
            transports.forEach(transport -> createUpdate(INSERT_INTO_CITY_AND_TRANSPORT, preparedStatement -> {
                preparedStatement.setInt(1, entity.getIdCity());
                preparedStatement.setInt(2, transport.getIdTransport());
            }));
            LOG.debug("Create transport dependency with city = " + entity.getNameCity());
        }

        private void deleteDependencyCityAndTransport(City entity) {
            createUpdate(DELETE_FROM_CITY_AND_TRANSPORT, preparedStatement -> preparedStatement.setInt(1, entity.getIdCity()));
            LOG.debug("Delete transport dependency with city = " + entity.getNameCity());
        }

        private List<Transport> getAllTransportInCurrentCity(int id) {

            List<Transport> allEntity = new TransportDao().getAll(SELECT_NAME_TRANSPORT_FROM_CITY_AND_TRANSPORT + "\"" + id + "\"", resultSet -> new Transport(resultSet.getInt(ID_TRANSPORT), resultSet.getString(NAME_TRANSPORT)));

            LOG.debug("Get all entity size = " + allEntity.size());
            return allEntity;

        }
    }

}
