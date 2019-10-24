package org.courses.tour.dao;

import java.util.List;

public interface EntityDao<T> {
    List<T> getAll();

    boolean create(T entity);

    boolean update(int idChange, T entity);

    boolean remove(T entity);
}
