JFLAGS = -g
JC = javac -cp src
JVM = java -cp ./src
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		src/ResourceManager.java \
		src/FileInfo.java \
		src/Disk.java \
		src/Printer.java \
		src/DirectoryManager.java \
		src/myGUI.java \
		src/main.java \
		src/PrintJobThread.java \
		src/UserThread.java \



MAIN = main

default: classes 
	$(JVM) $(MAIN)
classes: $(CLASSES:.java=.class)

clean:
		$(RM) src/*.class