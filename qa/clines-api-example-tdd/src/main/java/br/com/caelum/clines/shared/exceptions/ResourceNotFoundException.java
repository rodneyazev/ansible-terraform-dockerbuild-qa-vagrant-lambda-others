package br.com.caelum.clines.shared.exceptions;

public class ResourceNotFoundException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
