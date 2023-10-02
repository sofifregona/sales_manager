<h2>INTRODUCCIÓN:</h2>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    El presente proyecto tiene por objetivo realizar el análisis, diseño y prototipado de un sistema informático que permita gestionar las ventas del sector de kiosco/bar de la empresa M.M. para su posterior implementación y testeo.</p>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    La realización del mismo surge como consecuencia de un problema detectado por los encargados de la empresa, el cual será analizado en profundidad para lograr identificar la solución informática más adecuada.</p>
    <br>
 
<h2>DESARROLLO:</h2>

<h3>Contexto de negocio:</h3>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    La empresa M.M. se encuentra localizada en la ciudad de Santa Fe, y se dedica principalmente al lavado de autos y otros tipos de vehículos, actividad que realiza bajo el nombre comercial de M.L.. A su vez, dispone de un sector bar que se desempeña como actividad secundaria de la empresa.</p>
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
  <li>Los vendedores no suelen utilizar estas listas porque les resultan poco prácticas (debido a la cantidad de productos) y generalmente memorizan los valores de los productos más consumidos. Esto representa un problema si se tiene en cuenta que los precios se actualizan frecuentemente debido a la inflación.</li>
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
        <li>El sistema deberá contar con un proceso de autenticación que permita discriminar los roles de <i>usuario</i> y <i>administrador</i>.</li>
        <li>Las claves de <i>usuario</i> y <i>administrador</i> deberán encriptarse en la base de datos.</li>
        <li>El sistema deberá contar con una arquitectura MVC (modelo-vista-controlador) desarrollada en el lenguaje Java del lado del servidor (utilizando Hibernate y JPA) y HTML, CSS y JavaScript del lado del cliente.</li>
      </ol>
    </li>
  </ul>

<h3>Clases involucradas:</h3>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	A continuación, se describen las clases que estarán involucradas en el desarrollo del  sistema, con sus respectivos atributos.</p>
<ul>
	<li>Marca: id, nombre y activo.</li>
	<li>Categoría: id, nombre y activo.</li>
	<li>Producto: id, código, nombre, precio, marca, categoría y activo.</li>
	<li>Mesa: id, número y activo.</li>
	<li>Método de pago: id, nombre y activo.</li>
	<li>Venta: id, fecha y hora, mesa, estado, productos y total.</li>
</ul>

<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	Los campos con el nombre <i>activo</i> son los que permitirán dar el alta y la baja lógica de los  elementos al asignarles un valor booleano: <i>true</i> si está activo, <i>false</i> si fue dado de baja. </p>
 
<h3>Diagrama entidad relación y esquema relacional de la Base de Datos:</h3>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	Se desarrolla el modelo lógico de la base de datos a través de un diagrama ER y, partiendo de este, el esquema relacional de la base de datos. </p>

 <p align="center"><img src="https://github.com/sofifregona/sales_manager/blob/master/analysis/img/ER-diagram.jpg" alt="R" width="600" /></p>
  <p align="center"><img src="https://github.com/sofifregona/sales_manager/blob/master/analysis/img/relational-schema.jpg" alt="R" width="600" /></p>

<h3>Actores del sistema:</h3>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<b>Administrador:</b> El encargado del sector de ventas o la persona a la que éste designe. </p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
 	<b>Usuario:</b> Los empleados que realizan las ventas y el servicio a la venta. 
</p>

