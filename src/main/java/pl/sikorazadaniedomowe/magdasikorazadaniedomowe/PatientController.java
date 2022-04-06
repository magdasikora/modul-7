package pl.sikorazadaniedomowe.magdasikorazadaniedomowe;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor

public class PatientController {


    private final PatientService patientService;



    @PostMapping("/patient")
    public ResponseEntity<Void> registerPatient(@RequestBody @Valid Patient patient) {
        this.patientService.addPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/patient/{pesel}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String pesel, @RequestBody Patient patient) {
        this.patientService.updatePatient(pesel, patient);
        return ResponseEntity.status(HttpStatus.OK)
                .body(patient);
    }

    @DeleteMapping("/patient/{pesel}")
    public ResponseEntity<Void> deletePatient(@PathVariable String pesel) {
        this.patientService.deletePatient(pesel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

@GetMapping("/patients")
    public ResponseEntity<List<Patient>> getPatients() {
    List<Patient> patients = this.patientService.getPatients();
    return ResponseEntity.status(HttpStatus.OK).body(patients);

}

    }


