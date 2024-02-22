# Define variables
SRC_DIR := src
CLASS_DIR := classes
LIB_DIR := lib # Update this to the actual location of your JUnit and Hamcrest jars

# JUnit and Hamcrest jars
JUNIT_JAR := lib/junit-4.13.2.jar
HAMCREST_JAR := lib/hamcrest-core-2.2.jar

# Main class to run
MAIN_CLASS := ExpressionDriver
LINKEDLIST := Driver
# Find all Java files in the src directory
SOURCES := $(shell find $(SRC_DIR) -name '*.java')

# Define the classpath
CLASSPATH := $(CLASS_DIR):$(JUNIT_JAR):$(HAMCREST_JAR)

# Define the default make target
all: compile

# Compile Java files
compile: $(SOURCES)
	@javac -cp $(CLASSPATH) -d $(CLASS_DIR) $(SOURCES)

# Run the main class
run:
	@java -cp $(CLASSPATH) $(MAIN_CLASS)

# Clean the classes directory
clean:
	@rm -rf $(CLASS_DIR)/*

LinkedList:
	@java -cp $(CLASSPATH) $(LINKEDLIST)

## Test LinkedList
#LinkedListTest:
#	java -cp "$(CLASSPATH)" org.junit.runner.JUnitCore TestLinkedListWithIterator

