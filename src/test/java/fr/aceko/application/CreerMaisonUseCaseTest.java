package fr.aceko.application;

import fr.aceko.DaoFactory;
import fr.aceko.UseCaseFactory;
import fr.aceko.application.maison.CreerMaisonRequest;
import fr.aceko.application.maison.CreerMaisonUseCase;
import fr.aceko.application.maison.MaisonAlreadyExistException;
import fr.aceko.domain.MaisonDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreerMaisonUseCaseTest {

    private final CreerMaisonUseCase useCase = UseCaseFactory.creerMaisonUseCase();
    private final MaisonDao maisonDao = DaoFactory.maisonDao();

    @AfterEach
    void tearDown(){
        maisonDao.clear();
    }

    @Test
    void whenCreateANewMaison_thenMaisonsSizeMustGrow() throws MaisonAlreadyExistException {
        CreerMaisonRequest requester = CreerMaisonRequest.createMinimalRequest("Maison", 3000, "Adresse");
        assertTrue(this.useCase.creerMaison(requester));
        assertEquals(1, this.maisonDao.count());
    }

    @Test
    void whenCreateExistingMaison_shouldThrowException() throws MaisonAlreadyExistException {
        CreerMaisonRequest requester = CreerMaisonRequest.createMinimalRequest("Maison", 3000, "Adresse");
        this.useCase.creerMaison(requester);
        CreerMaisonRequest requester2 = CreerMaisonRequest.createMinimalRequest("Maison", 4000, "Adresse2");
        assertThrows(MaisonAlreadyExistException.class, () -> this.useCase.creerMaison(requester2));
    }
}