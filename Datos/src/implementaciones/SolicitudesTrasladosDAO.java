/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.SolicitudTraslado;
import interfaces.IConexionBD;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import interfaces.ISolicitudesTrasladosDAO;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public class SolicitudesTrasladosDAO implements ISolicitudesTrasladosDAO{
    
    private MongoDatabase baseDatos;
    
    public SolicitudesTrasladosDAO(MongoDatabase conexion) {
        this.baseDatos = conexion;
    }
    
    private MongoCollection<SolicitudTraslado> getColeccion(){
        return this.baseDatos.getCollection("solicitudes_traslados", SolicitudTraslado.class);
    }

    @Override
    public boolean agregarSolicitudTraslado(SolicitudTraslado solicitudTraslado) {
        MongoCollection<SolicitudTraslado> coleccion = this.getColeccion();
        coleccion.insertOne(solicitudTraslado);
        return true;
    }
    
    @Override
    public boolean actualizarSolicitudTraslado(SolicitudTraslado solicitudTrasladoAntiguo, SolicitudTraslado solicitudTrasladoNueva) {
        MongoCollection<SolicitudTraslado> coleccion = this.getColeccion();
        Document documento = new Document();
        documento.append("_id", solicitudTrasladoAntiguo.getId());
        coleccion.findOneAndReplace(documento, solicitudTrasladoNueva);
        return true;
    }

    @Override
    public List<SolicitudTraslado> solicitudesTrasladosConsultarTodos() {
        MongoCollection<SolicitudTraslado> coleccion = this.getColeccion();
        List<SolicitudTraslado> listaTraslados = new LinkedList<>();
        coleccion.find().into(listaTraslados);
        return listaTraslados;

    }

    @Override
    public List<SolicitudTraslado> solicitudesTrasladosConsultarFecha(String fecha) {
        MongoCollection<SolicitudTraslado> coleccion = this.getColeccion();
        List<Document> etapas = new ArrayList<>();
        etapas.add(new Document()
            .append("$match", new Document()
                .append("fechaTraslado", fecha)));
        List<SolicitudTraslado> traslados = new LinkedList<>();
        coleccion.aggregate(etapas).into(traslados);
        if (traslados.isEmpty())
        {
            return null;
        }
        return traslados;
    }
    
    @Override
    public boolean solicitudTrasladoVerificarTrasladoProductorFechaResiduos(SolicitudTraslado traslado) {
        MongoCollection<SolicitudTraslado> coleccion = this.getColeccion();
        List<Document> etapas = new ArrayList<>();
        etapas.add(new Document()
            .append("$match", new Document()
                .append("idProductor", traslado.getIdProductor())
                .append("fechaTraslado", traslado.getFechaTraslado())
                .append("residuosTransportados", traslado.getResiduosTransportados())));
        List<SolicitudTraslado> traslados = new LinkedList<>();
        coleccion.aggregate(etapas).into(traslados);
        if (traslados.isEmpty())
        {
            //No hay 
            return true;
        }
        //Si hay
        return false;
    }

    @Override
    public SolicitudTraslado solicitudTrasladoConsultarId(ObjectId id) {
        MongoCollection<SolicitudTraslado> coleccion = this.getColeccion();
        List<Document> etapas = new ArrayList<>();
        etapas.add(new Document()
            .append("$match", new Document()
                .append("_id", id)));
        List<SolicitudTraslado> traslados = new LinkedList<>();
        coleccion.aggregate(etapas).into(traslados);
        if (traslados.isEmpty())
        {
            return null;
        }
        return traslados.get(0);
    }
    
}
