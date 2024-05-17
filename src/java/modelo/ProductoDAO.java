/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;

public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Producto buscar(int id) {
        Producto prod = new Producto();
        String sql = "SELECT * FROM producto WHERE idproducto=" + id;
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                prod.setIdProducto(rs.getInt(1));
                prod.setNombres(rs.getString(2));
                prod.setPrecio(rs.getDouble(3));
                prod.setStock(rs.getInt(4));
                prod.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error al buscar producto: " + e.getMessage());
        }
        return prod;
    }

    public int actualizarstock(int id, int stock) {
        String sql = "UPDATE producto SET Stock=? WHERE idproducto=?";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar stock del producto: " + e.getMessage());
        }
        return r;
    }

//****************operaciones CRUD*****************/
    public List listar() {
        String sql = "SELECT * FROM producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setIdProducto(rs.getInt(1));
                prod.setNombres(rs.getString(2));
                prod.setPrecio(rs.getDouble(3));
                prod.setStock(rs.getInt(4));
                prod.setEstado(rs.getString(5));
                lista.add(prod);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar productos y agregarlos a la lista: " + e.getMessage());
        }
        return lista;
    }

    public int agregar(Producto prod) {
        String sql = "INSERT INTO producto(Nombres, Precio, Stock, Estado) VALUES(?,?,?,?)";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getNombres());
            ps.setDouble(2, prod.getPrecio());
            ps.setInt(3, prod.getStock());
            ps.setString(4, prod.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al agregar producto: " + e.getMessage());
        }
        return r;
    }

    public Producto listarId(int id) {
        Producto prod = new Producto();
        String sql = "SELECT * FROM producto WHERE IdProducto=" + id;
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                prod.setIdProducto(rs.getInt(1));
                prod.setNombres(rs.getString(2));
                prod.setPrecio(rs.getDouble(3));
                prod.setStock(rs.getInt(4));
                prod.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener producto por ID: " + e.getMessage());
        }
        return prod;
    }

    public int actualizar(Producto prod) {
        String sql = "UPDATE producto SET Nombres=?, Precio=?, Stock=?, Estado=? WHERE IdProducto=?";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getNombres());
            ps.setDouble(2, prod.getPrecio());
            ps.setInt(3, prod.getStock());
            ps.setString(4, prod.getEstado());
            ps.setInt(5, prod.getIdProducto());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
        }
        return r;
    }

    public void delete(int id) {
        String sql = "DELETE FROM producto WHERE IdProducto=" + id;
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
        }
    }
}
