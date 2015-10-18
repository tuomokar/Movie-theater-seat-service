#Project Structure Description

**Packages**
- seatservice
  - The main package
- seatservice.domain
  - Contains classes that represent the essential physical aspects of the movie theater
- seatservice.filehandling
  - Contains classes that handle anything to do with the file system that is used to save information on the halls
- seatservice.userinterface
  - Contains the UI class
- seatservice.userinterface.command
  - Contains an enum class that is used as helper in some methods
- seatservice.userinterface.listeners
  - Contains some custom made listeners for certain events
- seatservice.userinterface.logic
  - Contains classes that are responsible for handling the logic in the UI
  

**Classes**
- *Main*
  - Package: seatservice
  - Begins the program, i.e. creates the userinterface and starts it
  
- *Hall*
  - Package: seatservice.domain
  - Represents a single hall in the movie theater
  - Each hall has a name, amount of rows and amount of seats on each rows. Contains a map containing all the seats of the hall.
  
- *Halls*
  - Package: seatservice.domain
  - Encapsulates all the halls to a list the this class contains

- *Seat*
  - Package: seatservice.domain
  - Represents a single seat a hall of the movie theater.
  
- *HallHandler*
 - Package: seatservice.filehandling
 - Uses the HallAdder, HallRemover and HallParser classes to deal with the database xml file
 
- *HallAdder*
  - Package: seatservice.filehandling
  - Adds halls to the xml database file and into the list of the instance of <code>Halls</code> class
  
- *HallRemover*
  - Package: seatservice.filehandling
  - Removes halls from the xml database file and from the list of the instance of <code>Halls</code> class
  
- *HallParser*
  - Package: seatservice.filehandling
  - Parses the xml database file and unmarshals its information to <code>Hall</code> objects and puts them into the instance of the <code>Halls</code> class

- *UserInterface*
  - Package: seatservice.userinterface
  - Handles the user interface

- *Command*
  - Package: seatservice.userinterface.command
  - A simple enum class to determine the purpose of use for some methods

- *ClickListener*
  - Package: seatservice.userinterface.listeners
  - Listener for the seats in the GUI
  
- *HallNamesListener*
  - Package: seatservice.userinterface.listeners
  - Listener for the JLists containing the names of the halls in the GUI
  
- *InputErrorHandler*
  - Package: seatservice.userinterface.logic
  - Handles user input errors
  
- *UILogicHandler*
  - Package: seatservice.userinterface.logic
  - Handles the logic of the UI
  
**What really happens in the program once it's launched**

The program starts from the <code>Main</code> class. There the user interface is created and launched.

In the <code>UserInterface</code> class along with initializing all the variables the UI needs and setting the proper positions and such,
an instance of the <code>HallNamesListener</code> is also initialized. Once these are all done, instance of <code>UILogicHandler</code> is initialized.
The class gets all the needed tables, lists, panes, labels and text fields it needs to check input, give error messages, show halls visually and such.

In the constructor of <code>UILogicHandler</code> an instance of <code>HallHandler</code> is initialized, which initializes the <code>HallAdder</code>,
<code>HallParser</code>, <code>HallRemover</code> and <code>Halls</code> classes. After that in the <code>UILogicHandler</code> class <code>HallHandler</code>
is used to parse any possibly existing halls in the xml database file to objects. To do that, the HallHandler class uses an instance of <code>HallParser</code> class,
which uses JAXB (Java Architecture for XML Binding) to unmarshal the file. Any hall unmarshalled gets its seats also initialized.

Once the file is parsed the constructor of <code>UILogicHandler</code> continues with initializing all the tables, lists, panes and such and then adds
action listeners to the appropriate variables. After doing this all the constructor creates an in instance of <code>InputErrorHandler</code> which too
receives all the necessary fields it needs to check for input values and give proper error messages related to them. After <code>InputErrorHandler</code>
having initialized everything it needs to, the constructor of <code>UILogicHandler</code> finally fills all the appropriate fields in the GUI with the
information it has on any possible unmarshalled <code>Hall/<code> objects.

Now, everything having been initialized, the UI simply sees what the user does and uses the instance of <code>UILogicHandler</code> to do what is needed,
whether it's to show the halls in a visual representation, add new hall, update an existing hall, reset the hall view or remove a hall. The 
<code>UILogicHandler</code> uses <code>HallHandler</code> and <code>InputErrorHandler</code> as needed.