package br.com.caelum.clines.shared.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ErrorView {
    private List<ErrorMessage> errors = new ArrayList<>();

    public void addGenericError(String message) {
        errors.add(new ErrorMessage(message));
    }

    public void addFieldError(String field, String message) {
        errors.add(new FieldErrorMessage(field, message));
    }

    @Override
    public String toString() {
        return "ErrorView{" +
                "errors=" + errors +
                '}';
    }

    @AllArgsConstructor
    @Getter
    static class ErrorMessage {
        private String message;

        @Override
        public String toString() {
            return "ErrorMessage{" +
                    "message='" + message + '\'' +
                    '}';
        }
    }

    @Getter
    static class FieldErrorMessage extends ErrorMessage {
        private String field;

        FieldErrorMessage(String field, String message) {
            super(message);
            this.field = field;
        }

        @Override
        public String toString() {
            return "FieldErrorMessage{" +
                    "field='" + field + '\'' +
                    ", message='" + getMessage() + '\'' +
                    '}';
        }
    }
}
