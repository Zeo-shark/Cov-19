package com.example.covid_19tracker;

public class CountryModel {
    private String flag, country, cases, todayCases, deaths, todayDeaths, recovered, active, critical;

    public CountryModel() {

    }

    public CountryModel(String flag, String country, String cases, String todayCases, String deaths, String todayDeaths, String recovered, String active, String critical) {
        this.flag = flag;
        this.country = country;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
    }

    public String getFlag() {
        return flag;
    }

    public String getCountry() {
        return country;
    }

    public String getCases() {
        return cases;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public String getDeaths() {
        return deaths;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public String getActive() {
        return active;
    }

    public String getCritical() {
        return critical;
    }
}
