package com.example.qr.service;

import com.example.qr.exception.QRContentException;
import com.example.qr.exception.QRSizeException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class QRService {
    public BufferedImage createQRCode(String content, int size) {
        if (content == null || content.trim().isEmpty()) {
            throw new QRContentException("Contents cannot be null or blank");
        }

        if (size < 150 || size > 350) {
            throw new QRSizeException("Image size must be between 150 and 350 pixels");
        }

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, size, size);

            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            throw new QRContentException(e);
        }
    }
}
