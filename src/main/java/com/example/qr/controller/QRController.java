package com.example.qr.controller;

import com.example.qr.exception.QRTypeException;
import com.example.qr.service.QRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/api")
public class QRController {
    @Autowired
    QRService qrService;

    @GetMapping("/qrcode")
    public ResponseEntity<BufferedImage> getQRCode(
            @RequestParam("content") String content,
            @RequestParam(value = "type", defaultValue = "png") String type,
            @RequestParam(value = "size", defaultValue = "250") int size)
    {
        BufferedImage image = qrService.createQRCode(content, size);

        if (!type.equals("png") && !type.equals("jpeg") && !type.equals("gif")) {
            throw new QRTypeException("Only png, jpeg and gif image types are supported");
        }

        MediaType mediaType = switch (type) {
            case "jpeg" -> MediaType.IMAGE_JPEG;
            case "gif" -> MediaType.IMAGE_GIF;
            default -> MediaType.IMAGE_PNG;
        };

        return ResponseEntity
                .ok()
                .contentType(mediaType)
                .body(image);
    }
}
