# pencil-durability
Implementation of exercise specified in https://github.com/PillarTechnology/kata-pencil-durability. This project uses Maven to build the project and import dependencies (junit-4.12.jar, hamcrest-core-1.3.jar). This project was built using http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/neon3.
## Eclipse Instructions
After installing Eclipse, navigate to *File -> Import -> Git -> Projects from Git -> Clone URI*. Paste https://github.com/FPNelson/pencil-durability.git into the URI field.

After cloning the project, navigate to *File -> Import -> Maven -> Existing Maven Projects* and enter the path to the cloned project, select */pom.xml  kata:pencil-durability:0.0.1-SNAPSHOT:jar* when it appears and proceed until Maven builds the project from the pom.xml file.

Tests can be run in Maven by right clicking the project and navigating to *Run As -> Maven test*.