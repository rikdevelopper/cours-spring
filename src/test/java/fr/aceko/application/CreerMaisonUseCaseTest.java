package fr.aceko.application;

import fr.aceko.AppConfig;
import fr.aceko.application.maison.CreerMaisonRequest;
import fr.aceko.application.maison.CreerMaisonUseCase;
import fr.aceko.application.maison.MaisonAlreadyExistException;
import fr.aceko.domain.MaisonDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class CreerMaisonUseCaseTest {

    private CreerMaisonUseCase useCase;
    private MaisonDao maisonDao;

    @BeforeEach
    void setUpAll(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        useCase = context.getBean(CreerMaisonUseCase.class);
        maisonDao = context.getBean(MaisonDao.class);
    }
    @AfterEach
    void tearDown(){
        maisonDao.clear();
    }

    @Test
    void whenCreateANewMaison_thenMaisonsSizeMustGrow() throws MaisonAlreadyExistException {
        int currentDbSize = maisonDao.count();
        CreerMaisonRequest requester = CreerMaisonRequest.createMinimalRequester("Maison", 3000, "Adresse");
        assertTrue(this.useCase.creerMaison(requester));
        assertEquals(currentDbSize + 1, this.maisonDao.count());
    }

    @Test
    void whenCreateExistingMaison_shouldThrowException() throws MaisonAlreadyExistException {
        CreerMaisonRequest requester = CreerMaisonRequest.createMinimalRequester("Maison", 3000, "Adresse");
        this.useCase.creerMaison(requester);
        CreerMaisonRequest requester2 = CreerMaisonRequest.createMinimalRequester("Maison", 4000, "Adresse2");
        assertThrows(MaisonAlreadyExistException.class, () -> this.useCase.creerMaison(requester2));
    }
}