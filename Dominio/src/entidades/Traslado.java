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
public class Traslado {
    
    private ObjectId id;
    private AsignacionTraslado asignacionTraslado;
    private List<Vehiculo> vehiculos;
    private int kilometros;
    private float costo;
    private String fechaLlegada;
    

    public Traslado() {
    }

    public Traslado(ObjectId id, AsignacionTraslado asignacionTraslado, List<Vehiculo> vehiculos, int kilometros, float costo, String fechaLlegada) {
        this.id = id;
        this.asignacionTraslado = asignacionTraslado;
        this.vehiculos = vehiculos;
        this.kilometros = kilometros;
        this.costo = costo;
        this.fechaLlegada = fechaLlegada;
    }

    public Traslado(AsignacionTraslado asignacionTraslado, List<Vehiculo> vehiculos, int kilometros, float costo, String fechaLlegada) {
        this.asignacionTraslado = asignacionTraslado;
        this.vehiculos = vehiculos;
        this.kilometros = kilometros;
        this.costo = costo;
        this.fechaLlegada = fechaLlegada;
    }

    

    

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public AsignacionTraslado getAsignacionTraslado() {
        return asignacionTraslado;
    }

    public void setAsignacionTraslado(AsignacionTraslado asignacionTraslado) {
        this.asignacionTraslado = asignacionTraslado;
    }
    
    


    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Traslado other = (Traslado) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Traslado{" + "id=" + id + ", asignacionTraslado=" + asignacionTraslado + ", vehiculos=" + vehiculos + ", kilometros=" + kilometros + ", costo=" + costo + ", fechaLlegada=" + fechaLlegada + '}';
    }

    

    
    
    
    
}
