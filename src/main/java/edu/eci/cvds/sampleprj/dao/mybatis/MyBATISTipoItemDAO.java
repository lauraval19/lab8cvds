package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;

public class MyBATISTipoItemDAO implements TipoItemDAO {

    @Inject
    private TipoItemMapper tipoItemMapper;

    @Override
    public TipoItem consultarTipoItem(int id) throws PersistenceException {
        try {
            return tipoItemMapper.getTipoItem(id);
        } catch (Exception e) {
            throw new PersistenceException("No se encuentra el ID del tipo del item");
        }
    }

    @Override
    public List<TipoItem> consultarTiposItem() throws PersistenceException {
        try {
            return tipoItemMapper.consultarTiposItems();
        } catch (Exception e) {
            throw new PersistenceException("No se encuentra el ID del tipo del item");
        }
    }

    @Override
    public void save(TipoItem tipoitem) throws PersistenceException {
        try {
            tipoItemMapper.addTipoItem(tipoitem);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al registrar el tipo de item:" + tipoitem.toString(), e);
        }

    }
}
