package com.example.watermyplants;

import com.example.watermyplants.models.Plant;
import com.example.watermyplants.models.Role;
import com.example.watermyplants.models.User;
import com.example.watermyplants.models.UserRoles;
import com.example.watermyplants.repositories.PlantRepository;
import com.example.watermyplants.repositories.RoleRepository;
import com.example.watermyplants.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner {

    UserRepository userRepository;
    RoleRepository roleRepository;
    PlantRepository plantRepository;


    public SeedData(UserRepository userRepository, RoleRepository roleRepository, PlantRepository plantRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.plantRepository = plantRepository;
    }


    @Override
    public void run(String[] args) throws Exception {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        roleRepository.save(r1);
        roleRepository.save(r2);
        roleRepository.save(r3);

        // admin, data, user
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        admins.add(new UserRoles(new User(), r3));
        User u1 = new User("admin", "password", "222-333-4444", admins);
        u1.getPlants().add(new Plant("sunflower", "sunny", "28-08-2019 11:30:00", "Front Porch", u1));
        u1.getPlants().add(new Plant("Rubber Fig", "pokemon", "28-08-2019 9:00:00", "Family Room", u1));
        userRepository.save(u1);

        // data, user
        ArrayList<UserRoles> datas = new ArrayList<>();
        datas.add(new UserRoles(new User(), r3));
        datas.add(new UserRoles(new User(), r2));
        User u2 = new User("cinnamon", "1234567", "919-333-4444", datas);
        userRepository.save(u2);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("barnbarn", "ILuvM4th!", "415-555-1212", users);
        u3.getPlants().add(new Plant("sunflower", "sunny", "28-08-2019 11:30:00", "Front Porch", u3));
        u3.getPlants().add(new Plant("Spider plant", "Charlotte", "28-08-2019 8:30:00", "Bedroom", u3));
        u3.getPlants().add(new Plant("Sword Fern", "JonSnow", "28-08-2019 10:30:00", "Back Deck", u3));
        u3.getPlants().add(new Plant("Rubber Fig", "pokemon", "28-08-2019 9:00:00", "Family Room", u3));

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("Bob", "password", "310-333-1234", users);
        u4.getPlants().add(new Plant("Devil's Ivy", "BadBoy", "28-08-2019 15:00:00", "Family Room", u4));
        u4.getPlants().add(new Plant("Aloe Vera", "Doc", "28-08-2019 9:00:00", "Kitchen", u4));
        userRepository.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u5 = new User("Jane", "password", "123-456-7890", users);
        userRepository.save(u5);
    }
}