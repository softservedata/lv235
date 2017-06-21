package com.softserve.edu.registrator.data.communities;

import com.softserve.edu.registrator.data.users.UserRepository;

public class CommunityRepository {
	private static volatile CommunityRepository instance = null;

	private CommunityRepository() {
	}
	
    public static CommunityRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new CommunityRepository();
                }
            }
        }
        return instance;
    }

}
