/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.SolicitudTraslado;
import java.util.Calendar;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public interface ISolicitudesTrasladosDAO {
    boolean agregarSolicitudTraslado(SolicitudTraslado solicitudTraslado);
    boolean actualizarSolicitudTraslado(SolicitudTraslado solicitudTrasladoAntigua, SolicitudTraslado solicitudTrasladoNueva);
    List<SolicitudTraslado> solicitudesTrasladosConsultarTodos();
    List<SolicitudTraslado> solicitudesTrasladosConsultarFecha(String fecha);
    SolicitudTraslado solicitudTrasladoConsultarId(ObjectId id);
    boolean solicitudTrasladoVerificarTrasladoProductorFechaResiduos(SolicitudTraslado traslado);
}
