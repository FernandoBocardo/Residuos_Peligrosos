/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.QuimicoConstituyente;
import interfaces.IConexionBD;
import interfaces.IQuimicosConstituyentesDAO;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public class QuimicosConstituyentesDAO implements IQuimicosConstituyentesDAO{
    
    private MongoDatabase baseDatos;
    
    public QuimicosConstituyentesDAO(MongoDatabase conexion) {
        this.baseDatos = conexion;
    }
    
    private MongoCollection<QuimicoConstituyente> getColeccion(){
        return this.baseDatos.getCollection("quimicos_constituyentes", QuimicoConstituyente.class);
    }
    
    @Override
    public boolean agregarQuimicoConstituyente(QuimicoConstituyente quimico) {
        
        MongoCollection<QuimicoConstituyente> coleccion = this.getColeccion();
        coleccion.insertOne(quimico);
        return true;
    }

    @Override
    public List<QuimicoConstituyente> quimicosConsultarTodos() {
        
        MongoCollection<QuimicoConstituyente> coleccion = this.getColeccion();
        List<QuimicoConstituyente> listaQuimicos = new LinkedList<>();
        coleccion.find().into(listaQuimicos);
        return listaQuimicos;
    }

    @Override
    public QuimicoConstituyente quimicoConsultarNombre(String nombreQuimico) {
        MongoCollection<QuimicoConstituyente> coleccion = this.getColeccion();
        List<Document> etapas = new ArrayList<>();
        etapas.add(new Document()
            .append("$match", new Document()
                .append("nombre", nombreQuimico)));
        List<QuimicoConstituyente> quimicos = new LinkedList<>();
        coleccion.aggregate(etapas).into(quimicos);
        return quimicos.get(0);
    }

    
    
}
