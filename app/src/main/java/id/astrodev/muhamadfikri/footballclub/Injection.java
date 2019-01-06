package id.astrodev.muhamadfikri.footballclub;


import id.astrodev.muhamadfikri.footballclub.data.FootballRepository;
import id.astrodev.muhamadfikri.footballclub.data.local.FootballLocalDataSource;
import id.astrodev.muhamadfikri.footballclub.data.remote.FootballRemoteDataSource;

public class Injection {

    public static FootballRepository provideRepository() {
        return new FootballRepository(new FootballRemoteDataSource(), new FootballLocalDataSource());
    }
}
