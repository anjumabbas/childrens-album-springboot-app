package com.aa.soft.childrenspictures.repository;

import com.aa.soft.childrenspictures.model.Child;
import com.aa.soft.childrenspictures.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Anjum Abbas
 * @version 1.0
 */

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long>
{

}
