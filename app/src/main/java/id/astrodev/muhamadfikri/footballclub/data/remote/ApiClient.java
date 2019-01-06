package id.astrodev.muhamadfikri.footballclub.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import id.astrodev.muhamadfikri.footballclub.adapter.Contract;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

//    private static Retrofit retrofit = null;
//
//    public static Retrofit getClient() {
//        retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.thesportsdb.com")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        return retrofit;
//        //https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?s=Soccer&c=England
//    }

    static Retrofit getClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        // add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!

        // start converter json
        Gson gson = new GsonBuilder().setLenient().create();

        return new Retrofit.Builder().baseUrl(Contract.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).client(httpClient.build()).build();
    }
}






