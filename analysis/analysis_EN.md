<h2>INTRODUCTION:</h2>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
The present project aims to carry out the analysis, design, and prototyping of a computer system that allows managing the sales of the kiosk/bar sector of the company M. M. for subsequent implementation and testing.</p>

<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
The execution of it arises as a consequence of a problem detected by the company's managers, which will be analyzed in depth to identify the most suitable computer solution.</p>
<br>

<h2>DEVELOPMENT:</h2>

<h3>Business Context:</h3>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
The company M.M. is located in the city of Santa Fe and it is mainly dedicated to car washing, an activity carried out under the trade name M.L. Additionally, it has a bar section that serves as a secondary activity of the company.</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
The customers of the bar section are divided into two types: those who come with the purpose of using the bar's services and those who, while waiting for the car wash service to finish, enter the bar to consume food and/or drinks. The bar has a dining area with 18 tables for customers who wish to consume inside the establishment, but it is also possible to place orders for take away. There are three payment methods: cash, bank transfer, and MercadoPago.</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
The bar offers a special 20% discount to all company employees and some regular customers.</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Both, third-party products (sodas, snacks, bakery products, etc.) and in-house products (salads, sandwiches, smoothies, etc.) are consumed. The bar does not have a storage facility, so orders to suppliers are made on a Just-In-Time basis with a frequency of approximately once a week.</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Regarding personnel, the bar has two salespersons/waitstaff responsible for taking orders, preparing them (in the case of non-prepared foods) or forwarding them to the kitchen (for more complex dishes), delivering them to the table, and collecting payments from customers. There is also a general manager responsible for placing orders for products and raw materials with suppliers and establishing menu prices.</p>

<h3>Problem Diagnosis:</h3>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
After completing an information gathering by conducting an interviewing program and observing the work methodology, I was able to identify the following issues:</p>
<ul>
  <li>There aren't physical or digital records of the total amount charged to customers or the payment method used.</li>
  <li>There aren't records of which sales had the 20% discount applied to them.</li>
  <li>Product prices are detailed in printed lists that are often lost or damaged.</li>
  <li>When prices increase, new product lists are printed, but often the outdated price lists are not removed from circulation.</li>
  <li>Salespersons often do not use these lists because they find them impractical (due to the number of products) and generally memorize the prices of the most commonly consumed items. This is a problem if we consider that prices are frequently updated because of inflation.</li>
  <li>There are no records of what was consumed at each table when the time to charge customers arrives. Salespersons typically memorize what each customer has consumed.</li>
</ul>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
All of the aforementioned issues made it impossible to perform accounting at the end of the day, and even worse, at the end of the month.</p>

<h3>System Requirements:</h3>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Based on the gathered information, the following functional and non-functional requirements have been established:</p>

<ul>
  <li><b>FUNCTIONAL:</b>
    <ol>
      <li>Create a new product, assigning to it a code, name, price, and, if applicable, a brand and a product category.</li>
      <li>Filter products by code, name, brand, and/or category.</li>
      <li>Modify any field of a product.</li>
      <li>Perform a logical deletion of a product.</li>
      <li>Create a brand, assigning to it a name.</li>
      <li>Modify a brand.</li>
      <li>Perform a logical deletion of a brand.</li>
      <li>Create a new product category, assigning to it a name.</li>
      <li>Modify a product category.</li>
      <li>Perform a logical deletion of a product category.</li>
      <li>Create a new table, assigning to it a table number.</li>
      <li>Modify a table.</li>
      <li>Perform a logical deletion of a table.</li>
      <li>Create a new payment method, assigning to it a name.</li>
      <li>Modify a payment method.</li>
      <li>Perform a logical deletion of a payment method.</li>
      <li>Open a new sale, recording the date and time of it, and associating it with a table number.</li>
      <li>Modify an active sale by adding or removing products. The system must automatically calculate the total amount of the client's purchase.</li>
      <li>Close a sale by assigning a payment method and displaying the total amount to be charged to the customer.</li>
      <li>View the income obtained from sales for a specific date or date range.</li>
    </ol>
  </li>
  <br>
  <li><b>NON-FUNCTIONAL:</b>
    <ol>
      <li>The system must store data in a relational database (SQL).</li>
      <li>The system must have an authentication process that distinguishes between "user" and "administrator" roles.</li>
      <li>User and administrator passwords must be encrypted in the database.</li>
      <li>The system must have an MVC (Model-View-Controller) architecture developed using Java on the server-side (utilizing Hibernate and JPA) and HTML, CSS, and JavaScript on the client-side.</li>
    </ol>
  </li>
