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

public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Cliente buscar(String dni){
        Cliente c = new Cliente();
        String sql="SELECT * FROM cliente WHERE Dni="+dni;
        try{
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                c.setIdCliente(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEstado(rs.getString(5));
            }
        }catch(Exception e){
            
        }
        return c;
    }     
    
    public List listar() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("IdCliente"));
                cliente.setDni(rs.getString("Dni"));
                cliente.setNombres(rs.getString("Nombres"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setEstado(rs.getString("Estado"));
                lista.add(cliente);
            }
        } catch (Exception e) {
            
        }
        return lista;
    }

    public int agregar(Cliente cliente) {
        String sql = "INSERT INTO cliente(Dni, Nombres, Direccion, Estado) VALUES(?,?,?,?)";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
            
        }
        return r;
    }

    public Cliente listarId(int id) {
        Cliente cliente = new Cliente();
        String sql = "SELECT * FROM cliente WHERE IdCliente=?";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente.setIdCliente(rs.getInt("IdCliente"));
                cliente.setDni(rs.getString("Dni"));
                cliente.setNombres(rs.getString("Nombres"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setEstado(rs.getString("Estado"));
            }
        } catch (Exception e) {
            
        }
        return cliente;
    }

    public int actualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET Dni=?, Nombres=?, Direccion=?, Estado=? WHERE IdCliente=?";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getEstado());
            ps.setInt(5, cliente.getIdCliente());
            ps.executeUpdate();
        } catch (Exception e) {
            
        }
        return r;
    }

    public void delete(int id) {
        String sql="DELETE FROM cliente WHERE IdCliente="+id;
        try{
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            
        }
    }
}
