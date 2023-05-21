package fr.aceko.application;

import fr.aceko.application.maison.CreerMaisonRequester;
import fr.aceko.application.maison.CreerMaisonUseCase;
import fr.aceko.application.maison.MaisonAlreadyExistException;
import fr.aceko.domain.MaisonDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class CreerMaisonUseCaseTest {

    private CreerMaisonUseCase useCase;
    private MaisonDao maisonDao;

    @BeforeEach
    void setUpAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-dao.xml", "spring/spring-uc.xml");
        useCase = context.getBean("creerMaisonUseCase", CreerMaisonUseCase.class);
        maisonDao = context.getBean("maisonDao", MaisonDao.class);
    }
    @AfterEach
    void tearDown(){
        maisonDao.clear();
    }

    @Test
    void whenCreateANewMaison_thenMaisonsSizeMustGrow() throws MaisonAlreadyExistException {
        int currentDbSize = maisonDao.count();
        CreerMaisonRequester requester = CreerMaisonRequester.createMinimalRequester("Maison", 3000, "Adresse");
        assertTrue(this.useCase.creerMaison(requester));
        assertEquals(currentDbSize + 1, this.maisonDao.count());
    }

    @Test
    void whenCreateExistingMaison_shouldThrowException() throws MaisonAlreadyExistException {
        CreerMaisonRequester requester = CreerMaisonRequester.createMinimalRequester("Maison", 3000, "Adresse");
        this.useCase.creerMaison(requester);
        CreerMaisonRequester requester2 = CreerMaisonRequester.createMinimalRequester("Maison", 4000, "Adresse2");
        assertThrows(MaisonAlreadyExistException.class, () -> this.useCase.creerMaison(requester2));
    }
}