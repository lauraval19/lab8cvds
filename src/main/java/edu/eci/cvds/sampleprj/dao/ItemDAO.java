package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Item;
import java.util.List;

public interface ItemDAO {

    public void save(Item it) throws PersistenceException;

    public Item load(int id) throws PersistenceException;

    List<Item> consultarItemsDisponibles() throws edu.eci.cvds.sampleprj.dao.PersistenceException;

    public void actualizarTarifaItem(int id, long tarifa) throws PersistenceException, edu.eci.cvds.sampleprj.dao.PersistenceException;

}
