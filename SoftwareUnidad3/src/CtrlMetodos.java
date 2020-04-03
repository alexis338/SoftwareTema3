


import java.util.ArrayList;

/**
 *

 */
public class CtrlMetodos {
   
    
    //Metodos de Newton
     public tblNewton Newton(double li,double errorDeseado, int it){
         
         ArrayList <csNewton> lista = null;
         tblNewton tabla= null;
         double errorCalculado = 1;
         double xAnterior=0;
        int i = 1;
        lista = new ArrayList<csNewton>();
        while (errorCalculado > errorDeseado && it>0) {
            csNewton fila = new csNewton();
            fila.setIteracion(i); 
            fila.setXi(li); 
            double fxo = this.Funcion(fila.getXi());
            double fxdo = this.DerivadaFuncion(fila.getXi());
            fila.setFxi(fxo); 
            fila.setFdxi(fxdo); 
            fila.setResta(fila.getXi() - (fxo / fxdo));
            xAnterior = fila.getXi(); 
            li = fila.getResta();          
            if (i > 1) {
                      
                errorCalculado = Math.abs((fila.getResta() - fila.getXi()) / fila.getResta());
                fila.setError(errorCalculado);

            } else {
                fila.setError(errorCalculado);
            }
            lista.add(fila);
            i++;
        }
        if (errorCalculado < errorDeseado) {
            tabla = new tblNewton(lista);
            return tabla;
        } else {
            return null;
        }
         
         
     }//fin metodo newton
     
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
     
     
     //Funciones de Newton
     public double Funcion(double x) {
        return Math.pow(2.7182818284590452353602874713527, -x) - x;
    }

    public double DerivadaFuncion(double x) {
        return -Math.pow(2.7182818284590452353602874713527, -x) - 1;
    }
    
}
