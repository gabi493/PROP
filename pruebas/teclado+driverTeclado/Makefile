all: teclado

teclado.class: *.java
	   javac *.java
	  
teclado: teclado.class
	  java driverTeclado < driverTeclado.in
	  
clean:
	  rm *.class