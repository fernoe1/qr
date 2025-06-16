package com.example.qr.controller;

import com.example.qr.util.ImageUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
public class QRController {
    @GetMapping("/api/qrcode")
    public ResponseEntity<BufferedImage> getQRCode() {
        BufferedImage image = ImageUtils.getQRCode();
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(image);
    }
}
