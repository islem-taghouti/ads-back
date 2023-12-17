package com.ads.mangement.service;

import com.ads.mangement.model.Ad;
import com.ads.mangement.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AdService {
    @Autowired
    private AdRepository adRepository;

    public List<Ad> getAllAds() {
        return adRepository.findAll();
    }

    public Ad createAd(Ad ad) {
        ad.setDateCreated(new Date());
        ad.setCreatedBy("system");
        return adRepository.save(ad);
    }

    public Optional<Ad> getAdById(Long id) {
        return adRepository.findById(id);
    }
    public Ad updateAd(Long id, Ad updatedAd) {
        Optional<Ad> existingAdOptional = adRepository.findById(id);

        if (existingAdOptional.isPresent()) {
            Ad existingAd = existingAdOptional.get();
            existingAd.setName(updatedAd.getName());
            existingAd.setPrice(updatedAd.getPrice());
            existingAd.setCategory(updatedAd.getCategory());
            existingAd.setDescription(updatedAd.getDescription());
            existingAd.setPicture(updatedAd.getPicture());
            existingAd.setLocation(updatedAd.getLocation());
            existingAd.setStillAvailable(updatedAd.isStillAvailable());

            return adRepository.save(existingAd);
        } else {
            throw new RuntimeException("Ad not found with id: " + id);
        }
    }

    public void deleteAd(Long id) {
        if (adRepository.existsById(id)) {
            adRepository.deleteById(id);
        } else {
            throw new RuntimeException("Ad not found with id: " + id);
        }
    }

}
