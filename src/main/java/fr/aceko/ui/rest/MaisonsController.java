package fr.aceko.ui.rest;

import fr.aceko.application.maison.CreerMaisonRequest;
import fr.aceko.application.maison.CreerMaisonUseCase;
import fr.aceko.application.maison.ListeMaisonUseCase;
import fr.aceko.application.maison.MaisonAlreadyExistException;
import fr.aceko.domain.Maison;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("/maisons")
@RestController
public class MaisonsController {

    private final ListeMaisonUseCase listeMaisonUseCase;
    private final CreerMaisonUseCase creerMaisonUseCase;

    public MaisonsController(ListeMaisonUseCase listeMaisonUseCase, CreerMaisonUseCase creerMaisonUseCase) {
        this.listeMaisonUseCase = listeMaisonUseCase;
        this.creerMaisonUseCase = creerMaisonUseCase;
    }

    @GetMapping
    public Set<Maison> listAll(){
        return this.listeMaisonUseCase.listMaison();
    }

    @PostMapping
    public ResponseEntity createHouse(@RequestBody CreerMaisonRequest request){
        try {
            this.creerMaisonUseCase.creerMaison(request);
            return ResponseEntity.ok().build();
        } catch (MaisonAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
