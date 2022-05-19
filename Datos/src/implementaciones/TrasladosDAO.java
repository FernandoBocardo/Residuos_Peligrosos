/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Traslado;
import interfaces.IConexionBD;
import interfaces.ITrasladosDAO;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public class TrasladosDAO implements ITrasladosDAO{

    private MongoDatabase baseDatos;
    
    public TrasladosDAO(MongoDatabase conexion) {
        this.baseDatos = conexion;
    }
    
    private MongoCollection<Traslado> getColeccion(){
        return this.baseDatos.getCollection("traslados", Traslado.class);
    }
    
    @Override
    public boolean agregarTraslado(Traslado traslado) {
        MongoCollection<Traslado> coleccion = this.getColeccion();
        coleccion.insertOne(traslado);
        return true;
    }

    @Override
    public List<Traslado> trasladosConsultarTodos() {
        MongoCollection<Traslado> coleccion = this.getColeccion();
        List<Traslado> listaTraslados = new LinkedList<>();
        coleccion.find().into(listaTraslados);
        return listaTraslados;
    }

    @Override
    public Traslado trasladoConsultarId(ObjectId id) {
        MongoCollection<Traslado> coleccion = this.getColeccion();
        List<Document> etapas = new ArrayList<>();
        etapas.add(new Document()
            .append("$match", new Document()
                .append("_id", id)));
        List<Traslado> traslados = new LinkedList<>();
        coleccion.aggregate(etapas).into(traslados);
        if (traslados.isEmpty())
        {
            return null;
        }
        return traslados.get(0);
    }
    
}
