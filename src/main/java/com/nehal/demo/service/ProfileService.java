package com.nehal.demo.service;

import com.nehal.demo.dao.ProfileDao;
import com.nehal.demo.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    private final ProfileDao profileDao;

    @Autowired
    public ProfileService(@Qualifier("profileFakeRepo") ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    public int addProfile(Profile profile) {
        return profileDao.insertProfile(profile);
    }

    public List<Profile> getProfile() {
        return profileDao.getProfile();
    }
}
