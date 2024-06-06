/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

public class VentaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public String GenerarSerie() {
        String numeroserie = "";
        String sql = "SELECT max(NumeroSerie) FROM ventas";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                numeroserie = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al generar el número de serie de ventas: " + e.getMessage());
        }
        return numeroserie;
    }

    public String IdVentas() {
        String idventas = "";
        String sql = "SELECT max(IdVentas) FROM ventas";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idventas = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener ID de ventas: " + e.getMessage());
        }
        return idventas;
    }

    public int guardarVenta(Venta ve) {
        String sql = "INSERT INTO ventas (IdCliente, IdEmpleado,NumeroSerie,FechaVentas,Monto,Estado) VALUES (?,?,?,?,?,?)";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ve.getIdcliente());
            ps.setInt(2, ve.getIdempleado());
            ps.setString(3, ve.getNumserie());
            ps.setString(4, ve.getFecha());
            ps.setDouble(5, ve.getMonto());
            ps.setString(6, ve.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar venta: " + e.getMessage());
        }
        return r;
    }

    public int guardarDetalleVentas(Venta venta) {
        String sql = "insert into detalle_ventas(IdVentas,IdProducto,Cantidad,PrecioVenta)values(?,?,?,?) ";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getId());
            ps.setInt(2, venta.getIdproducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecio());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al guardar el detalle de la venta: " + e.getMessage());
        }
        return r;
    }
}
