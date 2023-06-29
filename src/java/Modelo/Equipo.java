package Modelo;

public class Equipo {
    private int idEquipo;
    private int idUsuario;
    private int codigo_SAP;
    private String Serie;
    private String Descripcion;
    private int Cantidad;
    private double Precio;
    private String Fecha;

    public Equipo() {
        
    }

    public Equipo(int idEquipo, int idUsuario, int codigo_SAP, String Serie, String Descripcion, int Cantidad, double Precio, String Fecha) {
        this.idEquipo = idEquipo;
        this.idUsuario = idUsuario;
        this.codigo_SAP = codigo_SAP;
        this.Serie = Serie;
        this.Descripcion = Descripcion;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Fecha = Fecha;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCodigo_SAP() {
        return codigo_SAP;
    }

    public void setCodigo_SAP(int codigo_SAP) {
        this.codigo_SAP = codigo_SAP;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String Serie) {
        this.Serie = Serie;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
}
