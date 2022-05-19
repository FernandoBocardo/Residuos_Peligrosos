/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Vehiculo;
import interfaces.IConexionBD;
import interfaces.IVehiculosDAO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public class VehiculosDAO implements IVehiculosDAO{

    private MongoDatabase baseDatos;
    
    public VehiculosDAO(MongoDatabase conexion) {
        this.baseDatos = conexion;
    }
    
    private MongoCollection<Vehiculo> getColeccion(){
        return this.baseDatos.getCollection("vehiculos", Vehiculo.class);
    }
    
    @Override
    public boolean agregarVehiculo(Vehiculo vehiculo) {
        MongoCollection<Vehiculo> coleccion = this.getColeccion();
        coleccion.insertOne(vehiculo);
        return true;
    }

    @Override
    public List<Vehiculo> vehiculosConsultarTodos() {
        MongoCollection<Vehiculo> coleccion = this.getColeccion();
        List<Vehiculo> listaVehiculos = new LinkedList<>();
        coleccion.find().into(listaVehiculos);
        return listaVehiculos;
    }
    
}
