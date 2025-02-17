package ch.erni.testmocking.injectmocks;

import org.springframework.stereotype.Service;

@Service
public class InjectMocksService {

	private DependencyService dependencyService;

	public InjectMocksService(DependencyService dependencyService) {
		this.dependencyService = dependencyService;
	}

	public String retrievePayload(String id) {
		ModelRequest request = new ModelRequest();
		request.setId(id);

		ModelResponse response = dependencyService.retrieve(request);

		return response.getPayload()
				.filter(payload -> !payload.isBlank())
				.orElse("empty");
	}
}
