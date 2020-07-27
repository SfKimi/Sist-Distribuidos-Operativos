<?php
include_once('conexion.php');

$con=mysqli_connect($host,$usuario,$clave,$bd) or die('Fallo la conexion');
mysqli_set_charset($con,"utf8");


?>



<!DOCTYPE html>
<html>
    <head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- PAGE settings -->
  <link rel="icon" href="https://templates.pingendo.com/assets/Pingendo_favicon.ico">
  <title>App Aquamarine - Pingendo template</title>
  <meta name="description" content="Free Bootstrap 4 Pingendo Aquamarine template made for app and softwares.">
  <meta name="keywords" content="Pingendo app aquamarine free template bootstrap 4">
  <!-- CSS dependencies -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="aquamarine.css">
  <!-- Script: Make my navbar transparent when the document is scrolled to top -->
  <script src="js/navbar-ontop.js"></script>
  <!-- Script: Animated entrance -->
  <script src="js/animate-in.js"></script>
    </head>
<body>
  <nav class="navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container"> <a class="navbar-brand" href="#">Medic APP</a> <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent" aria-controls="navbar2SupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
    </div>
  </nav>
    <div class="pt-5 bg-primary">
    <div class="container mt-5 pt-5">
      <div class="row">
      </div>
      <div class="row">
        <div class="col-md-12">
        </div>
      </div>
        <!-- Consulta que permite seleccionar Los Nombres y Apellidos del Cliente -->
		<?php
         
		 $consulta="SELECT * FROM $bd.historial";
         $resultado = mysqli_query($con,$consulta) or die(mysql_error());
				   
        ?>
		
        <div id="apDiv1">
        
          <table align="center" width="710" border="0">
            <tr>
              <td width="664"><form class="form">
                <input class="form-control" type="text" name="txtbuscar">
                <input type="submit" value="Buscar">     
            </form>
              
              </td>
              
            </tr>
          </table>
          
        </div>
       		
		<!-- Consulta que permite seleccionar Los Datos de la venta -->
		<?php
          $buscar = isset($_GET['txtbuscar']) ? $_GET['txtbuscar'] : '';
		  
		  if($buscar!=null){
		  $consulta="SELECT * FROM $bd.historial WHERE $bd.historial.cedula_usuario='$buscar'";
            
		  $resultado = mysqli_query($con,$consulta) or die(mysql_error());
		  }else{
                 echo "NO SE ENCONTRÓ NINGUN REGISTRO RELACIONADO...";
               }		   
        ?>
        
        <div class="container"> 
      <center>
        <h3>Listado General</h3></center>
            <p>&nbsp;</p>
          <p>&nbsp;</p>
      <hr>
            <hr>
            <table class="table table-bordered">
                <tr>
                    <th class="text-center">ID.</th>
                    <th class="text-center">Cedula medico</th>
                    <th class="text-center">cedula usuario</th>
                    <th class="text-center">id registro</th>
                    <th class="text-center">frecuencias</th>
                    
                </tr>
                <?php
                while($fila = mysqli_fetch_array($resultado)){
                ?>
                <tr>
                    <td class="text-center"><?php echo $fila['id_historial'];?></td>
                    <td class="text-center"><?php echo $fila['cedula_medico'];?></td>
                    <td class="text-center"><?php echo $fila['cedula_usuario'];?></td>
                    <td class="text-center"><?php echo $fila['id_registro'];?></td>
                    <td class="text-center"><?php echo $fila['frecuencias'];?></td>
                                      
                </tr>
                <?php 
				}
				
				 mysqli_close($con);  
			    ?>           
               
          </table>
        </div> 
        
    </body>
</html>
