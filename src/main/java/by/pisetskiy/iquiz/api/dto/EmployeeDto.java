package by.pisetskiy.iquiz.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeeDto extends BaseDto {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private PositionDto position;
    private Boolean isAdmin;
    private Integer appointments;
}
