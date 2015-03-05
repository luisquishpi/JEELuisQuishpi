package models.daos.jpa;

import java.util.List;

import models.daos.GenericDao;

public class GenericDaoJpa<T, ID> implements GenericDao<T, ID> {

    @Override
    public void create(T entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public T read(ID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(T entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(ID id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<T> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

}
