#Hour bookkeeping

*Note that an hour contains about 5 to 10 minutes of breaks in average*

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