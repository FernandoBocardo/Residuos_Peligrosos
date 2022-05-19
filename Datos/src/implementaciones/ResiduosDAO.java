/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Residuo;
import interfaces.IConexionBD;
import interfaces.IResiduosDAO;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public class ResiduosDAO implements IResiduosDAO{
    
    private MongoDatabase baseDatos;
    
    public ResiduosDAO(MongoDatabase conexion) {
        this.baseDatos = conexion;
    }
    
    private MongoCollection<Residuo> getColeccion(){
        return this.baseDatos.getCollection("residuos", Residuo.class);
    }

    @Override
    public boolean agregarResiduo(Residuo residuo) {
        MongoCollection<Residuo> coleccion = this.getColeccion();
        coleccion.insertOne(residuo);
        return true;
    }

    @Override
    public List<Residuo> residuosConsultarTodos() {
        MongoCollection<Residuo> coleccion = this.getColeccion();
        List<Residuo> listaResiduos = new LinkedList<>();
        coleccion.find().into(listaResiduos);
        return listaResiduos;
    }

    @Override
    public Residuo residuoConsultarNombre(String nombreResiduo) {
        MongoCollection<Residuo> coleccion = this.getColeccion();
        List<Document> etapas = new ArrayList<>();
        etapas.add(new Document()
            .append("$match", new Document()
                .append("nombre", nombreResiduo)));
        List<Residuo> residuos = new LinkedList<>();
        coleccion.aggregate(etapas).into(residuos);
        if (residuos.isEmpty())
        {
            return null;
        }
        return residuos.get(0);
    }

    @Override
    public Residuo residuoConsultarCodigo(String codigoResiduo) {
        MongoCollection<Residuo> coleccion = this.getColeccion();
        List<Document> etapas = new ArrayList<>();
        etapas.add(new Document()
            .append("$match", new Document()
                .append("codigo", codigoResiduo)));
        List<Residuo> residuos = new LinkedList<>();
        coleccion.aggregate(etapas).into(residuos);
        if (residuos.isEmpty())
        {
            return null;
        }
        return residuos.get(0);
    }

    @Override
    public Residuo residuoConsultarComponentes(List<ObjectId> componentesResiduo) {
        MongoCollection<Residuo> coleccion = this.getColeccion();
        List<Document> etapas = new ArrayList<>();
        etapas.add(new Document()
            .append("$match", new Document()
                .append("idsQuimicosConstituyentes", componentesResiduo)));
        List<Residuo> residuos = new LinkedList<>();
        coleccion.aggregate(etapas).into(residuos);
        if (residuos.isEmpty())
        {
            return null;
        }
        return residuos.get(0);
    }
    
}
