package gazinapijsonrest.developers.controller;

import gazinapijsonrest.developers.dto.DeveloperRequestDTO;
import gazinapijsonrest.developers.entity.Developer;
import gazinapijsonrest.developers.service.DeveloperService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/developers")

public class DeveloperController {

    @Autowired
    private DeveloperRequestDTO developerRequestDTO;

    @Autowired
    private DeveloperService developerService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Developer create(@RequestBody DeveloperRequestDTO developerRequestDTO){
        return developerService.createDeveloper(developerRequestDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Developer> list(){
        return developerService.listDeveloper();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Developer locateId(@PathVariable("id") Long id ) {
        return developerService.findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Desenvolvedor nao encontrado!"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable("id") Long id ){
        developerService.findById(id)
                        .map(developer -> {
                            developerService.deleteById(developer.getId());
                            return Void.TYPE;
                        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Desenvolvedor nao encontrado!"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Long id, @RequestBody Developer developer){
        developerService.update(id, developer);

    }



}

