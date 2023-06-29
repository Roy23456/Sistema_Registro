
package Modelo;

public class Despacho {
    private int idDespacho;
    private int idUsuario;
    private int idPersonal;
    private String fechaDespacho;
    private String Nombre;

    public Despacho() {
        
    }

    public Despacho(int idDespacho, int idUsuario, int idPersonal, String fechaDespacho, String Nombre) {
        this.idDespacho = idDespacho;
        this.idUsuario = idUsuario;
        this.idPersonal = idPersonal;
        this.fechaDespacho = fechaDespacho;
        this.Nombre = Nombre;
    }

    public int getIdDespacho() {
        return idDespacho;
    }

    public void setIdDespacho(int idDespacho) {
        this.idDespacho = idDespacho;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(String fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
