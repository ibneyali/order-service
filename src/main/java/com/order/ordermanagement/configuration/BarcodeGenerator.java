package com.order.ordermanagement.configuration;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.QRCodeWriter;

@Service
public class BarcodeGenerator {

	public ByteArrayOutputStream generateBarcodeImage(String data) throws Exception {
		Code128Writer barcodeWriter = new Code128Writer();
		BitMatrix bitMatrix = barcodeWriter.encode(data, BarcodeFormat.CODE_128, 400, 150);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outputStream;
	}

}
