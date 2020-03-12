package com.flege.gumukrejo.rest;

import com.flege.gumukrejo.model.DefaultResponse;
import com.flege.gumukrejo.model.GetAuth;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("auth/register")
    Call<DefaultResponse> register_pelanggan(
            @Field("nik") String nik,
            @Field("nama") String nama,
            @Field("gender") String gender,
            @Field("kontak") String kontak,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("auth/pelanggan")
    Call<GetAuth> getPelanggan(@Field("kontak") String kontak, @Field("password") String password);

    @FormUrlEncoded
    @POST("profile/change_password")
    Call<DefaultResponse> changePasswowd(
            @Field("id_pelanggan") String id_pelanggan,
            @Field("nik") String nik,
            @Field("password") String password,
            @Field("new_password") String new_password
    );

    @FormUrlEncoded
    @POST("auth/konfirmasi_pendaftaran")
    Call<DefaultResponse> konfirmasi_pendaftaran(@Field("kontak") String kontak, @Field("kode") String kode);

    @FormUrlEncoded
    @POST("profile/get_saldo")
    Call<DefaultResponse> get_balance(@Field("id_pelanggan") String id_pelanggan, @Field("nik") String nik);
}
