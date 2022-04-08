package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.ItemRentado;

import java.util.List;

public interface ItemRentadoDAO {
    public List<ItemRentado> load() throws PersistenceException;

    public ItemRentado load(int id) throws PersistenceException;
}
