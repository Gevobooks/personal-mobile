package com.example.senaisp.personalbooks.repository;

import android.content.Context;
import android.content.SharedPreferences;

import android.support.v7.app.AppCompatActivity;
import com.example.senaisp.personalbooks.model.viewModel.Token;
import com.example.senaisp.personalbooks.model.viewModel.UserFiles;
import com.google.gson.Gson;
import android.content.SharedPreferences;
import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by tancredofernando on 03/12/16.
 */

public class UserRepository
{

    static Gson gson = new Gson();


    public static void EnviarUsuario(final String json, final ICallback<Token> cb)
    {
        new Thread(new Runnable() {
            @Override
            public void run()
            {
                OkHttpClient client = new OkHttpClient();

                RequestBody body = RequestBody.create(Repository.MediaType, json);

                Request request = new Request.Builder()
                    .url(Repository.BaseUrl + "Account/Login")
                    .post(body)
                    .build();


                try {
                    Response response = client.newCall(request).execute();
                    int code = response.code();
                    String responseBody = response.body().string();

                    Token token = gson.fromJson(responseBody, Token.class);

                    if (code != 200)
                    {
                        cb.Callback(null, new Exception( ));
                    }
                    else cb.Callback(token, null);
                } catch (IOException e) {
                    cb.Callback(null, e);
                }
            }
        }).start();
    }

    public static void getForgetPassword(final String Email, final ICallback<Token> cb)
{
    new Thread(new Runnable() {
        @Override
        public void run()
        {
            OkHttpClient client = new OkHttpClient();

            RequestBody body = RequestBody.create(Repository.MediaType, "");

            Request request = new Request.Builder()
                    .url(Repository.BaseUrl + "Account/ForgetPassword?email=" + Email)
                    .post(body)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                int code = response.code();
                String responseBody = response.body().string();

                Token token = gson.fromJson(responseBody, Token.class);

                if (code != 200)
                {
                    cb.Callback(null, new Exception());
                }
                else cb.Callback(null, null);
            } catch (IOException e) {
                cb.Callback(null, e);
            }
        }
    }).start();
}

    public static void getUserFiles(final String access_token, final ICallback<UserFiles> cb)
    {
        new Thread(new Runnable() {
            @Override
            public void run()
            {
                OkHttpClient client = new OkHttpClient();



                Request request = new Request.Builder()
                        .header("Authorization","Bearer "+ access_token)
                        .url(Repository.BaseUrl + "File/UserFiles" )
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    int code = response.code();
                    String responseBody = response.body().string();

                    UserFiles userFiles = gson.fromJson(responseBody, UserFiles.class);

                    if (code != 200)
                    {
                        cb.Callback(null, new Exception());
                    }
                    else cb.Callback(null, null);
                } catch (IOException e) {
                    cb.Callback(null, e);
                }
            }
        }).start();
    }


}
