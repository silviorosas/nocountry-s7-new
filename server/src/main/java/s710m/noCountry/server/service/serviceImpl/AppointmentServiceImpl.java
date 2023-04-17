package s710m.noCountry.server.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import s710m.noCountry.server.configException.EntityFoundException;
import s710m.noCountry.server.configException.EntityNotFoundException;
import s710m.noCountry.server.configException.ForbiddenException;
import s710m.noCountry.server.mapper.AppointmentMapper;
import s710m.noCountry.server.model.Appointment;
import s710m.noCountry.server.model.User;
import s710m.noCountry.server.model.dto.AppointmentRequestDto;
import s710m.noCountry.server.model.dto.AppointmentResponseDto;
import s710m.noCountry.server.model.dto.AppointmentUpdateDto;
import s710m.noCountry.server.repository.AppointmentRepository;
import s710m.noCountry.server.service.AppointmentService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private  final AppointmentRepository repository;
    private final AppointmentMapper mapper;


    @Override
    @Transactional
    public AppointmentResponseDto saveAppointment(AppointmentRequestDto dto, User loggedUser) throws Exception {
        Appointment appointment = repository.findByDate(LocalDateTime.parse(dto.getDate().toString()));
        if(appointment != null){
            System.out.println("This date and time are reserved");
            throw new EntityFoundException("This date and time are reserved");
        }
        else {
            Appointment appointmentToSave = mapper.toEntity(dto);
            if(!loggedUser.getUsername().equals(appointmentToSave.getClient().getUser().getUsername()))
                throw new ForbiddenException("You do not have authorization");
            appointment=repository.save(appointmentToSave);
        }
        return mapper.toDto(appointment);
    }

    @Override
    public void deleteAppointment(Long appointmentId, User loggedUser) {
        Appointment appointment = searchById(appointmentId).get();
        if(!loggedUser.getUsername().equals(appointment.getClient().getUser().getUsername()))
            throw new ForbiddenException("You do not have authorization");
        repository.deleteById(appointmentId);
    }

    @Override
    public List<AppointmentResponseDto> getAllAppointments() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentResponseDto updateAppointment(Long id, AppointmentUpdateDto dto, User loggedUser) {
        Appointment appointment = mapper.toUpdatedEntity(dto,searchById(id).get());
        if(!loggedUser.getUsername().equals(appointment.getClient().getUser().getUsername()))
            throw new ForbiddenException("You do not have authorization");
        return mapper.toDto(repository.save(appointment));
    }

    @Override
    public Optional<Appointment> searchById(Long id) {
        Optional<Appointment> appointment = repository.findById(id);
        if (!appointment.isPresent()) {
            String message= "This appointment with id "+ id.toString()+" does not exists";
            System.out.println(message);
            throw new EntityNotFoundException(message);
        }
        return appointment;
    }
}