package fr.aceko.application;

import fr.aceko.DaoFactory;
import fr.aceko.UseCaseFactory;
import fr.aceko.application.maison.CreerMaisonRequester;
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
        CreerMaisonRequester requester = CreerMaisonRequester.createMinimalRequester("Maison", 3000, "Adresse");
        assertTrue(this.useCase.creerMaison(requester));
        assertEquals(1, this.maisonDao.count());
    }

    @Test
    void whenCreateExistingMaison_shouldThrowException() throws MaisonAlreadyExistException {
        CreerMaisonRequester requester = CreerMaisonRequester.createMinimalRequester("Maison", 3000, "Adresse");
        this.useCase.creerMaison(requester);
        CreerMaisonRequester requester2 = CreerMaisonRequester.createMinimalRequester("Maison", 4000, "Adresse2");
        assertThrows(MaisonAlreadyExistException.class, () -> this.useCase.creerMaison(requester2));
    }
}