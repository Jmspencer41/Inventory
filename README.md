# Inventory Management Application #
This application allows users to manage inventory items, including adding, editing, searching, and deleting items.

## Prerequisites ##
Java Development Kit (JDK) 21    
JavaFX library  
## Build Instructions ##
1. Clone the repository to your local machine:  
**git clone https://github.com/jmspencer41/inventory.git**
2. Navigate to the project directory:  
**cd inventory**
3. Compile the Java files:  
**javac com/inventory/frontends/\*.java com/inventory/classes/\*.java com/inventory/controllers/*.java**
## Run Instructions ##
1. Run the application:  
**java com.inventory.frontends.InventoryApplication**
## Usage ##
Upon running the application, you will be presented with the Inventory Management interface. Here's how to use it:  

* **Adding an Item:**  
  * Click on the "Add Inventory" button.
  * Enter the item details in the provided fields (name, description, price, quantity).
  * Click the "Add" button to add the item to the inventory.
* **Editing an Item:**  
  * Click on the "Edit" button next to the item you want to edit.
  * Modify the item details as needed.
  * Click the "Save" button to save the changes.
* **Searching for an Item:**  
  * Enter the name of the item you want to search for in the search field.
  * Click the "Search" button.
  *If the item is found, it will be displayed in the inventory list.
* **Deleting an Item:**  
  * Click on the "Delete" button next to the item you want to delete.
  * Confirm the deletion.
* **Saving the Inventory:**  
  * Click on the "Save" button to save the current state of the inventory to a file.
* **Switching to Dark Mode:**  
  * Click on the "Dark Mode" button to switch to a dark theme.
* **Navigating to Settings:**  
  * Click on the "Settings" button to access additional settings.
## Additional Notes ##  
* The inventory data is saved to a text file (inventory.txt) located in the src/main/resources/files/ directory.

