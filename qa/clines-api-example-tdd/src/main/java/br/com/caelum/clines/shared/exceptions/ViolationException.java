package br.com.caelum.clines.shared.exceptions;

import java.util.Collection;

import lombok.Getter;

@Getter
public class ViolationException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	private final Collection<Exception> violations;

    public ViolationException(Collection<Exception> violations) {
        this.violations = violations;
    }
}
