package com.nehal.demo.dao;

import com.nehal.demo.model.Profile;
import com.nehal.demo.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("profileFakeRepo")
public class ProfileDataAccessService implements ProfileDao {
    @Autowired
    private ProfileRepo profileRepo;

    private static List<Profile> profileList = new ArrayList<>();

    @Override
    public int insertProfile(Profile profile) {
        profileList.add(
                new Profile(
                        profile.getEmail(),
                        profile.getPhone(),
                        profile.getAddress(),
                        profile.getImage(),
                        profile.getDateOfBirth(),
                        profile.getUserId()
                )
        );
        profileRepo.save(
                new Profile(
                        profile.getEmail(),
                        profile.getPhone(),
                        profile.getAddress(),
                        profile.getImage(),
                        profile.getDateOfBirth(),
                        profile.getUserId()
                )
        );
        return 1;
    }

    @Override
    public List<Profile> getProfile() {
        return profileList;
    }
}
