package ch.erni.testmocking.injectmocks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
class InjectMocksServiceTest {

	@Mock
	private DependencyService dependencyService;

	@InjectMocks
	private InjectMocksService service;

	@Test
	void retrievePayload() {
		ModelRequest expectedRequest = new ModelRequest();
		expectedRequest.setId("the-id");

		ModelResponse modelResponse = new ModelResponse();
		modelResponse.setPayload("the-payload");

		when(dependencyService.retrieve(expectedRequest)).thenReturn(modelResponse);

		String response = service.retrievePayload("the-id");

		assertThat(response).isEqualTo("the-payload");
	}

	@Test
	void retrievePayload_empty() {
		ModelRequest expectedRequest = new ModelRequest();
		expectedRequest.setId("other-id");

		ModelResponse modelResponse = new ModelResponse();
		modelResponse.setPayload("");

		when(dependencyService.retrieve(expectedRequest)).thenReturn(modelResponse);

		String response = service.retrievePayload("other-id");

		assertThat(response).isEqualTo("empty");
	}
}