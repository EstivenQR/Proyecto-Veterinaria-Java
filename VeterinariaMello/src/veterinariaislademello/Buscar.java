package veterinariaislademello;

import java.sql.*;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import DBCon.Conexion;

public class Buscar {

    public void MostarCliente(JTable Tabla) {

        String Busc = "select * from clientes";
        Statement st;
        Conexion objconexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");
        modelo.addColumn("Cedula");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Correo");
        modelo.addColumn("Mascota");

        Tabla.setModel(modelo);
        String[] Datos = new String[8];

        try {
            st = objconexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(Busc);

            while (rs.next()) {
                Datos[0] = rs.getString(1);
                Datos[1] = rs.getString(2);
                Datos[2] = rs.getString(3);
                Datos[3] = rs.getString(4);
                Datos[4] = rs.getString(5);
                Datos[5] = rs.getString(6);
                modelo.addRow(Datos);
            }
            Tabla.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar la base de datos");
        }
    }

    public void BuscarCed(JTextField CedBus, JTextField nomResult, JTextField cedResult, JTextField dirResult, JTextField telResult, JTextField corResult, JTextField masResult) {

        String Consulta = "Select Nombre,Cedula,Direccion,Telefono,Correo,Mascota From clientes Where clientes.cedula=(?)";
        Conexion conexion = new Conexion();

        try {
            CallableStatement cs = conexion.getConnection().prepareCall(Consulta);
            cs.setString(1, CedBus.getText());
            cs.execute();
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Cliente Encontrado");
                nomResult.setText(rs.getString("Nombre"));
                cedResult.setText(rs.getString("Cedula"));
                dirResult.setText(rs.getString("Direccion"));
                telResult.setText(rs.getString("Telefono"));
                corResult.setText(rs.getString("Correo"));
                masResult.setText(rs.getString("Mascota"));
            } else {
                JOptionPane.showMessageDialog(null, "Empleado no Encontrado");
                nomResult.setText(rs.getString(""));
                cedResult.setText(rs.getString(""));
                dirResult.setText(rs.getString(""));
                telResult.setText(rs.getString(""));
                corResult.setText(rs.getString(""));
                masResult.setText(rs.getString(""));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Conectar la base de Datos");
        }
    }

    public void SeleccionCliente(JTable tabla, JTextField nomResult, JTextField cedResult, JTextField dirResult, JTextField telResult, JTextField corResult, JTextField masResult) {

        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {

                nomResult.setText(tabla.getValueAt(fila, 0).toString());
                cedResult.setText(tabla.getValueAt(fila, 0).toString());
                dirResult.setText(tabla.getValueAt(fila, 0).toString());
                telResult.setText(tabla.getValueAt(fila, 0).toString());
                corResult.setText(tabla.getValueAt(fila, 0).toString());
                masResult.setText(tabla.getValueAt(fila, 0).toString());

            } else {
                JOptionPane.showMessageDialog(null, "Empleado no sleccionado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror en la seleccion");
        }
    }
}
