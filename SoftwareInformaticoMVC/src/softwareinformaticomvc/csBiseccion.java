/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareinformaticomvc;

/**
 *
 * @author ALEXIS
 */
public class csBiseccion {
    private int interacion;
    private double xi, xs, xr, fxi, fxr, producto, error;

    @Override
    public String toString() {
        return "csBiseccion{" + "interacion=" + interacion + ", xi=" + xi + ", xs=" + xs + ", xr=" + xr + ", fxi=" + fxi + ", fxr=" + fxr + ", producto=" + producto + ", error=" + error + '}';
    }

    public int getInteracion() {
        return interacion;
    }

    public void setInteracion(int interacion) {
        this.interacion = interacion;
    }

    public double getXi() {
        return xi;
    }

    public void setXi(double xi) {
        this.xi = xi;
    }

    public double getXs() {
        return xs;
    }

    public void setXs(double xs) {
        this.xs = xs;
    }

    public double getXr() {
        return xr;
    }

    public void setXr(double xr) {
        this.xr = xr;
    }

    public double getFxi() {
        return fxi;
    }

    public void setFxi(double fxi) {
        this.fxi = fxi;
    }

    public double getFxr() {
        return fxr;
    }

    public void setFxr(double fxr) {
        this.fxr = fxr;
    }

    public double getProducto() {
        return producto;
    }

    public void setProducto(double producto) {
        this.producto = producto;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }
}
