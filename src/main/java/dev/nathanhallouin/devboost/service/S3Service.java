package dev.nathanhallouin.devboost.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.UUID;

@Service
public class S3Service {

    // Nom du bucket S3, injecté depuis application.properties
    @Value("${aws.s3.bucket}")
    private String bucketName;

    // Clé d'accès AWS, injectée depuis application.properties
    @Value("${aws.accessKeyId}")
    private String accessKeyId;

    // Clé secrète AWS, injectée depuis application.properties
    @Value("${aws.secretAccessKey}")
    private String secretAccessKey;

    // Région AWS, injectée depuis application.properties
    @Value("${aws.region}")
    private String region;

    /**
     * Upload un fichier sur AWS S3 et retourne la clé générée.
     * @param file le fichier à uploader
     * @return la clé du fichier dans le bucket S3
     * @throws IOException en cas d'erreur de lecture du fichier
     */
    public String uploadFile(MultipartFile file) throws IOException {
        // Génère une clé unique pour le fichier (UUID + nom original)
        String key = UUID.randomUUID() + "_" + file.getOriginalFilename();

        // Crée un client S3 avec les credentials et la région
        S3Client s3 = S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKeyId, secretAccessKey)))
                .build();

        // Upload le fichier dans le bucket S3
        s3.putObject(
                PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(key)
                        .contentType(file.getContentType())
                        .build(),
                software.amazon.awssdk.core.sync.RequestBody.fromBytes(file.getBytes())
        );

        // Retourne la clé du fichier stocké
        return key;
    }
}
