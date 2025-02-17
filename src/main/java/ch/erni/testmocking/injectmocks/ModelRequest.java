package ch.erni.testmocking.injectmocks;

import java.util.Objects;
import java.util.Optional;

public class ModelRequest {

	private String id;

	public Optional<String> getId() {
		return Optional.ofNullable(id);
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ModelRequest that = (ModelRequest) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
