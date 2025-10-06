package com.manhnv.vimaserver.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manhnv.vimaserver.dto.BucketPolicyConfigDto;
import com.manhnv.vimaserver.dto.request.MediaRequest;
import com.manhnv.vimaserver.exception.ApiException;
import com.manhnv.vimaserver.model.Media;
import com.manhnv.vimaserver.repository.MediaRepository;
import io.minio.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class MediaService {
    @Value("${minio.endpoint}")
    private String ENDPOINT;
    @Value("${minio.bucketName}")
    private String BUCKET_NAME;
    @Value("${minio.accessKey}")
    private String ACCESS_KEY;
    @Value("${minio.secretKey}")
    private String SECRET_KEY;

    private final MediaRepository mediaRepository;

    public Media uploadMedia(MediaRequest request) {
        try {
//            MinioClient minioClient =MinioClient.builder()
//                    .endpoint(ENDPOINT)
//                    .credentials(ACCESS_KEY,SECRET_KEY)
//                    .build();
//            boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(BUCKET_NAME).build());
//            if (isExist) {
//                log.info("Bucket exists！");
//            } else {
//                minioClient.makeBucket(MakeBucketArgs.builder().bucket(BUCKET_NAME).build());
//                BucketPolicyConfigDto bucketPolicyConfigDto = createBucketPolicyConfigDto(BUCKET_NAME);
//
//                ObjectMapper mapper = new ObjectMapper();
//
//                SetBucketPolicyArgs setBucketPolicyArgs = SetBucketPolicyArgs.builder()
//                        .bucket(BUCKET_NAME)
//                        .config(mapper.writeValueAsString(bucketPolicyConfigDto))
//                        .build();
//                minioClient.setBucketPolicy(setBucketPolicyArgs);
//            }
//            MultipartFile file = request.getMultipartFile();
//            String filename = null;
//            if (StringUtils.hasText(request.getFileNameOverride())) {
//                filename = request.getFileNameOverride();
//            } else {
//                filename = request.getMultipartFile().getOriginalFilename();
//            }
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//            String objectName = sdf.format(new Date()) + "/" + filename;
//            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
//                    .bucket(BUCKET_NAME)
//                    .object(objectName)
//                    .contentType(file.getContentType())
//                    .stream(file.getInputStream(), file.getSize(), ObjectWriteArgs.MIN_MULTIPART_SIZE).build();
//            minioClient.putObject(putObjectArgs);
//            log.info("put to minio client!");
//            Media media = Media.builder().url(ENDPOINT + "/" + BUCKET_NAME + "/" + objectName).name(filename).build();
//            return mediaRepository.save(media);
            return null;
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
    }

    private BucketPolicyConfigDto createBucketPolicyConfigDto(String bucketName) {
        BucketPolicyConfigDto.Statement statement = BucketPolicyConfigDto.Statement.builder()
                .Effect("Allow")
                .Principal("*")
                .Action("s3:GetObject")
                .Resource("arn:aws:s3:::"+bucketName+"/*.**").build();
        return BucketPolicyConfigDto.builder()
                .Version("2012-10-17")
                .Statement(Collections.singletonList(statement))
                .build();
    }
}
