package models.daos.jdbc;

import java.util.List;

import models.daos.TemaDao;
import models.entities.Tema;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TemaDaoJdbc extends GenericDaoJdbc<Tema, Integer> implements TemaDao {
    private Logger log = LogManager.getLogger(TemaDaoJdbc.class);

    private Tema create(ResultSet resultSet) {
        try {
            if (resultSet != null && resultSet.next()) {
                return new Tema(resultSet.getString(Tema.NOMBRE),
                        resultSet.getString(Tema.PREGUNTA));
            }
        } catch (SQLException e) {
            log.error("read: " + e.getMessage());
        }
        return null;
    }

    private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL, %s VARCHAR(255), "
            + "%s VARCHAR(255), PRIMARY KEY (%s))";

    public static String sqlToCreateTable() {
        return String.format(SQL_CREATE_TABLE, Tema.TABLE, Tema.ID, Tema.PREGUNTA, Tema.NOMBRE,
                Tema.ID);
    }

    private static final String SQL_INSERT = "INSERT INTO %s (%s,%s,%s) VALUES (%d,'%s','%s')";

    @Override
    public void create(Tema tema) {
        this.updateSql(String.format(SQL_INSERT, Tema.TABLE, Tema.PREGUNTA, Tema.NOMBRE,
                tema.getPregunta(), tema.getNombre()));
    }

    @Override
    public Tema read(Integer id) {
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ID, Tema.TABLE, id));
        return this.create(resultSet);
    }

    private static final String SQL_UPDATE = "UPDATE %s SET %s='%s', %s='%s' WHERE ID=%d";

    @Override
    public void update(Tema tema) {
        this.updateSql(String.format(SQL_UPDATE, Tema.TABLE, Tema.NOMBRE, tema.getNombre(),
                Tema.PREGUNTA, tema.getPregunta()));
    }

    @Override
    public void deleteById(Integer id) {
        this.updateSql(String.format(SQL_DELETE_ID, Tema.TABLE, id));
    }

    @Override
    public List<Tema> findAll() {
        List<Tema> list = new ArrayList<Tema>();
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ALL, Tema.TABLE));
        Tema category = this.create(resultSet);
        while (category != null) {
            list.add(category);
            category = this.create(resultSet);
        }
        return list;
    }

}
