/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import com.mongodb.client.MongoDatabase;
import entidades.AsignacionTraslado;
import entidades.EmpresaTransportadora;
import entidades.Productor;
import entidades.QuimicoConstituyente;
import entidades.Residuo;
import entidades.SolicitudTraslado;
import entidades.Traslado;
import entidades.Vehiculo;
import implementaciones.AsignacionesTrasladosDAO;
import implementaciones.EmpresasDAO;
import implementaciones.ProductoresDAO;
import implementaciones.QuimicosConstituyentesDAO;
import implementaciones.ResiduosDAO;
import implementaciones.SolicitudesTrasladosDAO;
import implementaciones.TrasladosDAO;
import implementaciones.VehiculosDAO;
import interfaces.IAsignacionesTrasladosDAO;
import interfaces.IEmpresasDAO;
import interfaces.IProductoresDAO;
import interfaces.IQuimicosConstituyentesDAO;
import interfaces.IResiduosDAO;
import interfaces.ISolicitudesTrasladosDAO;
import interfaces.ITrasladosDAO;
import interfaces.IVehiculosDAO;
import java.util.List;
import org.bson.types.ObjectId;
import singleton.Singleton;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public class Fachada {
    
    private static IAsignacionesTrasladosDAO asignacionesTrasladosDAO; 
    private static IEmpresasDAO empresasDAO;
    private static IProductoresDAO productoresDAO;
    private static IQuimicosConstituyentesDAO quimicosConstituyentesDAO;
    private static IResiduosDAO residuosDAO;
    private static ISolicitudesTrasladosDAO solicitudesTrasladosDAO;
    private static ITrasladosDAO trasladosDAO;
    private static IVehiculosDAO vehiculosDAO;
    
    public Fachada() 
    {
        this.asignacionesTrasladosDAO = new AsignacionesTrasladosDAO(Singleton.getInstancia());
        this.empresasDAO = new EmpresasDAO(Singleton.getInstancia());
        this.productoresDAO = new ProductoresDAO(Singleton.getInstancia());
        this.quimicosConstituyentesDAO = new QuimicosConstituyentesDAO(Singleton.getInstancia());
        this.residuosDAO = new ResiduosDAO(Singleton.getInstancia());
        this.solicitudesTrasladosDAO = new SolicitudesTrasladosDAO(Singleton.getInstancia());
        this.trasladosDAO = new TrasladosDAO(Singleton.getInstancia());
        this.vehiculosDAO = new VehiculosDAO(Singleton.getInstancia());
    }
    
    public boolean agregarAsignacionTraslado(AsignacionTraslado asignacionTraslado)
    {
        return asignacionesTrasladosDAO.agregarAsignacionTraslado(asignacionTraslado);
    }
    
    public List<AsignacionTraslado> asignacionesTrasladosConsultarTodos()
    {
        return asignacionesTrasladosDAO.asignacionesTrasladosConsultarTodos();
    }
    
    public boolean asignacionTrasladoCambiarEstado(ObjectId id, AsignacionTraslado asignacionTraslado)
    {
        return asignacionesTrasladosDAO.asignacionTrasladoCambiarEstado(id, asignacionTraslado);
    }
    
    
    public boolean agregarEmpresa(EmpresaTransportadora empresaTransportadora)
    {
        return empresasDAO.agregarEmpresa(empresaTransportadora);
    }
    
    public List<EmpresaTransportadora> empresasConsultarTodos()
    {
        return empresasDAO.empresasConsultarTodos();
    }
    
    
    public boolean agregarProductor(Productor productor)
    {
        return productoresDAO.agregarProductor(productor);
    }
    
    public List<Productor> productoresConsultarTodos()
    {
        return productoresDAO.productoresConsultarTodos();
    }
    
    public Productor productorConsultarUsuario(String usuario)
    {
        return productoresDAO.productorConsultarUsuario(usuario);
    }
    
    public Productor productorConsultarId(ObjectId id)
    {
        return productoresDAO.productorConsultarId(id);
    }
    
    
    public boolean agregarQuimicoConstituyente(QuimicoConstituyente quimico)
    {
        return quimicosConstituyentesDAO.agregarQuimicoConstituyente(quimico);
    }
    
    public List<QuimicoConstituyente> quimicosConsultarTodos()
    {
        return quimicosConstituyentesDAO.quimicosConsultarTodos();
    }
    
    public QuimicoConstituyente quimicoConsultarNombre(String nombreQuimico)
    {
        return quimicosConstituyentesDAO.quimicoConsultarNombre(nombreQuimico);
    }
    
    
    public boolean agregarResiduo(Residuo residuo)
    {
        return residuosDAO.agregarResiduo(residuo);
    }
    
    public List<Residuo> residuosConsultarTodos()
    {
        return residuosDAO.residuosConsultarTodos();
    }
    
    public Residuo residuoConsultarNombre(String nombreResiduo)
    {
        return residuosDAO.residuoConsultarNombre(nombreResiduo);
    }
    
    public Residuo residuoConsultarCodigo(String codigoResiduo)
    {
        return residuosDAO.residuoConsultarCodigo(codigoResiduo);
    }
    
    public Residuo residuoConsultarComponentes(List<ObjectId> componentesResiduo)
    {
        return residuosDAO.residuoConsultarComponentes(componentesResiduo);
    }
    
    
    public boolean agregarSolicitudTraslado(SolicitudTraslado solicitudTraslado)
    {
        return solicitudesTrasladosDAO.agregarSolicitudTraslado(solicitudTraslado);
    }
    
    public boolean actualizarSolicitudTraslado(SolicitudTraslado solicitudTrasladoAntiguo, SolicitudTraslado solicitudTrasladoNueva) 
    {
        return solicitudesTrasladosDAO.actualizarSolicitudTraslado(solicitudTrasladoAntiguo, solicitudTrasladoNueva);
    }
    
    public List<SolicitudTraslado> solicitudesTrasladosConsultarTodos()
    {
        return solicitudesTrasladosDAO.solicitudesTrasladosConsultarTodos();
    }
    
    public List<SolicitudTraslado> solicitudesTrasladosConsultarFecha(String fecha)
    {
        return solicitudesTrasladosDAO.solicitudesTrasladosConsultarFecha(fecha);
    }
    
    public boolean solicitudTrasladoVerificarTrasladoProductorFechaResiduos(SolicitudTraslado traslado)
    {
        return solicitudesTrasladosDAO.solicitudTrasladoVerificarTrasladoProductorFechaResiduos(traslado);
    }
    
    public SolicitudTraslado solicitudTrasladoConsultarId(ObjectId id)
    {
        return solicitudesTrasladosDAO.solicitudTrasladoConsultarId(id);
    }
    
    
    public boolean agregarTraslado(Traslado traslado)
    {
        return trasladosDAO.agregarTraslado(traslado);
    }
    
    public List<Traslado> trasladosConsultarTodos()
    {
        return trasladosDAO.trasladosConsultarTodos();
    }
    
    public Traslado trasladoConsultarId(ObjectId id)
    {
        return trasladosDAO.trasladoConsultarId(id);
    }
    
    
    public boolean agregarVehiculo(Vehiculo vehiculo)
    {
        return vehiculosDAO.agregarVehiculo(vehiculo);
    }
    
    public List<Vehiculo> vehiculosConsultarTodos()
    {
        return vehiculosDAO.vehiculosConsultarTodos();
    }
    
}
