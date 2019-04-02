package com.aa.soft.childrenspictures.repository;

import com.aa.soft.childrenspictures.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Anjum Abbas
 * @version 1.0
 */

@Repository
public interface ChildRepository extends JpaRepository<Child, Long>
{

}
