package ch.erni.testmocking.solutions.spy;

import ch.erni.testmocking.spy.HasHelloInterface;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class HasHelloInterfaceTest {

	@Test
	void sayHello() {
		HasHelloInterface hasHelloInterface = spy(HasHelloInterface.class);
		when(hasHelloInterface.getFirstName()).thenReturn("Max");
		when(hasHelloInterface.getLastName()).thenReturn("Muster");

		String response = hasHelloInterface.sayHello();

		assertThat(response).isEqualTo("Hello Max Muster!");
	}

}