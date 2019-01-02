package BasesDeDatos;
import java.sql.*;

public class Conexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	//1. crear conexion
	Connection miconexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");//no es neceesario indicar el puerto 3306, pero es mejor
	
	// 2. crear objeto Statement
	
	Statement mistatement=miconexion.createStatement();
	
//		INSERTAR UN REGISTRO
		String instrucionSql="INSERT INTO PRODUCTOS (`CÓDIGOARTÍCULO`,`SECCIÓN`,`NOMBREARTÍCULO`) VALUES ('AR77','PANTALON','20')";	

		mistatement.executeUpdate(instrucionSql);

		System.out.println("DATOS INSERTADOS");
		

//
	
	// 3. Ejecutar SQL
	
	ResultSet miresultset=mistatement.executeQuery("select* from PRODUCTOS");//tabla de la base de datos
	
	// 4. Recojer resultset (la tabla)
	
	while (miresultset.next()) {//el metod getint o getstring para diferentes tipos de datos etc
		System.out.println(miresultset.getString(3) +" "+ miresultset.getString("precio"));// es posible con el nombre o con el indice de la columna
		

	}
	
	miresultset.close();

		
} catch (Exception e) {
	// TODO: handle exception
	
	System.out.println("fallo en conexion");
	
	e.printStackTrace();
	
}
	}

}
