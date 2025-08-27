/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinariaislademello;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres Ortega
 */
public class Mascota {

    protected String tamano;
    protected String nombre;
    protected String edad;
    protected String fechaNacimiento;
    protected String especie;
    protected String raza;
    protected String fechaVisita;
    protected String comentarios;
    public static final String URL = "jdbc:mysql://localhost:3306/proyecto";
    public static final String USER = "root";
    public static final String PASS = "BaseDatos1.";//la password del usuario de MySQL

    public Mascota() {

    }

    public Mascota(String nombre, String tamano, String edad, String fechaNacimiento, String especie, String raza, String fechaVisita, String comentarios) {
        this.nombre = nombre;
        this.tamano = tamano;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.especie = especie;
        this.raza = raza;
        this.fechaVisita = fechaVisita;
        this.comentarios = comentarios;
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");//Solo es necesario en versiones antiguas de JDK
            con = (Connection) DriverManager.getConnection(URL, USER, PASS);
            System.out.println("La conexion fue exitosa");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    //Getters and Setters
    public String getTamano() {
        return tamano;
    }

    public void setTamano(String idMascota) {
        this.tamano = tamano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(String fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    
}
