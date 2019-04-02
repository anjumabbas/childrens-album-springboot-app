package com.aa.soft.childrenspictures.controller;

import javax.validation.Valid;

import com.aa.soft.childrenspictures.exceptions.ResourceNotFoundException;
import com.aa.soft.childrenspictures.model.Picture;
import com.aa.soft.childrenspictures.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Anjum Abbas
 * @version 1.0
 */

@RestController
@RequestMapping("/api")
public class PictureController
{
  @Autowired
  PictureRepository mPictureRepository;

  // Get Picture by ID
  @GetMapping("/picture/{id}")
  public Picture getPictureById(@PathVariable(value = "id") Long id) {
    return mPictureRepository.findById(id)
             .orElseThrow(() -> new ResourceNotFoundException("PICTURE", "PK", id));
  }

  // Update Picture
  @PutMapping("/picture/{id}")
  public Picture updatePicture(@PathVariable(value = "id") Long id, @Valid @RequestBody Picture aPicture) {
    Picture pictureToUpdate = mPictureRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("PICTURE", "PK", id));

    pictureToUpdate.setFilename(aPicture.getFilename());
    pictureToUpdate.setGeoCoordinates(aPicture.getGeoCoordinates());

    Picture updatedPicture = mPictureRepository.save(pictureToUpdate);

    return updatedPicture;
  }

  // Create a new Picture
  @PostMapping("/picture")
  public Picture createPicture(@Valid @RequestBody Picture mPicture) {
    return mPictureRepository.save(mPicture);
  }

  // Delete a Picture
  @DeleteMapping("/picture/{id}")
  public ResponseEntity<?> deletePicture(@PathVariable(value = "id") Long id) {
    Picture pictureToUpdate = mPictureRepository.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("PICTURE", "PK", id));

    mPictureRepository.delete(pictureToUpdate);

    return ResponseEntity.ok().build();
  }

}
