package fr.aceko.application.maison;

public class MaisonAlreadyExistException extends Exception{

    public MaisonAlreadyExistException(String message) {
        super(message);
    }
}
