package edu.eci.cvds.sampleprj.dao.mybatis;
import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.ItemRentado;
import java.sql.Date;

import java.util.List;

public class MyBATISClienteDAO implements ClienteDAO {
    @Inject
    private ClienteMapper clienteMapper;

    @Override
    public Cliente consultarCliente(long id) throws PersistenceException {
        try{
            return clienteMapper.consultarCliente(id);
        }
        catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("no se puede consultar cliente",e);
        }
    }

    @Override
    public List<Cliente> consultarClientes() throws PersistenceException {
        try{
            return clienteMapper.consultarClientes();
        }
        catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("no se puede consultar lista de  clientes",e);
        }
    }

    @Override
    public void registrarCliente(Cliente p) throws PersistenceException{
        try{
            clienteMapper.registrarCliente(p);
        }
        catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("no se puede regitsrar clientes",e);
        }
    }

    @Override
    public List<ItemRentado> consultarItemsCliente(long idcliente) throws PersistenceException {
        try{
           return clienteMapper.consultarItemsCliente(idcliente);
        }catch (Exception e){
            throw new PersistenceException("no se puede consultar los items");
        }
    }

    @Override
    public void vetarCliente(long docu, boolean estado) throws PersistenceException{
        try{
            clienteMapper.vetarCliente(docu,estado);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("no se puede vetar cliente",e);
        }
    }

    @Override
    public void agregarItemRentadoACliente(long idCliente, int idItem, Date fechainicio, Date fechafin) throws PersistenceException {
        try{
            clienteMapper.agregarItemRentadoACliente(idCliente,idItem,fechainicio,fechafin);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al agregar el item" + idItem + " a los items rentados del cliente con id" + idCliente, e);
        }
    }

}
