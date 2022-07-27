The application is a simulation of a toy robotModel moving on a square tabletop, of dimensions 5 units x 5 units.

There are no other obstructions on the table surface.

The robotModel is free to roam around the surface of the table, but must be prevented from falling to destruction. Any movement that would result in the robotModel falling from the table must be prevented, however further valid movement commands must still be allowed.

Create an application that can read in commands of the following form:

PLACE X,Y,F
MOVE
LEFT
RIGHT
REPORT

PLACE will put the toy robotModel on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST.

The origin (0,0) can be considered to be the SOUTH WEST most corner.

The first valid command to the robotModel is a PLACE command, after that, any sequence of commands may be issued, in any order, including another PLACE command. The application should discard all commands in the sequence until a valid PLACE command has been executed.

MOVE will move the toy robotModel one unit forward in the direction it is currently facing.

LEFT and RIGHT will rotate the robotModel 90 degrees in the specified direction without changing the position of the robotModel.

To be exact, LEFT is clock-wise direction, and RIGHT is counter clock-wise direction. not this is correct understanding, need to further examine this.

REPORT will announce the X,Y and F of the robotModel. This is in the form of "Robot is facing Z at X and Y"

A robotModel that is not on the table can choose the ignore the MOVE, LEFT, RIGHT and REPORT commands. . Input can be from a file, or from standard input, as the developer chooses. . Provide test data to exercise the application.

Constraints: The toy robotModel must not fall off the table during movement. This also includes the initial placement of the toy robotModel. Any move that would cause the robotModel to fall must be ignored.

Example Input and Output:

a)

PLACE 0,0,NORTH
MOVE
REPORT
Output: 0,1,NORTH
b)

PLACE 0,0,NORTH
LEFT
REPORT
Output: 0,0,WEST
c)

PLACE 1,2,EAST
MOVE
MOVE
LEFT
MOVE
REPORT
Output: 3,3,NORTH