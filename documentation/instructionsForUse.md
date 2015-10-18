# Instructions for use

Welcome to the movie theater seat service software. These instructions assume you are an employee of your movie theater who has the 
rights to manipulate any info relating to the movie theater's halls. If your boss has not given you clearance to be able to do that, 
then please DO NOT use the software to change any info relating to the halls! These instructions also assume some other things such 
as that you have already downloaded the software to your computer and you know where it's located and that you can use the command line 
and that you have java installed on your computer.

If you do have all the rights, then please continue. We wish you will have a lot of fun time and good memories from using our software!

---------------------------------------------------------------------
**Running the software**
To run this software, go into the software's location on the command line and write <code>java -jar Seatservice-1.0-SNAPSHOT.jar</code>.
The graphical user interface should open up. The user interface starts at the Administration tab.



**Adding a new hall**
To add a new hall you must give it a name, amount of rows and amount of seats on each row and then press the <code>Add Hall!</code> button.

Note that you can not give any empty values, and the rows and seats must be integers. Rows and seats also must be above zero. There is no 
top limit but the software sort of assumes your movie theater isn't some super massive movie theater having halls containing many thousands
of seats.

Once you have added a hall, its information should appear in the table below the input text fields and on the list to right of the aforementioned
table. The name should also appear on the list on the Customer serving tab.

**Updating an existing hall**
To update a hall, you must give an existing hall's name and new values for the rows and seats and press the <code>Update!</code> button. 
Again, note that any of the values can not be empty and the rows and integers must be integers and above zero. If everything seems fine, 
the program will ask you confirm that you really want to update the chosen hall. 

Once it's updated, the old information is forgotten and the new information is shown in the table and the lists.

**Removing a hall**
To remove a hall simply choose a name from the list on the Administration tab and press <code>Remove hall</code> button. The program will
ask you to confirm that you really want to delete all the information regarding the chosen hall.

Again, the lists and the table are automatically updated to not show the removed hall.

**Showing a hall's seat situation graphically**
If you are in the Administration tab, you must first switch the tab and go to the Customer serving tab. You can choose the tab 
from the top of the user interface.

Once you are on the Administration tab, you can choose a hall from the list shown on the left. Once you have selected a hall, you can press
the <code>Show</code> button to see its seat situation on the big pane on the right. The text "The White Screen" is shown below the hall view 
to mark its relational place to the seats.

Each seat shown has information on its row (for example "r3" to show that it's on the row number three) and the seats place on the row (for
example "20" to show that the seats place on the row is number 20).

Note that if there are no halls in the database, then there are no halls to be shown.

**Reseting the chosen hall's seats to available state**
To reset a hall's seats to available seats simply choose a hall from the list shown on the left of the Administration tab and press 
<code>Reset all seats to available</code> button. The new situation is updated to the hall view.

Alternatively, the hall view is emptied if you switch the tab.

**Emptying the hall view**
To empty the hall view simply press the <code>Empty field</code> button.

**Picking a seat for the customer**
The customer tells you which movie they want to see. You have other software to tell you in which hall that movie is shown, so you first 
choose the hall in question to be shown and press the <code>Show</code> button. Then you have the choice to either recommend seats to the 
customer and pick the seats yourself or let the customer see the view and let them pick it.

To pick the seat in practice, simply press any seat shown on the user interface. The green ones are available, the red ones are seats that 
have been already chosen. Once you press an available seat, it turns red to mark that it's no longer supposed to be available for others.

Note that if you press a seat that is already chosen, it will simply turn green again. You as a responsible employee of course would not
do that as it might mess up things for customers (for example two customers might have the same place), but beware of the possibility if 
you let the customer pick a seat directly.

**Exiting the program**
To exit the program simply press the <code>Exit</code> button on the bottom edge of the user interface. Alternatively, you can press 
<code>X</code> from the top of the program to shut down the program.