package com.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.ProductDetails;
import com.demo.repo.ProductDetailsRepo;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class SaveDataService {
	@Autowired
	private ProductDetailsRepo repo;

	public void csvReader() {
		int count = 1;
		repo.deleteAll();
		File[] file = new File(
				"D:\\work\\ExitTest\\prodoctcommunity-1\\src\\CsvFiles")
				.listFiles();
		for (File filename : file) {
			String csvFilePath = filename.getAbsolutePath();
			try {
				CSVReader csvReader = new CSVReaderBuilder(new FileReader(csvFilePath)).withSkipLines(1).build();
				String[] values = null;
				while ((values = csvReader.readNext()) != null) {
					String[] records = values[0].split("\\|");
					ProductDetails pd = new ProductDetails();
					pd.setSampleId(count++);
					pd.setId(records[0]);
					pd.setName(records[1]);
					pd.setColour(records[2]);
					pd.setGender(records[3]);
					pd.setSize(records[4]);
					pd.setPrice(Double.parseDouble(records[5]));
					pd.setRating(Double.parseDouble(records[6]));
					pd.setAvailability(records[7]);
					pd.setBrand(records[8]);
					pd.setImage(records[9]);
					repo.save(pd);
				}
			} catch (FileNotFoundException e) {
				System.out.println("File is not found");
				e.printStackTrace();
			} catch (CsvValidationException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<ProductDetails> getAllData() {
		return (List<ProductDetails>) repo.findAll();
	}

}
