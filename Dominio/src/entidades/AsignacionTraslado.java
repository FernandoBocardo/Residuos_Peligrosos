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
public class AsignacionTraslado {
    
    private ObjectId id;
    private ObjectId idSolicitudTraslado;
    private Residuo residuoAsignado;
    private List<EmpresaTransportadora> empresasTransportadoras;
    private String estado;

    public AsignacionTraslado() {
    }

    public AsignacionTraslado(ObjectId id, ObjectId idSolicitudTraslado, Residuo residuoAsignado, List<EmpresaTransportadora> empresasTransportadoras, String estado) {
        this.id = id;
        this.idSolicitudTraslado = idSolicitudTraslado;
        this.residuoAsignado = residuoAsignado;
        this.empresasTransportadoras = empresasTransportadoras;
        this.estado = estado;
    }

    public AsignacionTraslado(ObjectId idSolicitudTraslado, Residuo residuoAsignado, List<EmpresaTransportadora> empresasTransportadoras, String estado) {
        this.idSolicitudTraslado = idSolicitudTraslado;
        this.residuoAsignado = residuoAsignado;
        this.empresasTransportadoras = empresasTransportadoras;
        this.estado = estado;
    }

    

    

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getIdSolicitudTraslado() {
        return idSolicitudTraslado;
    }

    public void setIdSolicitudTraslado(ObjectId idSolicitudTraslado) {
        this.idSolicitudTraslado = idSolicitudTraslado;
    }

    public Residuo getResiduoAsignado() {
        return residuoAsignado;
    }

    public void setResiduoAsignado(Residuo residuoAsignado) {
        this.residuoAsignado = residuoAsignado;
    }
    
    

    public List<EmpresaTransportadora> getEmpresasTransportadoras() {
        return empresasTransportadoras;
    }

    public void setEmpresasTransportadoras(List<EmpresaTransportadora> empresasTransportadoras) {
        this.empresasTransportadoras = empresasTransportadoras;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final AsignacionTraslado other = (AsignacionTraslado) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "AsignacionTraslado{" + "id=" + id + ", idSolicitudTraslado=" + idSolicitudTraslado + ", residuoAsignado=" + residuoAsignado + ", empresasTransportadoras=" + empresasTransportadoras + '}';
    }

    
    
    
    
}
