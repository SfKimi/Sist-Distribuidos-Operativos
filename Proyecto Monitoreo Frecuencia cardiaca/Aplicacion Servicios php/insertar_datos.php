<?php
include_once("conexion.php");
//1. Crear conexi�n a la Base de Datos
$con=mysqli_connect($host,$usuario,$clave,$bd) or die('Fallo la conexion');
mysqli_set_charset($con,"utf8");
//2. Tomar los campos provenientes del Formulario
$vidM = $_GET['cidM'];
$vidU = $_GET['cidU'];
$vfre= $_GET['cfre'];
$inserta = "INSERT INTO $bd.historial (id,id_medico,id_usuario,frecuencia) VALUES (null,$vidM,$vidU,$vfre);";
$resultado = mysqli_query($con,$inserta);
echo json_encode ($resultado);
mysqli_close($con);
?>

