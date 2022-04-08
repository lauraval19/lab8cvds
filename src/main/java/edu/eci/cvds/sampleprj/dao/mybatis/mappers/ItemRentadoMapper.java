/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.ItemRentado;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.samples.entities.Item;
import java.util.List;

/**
 *
 * @author Jaime Castro -Laura Alvarado
 */
public interface ItemRentadoMapper {

    public ItemRentado consultarItemRentado(int id);

    public List<ItemRentado> consultarItemsRentados();

    public void insertarItem(@Param("item") Item it);

    public void actualizarTarifaItem(@Param("Iditem") int id, @Param("itemTarifa") long tarifa);
}
