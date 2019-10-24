package org.courses.tour.dao;

import org.apache.log4j.Logger;
import org.courses.tour.entity.FoodType;

import java.util.List;

public class FoodTypeDao extends AbstractDao<FoodType> {
    private static final Logger LOG = Logger.getLogger(FoodTypeDao.class);
    private static final String ID_FOOD_TYPE = "idFood_type";
    private static final String NAME_FOOD_TYPE = "name_food_type";
    private static final String COEFICIENT = "coeficient";
    private static final String SELECT_FROM = "SELECT * FROM Food_type";
    private static final String INSERT_INTO = "INSERT INTO Food_type("
            + NAME_FOOD_TYPE + ", " + COEFICIENT + ") VALUES (?,?)";

    private static final String DELETE_FOOD_TYPE = "DELETE FROM Food_type WHERE "
            + ID_FOOD_TYPE + " = ?";

    private static final String SELECT_WHERE_ID = "SELECT * FROM Food_type WHERE "
            + ID_FOOD_TYPE + " LIKE ?";

    private static final String UPDATE_FOOD_TYPE = "UPDATE Food_type SET "
            + NAME_FOOD_TYPE + " = ?"
            + COEFICIENT + " = ? WHERE "
            + ID_FOOD_TYPE + " = ?";


    @Override
    public List<FoodType> getAll() {
        List<FoodType> allEntity = getAll(SELECT_FROM, resultSet -> new FoodType(resultSet.getInt(ID_FOOD_TYPE), resultSet.getString(NAME_FOOD_TYPE), resultSet.getDouble(COEFICIENT)));
        LOG.debug("Get all FoodType size = " + allEntity.size());
        return allEntity;
    }

    @Override
    public boolean create(FoodType entity) {
        LOG.debug("Try create entity = " + entity.getName() + " idEntity = " + entity.getIdFoodType());
        return createUpdate(INSERT_INTO, preparedStatement -> {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setDouble(2, entity.getCoeficient());
        });
    }

    @Override
    public boolean update(int idChange, FoodType entity) {
        LOG.debug("Try update entity = " + entity.getName() + " idEntity = " + entity.getIdFoodType() + " where id =" + idChange);
        return createUpdate(UPDATE_FOOD_TYPE, ps -> {
            ps.setString(1, entity.getName());
            ps.setDouble(2, entity.getCoeficient());
            ps.setInt(3, idChange);
        });
    }

    @Override
    public boolean remove(FoodType entity) {
        LOG.debug("Try delete entity = " + entity.getName() + " idEntity = " + entity.getIdFoodType());
        return createUpdate(DELETE_FOOD_TYPE, preparedStatement -> preparedStatement.setInt(1, entity.getIdFoodType()));
    }

    public FoodType getFoodTypeById(int id) {
        FoodType foodType = getEntityWithCondition(SELECT_WHERE_ID, ps -> {
            ps.setInt(1, id);
        }, resultSet -> new FoodType(resultSet.getInt(ID_FOOD_TYPE), resultSet.getString(NAME_FOOD_TYPE), resultSet.getDouble(COEFICIENT)));
        LOG.debug("Get FoodType with name = " + foodType.getName() + " and id = " + foodType.getIdFoodType());
        return foodType;

    }
}
