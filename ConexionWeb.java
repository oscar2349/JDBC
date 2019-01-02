package BasesDeDatos;
import java.sql.*;

public class ConexionWeb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	
	Connection miconexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/registro","root","");
	Statement mistatement=miconexion.createStatement();
	String SQL="INSERT INTO `registroweb`(`Nombres`, `Apellidos`, `Usuario`, `Contraseña`, `Pais`, `Tecnologia`) VALUES ('jose','andres','carlos','2352','colombia','java')" ;
	mistatement.executeUpdate(SQL);
	System.out.println("Se conecto la base de datos");
	

//
	
	// 3. Ejecutar SQL
	
	//ResultSet miresultset=mistatement.executeQuery("select* from PRODUCTOS");//tabla de la base de datos
	
	// 4. Recojer resultset (la tabla)
	
	//while (miresultset.next()) {//el metod getint o getstring para diferentes tipos de datos etc
		//System.out.println(miresultset.getString(3) +" "+ miresultset.getString("precio"));// es posible con el nombre o con el indice de la columna
		

	} catch (Exception e) {
		// TODO: handle exception
		
		System.out.println("fallo en conexion");
		
		e.printStackTrace();
		
	}
	
	//miresultset.close();

		
}
	}

//}
