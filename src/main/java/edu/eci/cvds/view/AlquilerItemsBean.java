package edu.eci.cvds.view;
import javax.faces.bean.ManagedBean;

import edu.eci.cvds.samples.entities.Cliente;
import com.google.inject.Inject;

import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;

import java.sql.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;


@ManagedBean(name="AlquilerItemsBean")
@ApplicationScoped
public class AlquilerItemsBean extends BasePageBean{

    @Inject
    private ServiciosAlquiler serviciosAlquiler;

    private Cliente clienteSeleccionado;

    public List<Cliente> consultarClientes(){
        List<Cliente> clientes = null;
        try {
            clientes = serviciosAlquiler.consultarClientes();
            return  clientes;
        } catch (ExcepcionServiciosAlquiler e) {
            e.printStackTrace();
        }
        return clientes;
    }
    /**
     * Retorna el cliente que ha sido seleccionado.
     * @return clienteSeleccionado.
     */
    public Cliente getClienteSeleccionado() {
        return clienteSeleccionado;
    }
    /**
     * Actualiza el cliente que ha sido seleccionado.
     * @param clienteSeleccionado - nuevo cliente seleccionado.
     */
    public void setClienteSeleccionado(Cliente clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
    }

    /**
     * Calcula la multa que tiene un cliente para un item específico.
     * @param idItem - ID del item a calcular la multa
     */
    public long getMultaCliente(int idItem) {
        long multa = 0;
        try {
            multa = serviciosAlquiler.consultarMultaAlquiler(idItem, new Date(System.currentTimeMillis()));
        } catch (ExcepcionServiciosAlquiler e) {
            e.printStackTrace();
        }
        return multa;
    }
    /**
     *
     */
    public void registrarCliente(long documento,String nombre, String telefono, String direccion, String email) {
        Cliente clienteNuevo = new Cliente(documento,nombre,telefono,direccion,email);
        try {
            serviciosAlquiler.registrarCliente(clienteNuevo);
        } catch (ExcepcionServiciosAlquiler e) {
            e.printStackTrace();
        }
    }
}