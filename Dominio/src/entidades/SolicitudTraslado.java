/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public class SolicitudTraslado {
    
    private ObjectId id;
    private String fechaTraslado;
    private List<Residuo> residuosTransportados;
    private ObjectId idProductor;

    public SolicitudTraslado() {
    }

    public SolicitudTraslado(String fechaTraslado, List<Residuo> ResiduosTransportados) {
        this.fechaTraslado = fechaTraslado;
        this.residuosTransportados = ResiduosTransportados;
    }

    public SolicitudTraslado(ObjectId id, String fechaTraslado, List<Residuo> ResiduosTransportados) {
        this.id = id;
        this.fechaTraslado = fechaTraslado;
        this.residuosTransportados = ResiduosTransportados;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFechaTraslado() {
        return fechaTraslado;
    }

    public void setFechaTraslado(String fechaTraslado) {
        this.fechaTraslado = fechaTraslado;
    }

    public List<Residuo> getResiduosTransportados() {
        return residuosTransportados;
    }

    public void setResiduosTransportados(List<Residuo> ResiduosTransportados) {
        this.residuosTransportados = ResiduosTransportados;
    }

    public ObjectId getIdProductor() {
        return idProductor;
    }

    public void setIdProductor(ObjectId idProductor) {
        this.idProductor = idProductor;
    }
    
    
    
    public void addResiduoTransportado(Residuo residuoTransportado){
        if(this.residuosTransportados == null){
            this.residuosTransportados = new ArrayList<>();
        }
        this.residuosTransportados.add(residuoTransportado);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final SolicitudTraslado other = (SolicitudTraslado) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        int i = 0; int a = 1; 
        String residuos = "<HTML> ";
        while(i < this.residuosTransportados.size())
        {
            if(i == 0)
            {
                residuos = residuos+this.residuosTransportados.get(i).getNombre();
            }
            else
            {
                residuos = residuos+" <br> "+this.residuosTransportados.get(i).getNombre();
                a++;
            }
            i++;
        }

        residuos = residuos+" </HTML>";
        return residuos;
    }

    
    
    
    
}
