/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareinformaticomvc;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ALEXIS
 */
public class tblBiseccion extends AbstractTableModel {
    private String[] columnas = {"i","xi","xs","xr","fxi","fxr"
            ,"Producto","Error"};
    private ArrayList<csBiseccion> lista = null;

    public tblBiseccion(ArrayList<csBiseccion> resultados) 
    {
        this.lista = resultados;
        
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int i) {
        return this.columnas[i];
    }
    
    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnas.length;
    }

    @Override
    public Object getValueAt(int i, int columna) {
        csBiseccion fila = this.lista.get(i);
        switch(columna)
        {
            case 0:{
                return fila.getInteracion();
            }
            case 1:{
                return fila.getXi();
            }
            case 2: return fila.getXs();
            
            case 3: return fila.getXr();
            
            case 4: return fila.getFxi();
            
            case 5: return fila.getFxr();
            
            case 6: return fila.getProducto();
            
            case 7: return fila.getError();
        }
        return null;
    }
    
}
