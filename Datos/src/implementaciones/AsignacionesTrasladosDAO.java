/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.AsignacionTraslado;
import entidades.SolicitudTraslado;
import interfaces.IAsignacionesTrasladosDAO;
import interfaces.IConexionBD;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public class AsignacionesTrasladosDAO implements IAsignacionesTrasladosDAO{

    private MongoDatabase baseDatos;
    
    public AsignacionesTrasladosDAO(MongoDatabase conexion) {
        this.baseDatos = conexion;
    }
    
    private MongoCollection<AsignacionTraslado> getColeccion(){
        return this.baseDatos.getCollection("asignaciones_traslados", AsignacionTraslado.class);
    }
    
    @Override
    public boolean agregarAsignacionTraslado(AsignacionTraslado asignacionTraslado) {
        MongoCollection<AsignacionTraslado> coleccion = this.getColeccion();
        coleccion.insertOne(asignacionTraslado);
        return true;
    }

    @Override
    public List<AsignacionTraslado> asignacionesTrasladosConsultarTodos() {
        Document documento = new Document();
        documento.append("estado", "Pendiente");
        MongoCollection<AsignacionTraslado> coleccion = this.getColeccion();
        List<AsignacionTraslado> listaTraslados = new LinkedList<>();
        coleccion.find(documento).into(listaTraslados);
        return listaTraslados;
    }

    @Override
    public boolean asignacionTrasladoCambiarEstado(ObjectId id, AsignacionTraslado asignacionTraslado) {
        asignacionTraslado.setEstado("Registrado");
        Document documento = new Document();
        documento.append("_id", id);
        MongoCollection<AsignacionTraslado> coleccion = this.getColeccion();
        coleccion.findOneAndReplace(documento, asignacionTraslado);
        return true;
    }

    
}
