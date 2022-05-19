/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

import com.mongodb.client.MongoDatabase;
import implementaciones.ConexionBD;
import interfaces.IConexionBD;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public class Singleton{
    
    private static MongoDatabase instancia; 
    
    private Singleton() {} // private constructor with external access protection
	
    public static MongoDatabase getInstancia() 
    { 
	if (instancia == null) 
        { 
            instancia = new ConexionBD().crearConexion();
	}
        return instancia;
    }
}
