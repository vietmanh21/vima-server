package com.manhnv.vimaserver.dto.publication;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PublicationPostDTO {
    private String name;
    private String description;
    private String url;
    private String logo;
    private List<String> tags;
}
