
package Modelo;

public class Personal {
    private int idPersonal;
   private String nombre;
   private String cargo;

    public Personal() {
    }

    public Personal(int idPersonal, String nombre, String cargo) {
        this.idPersonal = idPersonal;
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
   
   
   
}
