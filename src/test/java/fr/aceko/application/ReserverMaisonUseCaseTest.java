package fr.aceko.application;

import fr.aceko.AppConfig;
import fr.aceko.application.reservation.ReserverMaisonRequest;
import fr.aceko.application.reservation.ReserverMaisonUseCase;
import fr.aceko.domain.Maison;
import fr.aceko.domain.MaisonDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReserverMaisonUseCaseTest {
    private MaisonDao maisonDao;
    private ReserverMaisonUseCase reserverMaisonUseCase;
    private Maison maison;

    @BeforeEach
    void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        maisonDao = context.getBean(MaisonDao.class);
        reserverMaisonUseCase = context.getBean(ReserverMaisonUseCase.class);
        maison = new Maison("AGBEDOUPE", 2000, "Adidogome");
        maisonDao.createMaison(maison);
    }

    @AfterEach
    void tearDown() {
        this.maisonDao.clear();
    }

    @Test
    void givenNotAvailableHouse_thenBookingShouldReturnErrorMessage() {
        ReserverMaisonRequest firstRequest = new ReserverMaisonRequest(1L, maison.getId(), 2000, 1000, LocalDate.now(), LocalDate.now().plusMonths(1));
        reserverMaisonUseCase.reserverMaison(firstRequest);
        LocalDate nowMinus5Days = LocalDate.now().minusDays(5);
        LocalDate nowPlus5Days = LocalDate.now().plusDays(5);
        ReserverMaisonRequest secondRequest = new ReserverMaisonRequest(2L, maison.getId(), 2000, 1000, nowMinus5Days, nowPlus5Days);
        BasicUseCaseResponse response = reserverMaisonUseCase.reserverMaison(secondRequest);
        assertFalse(response.hasSucceed());
        assertTrue(response.getErrorMessages().contains("The house is not available for the selected period."));
    }

    @Test
    void givenAvailableHouse_thenBookingShouldReturnSuccessfullResponse() {
        ReserverMaisonRequest request = new ReserverMaisonRequest(1L, maison.getId(), 2000, 1000, LocalDate.now(), LocalDate.now().plusMonths(1));
        BasicUseCaseResponse response = reserverMaisonUseCase.reserverMaison(request);
        assertTrue(response.hasSucceed());
        assertTrue(response.getErrorMessages().isEmpty());
    }


}