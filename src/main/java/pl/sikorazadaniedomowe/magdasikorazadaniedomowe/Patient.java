package pl.sikorazadaniedomowe.magdasikorazadaniedomowe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor


public class Patient {
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @Length(min = 11, max=11)
    private String pesel;
    @Length(min = 9, max=9)
    private String phoneNumber;
    private String comments;


    }

