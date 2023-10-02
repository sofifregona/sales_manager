<h2>INTRODUCCIÓN:</h2>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    El presente proyecto tiene por objetivo realizar el análisis, diseño y prototipado de un sistema informático que permita gestionar las ventas del sector de kiosco/bar de la empresa Megamultiservicios para su posterior implementación y testeo.</p>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    La realización del mismo surge como consecuencia de un problema detectado por los encargados de la empresa, el cual será analizado en profundidad para lograr identificar la solución informática más adecuada.</p>
    <br>
 
<h2>DESARROLLO:</h2>

<h3>Contexto de negocio:</h3>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    La empresa Mega Multiservicios se encuentra localizada en la ciudad de Santa Fe, y se dedica principalmente al lavado de autos y otros tipos de vehículos, actividad que realiza bajo el nombre comercial de Mega Lavaautos. A su vez, dispone de un sector bar que se desempeña como actividad secundaria de la empresa.</p>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Los clientes del sector bar se dividen en dos tipos, aquellos que acuden al bar con el principal objetivo de consumir alimentos y/o bebidas, y aquellos que ingresan derivados del sector de lavado de autos, a la espera de que finalice el servicio. El bar cuenta con un sector con 18 mesas para los clientes que deseen consumir dentro del establecimiento, pero también es posible realizar pedidos para llevar. Posee tres métodos de pago: efectivo, transferencia bancaria y mercado pago.</p>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    El bar ofrece un descuento especial del 20% para todos los empleados de la empresa y para algunos clientes asiduos.</p>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Se consumen tanto productos de terceros (gaseosas, snacks, panadería, etc) como de elaboración propia (ensaladas, sándwiches, licuados, etc). El bar no cuenta con depósito, por lo que los pedidos a los proveedores se realizan Just-In-Time con una frecuencia semanal aproximadamente.</p>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Respecto al personal, el bar cuenta con dos vendedores/camareros encargados de tomar los pedidos, prepararlos (en el caso de alimentos no elaborados) o derivarlos a cocina (cuando se trata de platos más complejos), llevarlos a la mesa y cobrarles a los clientes. A su vez, cuenta con un encargado general, responsable de realizar los pedidos de productos y materias primas a los proveedores y establecer los precios del menú.</p>
 
<h3>Diagnóstico del problema:</h3>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Luego de realizar un relevamiento de información a través de un programa de entrevistas y de la observación de la metodología de trabajo pude detectar las siguientes problemáticas:</p>
<ul>
  <li>No se lleva un registro ni físico ni digital del total de lo que se cobra a los clientes ni del método de pago utilizado.</li>
  <li>No se registra a cuáles ventas se les aplicó el descuento del 20%.</li>
  <li>Los precios de los productos se encuentran detallados en listas impresas que usualmente se pierden o deterioran.</li>
  <li>Cuando los precios aumentan, se imprimen nuevas listas de productos, pero muchas veces no se quita de circulación la lista con precios desactualizados.</li>
  <li>Los vendedores no suelen utilizar estas listas porque les resultan poco prácticas (debido a la cantidad de productos) y generalmente memorizan los valores de los productos más consumidos. Esto representa un problema si se tiene en cuenta que los precios se actualizan frecuentemente.</li>
  <li>No se lleva un registro de lo consumido por cada mesa al momento de cobrarles a los clientes. Los vendedores suelen memorizar lo consumido por cada cliente.</li>
</ul>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Todo lo anteriormente expuesto imposibilitaba la tarea de realizar la contabilidad al finalizar el día y, lo que es aún más grave, al finalizar el mes. </p>

<h3>Requerimientos del sistema:</h3>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Con la información recopilada se han establecido los siguientes requerimientos funcionales y no funcionales:</p>

  <ul>
    <li><b>FUNCIONALES:</b>
      <ol>
        <li>Crear un nuevo producto, asignándole un código, nombre, precio y, si  correspondiera, una marca y una categoría de producto.</li>
        <li>Filtrar productos por código, nombre, marca y/o categoría.</li>
        <li>Modificar cualquier campo de un producto.</li>
        <li>Dar la baja lógica de un producto.</li>
        <li>Crear una marca asignándole un nombre.</li>
        <li>Modificar una marca.</li>
        <li>Dar la baja lógica de una marca.</li>
        <li>Crear una nueva categoría de producto asignándole un nombre.</li>
        <li>Modificar una categoría de producto.</li>
        <li>Dar la baja lógica de una categoría de producto.</li>
        <li>Crear una nueva mesa asignándole un número de mesa.</li>
        <li>Modificar una mesa.</li>
        <li>Dar la baja lógica de una mesa.</li>
        <li>Crear un nuevo método de pago asignándole un nombre.</li>
        <li>Modificar un método de pago.</li>
        <li>Dar la baja lógica de un método de pago.</li>
        <li>Abrir una nueva venta que registre la fecha y hora y el número de mesa asociado.</li>
        <li>Modificar una venta activa agregando o quitando productos. El total consumido debe calcularse automáticamente.</li>
        <li>Cerrar una venta asignándole un método de pago y visualizando el total a cobrarle al cliente.</li>
        <li>Visualizar los ingresos obtenidos de las ventas para una fecha o rango de fechas.</li>
      </ol>
    </li>
    <br>
    <li><b>NO FUNCIONALES:</b>
      <ol>
        <li>El sistema deberá almacenar los datos en una base de datos de tipo relacional (SQL).</li>
        <li>El sistema deberá contar con un proceso de autenticación que permita discriminar los roles de “usuario” y “administrador”.</li>
        <li>Las claves de “usuario” y “administrador” deberán encriptarse en la base de datos.</li>
        <li>El sistema deberá contar con una arquitectura MVC (modelo-vista-controlador) desarrollada en el lenguaje Java del lado del servidor (utilizando Hibernate y JPA) y HTML, CSS y JavaScript del lado del cliente.</li>
      </ol>
    </li>
  </ul>
