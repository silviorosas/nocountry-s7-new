package s710m.noCountry.server.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import s710m.noCountry.server.model.Appointment;
import s710m.noCountry.server.model.User;
import s710m.noCountry.server.model.dto.AppointmentRequestDto;
import s710m.noCountry.server.model.dto.AppointmentResponseDto;
import s710m.noCountry.server.model.dto.AppointmentUpdateDto;
import s710m.noCountry.server.service.AppointmentService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService service;

    ////End point para obtener todos los turnos GET= "/api/appointment"
    @GetMapping
    public ResponseEntity<List<AppointmentResponseDto>> getAll() {
        List<AppointmentResponseDto> listAppointment= service.getAllAppointments();
        return new ResponseEntity<>(listAppointment, HttpStatus.OK);
    }

    ////End point para actualizar todos los turnos PUT= "/api/appointment"
    @PutMapping("/{id}")
    public ResponseEntity<AppointmentResponseDto> update(@PathVariable Long id, @RequestBody AppointmentUpdateDto appointment, @AuthenticationPrincipal User user) {
        AppointmentResponseDto updatedAppointment = service.updateAppointment(id,appointment,user);
        return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
    }


    ////End point para guardar  turnos POST= "/api/appointment"
    @PostMapping
    public ResponseEntity<AppointmentResponseDto> save(@RequestBody AppointmentRequestDto dto, @AuthenticationPrincipal User user) throws Exception {
        AppointmentResponseDto createdAppointment= service.saveAppointment(dto, user);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }

    ////End point para eliminar por id todos los turnos DELETE= "/api/appointment/3"
    @DeleteMapping("/{appointmentId}")
    public void delete(@PathVariable("appointmentId") Long appointmentId, @AuthenticationPrincipal User user) {
        service.deleteAppointment(appointmentId, user);
    }


    ////End point para obtener  POR ID todos los turnos GET= "/api/appointment/3"
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Appointment>> searchById(@PathVariable Long id) throws EntityNotFoundException {
        Optional<Appointment> appointment= service.searchById(id);
        return new ResponseEntity<>(appointment,HttpStatus.OK);
    }


}
