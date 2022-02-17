package parkir;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.representer.Represent;

import javax.swing.text.html.parser.Entity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
class ParkirModelAssembler implements RepresentationModelAssembler<Parkir, EntityModel<Parkir>>{


    @Override
    public EntityModel<Parkir> toModel(Parkir parkir) {
        return EntityModel.of(parkir, linkTo(methodOn(ParkirController.class).one(parkir.getId())).withSelfRel(),
                linkTo(methodOn(ParkirController.class).all()).withRel("parkir"));
    }
}
