package com.manhnv.vimaserver.dto.request;

import com.manhnv.vimaserver.utils.ValidFileType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class MediaRequest {
    @ValidFileType(allowedTypes = {"image/jpeg", "image/png", "image/gif"},
            message = "File type not allowed. Allowed types are: JPEG, PNG, GIF")
    private MultipartFile multipartFile;
    private String fileNameOverride;
    private Long clusterId;
}
