
package Modelo;

public class DetalleDespacho {
    private int idDetalleDespacho;
    private int idDespacho;
    private int idEquipo;
    private int Cantidad;
    private String fechaDespacho;
    private int codigo_SAP;
    private String Serie;
    private String Descripcion;

    public DetalleDespacho() {
        
    }

    public DetalleDespacho(int idDetalleDespacho, int idDespacho, int idEquipo, int Cantidad, String fechaDespacho, int codigo_SAP, String Serie, String Descripcion) {
        this.idDetalleDespacho = idDetalleDespacho;
        this.idDespacho = idDespacho;
        this.idEquipo = idEquipo;
        this.Cantidad = Cantidad;
        this.fechaDespacho = fechaDespacho;
        this.codigo_SAP = codigo_SAP;
        this.Serie = Serie;
        this.Descripcion = Descripcion;
    }

    public int getIdDetalleDespacho() {
        return idDetalleDespacho;
    }

    public void setIdDetalleDespacho(int idDetalleDespacho) {
        this.idDetalleDespacho = idDetalleDespacho;
    }

    public int getIdDespacho() {
        return idDespacho;
    }

    public void setIdDespacho(int idDespacho) {
        this.idDespacho = idDespacho;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(String fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
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
    
}
