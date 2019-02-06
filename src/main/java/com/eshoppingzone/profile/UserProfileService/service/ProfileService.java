package com.eshoppingzone.profile.UserProfileService.service;

import java.util.List;
import java.util.Optional;

import com.eshoppingzone.profile.UserProfileService.pojo.UserProfile;

public interface ProfileService {

	UserProfile addNewCustomerProfile(UserProfile profile);

	List<UserProfile> getAllProfiles();

	Optional<UserProfile> getByProfileId(int profileId);

	void updateProfile(UserProfile userProfile);

	void deleteProfile(int profileId);

	void addNewMerchantProfile(UserProfile profile);

	void addNewdeliveryProfile(UserProfile profile);

}
