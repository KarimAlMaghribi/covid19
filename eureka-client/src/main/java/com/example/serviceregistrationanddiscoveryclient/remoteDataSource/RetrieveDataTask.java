package com.example.serviceregistrationanddiscoveryclient.remoteDataSource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
@Service
public class RetrieveDataTask {

    private DataImpl retrieveData() {
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

                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new DataImpl();
    }


    public List<Country> getCountryList() {
        DataImpl apiData = this.retrieveData();
        List<Country> countries = apiData.countries;
        return countries;
    }
    public Global getGlobalData() {
        DataImpl apiData = this.retrieveData();
        Global globalData = apiData.global;
        return globalData;
    }
}


