package ch.erni.testmocking.spy;

public interface HasHelloInterface {

	String getFirstName();

	String getLastName();

	default String sayHello() {
		return "Hello " + getFirstName() + " " + getLastName() + "!";
	}

}
