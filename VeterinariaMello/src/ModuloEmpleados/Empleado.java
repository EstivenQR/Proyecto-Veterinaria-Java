package ModuloEmpleados;



import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author EstivenQ
 */
public class Empleado extends Persona {

    double Salario;
    String PuestoLaboral;
    String Correo;
    int Telefono;

    public Empleado() {
    }

    public Empleado(double Salario, String PuestoLaboral, String Correo, int Telefono) {
        this.Salario = Salario;
        this.PuestoLaboral = PuestoLaboral;
        this.Correo = Correo;
        this.Telefono = Telefono;
    }

    public Empleado(double Salario, String PuestoLaboral, String Correo, int Telefono, String Nombre, String Apellidos, int Cedula, int Edad) {
        super(Nombre, Apellidos, Cedula, Edad);
        this.Salario = Salario;
        this.PuestoLaboral = PuestoLaboral;
        this.Correo = Correo;
        this.Telefono = Telefono;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }

    public String getPuestoLaboral() {
        return PuestoLaboral;
    }

    public void setPuestoLaboral(String PuestoLaboral) {
        this.PuestoLaboral = PuestoLaboral;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }




}
