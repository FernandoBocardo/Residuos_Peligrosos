/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.EmpresaTransportadora;
import interfaces.IConexionBD;
import interfaces.IEmpresasDAO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public class EmpresasDAO implements IEmpresasDAO{
    
    private MongoDatabase baseDatos;
    
    public EmpresasDAO(MongoDatabase conexion) {
        this.baseDatos = conexion;
    }
    
    private MongoCollection<EmpresaTransportadora> getColeccion(){
        return this.baseDatos.getCollection("empresas", EmpresaTransportadora.class);
    }

    @Override
    public boolean agregarEmpresa(EmpresaTransportadora empresaTransportadora) {
        MongoCollection<EmpresaTransportadora> coleccion = this.getColeccion();
        coleccion.insertOne(empresaTransportadora);
        return true;
    }

    @Override
    public List<EmpresaTransportadora> empresasConsultarTodos() {
        MongoCollection<EmpresaTransportadora> coleccion = this.getColeccion();
        List<EmpresaTransportadora> listaEmpresas = new LinkedList<>();
        coleccion.find().into(listaEmpresas);
        return listaEmpresas;
    }
    
}
