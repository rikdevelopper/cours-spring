package fr.aceko.application;

import fr.aceko.UseCaseFactory;
import fr.aceko.application.maison.ListeMaisonUseCase;
import fr.aceko.domain.Maison;
import fr.aceko.domain.MaisonDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListeMaisonUseCaseTest {

    private MaisonDao maisonDao;

    @BeforeEach
    void setUp(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-conf.xml");
        maisonDao = context.getBean("maisonDao", MaisonDao.class);
    }
    @AfterEach
    void tearDown(){
        maisonDao.clear();
    }

    @Test
    void listMaison() {

        int sizeBeforeCreate = maisonDao.count();
        Maison maison1 =new Maison("Maison1", 2000, "ADRESSE");
        Maison maison2 =new Maison("Maison2", 2000, "ADRESSE");
        maisonDao.createMaison(maison1);
        maisonDao.createMaison(maison2);

        ListeMaisonUseCase listeMaisonUseCase = UseCaseFactory.listeMaisonUseCase();
        assertEquals(sizeBeforeCreate + 2, listeMaisonUseCase.listMaison().size());
    }
}