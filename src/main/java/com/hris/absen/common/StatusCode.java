package com.hris.absen.common;

public interface StatusCode {

    String SAVE_SUCCESS = "Data berhasil ditambahkan"; /*201*/
    String SAVE_FAILED = "Data gagal ditambahkan"; /*401*/
    String UPDATE_SUCCESS = "Data berhasil diubah"; /*202*/
    String UPDATE_FAILED = "Data gagal diubah";/*401*/
    String DELETE_SUCCESS = "Data berhasil dihapus"; /*202*/
    String DELETE_FAILED = "Data gagal dihapus"; /*401*/

    String OPERATION_SUCCESS = "200";
    String OPERATION_FAILED = "400";

    String PASSWORD_OR_USER_NOT_REGISTERED = "415";
    String LOGIN_SUCCESS = "211";
    String LOGIN_FAILED = "212";
}
