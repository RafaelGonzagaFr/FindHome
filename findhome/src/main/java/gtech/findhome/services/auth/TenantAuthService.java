package gtech.findhome.services.auth;

import gtech.findhome.domain.DTOs.LoginRequestDTO;
import gtech.findhome.domain.entities.Tenant;
import gtech.findhome.domain.repositories.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TenantAuthService {
    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public TenantAuthService(TenantRepository tenantRepository, BCryptPasswordEncoder passwordEncoder){
        this.tenantRepository = tenantRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String login(LoginRequestDTO loginRequest) {
        Tenant tenant = tenantRepository.findByLogin(loginRequest.login())
                .orElseThrow(() -> new RuntimeException("Nenhum inquilino encontrado"));
        if (passwordEncoder.matches(loginRequest.password(), tenant.getPassword())) {
            //Gerar e retornar um token JWT ou outra forma de autenticação
            return "token";
        } else {
            throw new RuntimeException("Senha inválida");
        }
    }
}
