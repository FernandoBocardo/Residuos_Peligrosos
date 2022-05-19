/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.AsignacionTraslado;
import entidades.SolicitudTraslado;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public interface IAsignacionesTrasladosDAO {
    boolean agregarAsignacionTraslado(AsignacionTraslado asignacionTraslado);
    List<AsignacionTraslado> asignacionesTrasladosConsultarTodos();
    boolean asignacionTrasladoCambiarEstado(ObjectId id, AsignacionTraslado asignacionTraslado);
}
