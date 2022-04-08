package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.TipoItem;
import java.util.List;

public interface TipoItemDAO {

    public TipoItem consultarTipoItem(int id) throws PersistenceException;

    public List<TipoItem> consultarTiposItem() throws PersistenceException;

    public void save(TipoItem it) throws PersistenceException, edu.eci.cvds.sampleprj.dao.PersistenceException;

}