</ul>

<h3>Classes Involved:</h3>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Below, the classes that will be involved in the development of the system with their respective attributes.</p>
<ul>
	<li>Brand: id, name, and active.</li>
	<li>Category: id, name, and active.</li>
	<li>Product: id, code, name, price, brand, category, and active.</li>
	<li>Bartable: id, number, and active.</li>
	<li>Payment Method: id, name, and active.</li>
	<li>Sale: id, date and time, bartable, status, products, and total.</li>
</ul>

<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
The fields with the name <i>active</i> are the ones that will allow logical activation and deactivation of the elements by assigning them a boolean value: <i>true</i> if active, <i>false</i> if deactivated. </p>

<h3>Entity-Relationship Diagram and Relational Schema of the Database:</h3>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
The logical model of the database is developed through an ER diagram, and based on this, the relational schema of the database is created. </p>

 <p align="center"><img src="https://github.com/sofifregona/sales_manager/blob/master/analysis/img/ER-diagram.jpg" alt="R" width="600" /></p>
  <p align="center"><img src="https://github.com/sofifregona/sales_manager/blob/master/analysis/img/relational-schema.jpg" alt="R" width="600" /></p>

<h3>Use Cases:</h3>
<table align="center">
	<tr><td width="600">
		<b>Use Case:</b> CreateBrand
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 1
	</td></tr>
	<tr><td width="600">
		<b>Description:</b> The administrator wants to create a new brand.
	</td></tr>
	<tr><td width="600">
		<b>Main Actors:</b> Administrator.
	</td></tr>
	<tr><td width="600">
		<b>Secondary Actors:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Preconditions:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Main Flow:</b>
			<ol>
				<li>In the <i>brand registration</i> section, enter the name of the brand.</li>
				<li>Select <i>save</i>.</li>
				<li>Validate the data.</li>
			</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postconditions:</b> 
			<ol>
				<li>A new brand is created.</li>
			</ol>
	</td></tr>
	<tr><td width="600">
		<b>Alternative Flows:</b>
			<ol>
				<li>InactiveElement
					<ol>
						<li>The brand exists in the database but was previously deactivated. Reactivate it by modifying its <i>active</i> status to <i>true</i>.</li>
					</ol>
				</li>
				<li>InvalidElement
					<ol>
						<li>The brand exists in the database and is active. Inform that a brand with the same name already exists and request a valid name.</li>
					</ol>
				</li>
				<li>EmptyName
					<ol>
						<li>Inform that the <i>name</i> field cannot be left blank and request a valid name.</li>
					</ol>
				</li>
				<li>Cancel</li>
			</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600">
		<b>Use Case:</b> UpdateBrand
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 2
	</td></tr>
	<tr><td width="600">
		<b>Description:</b> The administrator wants to modify a brand.
	</td></tr>
	<tr><td width="600">
		<b>Main Actors:</b> Administrator.
	</td></tr>
	<tr><td width="600">
		<b>Secondary Actors:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Preconditions:</b>
		<ol>
			<li>The brand must exist.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Main Flow:</b>
		<ol>
			<li>Select <i>edit</i> on the brand you wish to modify.</li>
			<li>In the <i>edit brand</i> section, enter the new name.</li>
			<li>Select <i>save</i>.</li>
			<li>Validate the data.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postconditions:</b>
		<ol>
			<li>The selected brand is modified.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Alternative Flows:</b>
		<ol>
			<li>InactiveElement
				<ol>
					<li>The brand exists in the database but was previously deactivated. Reactivate it by modifying its <i>active</i> status to <i>true</i> and logically deactivate the current brand.</li>
				</ol>
			</li>
			<li>InvalidElement
				<ol>
					<li>The brand exists in the database and is active. Inform that a brand with the same name already exists and request a valid name.</li>
				</ol>
			</li>
			<li>EmptyName
				<ol>
					<li>Inform that the <i>name</i> field cannot be left blank and request a valid name.</li>
				</ol>
			</li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600">
		<b>Use Case:</b> DeleteBrand
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 3
	</td></tr>
	<tr><td width="600">
		<b>Description:</b> The administrator wants to delete a brand.
	</td></tr>
	<tr><td width="600">
		<b>Main Actors:</b> Administrator.
	</td></tr>
	<tr><td width="600">
		<b>Secondary Actors:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Preconditions:</b>
		<ol>
			<li>The brand must exist.</li>
			<li>The brand must be active.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Main Flow:</b>
		<ol>
			<li>Select <i>delete</i> on the brand you wish to delete.</li>
			<li>Confirm if you want to delete the brand by clicking <i>accept</i></li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postconditions:</b>
		<ol>
			<li>A logical deactivation is carried out by modifying the <i>active</i> field of the selected brand to <i>false</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Alternative Flows:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600">
		<b>Use Case:</b> CreateCategory
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 4
	</td></tr>
	<tr><td width="600">
		<b>Description:</b> The administrator wants to generate a new product category.
	</td></tr>
	<tr><td width="600">
		<b>Main Actors:</b> Administrator.
	</td></tr>
	<tr><td width="600">
		<b>Secondary Actors:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Preconditions:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Main Flow:</b>
		<ol>
			<li>In the <i>new category</i> section, enter the name of the category.</li>
			<li>Select <i>save</i>.</li>
			<li>Validate the data.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postconditions:</b>
		<ol>
			<li>A new category is created.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Alternative Flows:</b>
		<ol>
			<li>InactiveElement
			<ol>
				<li>The category exists in the database but was previously deactivated. Reactivate it by modifying its <i>active</i> status to <i>true</i>.</li>
			</ol></li>
			<li>InvalidName
			<ol>
				<li>The category exists in the database and is active. Inform that a category with the same name already exists and request a valid name.</li>
			</ol></li>
			<li>EmptyName
			<ol>
				<li>Inform that the <i>name</i> field cannot be left blank and request a valid name.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600">
		<b>Use Case:</b> UpdateCategory
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 5
	</td></tr>
	<tr><td width="600">
		<b>Description:</b> The administrator wants to modify a category.
	</td></tr>
	<tr><td width="600">
		<b>Main Actors:</b> Administrator.
	</td></tr>
	<tr><td width="600">
		<b>Secondary Actors:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Preconditions:</b> 
		<ol>
			<li>The category must exist.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Main Flow:</b>
		<ol>
			<li>Select <i>edit</i> on the category you wish to modify.</li>
			<li>In the <i>edit category</i> section, enter the new name.</li>
			<li>Select <i>save</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postconditions:</b>
		<ol>
			<li>The selected category is modified.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Alternative Flows:</b> 
		<ol>
			<li>InactiveElement
			<ol>
				<li>The category exists in the database but was previously deactivated. Reactivate it by modifying its <i>active</i> status to <i>true</i> and logically deactivate the current category.</li>
			</ol></li>
			<li>InvalidName
			<ol>
				<li>The category exists in the database and is active. Inform that a category with the same name already exists and request a valid name.</li>
			</ol></li>
			<li>EmptyName
			<ol>
				<li>Inform that the <i>name</i> field cannot be left blank and request a valid name.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600">
		<b>Use Case:</b> DeleteCategory
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 6
	</td></tr>
	<tr><td width="600">
		<b>Description:</b> The administrator wants to delete a category.
	</td></tr>
	<tr><td width="600">
		<b>Main Actors:</b> Administrator.
	</td></tr>
	<tr><td width="600">
		<b>Secondary Actors:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Preconditions:</b>
		<ol>
			<li>The category must exist.</li>
			<li>The category must be active.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Main Flow:</b>
		<ol>
			<li>Select <i>delete</i> on the category you wish to delete.</li>
			<li>Confirm the deletion of the category by clicking <i>accept</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postconditions:</b>
		<ol>
			<li>The logical deletion is performed by modifying the <i>active</i> field of the selected category to <i>false</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Alternative Flows:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600">
		<b>Use Case:</b> CreateProduct
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 7
	</td></tr>
	<tr><td width="600">
		<b>Description:</b> The administrator wants to generate a new product.
	</td></tr>
	<tr><td width="600">
		<b>Main Actors:</b> Administrator.
	</td></tr>
	<tr><td width="600">
		<b>Secondary Actors:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Preconditions:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Main Flow:</b>
		<ol>
			<li>In the <i>apply</i> section, enter the code, name, and price. Select brand and category if applicable.</li>
			<li>Select <i>save</i>.</li>
			<li>Validate the data.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postconditions:</b>
		<ol>
			<li>A new product is created.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Alternative Flows:</b>
		<ol>
			<li>InvalidCode
			<ol>
				<li>Inform that a product with the same code already exists and request a valid code.</li>
			</ol></li>
			<li>EmptyCode
			<ol>
				<li>Inform that the <i>code</i> field cannot be left blank and request a valid code.</li>
			</ol></li>
			<li>InvalidName
			<ol>
				<li>Inform that a product with the same name already exists and request a valid name.</li>
			</ol>
			</li>
			<li>EmptyName
			<ol>
				<li>Inform that the <i>name</i> field cannot be left blank and request a valid name.</li>
			</ol>
			</li>
			<li>EmptyPrice
			<ol>
				<li>Inform that the <i>price</i> field cannot be left blank and request a valid price.</li>
			</ol>
			</li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600">
		<b>Use Case:</b> FilterProduct
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 8
	</td></tr>
	<tr><td width="600">
		<b>Description:</b> The administrator wants to search for one or more products.
	</td></tr>
	<tr><td width="600">
		<b>Main Actors:</b> Administrator.
	</td></tr>
	<tr><td width="600">
		<b>Secondary Actors:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Preconditions:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Main Flow:</b>
		<ol>
			<li>In the <i>apply filter</i> section, enter the characters by which you want to filter the product name, brand, and/or category.</li>
			<li>Select <i>search</i>.</li>
			<li>Validate the data.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postconditions:</b>
		<ol>
			<li>A list of active filtered products is returned.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Alternative Flows:</b>
		<ol>
			<li>EmptyList
			<ol>
				<li>Inform that no products were found.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600">
		<b>Use Case:</b> UpdateProduct
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 9
	</td></tr>
	<tr><td width="600">
		<b>Description:</b> The administrator wants to modify a product.
	</td></tr>
	<tr><td width="600">
		<b>Main Actors:</b> Administrator.
	</td></tr>
	<tr><td width="600">
		<b>Secondary Actors:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Preconditions:</b>
		<ol>
			<li>The product must exist.</li>
			<li>The product must be active.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Main Flow:</b>
		<ol>
			<li>Select <i>edit</i> on the product you wish to modify.</li>
			<li>In the <i>edit product</i> section, enter the data you wish to modify (code, name, price, brand, and/or category).</li>
			<li>Select <i>save</i>.</li>
			<li>Validate the data.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postconditions:</b>
		<ol>
			<li>The selected product is modified.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Alternative Flows:</b>
		<ol>
			<li>InvalidCode
				<ol>
					<li>Inform that a product with the same code already exists and request a valid code.</li>
				</ol>
			</li>
			<li>EmptyCode
			<ol>
				<li>Inform that the <i>code</i> field cannot be left blank and request a valid code.</li>
			</ol></li>
			<li>InvalidName
				<ol>
					<li>Inform that a product with the same name already exists and request a valid name.</li>
				</ol>
			</li>
			<li>EmptyName
			<ol>
				<li>Inform that the <i>name</i> field cannot be left blank and request a valid name.</li>
			</ol></li>
			<li>EmptyPrice
			<ol>
				<li>Inform that the <i>price</i> field cannot be left blank and request a valid price.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600">
		<b>Use Case:</b> DeleteProduct
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 10
	</td></tr>
	<tr><td width="600">
		<b>Description:</b> The administrator wants to delete a product.
	</td></tr>
	<tr><td width="600">
		<b>Main Actors:</b> Administrator.
	</td></tr>
	<tr><td width="600">
		<b>Secondary Actors:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Preconditions:</b>
		<ol>
			<li>The product must exist.</li>
			<li>The product must be active.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Main Flow:</b>
		<ol>
			<li>Select <i>delete</i> on the product you wish to delete.</li>
			<li>Confirm the deletion of the product by clicking on <i>accept</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postconditions:</b>
		<ol>
			<li>A logical deletion is performed by modifying the <i>active</i> field of the selected product to <i>false</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Alternative Flows:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600">
		<b>Use Case:</b> CreateBartable
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 11
	</td></tr>
	<tr><td width="600">
		<b>Description:</b> The administrator wants to create a new table.
	</td></tr>
	<tr><td width="600">
		<b>Main Actors:</b> Administrator.
	</td></tr>
	<tr><td width="600">
		<b>Secondary Actors:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Preconditions:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Main Flow:</b>
		<ol>
			<li>In the <i>new table</i> section, enter the corresponding number.</li>
			<li>Select <i>save</i>.</li>
			<li>Validate the data.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postconditions:</b>
		<ol>
			<li>A new table is created.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Alternative Flows:</b>
		<ol>
			<li>InactiveElement
			<ol>
				<li>The table exists in the database but was previously deactivated. Reactivate it by modifying its <i>active</i> status to <i>true</i>.</li>
			</ol></li>
			<li>InvalidNumber
			<ol>
				<li>The table exists in the database and is active. Inform that a table with the same number already exists and request a valid number.</li>
			</ol></li>
			<li>EmptyNumber
			<ol>
				<li>Inform that the <i>number</i> field cannot be left blank and request a valid number.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600">
		<b>Use Case:</b> UpdateBartable
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 12
	</td></tr>
	<tr><td width="600">
		<b>Description:</b> The administrator wants to modify a table.
	</td></tr>
	<tr><td width="600">
		<b>Main Actors:</b> Administrator.
	</td></tr>
	<tr><td width="600">
		<b>Secondary Actors:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Preconditions:</b> 
		<ol>
			<li>The table must exist.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Main Flow:</b>
		<ol>
			<li>Select <i>edit</i> on the table you wish to modify.</li>
			<li>In the <i>edit table</i> section, enter the new table number.</li>
			<li>Select <i>save</i>.</li>
			<li>Validate the data.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postconditions:</b>
		<ol>
			<li>The selected table is modified.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Alternative Flows:</b>
		<ol>
			<li>InactiveElement
			<ol>
				<li>The table exists in the database but was previously deactivated. Reactivate it by modifying its <i>active</i> status to <i>true</i> and logically deactivate the current table.</li>
			</ol></li>
			<li>EmptyNumber
			<ol>
				<li>Inform that the <i>number</i> field cannot be left blank and request a valid number.</li>
			</ol></li>
			<li>InvalidNumber
			<ol>
				<li>Inform that a table with the same number already exists in the database and request a valid number.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600">
		<b>Use Case:</b> DeleteBartable
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 13
	</td></tr>
	<tr><td width="600">
		<b>Description:</b> The administrator wants to delete a table.
	</td></tr>
	<tr><td width="600">
		<b>Main Actors:</b> Administrator.
	</td></tr>
	<tr><td width="600">
		<b>Secondary Actors:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Preconditions:</b>
		<ol>
			<li>The table must exist.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Main Flow:</b>
		<ol>
			<li>Select <i>delete</i> on the table you wish to delete.</li>
			<li>Confirm the deletion of the table by clicking on <i>accept</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postconditions:</b>
		<ol>
			<li>A logical deletion is performed by modifying the <i>active</i> field of the selected table to <i>false</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Alternative Flows:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600">
		<b>Use Case:</b> OpenSale
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 16
	</td></tr>
	<tr><td width="600">
		<b>Description:</b> The user wants to create a new sale.
	</td></tr>
	<tr><td width="600">
		<b>Main Actors:</b> User.
	</td></tr>
	<tr><td width="600">
		<b>Secondary Actors:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Preconditions:</b>
		<ol>
			<li>There must be at least one table.</li>
			<li>The table must not have an active associated sale.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Main Flow:</b>
		<ol>
			<li>In the <i>new sale</i> section, select the number corresponding to the customer's table.</li>
			<li>Select <i>open table</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postconditions:</b>
		<ol>
			<li>A new sale is created with the <i>open</i> field set to <i>true</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Alternative Flows:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600">
		<b>Use Case:</b> AddProductToSale
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 17
	</td></tr>
	<tr><td width="600">
		<b>Description:</b> The user wants to add products to an active sale.
	</td></tr>
	<tr><td width="600">
		<b>Main Actors:</b> User.
	</td></tr>
	<tr><td width="600">
		<b>Secondary Actors:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Preconditions:</b>
		<ol>
			<li>The sale must exist.</li>
			<li>The sale must be active.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Main Flow:</b>
		<ol>
			<li>In the <i>active sales</i> section, select <i>view table</i> in the sale to which you want to add products.</li>
			<li>In the <i>add products</i> section, select the product to add by entering its code or name, and the quantity of units.</li>
			<li>Select <i>add</i>.</li>
			<li>Validate the data.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postconditions:</b>
		<ol>
			<li>An instance of the <i>ProductSold</i> class is created with the data of the sold product, the number of units, the subtotal (price*units), and the associated sale.</li>
			<li>The <i>total</i> field (price to be paid by the customer) of the selected active sale is updated.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Alternative Flows:</b>
		<ol>
			<li>EmptyUnits
			<ol>
				<li>Inform that the <i>units</i> field cannot be left blank and request a valid number of units.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600">
		<b>Use Case:</b> DeleteProductFromSale
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 18
	</td></tr>
	<tr><td width="600">
		<b>Description:</b> The user wants to remove products from an active sale.
	</td></tr>
	<tr><td width="600">
		<b>Main Actors:</b> User.
	</td></tr>
	<tr><td width="600">
		<b>Secondary Actors:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Preconditions:</b>
		<ol>
			<li>The sale must exist.</li>
			<li>The sale must be active.</li>
			<li>The instance of the <i>ProductSold</i> class corresponding to the product to be deleted must exist.</li>
			<li>The instance of the <i>ProductSold</i> class corresponding to the product to be deleted must be associated with the active sale.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Main Flow:</b>
		<ol>
			<li>In the <i>active sales</i> section, select <i>view sale</i> in the sale from which you want to remove the product.</li>
			<li>In the <i>sales for the table</i> section, select the product to be deleted by clicking on <i>delete</i>.</li>
			<li>Confirm if you want to delete the product by clicking on <i>accept</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postconditions:</b>
		<ol>
			<li>The instance of the <i>ProductSold</i> class is deleted from the database.</li>
			<li>The <i>total</i> field (price to be paid by the customer) of the selected active sale is updated.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Alternative Flows:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600">
		<b>Use Case:</b> CloseSale
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 19
	</td></tr>
	<tr><td width="600">
		<b>Description:</b> The user wants to close an active sale.
	</td></tr>
	<tr><td width="600">
		<b>Main Actors:</b> User.
	</td></tr>
	<tr><td width="600">
		<b>Secondary Actors:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Preconditions:</b> 
		<ol>
			<li>The sale must exist.</li>
			<li>The sale must be active.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Main Flow:</b>
		<ol>
			<li>In the <i>active sales</i> section, select <i>view table</i> in the sale you want to close.</li>
			<li>Select <i>close table</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postconditions:</b>
		<ol>
			<li>The value of the <i>open</i> field of the selected sale is modified to <i>false</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Alternative Flows:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600">
		<b>Use Case:</b> ViewSales
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 20
	</td></tr>
	<tr><td width="600">
		<b>Description:</b> The user wants to view sales for a specific date or a range of dates.
	</td></tr>
	<tr><td width="600">
		<b>Main Actors:</b> User.
	</td></tr>
	<tr><td width="600">
		<b>Secondary Actors:</b> None.
	</td></tr>
	<tr><td width="600">
		<b>Preconditions:</b>
		<ol>
			<li>There must be at least one sale.</li>
			<li>The date cannot be in the future.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Main Flow:</b>
		<ol>
			<li>In the <i>select dates</i> section, select the <i>from</i> and <i>to</i> dates for which you want to view the sales from the two calendars.</li>
			<li>Select <i>search</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postconditions:</b>
		<ol>
			<li>A view is generated with the total revenue earned in the selected date range.</li>
			<li>A view is generated with a list of the total units sold for each product.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Alternative Flows:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>
