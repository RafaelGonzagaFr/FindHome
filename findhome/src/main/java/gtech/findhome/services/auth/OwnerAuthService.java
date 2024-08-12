package gtech.findhome.services.auth;

import gtech.findhome.domain.DTOs.LoginRequestDTO;
import gtech.findhome.domain.entities.Owner;
import gtech.findhome.domain.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class OwnerAuthService {
    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public OwnerAuthService(OwnerRepository ownerRepository, BCryptPasswordEncoder passwordEncoder){
        this.ownerRepository = ownerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String login(LoginRequestDTO loginRequest) {
        Owner owner = ownerRepository.findByLogin(loginRequest.login())
                .orElseThrow(() -> new RuntimeException("Nenhum proprietário encontrado"));
        if (passwordEncoder.matches(loginRequest.password(), owner.getPassword())) {
            //Gerar e retornar um token JWT ou outra forma de autenticação
            return "token";
        } else {
            throw new RuntimeException("Senha inválida");
        }


    }
}
