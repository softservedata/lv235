package com.softserve.edu.registrator.data.users;

public interface IAccountExt extends IAccount {

	IAccountExt setData(String data);

	IAccountExt setRegisterNumber(String registerNumber);

	IAccountExt setRegistratorNumber(String registratorNumber);

	IAccountExt setVolumeNumber(String volumeNumber);

}
