package com.example.patient.service;

import ai.onnxruntime.*;
import com.example.patient.model.Patient_Tests;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Arrays;
@Service
public class PredictionService {

    private OrtEnvironment env;
    private OrtSession session;

    // Constructor to initialize the ONNX runtime environment and load the model
    public PredictionService() throws OrtException, IOException {
        this.env = OrtEnvironment.getEnvironment();

        // Load the model from classpath
        String modelPath = "newmodel.onnx"; // Update with your actual model file name
        InputStream modelInputStream = new ClassPathResource(modelPath).getInputStream();

        // Create a temporary file to use with OrtSession
        java.nio.file.Path tempFile = java.nio.file.Files.createTempFile("model", ".onnx");
        java.nio.file.Files.copy(modelInputStream, tempFile, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

        this.session = env.createSession(tempFile.toString(), new OrtSession.SessionOptions());

        // Clean up temporary file
        tempFile.toFile().deleteOnExit();
    }

// Method to make predictions using the loaded model
    public float predict(Patient_Tests patient) throws OrtException {
        // Extract relevant fields from the Patient_Tests object
        double[] testData = {
                patient.getHeart_rate(),
                patient.getDiabetespedigreefunction(),
                patient.getGlucose(),
                patient.getBlood_pressure(),
                patient.getSkin_thickness(),
                patient.getInsulin(),
                patient.getBmi()
        };

        // Convert the input data to float[][] format
        float[][] floatInput = convertToFloat2DArray(testData);

        // Create an input tensor
        OnnxTensor inputTensor = OnnxTensor.createTensor(env, floatInput);

        // Run the model
        OrtSession.Result result = session.run(Collections.singletonMap("float_input", inputTensor));

        // Get the output
        //float[] output = (float[]) result.get(0).getValue();

        // Print the type and content of the result
        //System.out.println("Output type: " + output.getClass().getName());
        //System.out.println("Output content: " + Arrays.toString(output));

        //return output[0]; // Assuming the model returns a single float value
        //System.out.println(result.get(0).getValue()); //(long) ;
        //return result.get(0).getValue();
        return 1;
    }




    // Helper method to convert double array to float 2D array
    private float[][] convertToFloat2DArray(double[] input) {
        int length = input.length;
        float[][] floatArray = new float[1][length]; // Assuming the input should be 1 row and 'length' columns
        for (int i = 0; i < length; i++) {
            floatArray[0][i] = (float) input[i];
        }
        return floatArray;
    }
}