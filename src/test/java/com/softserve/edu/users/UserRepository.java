package com.softserve.edu.users;

public final class UserRepository {
	// Repository Realize by Static Methods, Singleton, Enum.
	//
	// Use Singleton, Repository
	private static volatile UserRepository instance;

	private UserRepository() {
	}

	public static UserRepository get() {
		if (instance == null) {
			synchronized (UserRepository.class) {
				if (instance == null) {
					instance = new UserRepository();
				}
			}
		}
		return instance;
	}
	
	public IUser admin() {
		// Code for read data
		return User.get()
	        .setLogin("aa")
	        .setPassword("bb")
	        .setFirstname("ccc")
	        .setLastname("dd")
	        .setEmail("ee")
	        .build();	
	}
	
	public IUser newUser() {
		return User.get()
		        .setLogin("aa1")
		        .setPassword("bb1")
		        .setFirstname("ccc1")
		        .setLastname("dd1")
		        .setEmail("ee1")
		        .build();	
	}

//	public static List<IUser> getNewUsersFromCsvFile() {
//		return new UserUtils().getAllUsers();
//	}
//
//	public static List<IUser> getNewUsersFromExcelFile() {
//		return new UserUtils("/newUsers.xlsx", new ExcelUtils()).getAllUsers();
//	}
//
//	public static List<IUser> getNewUsersFromDB() {
//		return new UserUtils("/", new DBUtils()).getAllUsers();
//	}

}
