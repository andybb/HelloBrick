# HelloBrick

This is a simple project for running code on Lego Mindstorms EV3, using
[leJOS][lejos]. The project contains a class with helper methods, EV3Helper,
which may make it easier to use the device. It also contains a main class and
some examples which utilizes the helper methods for some simple movement.

[lejos]: http://www.lejos.org/ev3/docs/

## Requirements

This project requires that you have [Java Development Kit 7][jdk7] installed on
your system.

[jdk7]: http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html

## Getting Eclipse

There exists a plugin for leJOS to Eclipse, which makes development easy. For
convenience we are distributing Eclipse bundled with the Lejos EV3 plugin.

- [Eclipse for Windows 64-bit](http://www.aaberge.net/stuff/eclipse/eclipse-java-luna-SR2-win32-x86_64.zip)
- [Eclipse for Windows 32-bit](http://www.aaberge.net/stuff/eclipse/eclipse-java-luna-SR2-win32.zip)
- [Eclipse for OS X 64-bit](http://www.aaberge.net/stuff/eclipse/eclipse-java-luna-SR2-macosx-cocoa-x86_64.zip)
- [Eclipse for OS X 32-bit](http://www.aaberge.net/stuff/eclipse/eclipse-java-luna-SR2-macosx-cocoa.zip)
- [Eclipse for Linux 64-bit](http://www.aaberge.net/stuff/eclipse/eclipse-java-luna-SR2-linux-gtk-x86_64.tar.gz)
- [Eclipse for Linux 32-bit](http://www.aaberge.net/stuff/eclipse/eclipse-java-luna-SR2-linux-gtk.tar.gz)

After launching Eclipse, you may have to set `EV3_HOME`, if it is not set. You
can do this by selecting `Window -> Preferences -> leJOS EV3`. Set `EV3_HOME`
to the `leJOS_EV3_0.9.0-beta` directory inside the `eclipse` directory you
unpacked.

## Creating a project

To create a project select `File -> New -> LeJOS EV3 Project`. Uncheck `Use
default location` and select the location you placed this project. Make sure
the selected JRE environment is `JavaSE-1.7`. Finally, press Finish.

After creating a leJOS-project, if the leJOS-libraries can't be found, right
click on your project and select `leJOS EV3 -> Convert to leJOS EV3 project`.

## Other development methods

If you rather want to set up Eclipse with the leJOS-plugin yourself, you may follow the guide in `README-ECLIPSE.md`.

If you want to use IntelliJ, you may follow the guide in `README-INTELLIJ.md`.

If you want to build using Apache Ant instead of Eclipse, you may follow the guide in `README-ANT.md`.

## Running a program

To run a program, right click a file containing a main method, `Run As -> LeJos EV3 Program`.

## Motors and Sensors connections

When seeing the robot from the back, the rightmost motor should be connected to port A, and the left motor should be connected to port B. The wires do not have to cross. 

The IR sensor should be connected to port 1, and the color sensor should be connected to port 4.

This is defined in src/no/itera/lego/EV3Helper.java, lines 65, 66, 73, 74, and can be changed.

## Common error messages

`Uncaught Exception: java.lang.UnsopprtedClassVersion`. This means you are compiling for Java 8, which is not supported by leJOS. To solve this `Right click project -> Properties -> Java Compiler -> Check "Enable project specific settings" -> change "Compiler compilance level" to 1.7`.

`Uncaught Exception: java.lang.IllegalArgumentException. Invalid sensor mode`. Make sure all sensors are connected, and not in use by the EV3 Controller.

## Tips and Tricks

You can use system.out.println() to print to the display.

Press `Center + Down` at the same time to stop the current program.

You can start an uploaded program by `Programs -> "name of program" -> Execute Program`.

Make sure the color sensor is not too far or too close to the ground. Use the EV3 Control plugin in Eclipse to test the sensors. A color_ID to color chart can be found [here](http://www.lejos.org/nxt/pc/api/constant-values.html#lejos.robotics).
