package br.com.caelum.clines.shared.util;

import java.text.Normalizer;

import static java.text.Normalizer.Form.NFD;

public final class StringNormalizer {

    private StringNormalizer() {

    }

    public static String normalize(String value) {
        return Normalizer.normalize(value.toUpperCase(), NFD);
    }
}

