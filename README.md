# ICS-372-GP1
Problem
  Create, test, and document a system for an application with business processes and other
  requirements described below.
 
 Business Processses
  A small co-op grocery store works by having members join it by paying a certain fee. The
  business processes are:
    
 1) Enroll a member: the system enrolls a member and remembers him/her; it keeps track of the name, address, phone number, date joined, and the amount paid as fee. These values are all entered at the time of member creation. Also, the system creates and maintains a unique id for each member.
   
 2) Remove a member: a member may be removed; the system would need the member’s id for this purpose.
 
3) Retrieve member info: Given a member name, the system displays the member’s address, fee paid, and id. If there is more than one member with the same name, print all such members.
 
 4) Add products: From time to time, the store decides to carry a new set of products. The products must then be added one by one. Relevant attributes are: product name, id, current price, and a minimum reorder level for the product. Once the quantity in stock reaches the reorder level or below, the product will be automatically reordered. No two products have the same name. So if the store carries coconut milk, there could be products such as “Low-value coconut milk” and “Unsafeway coconut milk.” When the user tries to add a product, the system orders the product. The quantity ordered is twice the minimum reorder level. For example, assume “California Orange Juice” is a new product that is being entered and that the reorder level is 100 units. The system automatically generates an order for 200 units. Each item is ordered separately and received as a separate shipment.

5) Check out a member’ cart: The member comes to the check-out counter with a cart of grocery items. The cashier inputs the product id and quantity for each and every item in the cart. The system computes, computes the total price. All members pay by cash. The system must display the individual items, the number of units, unit price, and price for the item. For example, if the user purchases three gallons of milk and two loaves of bread, the display might be
    
  Milk 3 $4.50 $13.50
    
  Bread 2 $1.50 $3.0
    
  Total $18.00

  The total price must also be displayed.

When a customer is checked out, reorder any product whose level reaches the reorder level (or below the level). Reorder 2 * reorder level. Also display a message saying that the item will be reordered. If an order has already been placed for this product and has not been fulfilled, do not reorder. For example, suppose the reorder level for Milk is 50 (bottles). Suppose on August 1, the quantity on stock falls to 40 after a certain purchase. You will now create an order for 100 bottles of Milk. Suppose before this order is fulfilled, on August 2, the stock falls from 40 to 35 after another purchase. The system should detect that an order has already been placed and not yet fulfilled, and should not reorder the product.

6) Retrieve product info: Given a product name, the system displays the product’s id, price, and stock in hand.

7) Process shipment: Whenever there is delivery of items from a supplier, the stocks must be updated. The system needs the product id to locate the product and quantity delivered to the store. Multiple shipments may be processed, one by one. Display the product id, name, and the new stock. Remember that each shipment has exactly one product. As stated earlier, each item is ordered separately and received as a separate shipment.

8) Change price: Changes the price of a product given its id. The system displays the product name and the new price.

9) Print transactions: Given the id of a member and two dates (input in the mm/dd/yyyy format), the system prints information (explained later) about each visit made by the corresponding member between the two dates (including both dates). The system must verify that the member id is valid and that the first date is not after the second date; if these conditions are met, the system displays the following information for each visit:
    a) The date on which the user visited the store
    b) The total price paid during that visit
A user may visit the store multiple times on a single day. In that case, there will be line items for each visit.

10) List all members. List name, id, and address of each member.

11) List all products. List product name, id, current price, and a minimum reorder level for the product.

12) List all outstanding orders. List for each order that has not been fulfilled, the product name, id, and amount ordered.

13) Save: Saves all data to disk.

14) Retrieve: Retrieves a given file and use it. Only applicable before any other command is issued.
Make sure that wherever there is reasonable common functionality, factor out code fragments from similar classes and move them to/create super classes. Use generics where applicable.

The User Interface and Other Aspects
  For the purposes of ensuring uniformity in grading, I ask the following.
  1. The interface must be non-GUI, but command driven, just like the library system. I should be able to invoke the business processes by typing in a number as listed under the business processes above: 1 for enrolling a member, 2 for removing a member, etc. Also use 0 for exit and 15 for help.
  2. If a use case asks for processing multiple entities, follow that requirement. If a use case asks for processing a single entity (such as adding a member), be sure not to add multiple members in the corresponding design/implementation.
  3. When the program starts, it should give an option to look for and load existing data on stable storage. If the user answers in the affirmative, that data should be loaded and used. Do not assume any specific directory structure on my system: use the current directory.
  4. In general (that is unless specified elsewhere), the l o o k a n d feel of the interface should be similar to that of the library system. (Obviously, the functionality is different.) This includes the nature of inputting commands and information, displays, etc.
  5. Error messages must be as specific as possible. For example, if an order request is invalid, display the precise reason: bad component id, bad supplier id, quantity <= 0. When the user interface starts, if the user does NOT wish to use a saved file, the program should give an option to programmatically set up a test bed, by prompting as follows.

Do you want to generate a test bed and invoke the functionality using asserts?
  If the user answers y or yes:
    1) The program first creates a number of products (at least 20) and members (at least 5).
    2) After completing Step 1, the program invokes the façade methods for business processes numbered 1, 2, 4, 5, 7, 8. Using assert statements, it checks the returned information and ensures that they are correct. This step should be a thorough test of the corresponding business processes. This test bed should be available for further interactive testing. (See Step 3.)
    3) Finally, the program presents the command line interface, so the user can enter more test data using the interactive approach.
