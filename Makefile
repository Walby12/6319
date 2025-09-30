all:
	javac src/app/*.java -d ../bin
run: all
	java -cp ../bin src.app.Main
