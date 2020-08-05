package com.example.serviceregistrationanddiscoveryclient.model.entity;

import com.example.serviceregistrationanddiscoveryclient.remoteDataSource.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "FavoriteCountry")
public class FavoriteCountryEntity {
    @Id
    private String id;
    @DBRef
    private Country country;
}
