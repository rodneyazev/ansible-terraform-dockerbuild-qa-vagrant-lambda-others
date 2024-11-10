package br.com.caelum.clines.api.locations;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor
@Getter
public class LocationForm {
    @NotBlank
    private String country;

    @NotBlank
    private String state;

    @NotBlank
    private String city;
}
