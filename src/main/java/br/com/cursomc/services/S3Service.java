package br.com.cursomc.services;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class S3Service {

	private Logger LOG = LoggerFactory.getLogger(S3Service.class);

	@Autowired
	private AmazonS3 s3cliente;

	@Value("${s3.bucket}")
	private String bucketName;

	public void uploadFile(String localFilePath) {
		try {
			LOG.info("Iniciando upload do arquivo");
			File file = new File(localFilePath);
			LOG.info("arquivo enviado");
			s3cliente.putObject(new PutObjectRequest(bucketName, "teste.jpg", file));
		} catch (AmazonServiceException e) {
			LOG.info(String.format("AmazonServiceException: %s%nStatus code: %d", e.getErrorMessage(), e.getStatusCode()));
		} catch (AmazonClientException e) {
			LOG.info(String.format("AmazonCLientException: %s", e.getMessage()));
		}

	}

}
