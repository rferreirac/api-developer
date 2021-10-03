package gazinapijsonrest.developers;

import gazinapijsonrest.developers.dto.DeveloperRequestDTO;
import gazinapijsonrest.developers.entity.Developer;
import gazinapijsonrest.developers.repository.DeveloperRepository;
import gazinapijsonrest.developers.service.DeveloperService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class DeveloperTest {

    @Mock
    private DeveloperRepository developerRepository;

    private DeveloperService developerService;

    @BeforeEach
    public void setup() {

        developerService = new DeveloperService(developerRepository);
    }

    @Test
    public void createDeveloper() {

        DeveloperRequestDTO createDeveloperDTO = createDeveloperDTO();
        Developer createDeveloperEntity = createDeveloperEntity();

        when(developerRepository.save(any())).thenReturn(createDeveloperEntity());

        Developer developerResponse = developerService.createDeveloper(createDeveloperDTO);

        assertNotNull(developerResponse);
    }

    @Test
    public void updateDeveloper() {

        DeveloperRequestDTO developerRequestDTO = createDeveloperRequestDTO();
        Developer developer = createDeveloperEntity();

        when(developerRepository.findById(eq(developer.getId()))).thenReturn(Optional.of(developer));

        developerService.update(developer.getId(), developer);

        verify(developerRepository).findById(eq(developer.getId()));
        verify(developerRepository).save(any(Developer.class));
    }

    @Test
    public void findDeveloperById() {
        Developer developer = createDeveloperEntity();

        when(developerRepository.findById(eq(developer.getId()))).thenReturn(Optional.of(developer));

        Optional<Developer> developerResponseDTO = developerService.findById(developer.getId());

        verify(developerRepository).findById(eq(developer.getId()));
        verifyNoMoreInteractions(developerRepository);

        assertNotNull(developerResponseDTO);
        assertEquals(developer.getNome(), developerResponseDTO.get().getNome());
    }

    @Test
    public void findByDevelopers() {
        when(developerRepository.findBy("teste", 'M', 10, "teste",
                Date.valueOf("2000-01-01"))).thenReturn(Stream
                .of(createDeveloperEntity(), createDeveloperEntity()).collect(Collectors.toList()));

        List<Developer> developerResponseDTOS = developerService.listDeveloper("teste", 10,
                Date.valueOf("2000-01-01"), 'M', "teste");

        verify(developerRepository).findBy("teste", 'M', 10, "teste",
                Date.valueOf("2000-01-01"));
        verifyNoMoreInteractions(developerRepository);

    }

    @Test
    public void deleteDeveloper() {

        DeveloperRequestDTO developerRequestDTO = createDeveloperRequestDTO();
        Developer developer = createDeveloperEntity();

        Optional<Developer> developerResponseDTO = developerService.findById(developer.getId());

        developerService.deleteById(developer.getId());

        verify(developerRepository).deleteById(eq(developer.getId()));

    }


    public static DeveloperRequestDTO createDeveloperDTO() {

        DeveloperRequestDTO developerRequestDTO = new DeveloperRequestDTO();

        developerRequestDTO.setNome("teste");
        developerRequestDTO.setIdade(10);
        developerRequestDTO.setHobby("hobby teste");
        developerRequestDTO.setDatanascimento(Date.valueOf("2000-01-01"));
        developerRequestDTO.setSexo('M');

        return developerRequestDTO;
    }

    public static Developer createDeveloperEntity() {

        Developer developer = createDeveloperDTO().transformToDeveloper();
        developer.setId(1L);
        return developer;
    }


    public static DeveloperRequestDTO createDeveloperRequestDTO() {

        DeveloperRequestDTO developerRequestDTO = new DeveloperRequestDTO();

        developerRequestDTO.setNome("teste");
        developerRequestDTO.setIdade(10);
        developerRequestDTO.setHobby("hobby teste");
        developerRequestDTO.setDatanascimento(Date.valueOf("2000-01-01"));
        developerRequestDTO.setSexo('M');

        return developerRequestDTO;
    }
}


