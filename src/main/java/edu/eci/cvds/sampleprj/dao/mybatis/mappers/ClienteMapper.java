package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.ItemRentado;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Cliente;
//import sun.util.resources.cldr.ext.LocaleNames_en_GB;

/**
 *
 * @author Jaime Castro - Laura Alvarado
 */
public interface ClienteMapper {

    public Cliente consultarCliente(long id);

    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param id
     * @param idit
     * @param fechainicio
     * @param fechafin
     */
    public void agregarItemRentadoACliente(@Param("idcli") long id,
                                           @Param("iditr")int idit,
                                           @Param("fini")Date fechainicio,
                                           @Param("ffin")Date fechafin);

    /**
     * Registrar un cliente
     * @param Cliente a registrar
     */
    public void registrarCliente(Cliente p);

    /**
     * consultar items rentados del cliente
     * @param idcliente id del cliente
     * @return Items rentados del cliente correspondiente
     */
    public List<ItemRentado> consultarItemsCliente(long idcliente) ;



    /**
     * Consultar todos los clientes
     * @return
     */
    public List<Cliente> consultarClientes();

    /**
     * veta un cliente
     * @param docu documento del cliente
     * @param estado estado del cliente
     */
    void vetarCliente(long docu, boolean estado);
}

