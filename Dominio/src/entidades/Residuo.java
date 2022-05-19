/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public class Residuo {
    private ObjectId id;
    private String codigo;
    private String nombre;
    private float cantidad;
    private String unidad;
    private List<ObjectId> idsQuimicosConstituyentes;
    private float cantidadAsignada;

    public Residuo() {
    }

    public Residuo(ObjectId id, String codigo, String nombre, List<ObjectId> idsQuimicosConstituyentes) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.idsQuimicosConstituyentes = idsQuimicosConstituyentes;
    }

    public Residuo(String codigo, String nombre, List<ObjectId> idsQuimicosConstituyentes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.idsQuimicosConstituyentes = idsQuimicosConstituyentes;
    }
    
    public Residuo(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<ObjectId> getIdsQuimicosConstituyentes() {
        return idsQuimicosConstituyentes;
    }

    public void setIdsQuimicosConstituyentes(List<ObjectId> idsQuimicosConstituyentes) {
        this.idsQuimicosConstituyentes = idsQuimicosConstituyentes;
    }
    
    public void addIdComponente(ObjectId idQuimicoConstituyente){
        if(this.idsQuimicosConstituyentes == null){
            this.idsQuimicosConstituyentes = new ArrayList<>();
        }
        this.idsQuimicosConstituyentes.add(idQuimicoConstituyente);
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public float getCantidadAsignada() {
        return cantidadAsignada;
    }

    public void setCantidadAsignada(float cantidadAsignada) {
        this.cantidadAsignada = cantidadAsignada;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Residuo other = (Residuo) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
