package s710m.noCountry.server.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import s710m.noCountry.server.configException.EntityNotFoundException;
import s710m.noCountry.server.model.Appointment;
import s710m.noCountry.server.model.Client;
import s710m.noCountry.server.model.dto.AppointmentRequestDto;
import s710m.noCountry.server.model.dto.AppointmentResponseDto;
import s710m.noCountry.server.model.dto.AppointmentUpdateDto;
import s710m.noCountry.server.repository.ClientRepository;
import s710m.noCountry.server.repository.ServiceProviderRepository;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AppointmentMapper {

    private final ClientRepository clientRepository;
    private final ServiceProviderRepository serviceProviderRepository;

    public Appointment toEntity(AppointmentRequestDto dto){
        Appointment appointment = new Appointment();
        appointment.setDate(dto.getDate());
        appointment.setProblemDescription(dto.getProblemDescription());
        appointment.setProblemPhotos(dto.getProblemPhotos());
        appointment.setClient(clientRepository
                .findById(dto.getIdClient())
                .orElseThrow( () -> new EntityNotFoundException("Client not found.")));
        appointment.setServiceProvider(serviceProviderRepository
                .findById(dto.getIdServiceProvider())
                .orElseThrow( () -> new EntityNotFoundException("Service Provider not found.")));
        return appointment;
    }

    public AppointmentResponseDto toDto(Appointment appointment){
        AppointmentResponseDto dto = new AppointmentResponseDto();
        dto.setDate(appointment.getDate());
        return dto;
    }

    public Appointment toUpdatedEntity(AppointmentUpdateDto dto, Appointment appointment){
        if(!Objects.isNull(dto.getDate())) appointment.setDate(dto.getDate());
        if(!Objects.isNull(dto.getProblemDescription()) && !dto.getProblemDescription().isEmpty())
            appointment.setProblemDescription(dto.getProblemDescription());
        if(!dto.getProblemPhotos().isEmpty())
            dto.getProblemPhotos()
                    .stream()
                    .forEach( p -> appointment.getProblemPhotos().add(p));
        return appointment;
    }
}
