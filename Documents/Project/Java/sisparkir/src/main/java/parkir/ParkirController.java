package parkir;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import javax.xml.stream.events.EntityReference;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ParkirController {

    private final ParkirRepository repository;
    private final ParkirModelAssembler assembler;

    public ParkirController(ParkirRepository repository, ParkirModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/parkir")
    CollectionModel<EntityModel<Parkir>> all(){
        List<EntityModel<Parkir>> parkirs = repository.findAll().stream().map(assembler::toModel).collect(Collectors.toList());

        return CollectionModel.of(parkirs, linkTo(methodOn(ParkirController.class).all()).withSelfRel());
    }
    @PostMapping("/parkir")
    Parkir newParkir(@RequestBody Parkir newParkir){
        return repository.save(newParkir);
    }
    @GetMapping("/parkir/{id}")
    EntityModel<Parkir> one(@PathVariable Long id){
        Parkir parkir = repository.findById(id).orElseThrow(() -> new ParkirNotFoundException(id));

        return assembler.toModel(parkir);
    }
    @PutMapping("/parkir/{id}")
    Parkir replaceParkir(@RequestBody Parkir newParkir, @PathVariable Long id){
        return repository.findById(id).map(parkir -> {
            parkir.setNo_registration(newParkir.getNo_registration());
            parkir.setArrival(newParkir.getArrival());
            parkir.setDeparture(newParkir.getDeparture());
            parkir.setStatus(newParkir.getStatus());
            parkir.setBills(newParkir.getBills());
            parkir.setSlot(newParkir.getSlot());
            return repository.save(parkir);
        }).orElseGet(() -> {
            newParkir.setId(id);
            return repository.save(newParkir);
        });
    }

    @DeleteMapping("/parkir/{id}")
        void deleteParkir(@PathVariable Long id){
            repository.deleteById(id);
        }

}
