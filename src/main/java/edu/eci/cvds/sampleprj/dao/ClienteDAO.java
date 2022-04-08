package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.ItemRentado;

import java.util.List;

public interface ClienteDAO {

    public Cliente consultarCliente(long id) throws PersistenceException;

    public List<Cliente> consultarClientes() throws PersistenceException;

    public void registrarCliente(Cliente p) throws PersistenceException;

    public List<ItemRentado> consultarItemsCliente(long idcliente) throws PersistenceException;

    void agregarItemRentadoACliente(long idCliente, int idItem, java.sql.Date fechainicio, java.sql.Date fechafin) throws edu.eci.cvds.sampleprj.dao.PersistenceException;

    void vetarCliente(long docu, boolean estado) throws PersistenceException;
}
