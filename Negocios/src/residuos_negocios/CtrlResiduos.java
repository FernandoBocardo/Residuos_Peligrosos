/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package residuos_negocios;

import entidades.QuimicoConstituyente;
import entidades.Residuo;
import fachada.Fachada;
import implementaciones.ConexionBD;
import implementaciones.ResiduosDAO;
import interfaces.IConexionBD;
import interfaces.IResiduosDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import singleton.Singleton;

/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public class CtrlResiduos {

    private final Fachada fachada;

    public CtrlResiduos() {
        this.fachada = new Fachada();
    }
    
    /**
     * Método para verificar el formato del residuo
     * @param nombreResiduo Nombre del residuo
     * @param modeloTablaComponentes Modelo de la tabla de los componentes
     * @return Regresa valor boolean dependiendo el resultado 
     */
    public boolean verificarFormato(String nombreResiduo, DefaultTableModel modeloTablaComponentes)
    {
        ArrayList<QuimicoConstituyente> componentes = getComponentesSeleccionados(modeloTablaComponentes);
        if (!nombreResiduo.equals("") && componentes.size() >= 1)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Método para verificar que no haya duplicados
     * @param codigo Codigo del residuo
     * @param nombreResiduo Nombre del residuo
     * @param modeloTablaComponentes Modelo de la tabla de los componentes del residuo
     * @return Regresa valor boolean dependiendo el resultado
     */
    public boolean verificarDuplicados(String codigo, String nombreResiduo, DefaultTableModel modeloTablaComponentes)
    {
        Residuo residuo = new Residuo(codigo, nombreResiduo);
        ArrayList<QuimicoConstituyente> componentes = getComponentesSeleccionados(modeloTablaComponentes);
        int i = 0;
        while(i < componentes.size())
        {
            residuo.addIdComponente(componentes.get(i).getId());
            i++;
        }
        if(fachada.residuoConsultarCodigo(residuo.getCodigo()) == null && fachada.residuoConsultarNombre(residuo.getNombre()) == null && fachada.residuoConsultarComponentes(residuo.getIdsQuimicosConstituyentes()) == null)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Método para agregarResiduo el residuo
     * @param codigo Codigo del residuo
     * @param nombreResiduo Nombre del residuo
     * @param modeloTablaComponentes Modelo de la tabla de los componentes del residuo
     * @return Regresa valor booleano dependiendo del resultado 
     */
    public boolean agregar(String codigo, String nombreResiduo, DefaultTableModel modeloTablaComponentes)
    {
        Residuo residuo = new Residuo(codigo, nombreResiduo);
        ArrayList<QuimicoConstituyente> componentes = getComponentesSeleccionados(modeloTablaComponentes);
        int i = 0;
        while(i < componentes.size())
        {
            residuo.addIdComponente(componentes.get(i).getId());
            i++;
        }
        if(fachada.agregarResiduo(residuo))
        {
            return true;
        }
        return false;
    }
    
    /**
     * Método para obtener los componentes seleccionados
     * @param modeloTablaComponentes Modelo de la tabla de los componentes
     * @return Regresa una lista de los componentes
     */
    private ArrayList<QuimicoConstituyente> getComponentesSeleccionados(DefaultTableModel modeloTablaComponentes)
    {
        CtrlQuimicos ctrlQuimicos = new CtrlQuimicos();
        ArrayList<QuimicoConstituyente> componentes = new ArrayList<>();
        int i = 0;
        QuimicoConstituyente componente;
        while(i < modeloTablaComponentes.getRowCount())
        {
            componente = ctrlQuimicos.consultarNombre((String) modeloTablaComponentes.getValueAt(i, 0));
            componentes.add(componente);
            i++;
        }
        
        return componentes;
    }
    
    /**
     * Método para consultar un residuo por su nombre
     * @param nombreResiduo Nombre del residuo que se quiere consultar
     * @return Regresa el residuo consultado
     */
    public Residuo consultarNombre(String nombreResiduo)
    {
        return fachada.residuoConsultarNombre(nombreResiduo);
    }
    
}
