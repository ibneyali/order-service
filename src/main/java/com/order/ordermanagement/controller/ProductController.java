package com.order.ordermanagement.controller;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.ordermanagement.configuration.BarcodeGenerator;
import com.order.ordermanagement.entity.ProductEntity;
import com.order.ordermanagement.service.ProductService;

@RestController
@RequestMapping("api/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping
	public List<ProductEntity> findAllProduct() {
		return productService.findAllProducts();
	}

	@GetMapping("/{id}")
	public Optional<ProductEntity> findProductById(@PathVariable Long id) {
		return productService.findProductById(id);
	}

	/*
	 * @GetMapping("/barcode") public static void barcode() { try {
	 * 
	 * String text =
	 * "{\"id\":2,\"name\":\"ibney\",\"address\":\"India\",\"gender\":\"Male\",\"age\":\"35\",\"married\":true}";
	 * String path = "D:\\Barcode\\barcode.jpg";
	 * 
	 * Code128Writer writer = new Code128Writer(); BitMatrix matrix =
	 * writer.encode(text, BarcodeFormat.CODE_128, 300, 200);
	 * 
	 * MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
	 * 
	 * System.out.println("Barcode created...");
	 * 
	 * } catch (Exception e) { System.out.println("Error while creating barcode"); }
	 * }
	 */
	
//	@GetMapping("/barcode")
//	public static BufferedImage generateEAN13BarcodeImage() throws Exception {
//	    EAN13Writer barcodeWriter = new EAN13Writer();
//	    String str = "{\"id\":1,\"name\":\"ibney\",\"gender\":\"Male\",\"Married\":\"yes\"}";
//	    BitMatrix bitMatrix = barcodeWriter.encode(str, BarcodeFormat.EAN_13, 300, 150);
//
//	    return MatrixToImageWriter.toBufferedImage(bitMatrix);
//	}
	
	@Autowired
    private BarcodeGenerator barcodeService;
	
	@PostMapping(value = "/generateBarcode", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> generateBarcode(@RequestParam String orderDetails) {
        try {
            ByteArrayOutputStream barcodeStream = barcodeService.generateBarcodeImage(orderDetails);
            byte[] barcodeBytes = barcodeStream.toByteArray();

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=barcode.png");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(barcodeBytes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
	
	@PostMapping
	public ProductEntity postProduct(@RequestBody ProductEntity productEntity) {
		return productService.saveProduct(productEntity);
	}

	@PutMapping
	public ProductEntity updateProduct(@RequestBody ProductEntity productEntity) {
		return productService.updateProduct(productEntity);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}