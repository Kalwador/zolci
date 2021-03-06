package com.project.manager.repositories;

import com.project.manager.entities.UserModel;
import com.project.manager.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * This is the class which provides all methods to manage the {@link UserModel} in database
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    /**
     * This method is searching the {@link UserModel} with passed id in database
     *
     * @param id this parameter is id to identify the user in database
     * @return the user with the same email ass passed in parameter
     */
    @Override
    Optional<UserModel> findById(Long id);

    /**
     * This method is searching the {@link UserModel} with passed username in database
     *
     * @param username this parameter is username to identify the user in database
     * @return the user with the same username ass passed in parameter
     */
    Optional<UserModel> findByUsername(String username);

    /**
     * This method is searching the {@link UserModel} with passed EMAIL in database
     *
     * @param email this parameter is emial to identify the user in database
     * @return the user with the same EMAIL ass passed in parameter
     */
    Optional<UserModel> findByEmail(String email);

    /**
     * This method is searching the {@link UserModel} with passed username or EMAIL in database
     *
     * @param username this parameter is username to identify the user in database
     * @param email    this parameter is username to identify the user in database
     * @return the user with the same username ass passed in parameter
     */
    Optional<UserModel> findByUsernameOrEmail(String username, String email);

    /**
     * This method is returning all users from database with specify {@link UserRole} in parameter
     *
     * @param userRole this is the role which help to specify what users we are want to return
     * @return the List of {@link UserModel } with the same role ass passed in parameter
     */
    List<UserModel> getAllByRole(UserRole userRole);

    @Query(value = "SELECT USER_MODEL.USERNAME FROM USER_MODEL", nativeQuery = true)
    Optional<List<String>> findAllUserNames();

    @Query(value = "SELECT USER_MODEL.USERNAME FROM USER_MODEL WHERE USER_MODEL.ROLE = 'USER' AND USER_MODEL.ISLOCKED = FALSE", nativeQuery = true)
    Optional<List<String>> findAllUserNamesByRole();
}
