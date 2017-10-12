package org.aditi.restwebservices.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.aditi.restwebservices.messenger.database.DatabaseClass;
import org.aditi.restwebservices.messenger.model.Profile;

public class ProfileService 
{
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService()
	{
		profiles.put("aditi", new Profile(1L,"aditi", "Aditi", "Pathak"));
		profiles.put("meera", new Profile(2L,"meera", "Meera", "Pathak"));
		profiles.put("arun", new Profile(3L,"arun", "Arun", "Pathak"));
		profiles.put("navi", new Profile(4L,"navi", "Navendu", "Pathak"));
		profiles.put("mansi", new Profile(5L,"mansi", "Mansi", "Pathak"));
	}
	public List<Profile> getAllProfiles()
	{
		return new ArrayList<Profile> (profiles.values());
	}

	public Profile getProfile(String profileName)
	{
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile)
	{
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile)
	{
		if(profile.getProfileName().isEmpty())
		{
			return null;
		}
		else
		{
			profiles.put(profile.getProfileName(), profile);
			return profile;
		}
	}

	public Profile removeProfile(String profileName)
	{
		return profiles.remove(profileName);
	}

}