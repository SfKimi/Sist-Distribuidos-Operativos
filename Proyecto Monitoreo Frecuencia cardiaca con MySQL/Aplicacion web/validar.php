<?php
include_once('conexion.php');

//1. Crear conexión a la Base de Datos
$con=mysqli_connect($host,$usuario,$clave,$bd) or die('Fallo la conexion');
mysqli_set_charset($con,"utf8");




if (isset($_POST['login'])) {
	
	//VARIABLES DEL USUARIO
$usuario = $_POST['cusu'];
$pass = $_POST['cclave'];

//VALIDAR CONTENIDO EN LAS VARIABLES O CAJAS DE TEXTO
if (empty($usuario) | empty($pass)) 
	{
	header("Location: login.php");
	exit();
	}
	
//VALIDANDO EXISTENCIA DEL USUARIO

$consulta = "SELECT * from medico where nombre = '$usuario' and cedula = '$pass' ";
$resultado = mysqli_query($con, $consulta);
	
	while($fila = mysqli_fetch_assoc($resultado))
    {
	 $usu=$fila['nombre'];	
	 $clav=$fila['cedula'];	
		
	}
	
	   
	
  //Valida Usuario y/Contraseña no coincidentes 
   if (($usu != $usuario) | ($clav != $pass))
	{
	header("Location: login.php");
	exit();
	}
		
			
		else 
			{
			header("Location: listado.php");
			exit();
		}
}
 mysqli_close($con);

?>