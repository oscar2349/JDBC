package BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import java.sql.*;

public class ConsultasPreparadas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		
		try {	//CREAR CONEXION
			Connection miconexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
		
			//PREPARA CONSULTA
			
			PreparedStatement mi_sentencia=miconexion.prepareStatement("SELECT* FROM PRODUCTOS WHERE SECCIÓN =? OR CÓDIGOARTÍCULO=?");
		
			// ESTABLECER LOS PARAMETROS DE CONSULTA
			
			mi_sentencia.setString(1,"FERRETERIA");//primer simbolo de ?
			mi_sentencia.setString(2,"AR30");// segundo simbolo de ?//
			
			//EJECUTAR CONSULTA
			
			//crear objero result set
			
			ResultSet rs=mi_sentencia.executeQuery();
			
			while (rs.next()) {//Imprimir lo almacendo, segun el numero de columna
				System.out.println(rs.getString(1)+" " + rs.getString(2)+" " + rs.getString(3)+" " + rs.getString(6)+" " + rs.getString(7));
				//System.out.println();// IMPRIME CON ESPACIO
				
				
			}
			System.out.println();
			System.out.println("Segunda consulta");
			System.out.println();
			rs.close();//liberar memoria
			
			//REUTILIZACION
			
			mi_sentencia.setString(1,JOptionPane.showInputDialog("INGRESE SECCCION"));//primer ?
			mi_sentencia.setString(2,"AR30");// segundo ?//
			
			//EJECUTAR CONSULTA
			
			//crear objero result set
			
			rs=mi_sentencia.executeQuery();
			
			while (rs.next()) {//Imprimir lo almacendo, segun el numero de columna
				System.out.println(rs.getString(1)+" " + rs.getString(2)+" " + rs.getString(3)+" " + rs.getString(6)+" " + rs.getString(7));
				
			}
			rs.close();//liberar memoria
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}

}
