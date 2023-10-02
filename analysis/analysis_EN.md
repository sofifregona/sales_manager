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
