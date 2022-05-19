/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Vehiculo;
import java.util.List;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public interface IVehiculosDAO {
    boolean agregarVehiculo(Vehiculo vehiculo);
    List<Vehiculo> vehiculosConsultarTodos();
}
