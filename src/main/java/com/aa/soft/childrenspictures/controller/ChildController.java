package com.aa.soft.childrenspictures.controller;

import javax.validation.Valid;

import com.aa.soft.childrenspictures.exceptions.ResourceNotFoundException;
import com.aa.soft.childrenspictures.model.Child;
import com.aa.soft.childrenspictures.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Anjum Abbas
 * @version 1.0
 */

@RestController
@RequestMapping("/api")
public class ChildController
{
  @Autowired
  ChildRepository mChildRepository;

  // Get Child by ID
  @GetMapping("/child/{id}")
  public Child getChildById(@PathVariable(value = "id") Long id) {
    return mChildRepository.findById(id)
             .orElseThrow(() -> new ResourceNotFoundException("CHILD", "PK", id));
  }

  // Update Child
  @PutMapping("/child/{id}")
  public Child updateChild(@PathVariable(value = "id") Long id, @Valid @RequestBody Child aChild) {
    Child childToUpdate = mChildRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("CHILD", "PK", id));

    childToUpdate.setDob(aChild.getDob());
    childToUpdate.setGender(aChild.getGender());
    childToUpdate.setName(aChild.getName());

    Child updatedChild = mChildRepository.save(childToUpdate);

    return updatedChild;
  }

  // Create a new Child
  @PostMapping("/child")
  public Child createChild(@Valid @RequestBody Child mChild) {
    return mChildRepository.save(mChild);
  }

  // Delete a Child
  @DeleteMapping("/child/{id}")
  public ResponseEntity<?> deleteChild(@PathVariable(value = "id") Long id) {
    Child childToUpdate = mChildRepository.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("CHILD", "PK", id));

    mChildRepository.delete(childToUpdate);

    return ResponseEntity.ok().build();
  }

}
