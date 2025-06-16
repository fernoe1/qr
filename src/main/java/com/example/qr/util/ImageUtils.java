package com.example.qr.util;

import com.example.qr.exception.QRSizeException;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUtils {
    public static BufferedImage getQRCode(int size) {
        if (size < 150 || size > 350) {
            throw new QRSizeException("Image size must be between 150 and 350 pixels");
        }

        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, size, size);

        return image;
    }
}
