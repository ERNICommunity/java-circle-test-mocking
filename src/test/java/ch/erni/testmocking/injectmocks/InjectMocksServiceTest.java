package ch.erni.testmocking.injectmocks;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InjectMocksServiceTest {

	private static final ModelRequest REQUEST_SUCCESS = new ModelRequest();
	private static final ModelResponse RESPONSE_SUCCESS = new ModelResponse();

	private static final ModelRequest REQUEST_EMPTY = new ModelRequest();
	private static final ModelResponse RESPONSE_EMPTY = new ModelResponse();

	@BeforeAll
	static void setup() {
		REQUEST_SUCCESS.setId("the-id");
		RESPONSE_SUCCESS.setPayload("the-payload");

		REQUEST_EMPTY.setId("other-id");
		RESPONSE_EMPTY.setPayload("");
	}

	@Test
	void retrievePayload() {
		InjectMocksService service = createMockedService();

		String response = service.retrievePayload("the-id");

		assertThat(response).isEqualTo("the-payload");
	}

	@Test
	void retrievePayload_empty() {
		InjectMocksService service = createMockedService();

		String response = service.retrievePayload("other-id");

		assertThat(response).isEqualTo("empty");
	}

	private InjectMocksService createMockedService() {
		DependencyService dependencyService = mock(DependencyService.class);

		when(dependencyService.retrieve(REQUEST_SUCCESS)).thenReturn(RESPONSE_SUCCESS);
		when(dependencyService.retrieve(REQUEST_EMPTY)).thenReturn(RESPONSE_EMPTY);

		return new InjectMocksService(dependencyService);
	}
}