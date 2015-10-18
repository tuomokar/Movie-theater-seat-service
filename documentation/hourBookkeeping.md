#Hour bookkeeping

*Note that an hour contains about 5 to 10 minutes of breaks in average. The times are not 100% accurate obviously*

*Time format is dd/mm/yyyy*


**Wednesday 2/9/2015, 1 hour**

Started the project:
- made the repository
- made the project in Netbeans
- started the basic documentation of the project

**Monday 7/9/2015, 5 hours**

- configured Pit to test only certain classes (not Main)
- added checkstyle
- thought about some of the basic functionality more thoroughly
- started actually coding
  - added a couple of domain classes (Seat and Hall)
  - added a couple of file handling classes (HallAdder and HallParser)
  - created javadoc comments for them at the same time
  - created tests for the domain classes and tested them thoroughly

**Tuesday 8/9/2015, 4 hours**

- wrote tests for the HallAdder and HallParser classes
(noteworthy that this took some time as there was some stuff with the files that was a little hard to test and I couldn't get some things to work properly)

**Friday 11/9/2015, 1 hour**

- initial draft of class diagram added
- some minor changes to javadoc
- some general pondering about some things related to certain parts of the project (e.g. perhaps Seat class should just inherit from JButton and how this would affect things)

**Monday 14/9/2015, 2 hours**

- refactored HallAdder and HallParser classes and their tests a little (and extensively checked that the tests were still functional)
- made class HallHandler and a test class for it (and again, checked that the tests functioned well)

**Wednesday 16/9/2015, 3 hours**

- refactored Hall class a little and other classes and tests to fit that
- added HallRemover class and some tests for it (and tested them)
- refactored the other classes dealing with files slightly
- added the functionality for HallRemover to HallHandler class
- started the foundations of the employee UI
  - created some classes for it
  - added some very basic functionality for it at least on the managing side so that you can now actually run the software
  
**Thursday 17/9/2015, 3 hours**

- made command class Add (for theaterManagingUI) functional
- spent time testing it extensively and squashed a lot of bugs
- made some minor adjustments to other classes

**Friday 18/9/2015, 2 hours**

- read about xml and did some simple practising with it
  - how to parse it in Java and create objects out of it
  - how to write it in Java
- updated the class diagram

**Wednesday 23/9/2015, 1 hour**
- thought through and designed the needed changes to the code in order to be able to change the project's file system from simple text files to xml files

**Thursday 24/9/2015, 2 hours**
- changed the file system of the project to xml
  - created a new class Halls for it
  - changed the methods responsible for writing to the file and reading from the file
  - did a lot of other minor changes to the code
  - fixed any now failing (due to the file system change) tests and tested the project (though not quite enough yet to be anywhere close to being actually sure it works completely)
 
**Friday 25/9/2015, 6 hours**
- refactored a lot of classes
  - cleaned out any unneeded methods after the xml change (and some otherwise unneeded ones)
  - added some methods to be more clear
  - updated the tests and added some tests
- wrote some tests for the Halls class
- wrote the basic functionality for SeeInfo command class
- encountered either some goofy JAXB behavior or a bug and hit my head on the table because of that for quite a while (not really, well a little, but mostly spent a lot of time trying to debug it)
  - (the problem being that at the moment it seems to unmarshal the halls currently in the xml file correctly, but for some reason all of the classes don't realize it and for example when writing new 
  halls into the xml file for the first time after the software is turned on, the already existing halls aren't remembered anymore and thus the content is reseted)
  - (was unsuccessful with fixing the problem so will keep on bumping my head to the table later)
  
**Wednesday 30/9/2015, 15 minutes**
- fixed some typos
- did some general thinking related to the project

**Thursday 1/10/2015, 2 hours**
- reminded myself on how Java Swing works and did some practising with it
- created the basic functionality for the customer serving GUI
  - user can choose the hall to be shown
  - GUI shows all the seats of that hall and user can click on the seats to choose their seat

**Friday 2/10/2015, 3 hours**
- reminded myself on how sequence diagrams work
- made a couple of sequence diagrams
- improved the GUI slightly and did some refactoring
- removed unnecessary bloat from the test classes (unused imports, unused methods and javadoc)
- some minor refactoring in general
- did some thinking related to the project

**Tuesday 13/10/2015, 3 hours**
- studied how to create tabbed panes with swing
- studied a bunch of other things mostly related to swing
- made the CustomerServingUI class a bit more user friendly and secure
- added a sequence diagram and updated the class diagram
- did some general thinking related to the project

**Thursday 15/10/2015, 4 hours**
- ditched the text UI and moved to complete GUI

**Friday 16/10/2015, 6 hours**
- added functionality the GUI and wrestled with some bugs

**Saturday 17/10/2015, 10 hours**
- added functionality the GUI and wrestled with some bugs
- added class to handle any input errors and wrote tests for it
- went through every class and did some refactoring and updated javadoc

**Sunday 18/10/2015, 7 hours**
- squashed any remaining bugs and finished the GUI
- separated the logic from the UI better with class UILogicHandler
- updated diagrams
- finished documentation
- finished the project