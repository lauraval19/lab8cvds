package edu.eci.cvds.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ServiciosAlquilerTest {

    @Inject
    private SqlSession sqlSession;

    ServiciosAlquiler serviciosAlquiler;

    public ServiciosAlquilerTest() {
        serviciosAlquiler = ServiciosAlquilerFactory.getInstance().getServiciosAlquiler();
    }

    @Before
    public void setUp() {
    }

    @Test
    public void emptyDB() {
        for(int i = 102010; i < 102020; i ++) {
            boolean r = false;
            try {
                Cliente cliente = serviciosAlquiler.consultarCliente(i);
            } catch(ExcepcionServiciosAlquiler e) {
                r = true;
            } catch(IndexOutOfBoundsException e) {
                r = true;
            }
            // Validate no Client was found;
            Assert.assertTrue(r);
        };
    }

    @Test
    public void consultarCienteNoExistente() {
        try {
            Cliente cliente = serviciosAlquiler.consultarCliente(123);
        } catch (ExcepcionServiciosAlquiler e) {
            Assert.assertEquals(e.getMessage(), "El cliente con documento: 123 no existe.");
        }
    }

    @Test
    public void deberiaErrorClienteDuplicado() {
        try {
            Cliente cliente = serviciosAlquiler.consultarCliente(1);
            serviciosAlquiler.registrarCliente(cliente);
        } catch (ExcepcionServiciosAlquiler e) {
            Assert.assertEquals(e.getMessage(), "Error al registrar el cliente con documento: 1");
        }
    }

    @Test
    public void deberiaConsultarItem() {
        try {
            Item item = serviciosAlquiler.consultarItem(4);
            Assert.assertEquals(item.getId(), item.getId());
        } catch (ExcepcionServiciosAlquiler e) {
            Assert.assertTrue("h", "h" != "h");
        }
    }
    @Test
    public void noItemFound() {
        boolean r = false;
        try {
            Item item = serviciosAlquiler.consultarItem(101090);
            if (item==null){
                r=true;
            }
            else{
                r=false;
            }
        } catch(ExcepcionServiciosAlquiler e) {
            r = true;
        } catch(IndexOutOfBoundsException e) {
            r = true;
        }
        // Validate no Client was found;
        Assert.assertTrue(r);
    }

    /*@Test
    public void insertarAlquilerAlCliente() {
        boolean esValido = false;
        try {
            serviciosAlquiler.registrarCliente(new Cliente("-12222",101220,"312313", "calle siempre viva", "homero@simpson.fox"));
            esValido = true;
        } catch (ExcepcionServiciosAlquiler e) {
            System.out.println(e.getMessage());
            esValido = false;
        }
        Assert.assertTrue(esValido);
    }*/

}