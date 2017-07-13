package com.softserve.edu.registrator.data.users;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.registrator.data.external.IExternalData;

public final class UserUtils {
    private IExternalData externalData;

    public UserUtils(IExternalData externalData) {
		this.externalData = externalData;
    }

    public List<IUser> getAllUsers() {
        List<IUser> users = new ArrayList<IUser>();
        for (List<String> row : externalData.getAllCells()) {
            //System.out.println("row = " + row);
            //System.out.println("row.size() = " + row.size());
            //System.out.println("row.get(2) = " + row.get(2));
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
