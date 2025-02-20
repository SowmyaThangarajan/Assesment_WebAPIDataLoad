package com.tests.db.Testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Listeners(com.listeners.ExtentReportManager.class)
public class OutputFileValidationTests {

    @Test
    public void dataValidation(){
        try {
            // To Load Input Files
            Map<String, Double> isinToUnitPrice = loadInstrumentDetails("src//test//java//com//tests//db//app_in//InstrumentDetails.csv");
            Map<Integer, Integer> positionIdToQuantity = loadPositionDetails("src//test//java//com//tests//db//app_in//PositionDetails.csv");

            // Validation of Output File
            validateOutputFile("src//test//java//com//tests//db//app_out//PositionReport.csv", isinToUnitPrice, positionIdToQuantity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Double> loadInstrumentDetails(String fileName) throws IOException {
        Map<String, Double> isinToUnitPrice = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            String isin = data[2];
            double unitPrice = Double.parseDouble(data[3]);
            isinToUnitPrice.put(isin, unitPrice);
        }
        reader.close();
        return isinToUnitPrice;
    }

    private static Map<Integer, Integer> loadPositionDetails(String fileName) throws IOException {
        Map<Integer, Integer> positionIdToQuantity = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            int positionId = Integer.parseInt(data[0]);
            int quantity = Integer.parseInt(data[2]);
            positionIdToQuantity.put(positionId, quantity);
        }
        reader.close();
        return positionIdToQuantity;
    }

    private static void validateOutputFile(String fileName, Map<String, Double> isinToUnitPrice, Map<Integer, Integer> positionIdToQuantity) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            int id = Integer.parseInt(data[0]);
            int positionId = Integer.parseInt(data[1]);
            String isin = data[2];
            int outputQuantity = Integer.parseInt(data[3]);
            double outputTotalPrice = Double.parseDouble(data[4]);

            if (!positionIdToQuantity.containsKey(positionId)) {
                System.out.println("Error: Invalid PositionID: " + positionId);
                continue;
            }

            if (!isinToUnitPrice.containsKey(isin)) {
                System.out.println("Error: Invalid ISIN: " + isin);
                continue;
            }

            int expectedQuantity = positionIdToQuantity.get(positionId);
            double unitPrice = isinToUnitPrice.get(isin);

            double expectedTotalPrice = expectedQuantity * unitPrice;

            if (outputQuantity != expectedQuantity) {
                System.out.println("Error: Quantity mismatch for PositionID " + positionId);
            }

            if (outputTotalPrice != expectedTotalPrice) {
                System.out.println("Error: Total Price mismatch for PositionID " + positionId + ". Expected: " + expectedTotalPrice + ", Found: " + outputTotalPrice);
            }

            if (outputQuantity == expectedQuantity && outputTotalPrice == expectedTotalPrice) {
                System.out.println("Valid Data: PositionID " + positionId);
            }
        }
        reader.close();
    }
}
