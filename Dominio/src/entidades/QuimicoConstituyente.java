/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public class QuimicoConstituyente {
    private ObjectId id;
    private String nombre;

    public QuimicoConstituyente() {
    }

    public QuimicoConstituyente(ObjectId id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public QuimicoConstituyente(String nombre) {
        this.nombre = nombre;
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

    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final QuimicoConstituyente other = (QuimicoConstituyente) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Quimicos{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
    
}
