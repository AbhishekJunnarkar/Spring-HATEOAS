package com.projectabhishek.partyDetailService.controller;

import com.projectabhishek.partyDetailService.domain.Party;
import com.projectabhishek.partyDetailService.exception.PartyNotFoundException;
import com.projectabhishek.partyDetailService.repository.PartyRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @RestController indicates that the data returned by each method will be written straight into the response body instead
 * of rendering a template.
 */
@RestController
public class PartyController {
    private final PartyRepository repository;

    // An PartyRepository is injected by constructor into the controller.
    PartyController(PartyRepository repository) {
        this.repository = repository;
    }

    /*//Aggregate Root (get all)
    @GetMapping("/parties")
    List<Party> all() {
        return repository.findAll();
    }
*/
    @GetMapping("/parties")
    CollectionModel<EntityModel<Party>> all() {

        List<EntityModel<Party>> parties = repository.findAll().stream()
                .map(party -> new EntityModel<>(party,
                        linkTo(methodOn(PartyController.class).getParty(party.getId())).withSelfRel(),
                        linkTo(methodOn(PartyController.class).all()).withRel("employees")))
                .collect(Collectors.toList());

        return new CollectionModel<>(parties,
                linkTo(methodOn(PartyController.class).all()).withSelfRel());
    }






    //Post new Party
    @PostMapping("/parties")
    Party newParty(@RequestBody Party party) {
        return repository.save(party);
    }

    //Retrieve Single Party
    //Using Entity model, provide a "self" link (kind of like a this statement in code) along with a link back to the aggregate root.
    @GetMapping("/parties/{id}")
    EntityModel<Party> getParty(@PathVariable Long id) {
        Party party = repository.findById(id)
                .orElseThrow(() -> new PartyNotFoundException(id));
                return new EntityModel<>(party,
                        linkTo(methodOn(PartyController.class).getParty(id)).withSelfRel(),
                        linkTo(methodOn(PartyController.class).all()).withRel("parties"));
    }

    // Update existing party
    @PutMapping("/parties/{id}")
    Party updateParty(@RequestBody final Party newParty, @PathVariable Long id) {

        return repository.findById(id).map(party -> {
            party.setName(newParty.getName());
            party.setType(newParty.getType());
            return repository.save(party);
        }).orElseGet(() -> {
            newParty.setId(id);
            return repository.save(newParty);
        });
    }

    //Delete Party
    @DeleteMapping("/party/{id}")
    @ResponseBody void deleteParty(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
