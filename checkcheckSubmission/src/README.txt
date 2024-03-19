Student name: Owen Bedford
Student number: 200348014

Please complete this README file for your level 3 mini-project submission.

If your level 1/2 submission did not get full marks you MUST complete the second part of this template describing how and where your have improved your code so that it now meets the level 1 and 2 requirements. If your code still does not meet level 1 and 2 requirements then you will get 0 for level 3.

LEVEL THREE

GUI

[Explain in three or four sentences how your code responds to a button being pressed (or other user interaction) in the GUI. Give file names and line numbers of where the code is that responds to user interaction.

One of the key examples of my code responding to a button being pressed is by pressing the Next Level button which results in the current visibile panel changing to the next levels panel and in the case a player is in a level which involves combat they are unable to change panels until they've cleared that combat room this is done by making said class implement the interface ActionListener (and providing implementation for the method actionPerformed) and calling the instance method addActionListener on a button object (and passing an instance of a class which implements ActionListener as an argument). 

The code which involves this example occurs in GUI.java at lines 34, 35, 74, 78, 82 and 125 - 144 (within 125-144 for the actionPerformed method), line 47 of BattleLevel.java, line 43 of MerchantLevel.java and line 32 of ChestLevel.java. 

Another example is the Inventory button which when pressed makes a inventory panel visible and allows a user to change their currently equipped weapons through another series of buttons, there's also a button with a label added to it which makes it have Close Inventory which when pressed makes the old panel visibile again which was visible before opening the inventory. 

Within the GameInformationPanel.java the code for this example occurs at lines 31, 32, 33, 69 - 82 (69- 82 is for the actionPerformed method) and lines of code for Close Inventory button is 31, 32, 48 - 54 within the InventoryPanel.java and the code for equipping items is lines 30, 33 and lines 56 - 93 also within InventoryPanel.java. 

When the player is in a combat room the BattleLevel panel is visibile and they can select which attack they'd like to use on an enemy through the use of a Choice component and Button component to the panel.

The lines of code for this is within the BattleLevel.java at lines 27 - 32 and lines 52 - 82 (this is within the actionPerformed method).


]

Exceptions

[Within the class named GUI, at line numbers 89 - 97 exception handling is used]
[At line numbers 89 - 98 this involves file input which may result in a IOException or ClassNotFoundException being thrown within the context of my code. An example of why a IOException may be thrown could be due to issues with reading the file. It's not necessary for the program to end because of this since we can start a new game, hence exception handling can be used to handle these exceptions and allow the game to continue running by starting a new save file by catching the exception.]

Collections

[Within the class named Player, ArrayLists are used at lines 26, 27, 175]
[Within my adventure game it's necessary for a player to have an inventory which holds items they've gained on their journey, as such as the game grows in scope the need to have more items becomes more present. The use of normal arrays is not sufficient as it requires a large amount of code to be changed to accommodate this because of an arrays fixed size. My implementation of array lists greatly reduces this issue and makes adding new items for the game which players can gain a lot easier to maintain and debug which resolves a concern from mini level 2 because of the nature of ArrayLists allowing for size to increase.]

File I/O

[My code implements file input by using objects of the type FileInputStream and ObjectInputStream (these classes have been imported) for reading a file inorder to initialise a player object which appears to the user as being identicle hence the same instance variables as was where a player left off after the games saves. File output is done by calling the instance method named start method for object of the type GameSaveThread (the implementation of multithreading discussed in something impressive) which within the method body for run (since calling start calls run) makes use of objects of the type FileOutputStream and ObjectOutputStream (these classes have been imported) to write a player object to a file named adventureGameSave.txt. Each time a player changes levels the game saves, with information about game progress all retained within the player object.]

'Something impressive'

[Explain in no more than six sentences how and where your code implements OOP/Java principles beyond those taught on the course.
My code has the classes GameSaveThread and MerchantLevelDisplayThread which extends the class Thread which overrides the method run (which is implemented in the superclass Thread because it implements Runnable). When calling the method named start for objects of the type GameSaveThread or MerchantLevelDisplayThread this creates a new thread which executes the contents of the method run (since start calls run). This allows for the main thread to continue running while also having threads running which execute the content within the method run. This is called multi threading and goes beyond what has been taught in this module and opens the doorway for more complicated games for examples games which implement multiplayer. My implementation of multi threading is done in object orientated way through the use of subclasses, overriding and objects. The lines of code where objects of the type GameSaveThread or MerchantLevelDisplayThread are used for the purposes of multithreading occur at the lines 129 in GUI.java for saving the game, and at lines 45 of MerchantLevel.java for displaying the contents a merchant has which a player can buy the code for the run method mentioned can be found within the classes MerchantLevelDisplayThread and GameSaveThread.]


LEVELS 1 AND 2

(ONLY complete this if you did not get full marks for your level 1/2 submission.)

LEVEL ONE

[Briefly (three sentences) explain the changes you have made to your code so that it fully meets the level one requirements.]

My code demonstrates inheritance in the following way...

I have a superclass called [Insert name of superclass here]

This superclass is extended into at least two subclasses called [Insert names of the subclasses here]

For each of the named subclasses complete the following...

Subclass 1.

Subclass [Insert name of subclass] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [Insert names of properties here.]

These/this new properties/property are used by the subclass in the following way: [Insert justification for adding the property and give the line numbers in the code of where the property is used.]

Subclass [Insert name of subclass] extends the superclass by overriding the following methods (there must be at least one): [Insert names of overridden methods and their line numbers in the code.]

These overridden methods are used in the working code in the following places: [list the file names and line numbers where the overridden methods are called.]

Subclass 2.

Subclass [Insert name of subclass] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [Insert names of properties here.]

These/this new properties/property are used by the subclass in the following way: [Insert justification for adding the property and give the line numbers in the code of where the property is used.]

Subclass [Insert name of subclass] extends the superclass by overriding the following methods (there must be at least one): [Insert names of overridden methods and their line numbers in the code.]

These overridden methods are used in the working code in the following places: [list the file names and line numbers where the overridden methods are called.]


LEVEL TWO

[Briefly (three sentences) explain the changes you have made to your code so that it fully meets the level two requirements.]

Polymorphism consists of the use of the Substitution principle and Late Dynamic binding.

In my code, polymorphism is implemented in at least two places…

Example 1.

The substitution principle can be seen in use in [class name and line number where substitution is used]. The name of the superclass used this example is [name of superclass] and the subclasses used are [names of subclasses].

Late dynamic binding can be seen in [class name and line number].

[Explain briefly (no more than four sentences), why this example of polymorphism is necessary in your code.]

Example 2.

The substitution principle can be seen in use in [class name and line number where substitution is used]. The name of the superclass used this example is [name of superclass] and the subclasses used are [names of subclasses].

Late dynamic binding can be seen in [class name and line number].

[Explain briefly (no more than four sentences), why this example of polymorphism is necessary in your code.]

