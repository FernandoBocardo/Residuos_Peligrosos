/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public class EmpresaTransportadora {
    
    private ObjectId id;
    private String nombre;
    private List<Residuo> residuosAsignados;

    public EmpresaTransportadora() {
    }

    public EmpresaTransportadora(ObjectId id, String nombre, List<Residuo> residuosAsignados) {
        this.id = id;
        this.nombre = nombre;
        this.residuosAsignados = residuosAsignados;
    }

    public EmpresaTransportadora(String nombre, List<Residuo> residuosAsignados) {
        this.nombre = nombre;
        this.residuosAsignados = residuosAsignados;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Residuo> getResiduosAsignados() {
        return residuosAsignados;
    }

    public void setResiduosAsignados(List<Residuo> residuosAsignados) {
        this.residuosAsignados = residuosAsignados;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final EmpresaTransportadora other = (EmpresaTransportadora) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
