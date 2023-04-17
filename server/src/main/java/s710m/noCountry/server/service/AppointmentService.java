package s710m.noCountry.server.service;

import s710m.noCountry.server.model.Appointment;
import s710m.noCountry.server.model.User;
import s710m.noCountry.server.model.dto.AppointmentRequestDto;
import s710m.noCountry.server.model.dto.AppointmentResponseDto;
import s710m.noCountry.server.model.dto.AppointmentUpdateDto;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {


    public AppointmentResponseDto saveAppointment(AppointmentRequestDto dto, User loggedUser) throws Exception;

    public void deleteAppointment(Long appointmentId, User loggedUser);

    public List<AppointmentResponseDto> getAllAppointments();

    public AppointmentResponseDto updateAppointment (Long id, AppointmentUpdateDto appointment, User loggedUser);

    public Optional<Appointment> searchById(Long id);



}
