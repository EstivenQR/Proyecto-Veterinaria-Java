package veterinariaislademello;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import DBCon.Conexion;

public class EditarCli {

    public void MostarCliente(JTable TablaClientes) {

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

        TablaClientes.setModel(modelo);
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
            TablaClientes.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror al conectar con la base de datos");

        }

    }

    public void SeleccionCliente(JTable TablaCliente, JTextField txtnombre, JTextField txtcedula, JTextField txtdireccion, JTextField txttelefono, JTextField txtcorreo, JTextField txtmascota) {

        try {
            int fila = TablaCliente.getSelectedRow();
            if (fila >= 0) {

                txtnombre.setText((TablaCliente.getValueAt(fila, 0).toString()));
                txtcedula.setText((TablaCliente.getValueAt(fila, 1).toString()));
                txtdireccion.setText((TablaCliente.getValueAt(fila, 2).toString()));
                txttelefono.setText((TablaCliente.getValueAt(fila, 3).toString()));
                txtcorreo.setText((TablaCliente.getValueAt(fila, 4).toString()));
                txtmascota.setText((TablaCliente.getValueAt(fila, 5).toString()));

            } else {
                JOptionPane.showMessageDialog(null, "Cliente no seleccionado");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la seleccion del Cliente");
        }
    }

    public void ModificarCliente(JTextField txtnombre, JTextField txtcedula, JTextField txtdireccion, JTextField txttelefono, JTextField txtcorreo, JTextField txtmascota) {
        
        String enc = "select * from clientes";
        Conexion con = new Conexion();
        Connection cn = Conexion.getConnection();

        try {
            PreparedStatement ps = cn.prepareStatement("UPDATE clientes Set clientes.nombre ='" + txtnombre.getText() + " ' ,clientes.cedula ='" + txtcedula.getText() + " ' ,clientes.direccion ='"
                    + txtdireccion.getText() + " ' ,clientes.telefono ='" + txttelefono.getText() + " ' ,clientes.correo ='"
                    + txtcorreo.getText() + " ' ,clientes.mascota ='" + txtmascota.getText() + " ' where clientes.cedula='" + txtcedula.getText() + "'");
            int indice = ps.executeUpdate();
            if (indice > 0) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un Cliente");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void BuscarCed(JTextField BusCed, JTextField txtnombre, JTextField txtcedula, JTextField txtdireccion, JTextField txttelefono, JTextField txtcorreo, JTextField txtmascota) {

        String Consulta = "Select Nombre,Cedula,Direccion,Telefono,Correo,Mascota From clientes Where clientes.cedula=(?)";
        Conexion conexion = new Conexion();

        try {
            java.sql.CallableStatement cs = conexion.getConnection().prepareCall(Consulta);
            cs.setString(1, BusCed.getText());
            cs.execute();
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Cliente Encontrado");
                txtnombre.setText(rs.getString("Nombre"));
                txtcedula.setText(rs.getString("Cedula"));
                txtdireccion.setText(rs.getString("Direccion"));
                txttelefono.setText(rs.getString("Telefono"));
                txtcorreo.setText(rs.getString("Correo"));
                txtmascota.setText(rs.getString("Mascota"));

            } else {
                JOptionPane.showMessageDialog(null, "Cliente no Encontrado");
                txtnombre.setText(rs.getString(""));
                txtcedula.setText(rs.getString(""));
                txtdireccion.setText(rs.getString(""));
                txttelefono.setText(rs.getString(""));
                txtcorreo.setText(rs.getString(""));
                txtmascota.setText(rs.getString(""));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Conectar la base de Datos");
        }
    }

    public void eliminar(JTextField txtcedula) {

        Conexion con = new Conexion();
        Connection cn = Conexion.getConnection();

        try {
            PreparedStatement ps = cn.prepareStatement("DELETE FROM clientes Where clientes.cedula='" + txtcedula.getText() + "'");
            int indice = ps.executeUpdate();
            if (indice > 0) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
