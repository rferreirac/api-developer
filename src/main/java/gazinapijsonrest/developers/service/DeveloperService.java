package gazinapijsonrest.developers.service;

import gazinapijsonrest.developers.dto.DeveloperRequestDTO;
import gazinapijsonrest.developers.entity.Developer;
import gazinapijsonrest.developers.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperService {

    @Autowired
    DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public Developer createDeveloper(DeveloperRequestDTO developerRequestDTO) {
        return developerRepository.save(developerRequestDTO.transformToDeveloper());
    }

    public List<Developer> listDeveloper() {
        return developerRepository.findAll();
    }

    public Optional<Developer> findById(Long id) {
        return developerRepository.findById(id);
    }

    public void deleteById(Long id) {
        developerRepository.deleteById(id);
    }

    public void update(Long id, Developer developer) {
        Optional<Developer> actualDeveloper = findById(id);
        actualDeveloper.get().setSexo(developer.getSexo());
        actualDeveloper.get().setNome(developer.getNome());
        actualDeveloper.get().setHobby(developer.getHobby());
        actualDeveloper.get().setDatanascimento(developer.getDatanascimento());
        actualDeveloper.get().setIdade(developer.getIdade());

        developerRepository.save(actualDeveloper.get());
    }
}

