/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package residuos_negocios;

import entidades.QuimicoConstituyente;
import fachada.Fachada;
import implementaciones.ConexionBD;
import implementaciones.QuimicosConstituyentesDAO;
import interfaces.IConexionBD;
import interfaces.IQuimicosConstituyentesDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import singleton.Singleton;


/**
 *
 * @author Equipo 2 - Residuos peligrosos
 */
public class CtrlQuimicos {
    
    private final Fachada fachada;

    public CtrlQuimicos() {
        this.fachada = new Fachada();
    }
    
    /**
     * Método para consultar un quimico por su nombre
     * @param nombreQuimico El nombre del quimico que se quiere consultar
     * @return Regresa el quimico consultado
     */
    public QuimicoConstituyente consultarNombre(String nombreQuimico)
    {
        return fachada.quimicoConsultarNombre(nombreQuimico);
    }
    
    /**
     * Método para llenar la tabla de quimico
     * @param modeloTabla Modelo de la tabla a llenar
     * @return Regresa el modelo de la tabla llenada
     */
    public DefaultTableModel llenarTablaQuimicos(DefaultTableModel modeloTabla){
        List<QuimicoConstituyente> listaQuimicos = this.fachada.quimicosConsultarTodos();
        modeloTabla.setRowCount(0);
        listaQuimicos.forEach(quimico -> {
            Object[] fila = new Object[1];
            fila[0] = quimico.getNombre();
            modeloTabla.addRow(fila); 
        });
        return modeloTabla;
    }
    
    /**
     * Método para agregarQuimicoConstituyente un quimico en la tabla de componentes
     * @param modeloTabla El modelo de la tabla a la que se le agregarQuimicoConstituyente
     * @param componente Nombre del quimico
     * @return Regresa el modelo de la tabla a la que se le agregara
     */
    public DefaultTableModel agregarTablaComponentes(DefaultTableModel modeloTabla, String componente){
        Object[] fila = new Object[1];
            fila[0] = componente;
            modeloTabla.addRow(fila); 
        return modeloTabla;
    }
    
    /**
     * Método para remover un quimico de la tabla de quimicos
     * @param modeloTabla Modelo de la tabla de quimicos
     * @param fila Fila que se removera
     * @return Regresa el modelo de la tabla con el quimico removido
     */
    public DefaultTableModel removerTablaQuimicos(DefaultTableModel modeloTabla, int fila)
    {
        modeloTabla.removeRow(fila);
        return modeloTabla;
    }
    
    /**
     * Método para remover un componente de la tabla de componentes
     * @param modeloTabla Modelo de la tabla componentes
     * @param fila Fila que se removera
     * @return Regresa el modelo de la tabla con el componente removido
     */
    public DefaultTableModel removerTablaComponentes(DefaultTableModel modeloTabla, int fila){
        modeloTabla.removeRow(fila);
        return modeloTabla;
    }
    
    /**
     * Método para agregarQuimicoConstituyente un quimico en la tabla de quimicos
     * @param modeloTabla Modelo de la talba a la que se agregara
     * @param componente Nombre del componente
     * @return Regresa el modelo de la tabla a la que se le agrego
     */
    public DefaultTableModel agregarTablaQuimicos(DefaultTableModel modeloTabla, String componente)
    {
        Object[] fila = new Object[1];
            fila[0] = componente;
            modeloTabla.addRow(fila); 
        return modeloTabla;
    }
    
}
