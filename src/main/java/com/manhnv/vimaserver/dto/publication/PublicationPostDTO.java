package com.manhnv.vimaserver.dto.publication;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PublicationPostDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String url;
    private String logo;
    private List<String> tags;
}
