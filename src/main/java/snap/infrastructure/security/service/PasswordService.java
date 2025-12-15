package snap.infrastructure.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import snap.member.entity.Member;

@Service
@RequiredArgsConstructor
public class PasswordService {
    private final PasswordEncoder passwordEncoder;

    public Boolean verifyPassword(Member member, String password) {
        return passwordEncoder.matches(password, member.getPassword());
    }
}
