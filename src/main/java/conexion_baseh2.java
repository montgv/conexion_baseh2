import java.sql.*;

public class conexion_baseh2 {
    public static void main(String[] args) {
        try {
            //Antes de comenzar debemos de añadir la depencecia de hsqldb

            //Cargamos el driver
            Class.forName("org.h2.Driver");

            //Declaramos la variable para guardar la direccion de la base de datos y como se llama
            String url = "jdbc:h2:C:/Users/MateBook/Desktop/DAM/2ºDAM/ACDAT/TEMA 2/baseH2/pracEmbedida";

            //Establecemos la conexion con la base de datos
            Connection conexion = DriverManager.getConnection(url, "montse", "");

            //Preparamos la consulta que deseamos realizar
            Statement sentencia = conexion.createStatement();
            String consulta = "SELECT apellido, oficio, salario FROM empleados";
            ResultSet resultado = sentencia.executeQuery(consulta);

            //Recorremos el resultado obtenido de la consulta mediante un bucle mientras que haya registros
            while (resultado.next()) {
                System.out.println("Apellido: " + resultado.getString(1));
                System.out.println("Oficio: " + resultado.getString(2));
                System.out.println("Salario: " + resultado.getInt(3));
            }

            //Cerramos los recursos utilizados
            resultado.close();
            sentencia.close();
            conexion.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
