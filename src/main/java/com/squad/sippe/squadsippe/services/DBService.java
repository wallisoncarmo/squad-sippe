package com.squad.sippe.squadsippe.services;

import java.text.ParseException;

import com.squad.sippe.squadsippe.domain.User;
import com.squad.sippe.squadsippe.domain.enums.Profile;
import com.squad.sippe.squadsippe.repositoties.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bc;

    public void instantieateTestDatabase() throws ParseException {

        // CONFIG
        SimpleDateFormat sdfDateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm");

        // BLOCO USUARIOS
        System.out.println("Adiciona usuarios");
        User admin = new User(null, "Administrador", "admin@gmail.com", true, bc.encode("123"));
        admin.addProfile(Profile.ADMIN);
        userRepository.saveAll(Arrays.asList(admin));
        System.out.println("=============================");

    }
}
