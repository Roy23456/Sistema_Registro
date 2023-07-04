package Modelo;

public class Indicador {
    private String Descripcion;
    private int Mes;
    private int cantidadTotal;

    public Indicador() {
        
    }

    public Indicador(String Descripcion, int Mes, int cantidadTotal) {
        this.Descripcion = Descripcion;
        this.Mes = Mes;
        this.cantidadTotal = cantidadTotal;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getMes() {
        return Mes;
    }

    public void setMes(int Mes) {
        this.Mes = Mes;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }
    
}
