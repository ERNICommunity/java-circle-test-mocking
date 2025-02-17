package ch.erni.testmocking.injectmocks;

import org.springframework.stereotype.Service;

@Service
public class DependencyService {

	public ModelResponse retrieve(ModelRequest request) {
		ModelResponse response = new ModelResponse();
		response.setPayload("This is a payload");
		return response;
	}

}
