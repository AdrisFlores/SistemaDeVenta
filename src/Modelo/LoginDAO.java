/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author adria
 */
public class LoginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public login log(String correo, String pass){
        login l = new login();
        String sql= "SELECT * FROM usuarios WHERE correo = ? AND pass= ?";
        try {
           
            con = (Connection) cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, pass);//consulta
            rs=ps.executeQuery();//ejecutar consultar
            if(rs.next()){                            //validar 
                l.setId(rs.getInt("id"));
                l.setNombre(rs.getString("nombre"));
                l.setCorreo(rs.getString("correo"));
                l.setPass(rs.getString("pass"));       
            }
            
            
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            
        }
        return l;
                
        
    }
    
    
}
