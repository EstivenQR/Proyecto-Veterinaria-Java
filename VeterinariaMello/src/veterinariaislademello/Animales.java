/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package veterinariaislademello;

import DBCon.Conexion;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;
import java.time.LocalDate;

/**
 *
 * @author Andres Ortega
 */
public class Animales extends Mascota implements MetodosMascotas {

    public Animales() {
    }

    public Animales(String tamano, String nombre, String edad, String fechaNacimiento, String especie, String raza, String fechaVisita, String comentarios) {
        super(nombre, tamano, edad, fechaNacimiento, especie, raza, fechaVisita, comentarios);
    }

    public void anadirMascota() {
        try {
            nombre = JOptionPane.showInputDialog("Nombre:");
            edad = JOptionPane.showInputDialog("Edad:");
            especie = JOptionPane.showInputDialog("Especie:");
            raza = JOptionPane.showInputDialog("Raza:");
            tamano = JOptionPane.showInputDialog("Tamano:");
            fechaNacimiento = JOptionPane.showInputDialog("Fecha de nacimiento (AAAA/MM/DD):");
            fechaVisita = LocalDate.now().toString();
            comentarios = JOptionPane.showInputDialog("Observaciones:");

            Connection con = Conexion.getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("INSERT INTO `mascotas` (`nombre`, `edad`,"
                    + " `especie`, `raza`, `tamano`, `fechaNacimiento`, `fechaVisita`,"
                    + " `comentarios`) VALUES ('" + nombre + "', '" + edad + "', '" + especie
                    + "', '" + raza + "', '" + tamano + "', '" + fechaNacimiento + "', '" 
                    + fechaVisita + "', '" + comentarios + "');");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void modificarMascota(String dato, String nuevoDato, String id) {
        try {
            Connection con = Conexion.getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("UPDATE `mascotas` SET `" + dato + "` = '" + nuevoDato + "' WHERE (`id` = '" + id + "');");
            comentarios = JOptionPane.showInputDialog("Observaciones:");
            if (!comentarios.equals("")) {
                ps.executeUpdate("UPDATE `mascotas` SET `comentarios` = '" + comentarios + "' WHERE (`id` = '" + id + "');");
            }
            ps.executeUpdate("UPDATE `mascotas` SET `fechaVisita` = '" + LocalDate.now().toString() + "' WHERE (`id` = '" + id + "');");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void eliminarMascota() {
        try {
            String id = JOptionPane.showInputDialog("Digite el ID de la mascota a eliminar:");

            Connection con = Conexion.getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("delete from mascotas where id = " + id + ";");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void buscarMascota(String dato, String valor) {
        String s = "";
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM mascotas WHERE " + dato + " = '" + valor + "';");
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                s = s + "ID: " + res.getString("id") + ", Nombre: " + res.getString("nombre")
                        + ", Edad: " + res.getString("edad") + ", Especie: " + res.getString("especie")
                        + ", Raza: " + res.getString("raza") + ", Ultima Cita: " + res.getString("fechaVisita")
                        + ", Comentarios: " + res.getString("comentarios") + "\n";
            }
            if (s.equals("")) {
                JOptionPane.showMessageDialog(null, "No existe una mascota con el criterio indicado.");
            } else {
                JOptionPane.showMessageDialog(null, s);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
