/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Productor;
import interfaces.IConexionBD;
import interfaces.IProductoresDAO;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public class ProductoresDAO implements IProductoresDAO{

    private MongoDatabase baseDatos;
    
    public ProductoresDAO(MongoDatabase conexion) {
        this.baseDatos = conexion;
    }
    
    private MongoCollection<Productor> getColeccion(){
        return this.baseDatos.getCollection("productores", Productor.class);
    }
    
    @Override
    public boolean agregarProductor(Productor productor) {
        MongoCollection<Productor> coleccion = this.getColeccion();
        coleccion.insertOne(productor);
        return true;
    }

    @Override
    public List<Productor> productoresConsultarTodos() {
        MongoCollection<Productor> coleccion = this.getColeccion();
        List<Productor> listaProductores = new LinkedList<>();
        coleccion.find().into(listaProductores);
        return listaProductores;
    }

    @Override
    public Productor productorConsultarUsuario(String usuario) {
        MongoCollection<Productor> coleccion = this.getColeccion();
        List<Document> etapas = new ArrayList<>();
        etapas.add(new Document()
            .append("$match", new Document()
                .append("usuario", usuario)));
        List<Productor> productores = new LinkedList<>();
        coleccion.aggregate(etapas).into(productores);
        if (productores.isEmpty())
        {
            return null;
        }
        return productores.get(0);
    }

    @Override
    public Productor productorConsultarId(ObjectId id) {
        MongoCollection<Productor> coleccion = this.getColeccion();
        List<Document> etapas = new ArrayList<>();
        etapas.add(new Document()
            .append("$match", new Document()
                .append("_id", id)));
        List<Productor> productores = new LinkedList<>();
        coleccion.aggregate(etapas).into(productores);
        if (productores.isEmpty())
        {
            return null;
        }
        return productores.get(0);
    }
    
}
