import java.util.Date;

public class Estudiante extends Persona {
    private Date fechaDeNacimiento;
    private String estado; // Puede ser "matriculado", "inactivo" o "graduado"

    public Estudiante(int id, String nombre, String apellido, Date fechaDeNacimiento, String estado) {
        super(id, nombre, apellido);
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.estado = estado;
    }

    // Getters y setters

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
