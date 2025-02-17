package ch.erni.testmocking.injectmocks;

import java.util.Objects;
import java.util.Optional;

public class ModelResponse {

	private String payload;

	public Optional<String> getPayload() {
		return Optional.ofNullable(payload);
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ModelResponse that = (ModelResponse) o;
		return Objects.equals(payload, that.payload);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(payload);
	}
}
