package com.example.senaisp.personalbooks.repository;

import okhttp3.MediaType;

/**
 * Created by tancredofernando on 03/12/16.
 */

public class Repository
{
    public static String BaseUrl = "http://evolearn.ddns.net:63000/";

    public static MediaType MediaType = okhttp3.MediaType.parse("application/json");
}
