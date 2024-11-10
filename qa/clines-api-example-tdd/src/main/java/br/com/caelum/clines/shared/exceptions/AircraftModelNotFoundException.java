package br.com.caelum.clines.shared.exceptions;

public class AircraftModelNotFoundException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	public AircraftModelNotFoundException(String message) {
        super(message);
    }
}
