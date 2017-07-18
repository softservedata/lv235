package com.softserve.edu.registrator.data.users;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.registrator.data.external.IExternalData;

public final class UserUtils {

    public static enum UserUtilsFields {
        UNNECESSARY("Unnecessary", -1),
        FIRSTNAME("Firstname", 0),
        LASTNAME("Lastname", 1),
        EMAIL("Email", 2),
        MIDDLENAME("Middlename", 3),
        PHONE_NUMBER("Phonenumber", 4),
        LOGIN("Login", 5),
        PASSWORD("Password", 6),
        ROLE("Role", 7),
        STATUS("Status", 8),
        COMMUNITY("Community", 9),
        DATA("Data", 10),
        REGISTER_NUMBER("RegisterNumber", 11),
        REGISTRATOR_NUMBER("RegistratorNumber", 12),
        VOLUME_NUMBER("VolumeNumber", 13),
        REGION("Region", 14),
        DISTRICT("District", 15),
        CITY("City", 16),
        STREET("Street", 17),
        BUILDING("Building", 18),
        FLAT("Flat", 19),
        POSTCODE("Postcode", 20),
        SERIA("Seria", 21),
        NUMBER("Number", 22),
        PUBLISHED("Published", 23);
        //
        private String field;
        private int number;

        private UserUtilsFields(String field, int number) {
            this.field = field;
            this.number = number;
        }

        public int getnumber() {
            return number;
        }
        
        @Override
        public String toString() {
            return field;
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    private IExternalData externalData;

    public UserUtils(IExternalData externalData) {
		this.externalData = externalData;
    }

    public List<IUser> getAllUsers() {
        List<IUser> users = new ArrayList<IUser>();
        for (List<String> row : externalData.getAllCells()) {
            row = externalData.getRowFactory().updateRow(row);
            System.out.println("+++row = " + row);
            System.out.println("+++row.size() = " + row.size());
            System.out.println("+++row.get(2) = " + row.get(2));
            if (!row.get(2).contains("@")) {
                continue;
            }
            users.add(User.get()
                    .setPerson(Person.get()
                            .setFirstname(row.get(0))
                            .setLastname(row.get(1))
                            .setEmail(row.get(2))
                            .build()
                            .setMiddlename(row.get(3) == null ? new String() : row.get(3))
                            .setPhonenumber(row.get(4) == null ? new String() : row.get(4))
                    )
                    .setAccount(Account.get()
                                    .setLogin(row.get(5))
                                    .setPassword(row.get(6))
                                    .setRole(row.get(7))
                                    .setStatus(row.get(8))
                                    .setCommunity(row.get(9))
                                    .build()
                                    .setData(row.get(10) == null ? new String() : row.get(10))
                                    .setRegisterNumber(row.get(11) == null ? new String() : row.get(11))
                                    .setRegistratorNumber(row.get(12) == null ? new String() : row.get(12))
                                    .setVolumeNumber(row.get(13) == null ? new String() : row.get(13))
                            )
                    .build()
                    .setAddress(Address.get()
                            .setRegion(row.get(14) == null ? new String() : row.get(14))
                            .setDistrict(row.get(15) == null ? new String() : row.get(15))
                            .setCity(row.get(16) == null ? new String() : row.get(16))
                            .setStreet(row.get(17) == null ? new String() : row.get(17))
                            .setBuilding(row.get(18) == null ? new String() : row.get(18))
                            .setFlat(row.get(19) == null ? new String() : row.get(19))
                            .setPostcode(row.get(20) == null ? new String() : row.get(20))
                            )
                    .setPassport(Passport.get()
                            .setSeria(row.get(21) == null ? new String() : row.get(21))
                            .setNumber(row.get(22) == null ? new String() : row.get(22))
                            .setPublished(row.get(23) == null ? new String() : row.get(23))
                            )
                    );
        }
        return users;
    }

}
