/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareinformaticomvc;

import java.util.ArrayList;

/**
 *
 * @author ALEXIS
 */
public class ctrlMetodos {

    
    
    public tblBiseccion Biseccion(double li, double ls,double errorDeseado, int it)
      {//rrayList<csBiseccion> lista = new ArrayList<csBiseccion>();
      
        ArrayList <csBiseccion> lista = null;
        tblBiseccion tabla=null;
        double fxi;
        double fxs;
        double errorCalculado = 1;
        int interacion = 0;
        double xAnterior;
        double xActual;
        fxi = this.getfx(li);
        fxs = this.getfx(ls);
        if((fxi*fxs)<0)
        {
            lista = new ArrayList<csBiseccion>();
            while(errorCalculado>errorDeseado && it>0)
            {
               csBiseccion fila = new csBiseccion();
               fila.setInteracion(interacion+1);
               fila.setXi(li);
               fila.setXs(ls);
               fila.setXr((fila.getXi()+fila.getXs())/2);
               fila.setFxi(this.getfx(fila.getXi()));
               fila.setFxr(this.getfx(fila.getXr()));
               fila.setProducto(fila.getFxi()*fila.getFxr());
               if(fila.getProducto()>0)
               {
                   errorCalculado = this.errorRelativo(li, ls);
                   xAnterior = li;
                   li = fila.getXr();
               }
               else{
                   errorCalculado = this.errorRelativo(li, ls);
                   xAnterior = ls;
                   ls = fila.getXr();
               }
               //errorCalculado = this.errorRelativo(fila.getXr(), xAnterior);
               fila.setError(errorCalculado);
               System.out.println(fila.toString());
               lista.add(fila);
               interacion++;
            }
            tabla = new tblBiseccion(lista);
            return tabla;
            
        }
        else return null;
        
      } 
    
    private double getfx(double x)
    {
        return ((9.8*68.1)/x)*(1-Math.exp(-(x/68.1)*10))-40;
    }
    
    private double errorRelativo(double xActual, double xAnterior)
    {
        return Math.abs((xActual-xAnterior)/xActual);
    }
    
}

