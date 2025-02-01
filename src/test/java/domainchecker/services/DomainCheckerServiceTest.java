package domainchecker.services;

import com.tecnologiadevalor.domainchecker.services.DomainCheckerService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class DomainCheckerServiceTest {

    private final DomainCheckerService service = new DomainCheckerService();

    @Test
    public void isAvailableDomainTest() throws IOException, InterruptedException {

        String domain1 = "tecnologiadevalor.com";
        String domain2 = "domainchecker.com";

        boolean isAvaliableDomain1 = service.isAvailableDomain(domain1);
        boolean isAvaliableDomain2 = service.isAvailableDomain(domain2);

        assertFalse(isAvaliableDomain1);
        assertFalse(isAvaliableDomain2);
    }

    @Test
    public void isAvaileDomainTest_Exception() throws IOException, InterruptedException {
        String domain = "fakegooglebrazilbitcoin .com";

        assertThrowsExactly(IllegalArgumentException.class,
                () -> service.isAvailableDomain(domain));
    }

    
}