package snap.infrastructure.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;

    @Value("${mail.from-address}")
    private String fromAddress;

    public void mailSendZipFile(MailDto dto) {
        String title = "[SnapSpot] " + dto.getToName() + "님, 촬영번호 " + dto.getPlanId().toString() +"의 사진을 보내드려요.";
        try {
            MailHandler mailHandler = new MailHandler(mailSender);
            mailHandler.setFrom(fromAddress);
            mailHandler.setTo(dto.getToEmail());
            mailHandler.setFile(dto.getFile());
            mailHandler.setTitle(title);
            mailHandler.setContext("<p>" + dto.getMessage()  +"<p>", true);
            mailHandler.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
