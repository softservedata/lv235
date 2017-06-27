package com.softserve.edu.registrator.data.users;

public final class UserRepository {
    private static volatile UserRepository instance = null;

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

    // TODO
	//public IUser getAdmin()
	//public IUser getRegistrator()
	//public IUser getCommissioner()
	//public IUser getCoOwner()
	//public IUser getNewUser()
	//
	//public List<IUser> getAdminDB()
	
	public IUser admin() {
		// TODO Read from file
		return User.get()
					.setPerson(Person.get()
									.setFirstname("Адміністратор")
									.setLastname("Адміністратор")
									.setEmail("admin@admin.com")
									.build()
									.setMiddlename("Адміністратор")
									.setPhonenumber("")
							)
					.setAccount(Account.get()
									.setLogin("admin")
									.setPassword("admin")
									.setRole("Адміністратор")
									.setStatus("Активний")
									.setCommunity("Україна")
									.build()
									.setData("")
									.setRegisterNumber("0")
									.setRegistratorNumber("0")
									.setVolumeNumber("0")
							)
					.build()
					.setAddress(Address.get()
							.setRegion("Львівська")
							.setDistrict("Галицький")
							.setCity("Львів")
							.setStreet("Вітовського")
							.setBuilding("48")
							.setFlat("31")
							.setPostcode("00000")
							)
					.setPassport(Passport.get()
							.setSeria("AA")
							.setNumber("00000")
							.setPublished("Народом України")
							);
	}

	public IUser commissioner() {
		// TODO Read from file
		return User.get()
					.setPerson(Person.get()
									.setFirstname("NazarComis")
									.setLastname("NazarComis")
									.setEmail("NazarComis@gmail.com")
									.build()
									.setMiddlename("NazarComis")
									.setPhonenumber("")
							)
					.setAccount(Account.get()
									.setLogin("NazarComis")
									.setPassword("qwerty")
									.setRole("Уповноважений") // TODO Add Language Support
									.setStatus("Активний")
									.setCommunity("Україна")
									.build()
									.setData("")
									.setRegisterNumber("0")
									.setRegistratorNumber("0")
									.setVolumeNumber("0")
							)
					.build()
					.setAddress(Address.get()
							.setRegion("Lviv")
							.setDistrict("Lviv")
							.setCity("Lviv")
							.setStreet("Street")
							.setBuilding("99")
							.setFlat("56")
							.setPostcode("79014")
							)
					.setPassport(Passport.get()
							.setSeria("АА")
							.setNumber("919191")
							.setPublished("Любий РВУМВСУ")
							);
	}

	public IUser registrator() {
		// TODO Read from file
		return User.get()
					.setPerson(Person.get()
									.setFirstname("реєстратор")
									.setLastname("реєстратор")
									.setEmail("registrator@ukr.net")
									.build()
									.setMiddlename("")
									.setPhonenumber("")
							)
					.setAccount(Account.get()
									.setLogin("registrator")
									.setPassword("registrator")
									.setRole("Реєстратор") // TODO Add Language Support
									.setStatus("Активний")
									.setCommunity("Львівська")
									.build()
									.setData("")
									.setRegisterNumber("0")
									.setRegistratorNumber("0")
									.setVolumeNumber("0")
							)
					.build()
					.setAddress(Address.get()
							.setRegion("")
							.setDistrict("")
							.setCity("")
							.setStreet("")
							.setBuilding("")
							.setFlat("")
							.setPostcode("")
							)
					.setPassport(Passport.get()
							.setSeria("")
							.setNumber("")
							.setPublished("")
							);
	}

	public IUser getEmpty() {
		// TODO Read from file
		return User.get()
					.setPerson(Person.get()
									.setFirstname("")
									.setLastname("")
									.setEmail("")
									.build()
									.setMiddlename("")
									.setPhonenumber("")
							)
					.setAccount(Account.get()
									.setLogin("")
									.setPassword("")
									.setRole("")
									.setStatus("")
									.setCommunity("")
									.build()
									.setData("")
									.setRegisterNumber("")
									.setRegistratorNumber("")
									.setVolumeNumber("")
							)
					.build()
					.setAddress(Address.get()
							.setRegion("")
							.setDistrict("")
							.setCity("")
							.setStreet("")
							.setBuilding("")
							.setFlat("")
							.setPostcode("")
							)
					.setPassport(Passport.get()
							.setSeria("")
							.setNumber("")
							.setPublished("")
							);
	}

	   public IUser invalid() {
	        // TODO Read from file
	        return User.get()
	                    .setPerson(Person.get()
	                                    .setFirstname("Адміністратор")
	                                    .setLastname("Адміністратор")
	                                    .setEmail("admin@admin.com")
	                                    .build()
	                                    .setMiddlename("Адміністратор")
	                                    .setPhonenumber("")
	                            )
	                    .setAccount(Account.get()
	                                    .setLogin("admin11")
	                                    .setPassword("admin11")
	                                    .setRole("Адміністратор")
	                                    .setStatus("Активний")
	                                    .setCommunity("Україна")
	                                    .build()
	                                    .setData("")
	                                    .setRegisterNumber("0")
	                                    .setRegistratorNumber("0")
	                                    .setVolumeNumber("0")
	                            )
	                    .build()
	                    .setAddress(Address.get()
	                            .setRegion("Львівська")
	                            .setDistrict("Галицький")
	                            .setCity("Львів")
	                            .setStreet("Вітовського")
	                            .setBuilding("48")
	                            .setFlat("31")
	                            .setPostcode("00000")
	                            )
	                    .setPassport(Passport.get()
	                            .setSeria("AA")
	                            .setNumber("00000")
	                            .setPublished("Народом України")
	                            );
	    }

//    public List<IUser> getExistUsersCVS() {
//        return new UserUtils().getAllUsers();
//    }
//
//    public List<IUser> getExistUsersExcel() {
//        return new UserUtils("/users.xlsx", new ExcelUtils()).getAllUsers();
//    }

}
