package ch.erni.testmocking.spy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HasHelloInterfaceTest {

	@Test
	void sayHello() {
		HasHelloInterface impl = new HasHelloInterface() {
			@Override
			public String getFirstName() {
				return "Max";
			}

			@Override
			public String getLastName() {
				return "Muster";
			}
		};

		String response = impl.sayHello();

		assertThat(response).isEqualTo("Hello Max Muster!");
	}

}