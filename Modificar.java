package BasesDeDatos;
import java.sql.*;

public class Modificar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	
	//1. crear conexion
	Connection miconexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");//no es neceesario indicar el puerto 3306, pero es mejor
	
	// 2. crear objeto Statement
	
	Statement mistatement=miconexion.createStatement();
	
//		INSERTAR UN REGISTRO
	
		String instrucionSql="INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO,SECCIÓN,NOMBREARTÍCULO) VALUES ('AR11','PANTALON','20')";	

		mistatement.executeUpdate(instrucionSql);

	

		String instrucionSq2="UPDATE PRODUCTOS SET NOMBREARTÍCULO='100' WHERE CÓDIGOARTÍCULO='AR11'";	

		mistatement.executeUpdate(instrucionSq2);

		System.out.println("DATOS INSERTADOS O MODIFICADOS");

		
} catch (Exception e) {
	// TODO: handle exception
	
	System.out.println("fallo en conexion");
	
	e.printStackTrace();
	
}
}
}
	


