# Define variables
SRC_DIR := src
CLASS_DIR := classes

# Main class to run
MAIN_CLASS := ExpressionDriver

# Find all Java files in the src directory
SOURCES := $(shell find $(SRC_DIR) -name '*.java')



# Define the default make target
all: compile

# Compile Java files
compile: $(SOURCES)
	@javac -d $(CLASS_DIR) $(SOURCES)

# Run the main class
run:
	@java -cp $(CLASS_DIR) $(MAIN_CLASS)

# Clean the classes directory
clean:
	@rm -rf $(CLASS_DIR)/*

