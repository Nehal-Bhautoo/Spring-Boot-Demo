package com.nehal.demo.api;

import com.nehal.demo.exception.ResourceNotFoundException;
import com.nehal.demo.model.Profile;
import com.nehal.demo.model.User;
import com.nehal.demo.repository.ProfileRepo;
import com.nehal.demo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nehal.demo.encryption.JasyptEncryptorUtils.encode;

@RequestMapping("api/v1")
@RestController
public class ProfileController {
    private final ProfileService profileService;

    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    // get all user
    @GetMapping("/profile")
    public List<Profile> getAllProfile() {
        System.out.println(profileRepo.findAll().toString());
        return profileRepo.findAll();
    }

    // get profile by id
    @GetMapping("/profile/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable(value = "id") Integer userId)
        throws ResourceNotFoundException {
        Profile profile = profileRepo.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User does not exist" + userId));
        return ResponseEntity.ok().body(profile);
    }

    // create new profile
    @PostMapping("/profile")
    public void addProfile(@RequestBody Profile profile) {
        profileService.addProfile(profile);
    }
}
