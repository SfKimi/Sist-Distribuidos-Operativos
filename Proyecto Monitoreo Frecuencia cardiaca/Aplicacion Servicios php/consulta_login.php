<?php
include_once("conexion.php");

//1. Crear conexión a la Base de Datos

$con=mysqli_connect($host,$usuario,$clave,$bd) or die('Fallo la conexion');
mysqli_set_charset($con,"utf8");

//2. Tomar los campos provenientes de la tabla

$nusu=$_GET["cusuario"];
$cla=$_GET["cclave"];


$consulta="SELECT usuario,clave,usuarios.nombre,edad,medicos.telefono,usuarios.cedula,usuarios.id_medico FROM $bd.usuarios,$bd.medicos where usuario='$nusu' AND clave='$cla' and id_medico=medicos.id;";

if ($resultado = mysqli_query($con, $consulta)){

	while($fila = mysqli_fetch_row($resultado))
        {
	 echo json_encode($fila);
	 
	}
}		

mysqli_free_result($resultado);

mysqli_close($con);
?>
