package com.nehal.demo.dao;

import com.nehal.demo.model.Profile;
import java.util.List;
import java.util.UUID;

public interface ProfileDao {
    default int insertProfile(Profile profile) {
        return insertProfile(profile);
    }

    List<Profile> getProfile();
}
