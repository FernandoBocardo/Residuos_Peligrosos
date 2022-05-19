/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Residuo;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public interface IResiduosDAO {
    boolean agregarResiduo(Residuo residuo);
    List<Residuo> residuosConsultarTodos();
    Residuo residuoConsultarNombre(String nombre);
    Residuo residuoConsultarCodigo(String codigo);
    Residuo residuoConsultarComponentes(List<ObjectId> componentes);
}
