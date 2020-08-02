package com.example.covidservice.remoteDataSource;

import com.example.covidservice.model.entity.CountryEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RetrieveDataTask {

    public DataImpl retrieveData() {
        try {
            final URL url = new URL("https://api.covid19api.com/summary");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            try(InputStream in = con.getInputStream()){
                BufferedReader rd = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
                StringBuffer response = new StringBuffer();
                String line;
                while ((line = rd.readLine()) != null) {
                    response.append(line);
                    response.append('\r');
                }
                rd.close();

                ObjectMapper mapper = new ObjectMapper();
                DataImpl result = mapper.readValue(response.toString(),DataImpl.class);
                List<Country> c = result.countries;
                Global global = result.global;
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new DataImpl();
    }


    public List<Country> getCountryList(DataImpl retrievedData) {
        List<Country> countries = retrievedData.countries;
        return countries;
    }
    public Global getGlobalData(DataImpl retrievedData) {
        Global globalData = retrievedData.global;
        return globalData;
    }
}


