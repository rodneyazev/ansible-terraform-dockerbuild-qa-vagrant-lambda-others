package br.com.caelum.clines.shared.infra;

public interface Mapper<S, T> {
    T map(S source);
}
