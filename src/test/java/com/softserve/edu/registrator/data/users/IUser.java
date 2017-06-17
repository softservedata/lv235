package com.softserve.edu.registrator.data.users;

public interface IUser {

	IPerson getPerson();

	IAccount getAccount();

	IAddress getAddress();

	IPassport getPassport();

}
