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
   
    
    //Ejercicio Punto Fijo
    public ArrayList<csFijo> PuntoFijo(double xo, double errorDeseado, int iteraciones){ 
        double x = this.funcion(xo);
        double errorCalculado=1;
        
        ArrayList<csFijo> lista;

        int i = 1; 
        
        lista = new ArrayList<csFijo>();
        
        while (i <= iteraciones && errorCalculado > errorDeseado) {
           
            csFijo fila = new csFijo();
            fila.setIteracion(i);
            fila.setXi(xo); 
            fila.setGx(this.funcion(fila.getXi()));
            
            xo = fila.getGx();         
            if (i > 1) {
                     
                errorCalculado = Math.abs((this.funcion(fila.getXi()) - fila.getXi()) / this.funcion(fila.getXi()));
                fila.setError(errorCalculado);
            } else {
                fila.setError(errorCalculado);
            }
            lista.add(fila);
            i++;
        }
        
        return lista;   
    }
   
    private double funcion(double x){
     
        return Math.pow(2.7182818284590452353602874713527,-x);
    }
}

