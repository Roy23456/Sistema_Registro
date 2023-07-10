package Modelo;

public class Indicador {
    private String Descripcion;
    private String Mes;
    private int cantidadTotal;
    private double indiceRotacion;

    public Indicador() {
        
    }

    public Indicador(String Descripcion, String Mes, int cantidadTotal, double indiceRotacion) {
        this.Descripcion = Descripcion;
        this.Mes = Mes;
        this.cantidadTotal = cantidadTotal;
        this.indiceRotacion = indiceRotacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getMes() {
        return Mes;
    }

    public void setMes(String Mes) {
        this.Mes = Mes;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public double getIndiceRotacion() {
        return indiceRotacion;
    }

    public void setIndiceRotacion(double indiceRotacion) {
        this.indiceRotacion = indiceRotacion;
    }
    
}
