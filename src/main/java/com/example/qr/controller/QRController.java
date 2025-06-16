package com.example.qr.controller;

import com.example.qr.service.QRService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@Validated
@RequestMapping("/api")
public class QRController {
    @Autowired
    QRService qrService;

    @GetMapping("/qrcode")
    public ResponseEntity<BufferedImage> getQRCode(
            @RequestParam("content") @NotBlank String content,
            @RequestParam(value = "type", defaultValue = "png") @Pattern(regexp = "png|jpeg|gif") String type,
            @RequestParam(value = "size", defaultValue = "250") @Min(150) @Max(350) int size,
            @RequestParam(value = "correction", defaultValue = "L") @Pattern(regexp = "[LMQH]") String correction
    ) {
        BufferedImage image = qrService.createQRCode(content, size, correction);
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf("IMAGE/" + type.toUpperCase()))
                .body(image);
    }
}
