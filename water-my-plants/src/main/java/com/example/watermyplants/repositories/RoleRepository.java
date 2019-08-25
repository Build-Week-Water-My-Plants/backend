package com.example.watermyplants.repositories;

import com.example.watermyplants.models.Role;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


public interface RoleRepository extends CrudRepository<Role, Long>
{
    @Transactional
    @Modifying
    @Query(value = "DELETE from UserRoles where userid = :userid")
    void deleteUserRolesByUserId(long userid);

    @Transactional
    @Modifying
    @Query(value = "INSERT into UserRoles(userid, roleid) values (:userid, :roleid)")

    default void insertUserRoles(long userid, long roleid) {
    }

    Role findByNameIgnoreCase(String name);
}