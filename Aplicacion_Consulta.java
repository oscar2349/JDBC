package AplicacionConexionBDD;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Aplicacion_Consulta {

	public static void main(String[] args) {
		
		JFrame mimarco=new Marco_Aplicacion();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}
}      

/***************** CREACION DE LA VENTANA GRAFICA**************/
class Marco_Aplicacion extends JFrame{
	private Connection miconexion;
	private JComboBox secciones;
	private JComboBox paises;
	private JTextArea resultado;
	private PreparedStatement enviaConsulta;
	private final String ConsultaSeccion="SELECT* FROM PRODUCTOS WHERE SECCIÓN =?";
	
	
	public Marco_Aplicacion(){
		
		setTitle ("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JPanel menus=new JPanel();
		
		menus.setLayout(new FlowLayout());
		
		//BOTON DE SECCIONES
		
		secciones=new JComboBox();
		
		secciones.setEditable(false);
		
		secciones.addItem("SECCIONES");
		
		//BOTON DE PAISES
		
		paises=new JComboBox();
		
		paises.setEditable(false);
		
		paises.addItem("PAISES");
		
		//ESPACIO DE LA CONSULTA
		resultado= new JTextArea(4,50);
		
		resultado.setEditable(false);
		
		add(resultado);
		
		menus.add(secciones);
		
		menus.add(paises);	
		
		add(menus, BorderLayout.NORTH);
		
		add(resultado, BorderLayout.CENTER);
		
		//BOTON CONSULTA
		
		JButton botonConsulta=new JButton("Consulta");	
		
		botonConsulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EjecutaConsulta();
				
			}
		});
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		
		
		
		/***************************CONEXION A LA BASE DE DATOS****************/
		
		try {
			//1. crear conexion CARGANDO EL EXTERNAL JAR
			
			miconexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");//contructor de mi conexion
			
			//2. crear objeto Statement
			
			Statement sentencia=miconexion.createStatement();
			
			
			/***********************BOTON DE SECCIONES**************************/
			
			
			String Consulta="SELECT distinctrow`SECCIÓN` FROM `productos`";// SENTENCIA SQL
			
			ResultSet rs=sentencia.executeQuery(Consulta);//ejecuto la consulta
			
			while (rs.next()) {
				
				secciones.addItem(rs.getString(1));
			}
			
			rs.close();
			
			
			/***********************BOTON DE PAISES**************************/
			
			
			Consulta="SELECT distinctrow`PAÍSDEORIGEN` FROM `productos`";// SENTENCIA SQL REDEFINIENDO LA VARIABLE
			
			rs=sentencia.executeQuery(Consulta);//ejecuto la consulta
			
			while (rs.next()) {
				
				paises.addItem(rs.getString(1));
			}
			
			rs.close();
			
			
			/*********************CAPTURA DE LA EXCEPCION*********************/
							
		} catch (Exception e) {
			
			System.out.println("fallo en conexion");
			
			e.printStackTrace();
			
		}
		
	}
	
	private void EjecutaConsulta() {
		
		ResultSet rs=null;
		try {
			resultado.setText("");//poner en blanco las consultas
			String Seccion=(String)secciones.getSelectedItem();//devuelve un objeto toca hacer un casting
			enviaConsulta=miconexion.prepareStatement(ConsultaSeccion);
			enviaConsulta.setString(1, Seccion);// se reemplaza el ? de la consulta preparada y se trae la seleccion de la lista desplegable
			rs=enviaConsulta.executeQuery();// se ejecuta la consulta
			
		
		
		} catch (Exception e) {
			
		}
		
		try {
			while (rs.next()) {
				
				resultado.append(rs.getString(1));
				resultado.append(" , ");
				resultado.append(rs.getString(2));
				resultado.append(" , ");
				resultado.append(rs.getString(3));
				resultado.append(" , ");
				resultado.append(rs.getString(4));
				resultado.append(" , ");
				resultado.append(rs.getString(5));
				resultado.append(" , ");
				resultado.append(rs.getString(6));
				resultado.append(" , ");
				resultado.append(rs.getString(7));
				resultado.append(" , ");
				resultado.append(rs.getString(8));
				resultado.append("\n");
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
	}
}

