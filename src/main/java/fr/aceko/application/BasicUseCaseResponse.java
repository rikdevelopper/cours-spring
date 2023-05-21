package fr.aceko.application;

import java.util.ArrayList;
import java.util.List;

public class BasicUseCaseResponse {
    final List<String> errorMessages;

    public BasicUseCaseResponse() {
        this.errorMessages = new ArrayList<>();
    }

    public void addErrorMessage(String errorMessage) {
        this.errorMessages.add(errorMessage);
    }

    public boolean hasSucceed() {
        return this.errorMessages.isEmpty();
    }

    public List<String> getErrorMessages() {
        return this.errorMessages;
    }
}