<h3>Casos de uso:</h3>
<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> CreateBrand
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 1
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El administrador desea generar una nueva marca.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Administrador.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b> Ninguna.
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
			<ol>
				<li>En la sección <i>registrar marca</i> se ingresa el nombre de la misma.</li>
				<li>Se selecciona <i>guardar</i>.</li>
				<li>Se validan los datos.</li>
			</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b> 
			<ol>
				<li>Se crea una nueva marca.</li>
			</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
			<ol>
				<li>InactiveElement
					<ol>
						<li>La marca existe en la base de datos, pero fue dada de baja con anterioridad. Se le  vuelve a dar el alta modificando su estado <i>activo</i> a <i>true</i>.</li>
					</ol>
				</li>
				<li>InvalidElement
					<ol>
						<li>La marca existe en la base de datos y está activa. Se informa que ya existe una marca con dicho nombre y se solicita que se ingrese un nombre válido.</li>
					</ol>
				</li>
				<li>EmptyName
					<ol>
						<li>Se informa que no puede quedar en blanco el campo <i>nombre</i> y se solicita que se  ingrese un nombre válido.</li>
					</ol>
				</li>
				<li>Cancel</li>
			</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> UpdateBrand
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 2
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El administrador desea modificar una marca.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Administrador.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b>
		<ol>
			<li>La marca debe existir.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
		<ol>
			<li>Se selecciona <i>editar</i> en la marca que se desea modificar.</li>
			<li>En la sección <i>editar marca</i> se ingresa el nuevo nombre.</li>
			<li>Se selecciona <i>guardar</i>.</li>
			<li>Se validan los datos.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
		<ol>
			<li>Se modifica la marca seleccionada.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
		<ol>
			<li>InactiveElement
				<ol>
					<li>La marca existe en la base de datos, pero fue dada de baja con anterioridad. Se le vuelve a dar el alta modificando su estado <i>activo</i> a <i>true</i> y se le da la baja lógica a la marca actual.</li>
				</ol>
			</li>
			<li>InvalidElement
				<ol>
					<li>La marca existe en la base de datos y está activa. Se informa que ya existe una marca con dicho nombre y se solicita que se ingrese un nombre válido.</li>
				</ol>
			</li>
			<li>EmptyName
				<ol>
					<li>Se informa que no puede quedar en blanco el campo <i>nombre</i> y se solicita que se ingrese un nombre válido</li>
				</ol>
			</li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> DeleteBrand
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 3
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El administrador desea eliminar una marca.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Administrador.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b>
		<ol>
			<li>La marca debe existir.</li>
			<li>La marca debe estar activa.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
		<ol>
			<li>Se selecciona <i>borrar</i> en la marca que se desea eliminar.</li>
			<li>Se confirma si se desea borrar la marca haciendo click en <i>aceptar</i></li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
		<ol>
			<li>Se procede a la baja lógica, modificando el campo <i>activo</i> de la marca seleccionada por <i>false</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> CreateCategory
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 4
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El administrador desea generar una nueva categoría de producto.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Administrador.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b> Ninguna.
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
		<ol>
			<li>En la sección <i>nueva categoría</i> se ingresa el nombre de la misma.</li>
			<li>Se selecciona <i>guardar</i>.</li>
			<li>Se validan los datos.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
		<ol>
			<li>Se crea una nueva categoría.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
		<ol>
			<li>InactiveElement
			<ol>
				<li>La cateogría en la base de datos, pero fue dada de baja con anterioridad. Se le vuelve a dar el alta modificando su estado <i>activo</i> a <i>true</i>.</li>
			</ol></li>
			<li>IvalidName
			<ol>
				<li>La categoría existe en la base de datos y está activa. Se infroma que ya existe una categoría con dicho nombre y se solicita que se ingrese un nombre válido.</li>
			</ol></li>
			<li>EmptyName
			<ol>
				<li>Se infroma que no puede quedar en blanco el campo <i>nombre</i> y se solicita que se ingrese un nombre válido.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> UpdateCategory
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 5
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El administrador desea modificar una categoría.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Administrador.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b> 
		<ol>
			<li>La categoría debe existir.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
		<ol>
			<li>Se selecciona <i>editar</i> en la categoría que se desea modificar.</li>
			<li>En la sección <i>editar categoría</i> se ingrea el nuevo nombre.</li>
			<li>Se selecciona <i>guardar</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
		<ol>
			<li>Se modifica la categoría seleccionada.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b> 
		<ol>
			<li>InactiveElement
			<ol>
				<li>La categoría existe en la base de datos, pero fue dada de baja con anterioridad. Se le vuelve a dar el alta modificando su estado <i>activo</i> a <i>true</i> y se le da la baja lógica a la cateogría actual.</li>
			</ol></li>
			<li>InvalidName
			<ol>
				<li>La categoría existe en la base de datos y está activa. Se informa que ya existe una categoría con dicho nombre y se solicita que se ingrese un nombre válido.</li>
			</ol></li>
			<li>EmptyName
			<ol>
				<li>Se informa que no puede quedar en blanco el campo <i>nombre</i> y se solicita que se ingrese un nombre válido.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> DeleteCategory
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 6
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El administrador desea eliminar una categoría.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Administrador.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b>
		<ol>
			<li>La cateogoría debe existir.</li>
			<li>La categoría debe estar activa.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
		<ol>
			<li>Se selecciona <i>borrar</i> en la categoría que se desea eliminar.</li>
			<li>Se confirma si se desea borrar la categoría haciendo click en <i>aceptar</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
		<ol>
			<li>Se procede a la baja lógica, modificando el campo <i>activo</i> de la categoría seleccionada por <i>false</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> CreateProduct
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 7
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El administrador desea generar un nuevo producto.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Administrador.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b> Ninguna.
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
		<ol>
			<li>En la sección <i>aplicar</i> se ingresa código, nombre y precio. Se seleccionan marca y categoría si corresponde.</li>
			<li>Se selecciona <i>guardar</i>.</li>
			<li>Se validan los datos.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
		<ol>
			<li>Se crea un nuevo producto.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
		<ol>
			<li>InvalidCode
			<ol>
				<li>Se informa que ya existe un producto con dicho código y se solicita que se ingrese un código válido.</li>
			</ol></li>
			<li>EmptyCode
			<ol>
				<li>Se informa que no puede quedar en blanco el campo <i>código</i> y se solicita que se ingrese un código válido.</li>
			</ol></li>
			<li>InvalidName
			<ol>
				<li>Se informa que ya existe un producto con dicho nombre y se solicita que se ingrese un nombre válido.</li>
			</ol>
			</li>
			<li>EmptyName
			<ol>
				<li>Se infroma que no puede quedar en blanco el campo <i>nombre</i> y se solicita que se ingrese un nombre válido.</li>
			</ol>
			</li>
			<li>EmptyPrice
			<ol>
				<li>Se informa que no puede quedar en blanco el campo <i>price</i> y se solicita que se ingrese un precio válido.</li>
			</ol>
			</li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> FilterProduct
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 8
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El administrador desea buscar uno o más productos.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Administrador.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b> Ninguna.
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
		<ol>
			<li>En la sección <i>aplicar filtro</i> se ingresan los caracteres por los cuales desea filtrar el nombre del producto, la marca y/o la categoría.</li>
			<li>Se selecciona <i>buscar</i>.</li>
			<li>Se validan los datos.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
		<ol>
			<li>Se devuelve una lista con los productos activos filtrados.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
		<ol>
			<li>EmptyList
			<ol>
				<li>Se informa que no se ha encontrado ningún producto.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> UpdateProduct
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 9
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El administrador desea modificar un producto.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Administrador.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b>
		<ol>
			<li>El producto debe existir.</li>
			<li>El producto debee estar activo.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
		<ol>
			<li>Se selecciona <i>editar</i> en el producto que se desea modificar.</li>
			<li>En la sección <i>editar producto</i> se ingresan los datos que se desean modificar (código, nombre, precio, marca y/o categoría).</li>
			<li>Se selecciona <i>guardar</i>.</li>
			<li>Se validan los datos.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
		<ol>
			<li>Se modifica el producto seleccionado.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
		<ol>
			<li>InvalidCode
				<ol>
					<li> Se informa que ya existe un producto con dicho código y se solicita que se ingrese un código válido.</li>
				</ol>
			</li>
			<li>EmptyCode
			<ol>
				<li>Se informa que no puede quedar en blanco el campo <i>código</i> y se solicita que ingrese un código válido.
			</ol></li>
			<li>InvalidName
				<ol>
					<li>Se informa que ya existe un producto con dicho nombre y se solicita que se ingrese un nombre válido.</li>
				</ol>
			</li>
			<li>EmptyName
			<ol>
				<li>Se informa que no puede quedar en blanco el campo <i>nombre</i> y se solicita que se ingrese un nombre válido.</li>
			</ol></li>
			<li>EmptyPrice
			<ol>
				<li>Se informa que no puede quedar en blanco el campo <i>precio</i> y se solicita que se ingrese un precio válido.
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> DeleteProcut
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 10
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El administrador desea eliminar un producto.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Administrador.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b>
		<ol>
			<li>El producto debe existir.</li>
			<li>El producto debe estar activo.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
		<ol>
			<li>Se selecciona <i>borrar</i> en el producto que se desea eliminar.</li>
			<li>Se confirma si se desea borrar el producto haciendo click en <i>aceptar</i></li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
		<ol>
			<li>Se procede a la baja lógica, modificando el campo <i>activo</i> del producto sleccionado por <i>false</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> CreateBartable
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 11
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El administrador desea crear una nueva mesa.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Administrador.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b> Ninguna.
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
		<ol>
			<li>En la sección <i>nueva mesa</i> se ingresa el número que corresponde a la misma.</li>
			<li>Se selecciona <i>guardar</i>.</li>
			<li>Se validan los datos.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
		<ol>
			<li>Se crea una nueva mesa.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
		<ol>
			<li>InactiveElement
			<ol>
				<li>La mesa existe en la base de atos, pero fue dada de baja con anterioridad. Se le vuelve a dar el alta modificando su estado <i>activo</i> a <i>true</i>.</li>
			</ol></li>
			<li>IvalidNumber
			<ol>
				<li>La mesa existe en la base de datos y está activa. Se informa que ya exisste una mesa con dicho número y se solicita que se ingrese un número válido.</li>
			</ol></li>
			<li>EmptyNumber
			<ol>
				<li>Se informa que no puede quedar en blanco el campo <i>número</i> y se solicita que se ingrese un número válido.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> UpdateBartable
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 12
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El adminsitrador desea modificar una mesa.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Administrador.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b> 
		<ol>
			<li>La mesa debe existir.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
		<ol>
			<li>Se selecciona <i>editar</i> en la mesa que se desea modificar.</li>
			<li>En la sección <i>editar categoría</i> se ingresa el nuevo número de mesa.</li>
			<li>Se selecciona <i>guardar</i>.</li>
			<li>Se validan los datos.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
		<ol>
			<li>Se modifica la mesa seleccionada.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
		<ol>
			<li>InactiveElement
			<ol>
				<li>La mesa existe en la base de datos, pero fue dada de baja con anterioridad. Se le vuelve a dar el alta modificando su estado <i>activo</i> a <i>true</i> y se le da la baja lógica a la mesa actual.</li>
			</ol></li>
			<li>EmptyNumber
			<ol>
				<li>Se informa que no puede quedar en blanco el campo <i>número</i> y se solicita que se inferse un número válido.</li>
			</ol></li>
			<li>InvalidNumber
			<ol>
				<li>Se informa que ya existe una mesa con dicho número y se solicita que se ingrese un número válido.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> DeleteBartable
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 13
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El administrador desea eliminar una mesa.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Administrador.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b>
		<ol>
			<li>La mesa debe existir.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
		<ol>
			<li>Se selecciona <i>borrar</i> en la mesa que se desea eliminar.</li>
			<li>Se confirma si se desea borrar la mesa haciendo click en <i>aceptar</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
		<ol>
			<li>Se procede a la baja lógica, modificando el campo <i>activo</i> de la mesa seleccionada por <i>false</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> CreatePaymentMethod
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 14
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El administrador desea crear un nuevo método de pago.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Administrador.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b> Ninguna.
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
		<ol>
			<li>En la sección <i>nuevo método de pago</i> se ingresa el nombre del mismo.</li>
			<li>Se selecciona <i>guardar</i>.</li>
			<li>Se validan los datos.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
		<ol>
			<li>Se crea un nuevo método de pago.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
		<ol>
			<li>InactiveElement
			<ol>
				<li>El método de pago existe en la base de datos, pero fue dado de baja con anterioridad. Se le vuelve a dar el alta modificando su estado <i>activo</i> a <i>true</i>.</li>
			</ol></li>
			<li>InvalidName
			<ol>
				<li>El método de pago existe en la base de datos y está activo. Se informa que ya existe un método de pago con dicho nombre y se solicita que se ingrese un nombre válido.</li>
			</ol></li>
			<li>EmptyName
			<ol>
				<li>Se informa que no puede quedar en blanco el campo <i>nombre</i> y se solicita que se ingrese un nombre válido.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> UpdatePaymentMethod
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 15
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El administrador desea modificar un método de pago.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Administrador.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b>
		<ol>
			<li>El método de pago debe existir.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
		<ol>
			<li>Se selecciona <i>editar</i> en el método de pago que se desea modificar.</li>
			<li>En la sección <i>editar método de pago</i> se ingresa el nuevo método de pago.</li>
			<li>Se selecciona <i>guardar</i>.</li>
			<li>Se validan los datos.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
		<ol>
			<li>Se modifica el método de pago seleccionado.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
		<ol>
			<li>InactiveElement
			<ol>
				<li>El método de pago existe en la base de datos, pero fue dada de baja con anterioridad. Se le vuelve a dar el alta modificando su estado <i>activo</i> a <i>true</i> y se le da la baja lógica al méotod de pago actual.</li>
			</ol></li>
			<li>InvalidName
			<ol>
				<li>El método de pago existe en la base de datos y está activo. Se informa que ya existe un método de pago con dicho nombre y se solicita que se ingrese un nombre válido.</li>
			</ol></li>
			<li>EmptyName
			<ol>
				<li>Se informa que no puede quedar en blanco el campo <i>nombre</i> y se solicita que se ingrese un nombre válido.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> OpenSale
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 16
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El usuario desea generar una nueva venta.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Usuario.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b>
		<ol>
			<li>Debe existir al menos una mesa.</li>
			<li>La mesa no debe tener una venta activa asociada.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
		<ol>
			<li>En la sección <i>nueva venta</i> se selecciona el número que corresponde a la mesa del cliente.</li>
			<li>Se selecciona <i>abrir mesa</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
		<ol>
			<li>Se crea una nueva venta con valor <i>true</i> para el campo <i>open</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600 align="center"">
		<b>Caso de uso:</b> AddProductToSale
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 17
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El usuario desea agregar productos a una venta activa.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Usuario.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b>
		<ol>
			<li>La venta debe existir.</li>
			<li>La venta debe estar activa.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
		<ol>
			<li>En la sección <i>ventas activas</i> se selecciona <i>ver mesa</i> en la venta que se desea agregar productos.</li>
			<li>En la sección <i>agregar productos</i> se selecciona el producto a agregar infresando el código o nombre del mismo y la cantidad de unidades.</li>
			<li>Se selecciona <i>agregar</i>.</li>
			<li>Se validan los datos.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
		<ol>
			<li>Se genera una instancia de la clase <i>ProductSold</i> con los datos del producto vendido, las unidades del mismo, el subtotal (precio*unidades) y la venta a la que se encuentra asociado.</li>
			<li>Se actualiza el campo <i>total</i> (precio a pagar por el cliente) de la venta activa seleccionada.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
		<ol>
			<li>EmptyUnities
			<ol>
				<li>Se informa que no puede quedar en blanco el campo <i>unidades</i> y se solicita que se ingrese un número de unidades válido.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> DeleteProductFromSale
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 18
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El usuario desea quitar productos de una venta activa.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Usuario.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b>
		<ol>
			<li>La venta debe existir.</li>
			<li>La venta debe estar activa.</li>
			<li>La instancia de la clase <i>ProductSold</i> a la que corresponde el producto que se desea eliminar debe existir.</li>
			<li>La instancia de la clase <i>ProductSold</i> a la que corresponde el producto que se desea eliminar debe estar asociada al a venta activa.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
		<ol>
			<li>En la sección <i>ventas activas</i> se selecciona <i>ver venta</i> en la venta que se desea quitar el producto.</li>
			<li>En la sección <i>ventas de la mesa</i> se selecciona el producto que se desea eliminar haciendo click en <i>borrar</i>.</li>
			<li>Se confirma si se desea borrar el producto haciendo click en <i>aceptar</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
		<ol>
			<li>La instancia de la clase <i>ProductSold</i> es eliminada de la base de datos.</li>
			<li>Se actualiza el campo <i>total</i> (precio a pagar por el cliente) de la venta activa seleccionada.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> CloseSale
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 19
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El usuario desea cerrar una venta activa.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Usuario.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b> 
		<ol>
			<li>La venta debe existir.</li>
			<li>La venta debe estar activa.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
		<ol>
			<li>En la sección <i>ventas activas</i> se selecciona <i>ver mesa</i> en la venta que se desea cerrar.</li>
			<li>Se selecciona <i>cerrar mesa</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
		<ol>
			<li>Se modifica el valor del campo <i>open</i> de la venta seleccionada pasando a ser <i>false</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> ViewSales
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 20
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b> El usuario desea ver las ventas de una fecha específica o un rango de fechas.
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> Usuario.
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> Ninguno.
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b>
		<ol>
			<li>Debe existir al menos una venta.</li>
			<li>La fecha no puede ser futura.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
		<ol>
			<li>En la sección <i>seleccionar fechas</i> se seleccionan de los dos calendarios las fechas <i>desde</i> y <i>hasta</i> las cuales se desea visualizar las ventas.</li>
			<li>Se selecciona <i>buscar</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
		<ol>
			<li>Se genera una vista con el total de ingresos percibidos en le rango de fechas seleccionado.</li>
			<li>Se genera una vista con una lista del total de unidades vendidas de cada producto.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>



<!--

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso de uso:</b> 
	</td></tr>
	<tr><td width="600">
		<b>ID:</b>
	</td></tr>
	<tr><td width="600">
		<b>Descripción:</b>
	</td></tr>
	<tr><td width="600">
		<b>Actores principales:</b> 
	</td></tr>
	<tr><td width="600">
		<b>Actores secundarios:</b> 
	</td></tr>
	<tr><td width="600">
		<b>Pre-condiciones:</b>
	</td></tr>
	<tr><td width="600">
		<b>Flujo principal:</b>
	</td></tr>
	<tr><td width="600">
		<b>Pos-condiciones:</b>
	</td></tr>
	<tr><td width="600">
		<b>Flujos alternativos:</b>
	</td></tr>
</table>

-->

