package org.example.services.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Base64Utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Slf4j
public class ImageUtils {

    private static final String STATIC_FOLDER = "src/main/resources/static/";

    public static String saveBase64Image(String base64Image, String fileName) {
        log.info("Starting to save Base64 image with fileName: {}", fileName);

        byte[] imageBytes = Base64Utils.decodeFromString(base64Image);
        Path path = Paths.get(STATIC_FOLDER + fileName + LocalDateTime.now() + ".png");
        try {
            Files.createDirectories(path.getParent());
            log.info("Directories created for path: {}", path.getParent());
        } catch (IOException e) {
            log.error("Error creating directories for path: {}", path.getParent(), e);
            throw new RuntimeException(e);
        }
        try (FileOutputStream fos = new FileOutputStream(path.toFile())) {
            fos.write(imageBytes);
            log.info("Image successfully written to file: {}", path);
        } catch (IOException e) {
            log.error("Error writing image to file: {}", path, e);
            throw new RuntimeException(e);
        }
        return path.toString();
    }
}
