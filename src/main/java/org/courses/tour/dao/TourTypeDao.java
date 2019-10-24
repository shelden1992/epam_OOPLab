package org.courses.tour.dao;

import org.apache.log4j.Logger;
import org.courses.tour.entity.City;
import org.courses.tour.entity.TourType;

import java.util.List;

public class TourTypeDao extends AbstractDao<TourType> {
    private static final Logger LOG = Logger.getLogger(TourTypeDao.class);
    private static final String ID_TOUR = "idTour";
    private static final String NAME_TOUR = "name_tour";
    private static final String DAYS = "days";
    private static final String PRICE = "price";
    private static final String ID_FOOD_TYPE = "idFood_type";
    private static final String ID_TRANSPORT = "idTransport";
    private static final String SELECT_FROM_CITY = "SELECT * FROM Tour_type";
    private static final String INSERT_INTO = "INSERT INTO Tour_type("
            + ID_TOUR + ", "
            + NAME_TOUR + ", "
            + DAYS + ", "
            + PRICE + ", "
            + ID_FOOD_TYPE + ", "
            + ID_TRANSPORT
            + ") VALUES (?,?,?,?,?,?)";
    private static final String DELETE_TOUR = "DELETE FROM Tour_type " +
            "WHERE " + ID_TOUR + " =?";
    private static final String UPDATE_TOUR = "UPDATE Tour_type SET "
            + NAME_TOUR + "= ?, "
            + DAYS + "= ?, "
            + PRICE + "= ?, "
            + ID_FOOD_TYPE + "= ?, "
            + ID_TRANSPORT + "= ? " +
            "WHERE " + ID_TOUR + " = ?";


    @Override
    public List<TourType> getAll() {
        List<TourType> allTours = getAll(SELECT_FROM_CITY, resultSet ->
                new TourType(resultSet.getInt(ID_TOUR),
                        resultSet.getString(NAME_TOUR),
                        resultSet.getInt(DAYS),
                        resultSet.getDouble(PRICE),
                        new FoodTypeDao().getFoodTypeById(resultSet.getInt(ID_FOOD_TYPE)),
                        new TransportDao().getTransportById(resultSet.getInt(ID_TRANSPORT)),
                        new CityDao().getListCityByIdTour(resultSet.getInt(ID_TOUR))));
        LOG.debug("Get all Tour size = " + allTours.size());
        return allTours;
    }

    @Override
    public boolean create(TourType entity) {
        LOG.debug("Try create entity = " + entity.getNameTour() + " idEntity = " + entity.getIdTour());
        boolean update = createUpdate(INSERT_INTO, ps -> {
            ps.setInt(1, entity.getIdTour());
            ps.setString(2, entity.getNameTour());
            ps.setInt(3, entity.getDays());
            ps.setDouble(4, entity.getPrice());
            ps.setInt(5, entity.getFoodType().getIdFoodType());
            ps.setInt(6, entity.getTransport().getIdTransport());

        });
        TourTypeAndCityDao.getTourTypeAndCity().createDependencyTourAndCity(entity);
        return update;
    }

    @Override
    public boolean update(int idChange, TourType entity) {
        LOG.debug("Try update entity = " + entity.getNameTour() + " idEntity = " + entity.getIdTour() + " where id =" + idChange);
        return createUpdate(UPDATE_TOUR, ps -> {
            ps.setString(1, entity.getNameTour());
            ps.setInt(2, entity.getDays());
            ps.setDouble(3, entity.getPrice());
            ps.setInt(4, entity.getFoodType().getIdFoodType());
            ps.setInt(5, entity.getTransport().getIdTransport());
            ps.setInt(6, idChange);
        });
    }

    @Override
    public boolean remove(TourType entity) {
        TourTypeAndCityDao.getTourTypeAndCity().deleteDependencyTourAndCity(entity);
        LOG.debug("Try delete entity = " + entity.getNameTour() + " idEntity = " + entity.getIdTour());
        return createUpdate(DELETE_TOUR, ps -> {
            ps.setInt(1, entity.getIdTour());
        });
    }

    private static class TourTypeAndCityDao extends TourTypeDao {
        private static final Logger LOG = Logger.getLogger(TourTypeAndCityDao.class);
        private static final TourTypeAndCityDao INSTANCE = new TourTypeAndCityDao();
        private static final String NAME_CITY = "name_city";
        private static final String ID_CITY = "idCity";
        private static final String INSERT_INTO_TOUR_TYPE_AND_CITY = "INSERT INTO Tour_type_and_city(" +
                ID_TOUR + ", "
                + ID_CITY + ") VALUES (?,?)";
        private static final String DELETE_FROM_TOUR_TYPE_AND_CITY =
                "DELETE FROM Tour_type_and_city WHERE " + ID_TOUR + " =?";


        private TourTypeAndCityDao() {
        }

        private static TourTypeAndCityDao getTourTypeAndCity() {
            return INSTANCE;
        }

        // TODO: 2019-10-24 add to Tour_type_and_city only already exist city in table City,
        //  but if city is missing in table don't add to table Tour_type_and_city
        private void createDependencyTourAndCity(TourType entity) {
            List<City> cities = entity.getCities();
            cities.forEach(city -> createUpdate(INSERT_INTO_TOUR_TYPE_AND_CITY, preparedStatement -> {
                preparedStatement.setInt(1, entity.getIdTour());
                preparedStatement.setInt(2, city.getIdCity());
            }));
            LOG.debug("Create city dependency with tour = " + entity.getNameTour());

        }

        private void deleteDependencyTourAndCity(TourType entity) {
            createUpdate(DELETE_FROM_TOUR_TYPE_AND_CITY, preparedStatement -> preparedStatement.setInt(1, entity.getIdTour()));
            LOG.debug("Delete city dependency with tour = " + entity.getNameTour());
        }

    }


}


