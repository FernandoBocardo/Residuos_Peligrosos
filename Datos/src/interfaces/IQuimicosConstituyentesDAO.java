/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.QuimicoConstituyente;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public interface IQuimicosConstituyentesDAO {
    boolean agregarQuimicoConstituyente(QuimicoConstituyente quimicoConstituyente);
    List<QuimicoConstituyente> quimicosConsultarTodos();
    QuimicoConstituyente quimicoConsultarNombre(String nombre);
}
