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
public class Productor {
    
    private ObjectId id;
    private String usuario;
    private String clave;
    private List<Residuo> residuos;
    private List<SolicitudTraslado> traslados;

    public Productor() {
    }

    public Productor(ObjectId id, String usuario, String clave, List<Residuo> residuos) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
        this.residuos = residuos;
    }

    public Productor(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public Productor(String usuario, String clave, List<Residuo> residuos) {
        this.usuario = usuario;
        this.clave = clave;
        this.residuos = residuos;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<Residuo> getResiduos() {
        return residuos;
    }

    public void setResiduos(List<Residuo> residuos) {
        this.residuos = residuos;
    }

    public List<SolicitudTraslado> getTraslados() {
        return traslados;
    }

    public void setTraslados(List<SolicitudTraslado> traslados) {
        this.traslados = traslados;
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
        final Productor other = (Productor) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Productor{" + "id=" + id + ", usuario=" + usuario + ", clave=" + clave + ", residuos=" + residuos + '}';
    }
    
    
    
}
