Interface.class: Interface.java
	javac Interface.java

Product.class: Product.java 
	javac Product.java

clean: 
	rm -f *.class
	
