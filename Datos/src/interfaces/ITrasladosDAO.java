/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Traslado;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public interface ITrasladosDAO {
    boolean agregarTraslado(Traslado traslado);
    List<Traslado> trasladosConsultarTodos();
    Traslado trasladoConsultarId(ObjectId id);
}
