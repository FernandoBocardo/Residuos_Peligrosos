/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package residuos_negocios;

import entidades.AsignacionTraslado;
import entidades.EmpresaTransportadora;
import entidades.Productor;
import entidades.Residuo;
import entidades.SolicitudTraslado;
import entidades.Traslado;
import entidades.Vehiculo;
import fachada.Fachada;
import implementaciones.AsignacionesTrasladosDAO;
import implementaciones.ConexionBD;
import implementaciones.EmpresasDAO;
import implementaciones.ProductoresDAO;
import implementaciones.ResiduosDAO;
import implementaciones.SolicitudesTrasladosDAO;
import implementaciones.TrasladosDAO;
import implementaciones.VehiculosDAO;
import interfaces.IAsignacionesTrasladosDAO;
import interfaces.IConexionBD;
import interfaces.IEmpresasDAO;
import interfaces.IProductoresDAO;
import interfaces.IResiduosDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;
import interfaces.ISolicitudesTrasladosDAO;
import interfaces.ITrasladosDAO;
import interfaces.IVehiculosDAO;
import singleton.Singleton;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public class CtrlTraslados {
    
    private final Fachada fachada;
    private int j = 0;

    public CtrlTraslados() {
        this.fachada = new Fachada();
    }
    
    /**
     * Este método sirve para agregarAsignacionTraslado una solicitud de traslado
     * @param usuarioProductor El usuario del productor
     * @param fechaElegida La fecha que se eligio para la solicitud
     * @param modeloTablaResiduosElegidos El modelo de la tabla de los residuos elegidos
     * @return Regresa valor booleano dependiendo si se pudo agregarAsignacionTraslado o no
     */
    public boolean agregarSolicitudTraslado(String usuarioProductor, String fechaElegida, DefaultTableModel modeloTablaResiduosElegidos)
    {
        Productor productor = fachada.productorConsultarUsuario(usuarioProductor);
        SolicitudTraslado traslado = new SolicitudTraslado();
        traslado.setIdProductor(productor.getId());
        traslado.setFechaTraslado(fechaElegida);
        ArrayList<Residuo> residuos = getResiduosElegidos(modeloTablaResiduosElegidos);
        int i = 0;
        while(i < residuos.size())
        {
            traslado.addResiduoTransportado(residuos.get(i));
            i++;
        }
        
        
        if(fachada.agregarSolicitudTraslado(traslado))
        {
            return true;
        }
        return false;
    }
    
    /**
     * Método para llenar la tabla de los residuos disponibles
     * @param modeloTabla Modelo de la tabla de los residuos disponibles
     * @return Regresa el modelo de la tabla llenado
     */
    public DefaultTableModel llenarTablaResiduosDisponibles(DefaultTableModel modeloTabla){
        List<Residuo> listaResiduos = this.fachada.residuosConsultarTodos();
        modeloTabla.setRowCount(0);
        listaResiduos.forEach(residuo -> {
            Object[] fila = new Object[1];
            fila[0] = residuo.getNombre();
            modeloTabla.addRow(fila); 
        });
        return modeloTabla;
    }
    
    /**
     * Método para agregarAsignacionTraslado un residuo en la tabla de los residuos elegidos
     * @param modeloTabla el modelo de la tabla de los residuos elegidos
     * @param residuo El nombre del residuo que se añadira
     * @param cantidad La cantidad que se transportara
     * @param unidadMedicion La unidad en la que se mide el residuo seleccionado
     * @return Regresa el modelo de la tabla con el residuo agregado
     */
    public DefaultTableModel agregarTablaResiduosElegidos(DefaultTableModel modeloTabla, String residuo, int cantidad, String unidadMedicion){
        Object[] fila = new Object[3];
            fila[0] = residuo;
            fila[1] = cantidad;
            fila[2] = unidadMedicion;
            modeloTabla.addRow(fila); 
        return modeloTabla;
    }

    /**
     * Método para remover un residuo de la tabla de residuos disponibles
     * @param modeloTabla Modelo de la tabla a la que se le removera
     * @param fila Indice de la fila que se removera
     * @return Regresa el modelo de la tabla con la fila removida
     */
    public DefaultTableModel removerTablaResiduosDisponibles(DefaultTableModel modeloTabla, int fila)
    {
        modeloTabla.removeRow(fila);
        return modeloTabla;
    }
    
    /**
     * Método para remover un residuo de la tabla de residuos elegidos
     * @param modeloTabla Modelo de la tabla a la que se le removera
     * @param fila Indice de la fila que se removera
     * @return Regresa el modelo de la tabla con la fila removida
     */
    public DefaultTableModel removerTablaResiduosElegidos(DefaultTableModel modeloTabla, int fila){
        modeloTabla.removeRow(fila);
        return modeloTabla;
    }
    
    /**
     * Método que agrega un residuo a la tabla de residuos disponibles
     * @param modeloTabla Modelo de la tabla a la que se le agregara el residuo
     * @param residuo El nombre del residuo que se agregara
     * @return Regresa el modelo de la tabla con el residuo agregado
     */
    public DefaultTableModel agregarTablaResiduosDisponibles(DefaultTableModel modeloTabla, String residuo)
    {
        Object[] fila = new Object[1];
            fila[0] = residuo;
            modeloTabla.addRow(fila); 
        return modeloTabla;
    }
    
    
    
    
    /**
     * Método para verificar que el formato de los residuos elegidos
     * @param modeloTablaResiduosElegidos Modelo de la tabla en la que estan los residuos
     * @return Regresa valor boolean dependiendo si la verificación fue correcta o no
     */
    public boolean verificarFormatoResiduosElegidos(DefaultTableModel modeloTablaResiduosElegidos)
    {
        ArrayList<Residuo> residuosElegidos = getResiduosElegidos(modeloTablaResiduosElegidos);
        if (residuosElegidos.size() >= 1)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Método que verifica si se eligio al menos un vehiculo
     * @param modeloTablaVehiculosElegidos Modelo de la tabla de la que se obtendran los vehiculos
     * @return Regresa valor boolean dependiendo si la verificación fue correcta o no
     */
    public boolean verificarVehiculosElegidos(DefaultTableModel modeloTablaVehiculosElegidos)
    {
        if (modeloTablaVehiculosElegidos.getRowCount() >= 1)
        {
            return true;
        }
        return false;
    }
    

    /**
     * Método para obtener los residuos elegidos del modelo de la tabla
     * @param modeloTablaResiduosElegidos Modelo de la tabla que se usara
     * @return Regresa una lista con los residuos
     */
    private ArrayList<Residuo> getResiduosElegidos(DefaultTableModel modeloTablaResiduosElegidos)
    {
        CtrlResiduos ctrlResiduos = new CtrlResiduos();
        ArrayList<Residuo> residuos = new ArrayList<>();
        int i = 0;
        Residuo residuo;
        while(i < modeloTablaResiduosElegidos.getRowCount())
        {
            residuo = ctrlResiduos.consultarNombre((String) modeloTablaResiduosElegidos.getValueAt(i, 0));
            residuo.setCantidad((int) modeloTablaResiduosElegidos.getValueAt(i, 1));
            residuo.setUnidad((String) modeloTablaResiduosElegidos.getValueAt(i, 2));
            residuos.add(residuo);
            i++;
        }
        
        return residuos;
    }
    
    /**
     * Método para verificar que haya disponibilidad
     * @param fecha La fecha en la que se busca verificar
     * @return Regresa valor booleano dependiendo si la verificación es correcta o no
     */
    public boolean verificarDisponibilidad(String fecha)
    {
        List<SolicitudTraslado> traslados;
        traslados = fachada.solicitudesTrasladosConsultarFecha(fecha);
        if(traslados == null)
        {
            return true;
        }
        if(traslados.size() >= 5)
        {
            return false;
        }
        return true;
    }
    
    /**
     * Método para verificar que no se registre la misma solicitud
     * @param usuarioProductor Usuario del productor
     * @param fechaElegida La fecha elegida
     * @param modeloTablaResiduosElegidos El modelo de la tabla de los residuos elegidos
     * @return Regresa valor booleano dependiendo si la verificación es correcta o no
     */
    public boolean verificarTrasladoProductorFechaResiduos(String usuarioProductor, String fechaElegida, DefaultTableModel modeloTablaResiduosElegidos)
    {
        Productor productor = fachada.productorConsultarUsuario(usuarioProductor);
        SolicitudTraslado traslado = new SolicitudTraslado();
        traslado.setIdProductor(productor.getId());
        traslado.setFechaTraslado(fechaElegida);
        ArrayList<Residuo> residuos = getResiduosElegidos(modeloTablaResiduosElegidos);
        int i = 0;
        while(i < residuos.size())
        {
            traslado.addResiduoTransportado(residuos.get(i));
            i++;
        }
        
        
        if(fachada.solicitudTrasladoVerificarTrasladoProductorFechaResiduos(traslado))
        {
            return true;
        }
        return false;
    }
    
    
    
    /**
     * Método para llenar la tabla de las solicitudes de traslados
     * @param table La tabla que se llenara
     * @return Regresa la tabla llenada
     */
    public JTable llenarTablaSolicitudTraslados(JTable table){
        List<SolicitudTraslado> listaTraslados = this.fachada.solicitudesTrasladosConsultarTodos();
        DefaultTableModel modeloTabla = (DefaultTableModel)table.getModel();
        modeloTabla.setRowCount(0);
        this.j = 0;
        listaTraslados.forEach(traslados -> {
            Object[] fila = new Object[3];
            fila[0] = fachada.productorConsultarId(traslados.getIdProductor()).getUsuario();
            fila[1] = traslados.getFechaTraslado();
            int i = 0; int a = 1; 
            while(i < traslados.getResiduosTransportados().size())
            {
                if(i != 0)
                {
                    a++;
                }
                i++;
            }
            fila[2] = traslados;
            if(!traslados.getResiduosTransportados().isEmpty())
            {
                modeloTabla.addRow(fila); 
                table.setRowHeight(j, a*16);
                j++;
            }
        });
        
        return table;
    }
    
    /**
     * Método para llenar la tabla de detalles de las solicitudes de traslados
     * @param modeloTabla Modelo de la tabla que se llenara
     * @param traslado La solicitud de traslado que se quiere ver los detalles
     * @return Regresa el modelo de la tabla llenada
     */
    public DefaultTableModel llenarTablaSolicitudTrasladoDetalles(DefaultTableModel modeloTabla, SolicitudTraslado traslado){
        List<Residuo> listaResiduos = traslado.getResiduosTransportados();
        modeloTabla.setRowCount(0);
        listaResiduos.forEach(residuos -> {
            Object[] fila = new Object[2];
            fila[0] = residuos;
            fila[1] = residuos.getCantidad()+" "+residuos.getUnidad();
            modeloTabla.addRow(fila); 
        });
        return modeloTabla;
    }
    
    /**
     * Método para llenar la tabla de las empresas disponibles
     * @param modeloTabla Modelo de la tabla que se llenara
     * @return Regresa el modelo de la tabla llenado
     */
    public DefaultTableModel llenarTablaEmpresasDisponibles(DefaultTableModel modeloTabla){
        List<EmpresaTransportadora> listaEmpresas = this.fachada.empresasConsultarTodos();
        modeloTabla.setRowCount(0);
        listaEmpresas.forEach(empresas -> {
            Object[] fila = new Object[1];
            fila[0] = empresas;
            modeloTabla.addRow(fila); 
        });
        return modeloTabla;
    }
    
    /**
     * Método para consultar un productor por su ID
     * @param idProductor La id del productor que se buscara
     * @return Regresa el productor consultado
     */
    public Productor consultarProductorId(ObjectId idProductor)
    {
        return fachada.productorConsultarId(idProductor);
    }
    
    
    
    
    /**
     * Método para agregarAsignacionTraslado una empresa en la tabla de empresas seleccionadas
     * @param modeloTabla Modelo de la tabla a la que se le agregara
     * @param empresa Empresa que se agregara a la tabla
     * @param residuoSeleccionado El residuo seleccionado
     * @return Regresa el modelo de la tabla con la empresa agregada
     */
    public DefaultTableModel agregarTablaEmpresasSeleccionadas(DefaultTableModel modeloTabla, EmpresaTransportadora empresa, Residuo residuoSeleccionado){
        int i = 0;
        EmpresaTransportadora empresaAnterior;
        while(i < modeloTabla.getRowCount())
        {
            empresaAnterior = (EmpresaTransportadora) modeloTabla.getValueAt(0, 0);
            modeloTabla.removeRow(0);
            Object[] fila = new Object[2];
                fila[0] = empresaAnterior;
                fila[1] = residuoSeleccionado.getCantidad()/(2+modeloTabla.getRowCount())+" "+residuoSeleccionado.getUnidad();
                modeloTabla.addRow(fila); 
            i++;
        }
        Object[] fila = new Object[2];
            fila[0] = empresa;
            fila[1] = residuoSeleccionado.getCantidad()/(1+modeloTabla.getRowCount())+" "+residuoSeleccionado.getUnidad();
            modeloTabla.addRow(fila); 
        return modeloTabla;
    }
    
    /**
     * Mpetodo para remover una empresa de la tabla de empresas disponibles
     * @param modeloTabla Modelo de la tabla a la que se le removera una empresa
     * @param fila La fila que se removera
     * @return Regresa el modelo de la tabla con la empresa removida
     */
    public DefaultTableModel removerTablaEmpresasDisponibles(DefaultTableModel modeloTabla, int fila)
    {
        modeloTabla.removeRow(fila);
        return modeloTabla;
    }
    
    /**
     * Método para remover una empresa de la tabla de empresas seleccionadas
     * @param modeloTabla Modelo de la tabla a la que se le removera una empresa
     * @param fila Fila que se removera
     * @param residuoSeleccionado Residuo seleccionado
     * @return Regresa el modelo de la tabla con la empresa removida
     */
    public DefaultTableModel removerTablaEmpresasSeleccionadas(DefaultTableModel modeloTabla, int fila, Residuo residuoSeleccionado){
        modeloTabla.removeRow(fila);
        int i = 0;
        EmpresaTransportadora empresaAnterior;
        while(i < modeloTabla.getRowCount())
        {
            empresaAnterior = (EmpresaTransportadora) modeloTabla.getValueAt(0, 0);
            modeloTabla.removeRow(0);
            Object[] fila2 = new Object[2];
                fila2[0] = empresaAnterior;
                fila2[1] = residuoSeleccionado.getCantidad()/(1+modeloTabla.getRowCount())+" "+residuoSeleccionado.getUnidad();
                modeloTabla.addRow(fila2); 
            i++;
        }
        return modeloTabla;
    }
    
    /**
     * Método para agregarAsignacionTraslado una empresa a la tabla de empresas disponibles
     * @param modeloTabla Modelo de la tabla a la que se le agregara una empresa
     * @param empresa Empresa que se agregara a la tabla
     * @return Regresa el modelo de la tabla con la empresa agregada
     */
    public DefaultTableModel agregarTablaEmpresasDisponibles(DefaultTableModel modeloTabla, EmpresaTransportadora empresa)
    {
        Object[] fila = new Object[1];
            fila[0] = empresa;
            modeloTabla.addRow(fila); 
        return modeloTabla;
    }
    
    /**
     * Método oara verificar las empresas seleccionadas
     * @param modeloTabla Modelo de la tabla que se vericara
     * @return Regresa valor boolean dependiendo si la verificación resulto correcta o no
     */
    public boolean verificarEmpresasSeleccionadas(DefaultTableModel modeloTabla)
    {
        if(modeloTabla.getRowCount() != 0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Método para agregarAsignacionTraslado una asignacion de traslado
     * @param residuo Residuo que se asignara
     * @param modeloTabla Modelo de la tabla donde vienen las empresas
     * @param solicitudTraslado La solicitud de traslado a la que se le estan asignando las empresas
     * @return Regresa valor boolean dependiendo si la verificación resulto correcta o no
     */
    public boolean agregarAsignacionTraslado(Residuo residuo, DefaultTableModel modeloTabla, SolicitudTraslado solicitudTraslado)
    {
        List<EmpresaTransportadora> empresas = new LinkedList<>();
        int i = 0;
        while(i < modeloTabla.getRowCount())
        {
            empresas.add((EmpresaTransportadora) modeloTabla.getValueAt(i, 0));
            i++;
        }
        Residuo residuoAsignacion = new Residuo();
        residuoAsignacion.setId(residuo.getId());
        residuoAsignacion.setIdsQuimicosConstituyentes(residuo.getIdsQuimicosConstituyentes());
        residuoAsignacion.setNombre(residuo.getNombre());
        residuoAsignacion.setUnidad(residuo.getUnidad());
        residuoAsignacion.setCodigo(residuo.getCodigo());
        residuoAsignacion.setCantidadAsignada(residuo.getCantidad()/empresas.size());
        residuoAsignacion.setCantidad(residuo.getCantidad());
        AsignacionTraslado asignacionTraslado = new AsignacionTraslado(solicitudTraslado.getId(), residuoAsignacion, empresas, "Pendiente");
        SolicitudTraslado solicitudTrasladoAntigua = solicitudTraslado;
        int j = 0;
        while(j < solicitudTraslado.getResiduosTransportados().size())
        {
            if(solicitudTraslado.getResiduosTransportados().get(j).getId() == residuo.getId())
            {
                solicitudTraslado.getResiduosTransportados().remove(j);
            }
            j++;
        }
        fachada.actualizarSolicitudTraslado(solicitudTrasladoAntigua, solicitudTraslado);
        if(fachada.agregarAsignacionTraslado(asignacionTraslado))
        {
            return true;
        }
        return false;
    }
    
    /**
     * Método para llenar la tabla de traslados asignados
     * @param modeloTabla Modelo de la tabla a llenar
     * @return Regresa una lista de objetos donde la primera posición es el modelo de la tabla llenada y la segunda posición es una lista de los traslados asignados
     */
    public List<Object> llenarTablaTrasladosAsignados(DefaultTableModel modeloTabla){
        List<AsignacionTraslado> listaTrasladosAsignados = this.fachada.asignacionesTrasladosConsultarTodos();
        modeloTabla.setRowCount(0);
        listaTrasladosAsignados.forEach(trasladoAsignado -> {
            Object[] fila = new Object[4];
            fila[0] = this.fachada.solicitudTrasladoConsultarId(trasladoAsignado.getIdSolicitudTraslado()).getFechaTraslado();
            fila[1] = trasladoAsignado.getResiduoAsignado();
            fila[2] = trasladoAsignado.getResiduoAsignado().getCantidadAsignada();
            fila[3] = "Alberto";
            modeloTabla.addRow(fila); 
        });
        List<Object> objetos = new ArrayList<>();
        objetos.add(modeloTabla);
        objetos.add(listaTrasladosAsignados);
        return objetos;
    }
    
    /**
     * Método para llenar la tabla de vehiculos disponibles
     * @param modeloTabla Modelo de la tabla a llenar
     * @return Regresa el modelo de la tabla llenada
     */
    public DefaultTableModel llenarTablaVehiculosDisponibles(DefaultTableModel modeloTabla){
        List<Vehiculo> listaVehiculosDisponibles = this.fachada.vehiculosConsultarTodos();
        modeloTabla.setRowCount(0);
        listaVehiculosDisponibles.forEach(vehiculo -> {
            Object[] fila = new Object[1];
            fila[0] = vehiculo;
            modeloTabla.addRow(fila); 
        });
        return modeloTabla;
    }
    
    /**
     * Método para agregarAsignacionTraslado un vehiculo a la tabla de vehiculos elegidos
     * @param modeloTabla Modelo de la tabla a las que se le agregara un vehiculo
     * @param vehiculo Vehiculo que se agregara a la tabla
     * @return Regresa el modelo de la tabla con el vehiculo agregado
     */
    public DefaultTableModel agregarTablaVehiculosElegidos(DefaultTableModel modeloTabla, Vehiculo vehiculo){
        Object[] fila = new Object[1];
            fila[0] = vehiculo;
            modeloTabla.addRow(fila); 
        return modeloTabla;
    }

    /**
     * Método para remover un vehiculo de la tabla de vehiculos disponibles
     * @param modeloTabla Modelo de la tabla que se le removera un vehiculo
     * @param fila Fila que se removera
     * @return Regresa el modelo de la tabla con el vehiculo removido
     */
    public DefaultTableModel removerTablaVehiculosDisponibles(DefaultTableModel modeloTabla, int fila)
    {
        modeloTabla.removeRow(fila);
        return modeloTabla;
    }
    
    /**
     * Método para remover un vehiculo de la tabla de vehiculos elegidos
     * @param modeloTabla Modelo de la tabla a la que se le removera un vehiculo
     * @param fila Fila que se removera
     * @return Regresa el modelo de la tabla que se le removio el vehiculo
     */
    public DefaultTableModel removerTablaVehiculosElegidos(DefaultTableModel modeloTabla, int fila){
        modeloTabla.removeRow(fila);
        return modeloTabla;
    }
    
    /**
     * Método para agregarAsignacionTraslado un vehiculo a la tabla de vehiculos disponibles
     * @param modeloTabla Modelo de la tabla que se le agregara
     * @param vehiculo vehiculo que se agregara
     * @return Regresa el modelo de la tabla que se le añadio el vehiculo
     */
    public DefaultTableModel agregarTablaVehiculosDisponibles(DefaultTableModel modeloTabla, Vehiculo vehiculo)
    {
        Object[] fila = new Object[1];
            fila[0] = vehiculo;
            modeloTabla.addRow(fila); 
        return modeloTabla;
    }
    
    /**
     * Método para agregarAsignacionTraslado un traslado
     * @param asignacionTraslado La asignacion de traslado
     * @param kilometros Los kilometros del traslado
     * @param costo El costo del traslado 
     * @param fechaLlegada La fecha de llegada del traslado
     * @param modeloTablaVehiculos El modelo de la tabla de los vehiculos
     * @return Regresa un valor boolean dependiendo el resultado 
     */
    public boolean agregarTraslado(AsignacionTraslado asignacionTraslado, int kilometros, float costo, String fechaLlegada, DefaultTableModel modeloTablaVehiculos)
    {
        int i = 0;
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        while(i < modeloTablaVehiculos.getRowCount())
        {
            listaVehiculos.add((Vehiculo) modeloTablaVehiculos.getValueAt(i, 0));
            i++;
        }
        Traslado traslado = new Traslado();
        traslado.setAsignacionTraslado(asignacionTraslado);
        traslado.setCosto(costo);
        traslado.setFechaLlegada(fechaLlegada);
        traslado.setKilometros(kilometros);
        traslado.setVehiculos(listaVehiculos);
        if(fachada.agregarTraslado(traslado))
        {
            fachada.asignacionTrasladoCambiarEstado(asignacionTraslado.getId(), asignacionTraslado);
            return true;
        }
        return false;
    }
    
}
