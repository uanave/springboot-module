package academy.everyonecodes.validation.service;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Service
@Validated
public class TextReceiver {
    @Length(min = 3)
    public String receive(@NotEmpty String text) {
        return text;
    }
}
