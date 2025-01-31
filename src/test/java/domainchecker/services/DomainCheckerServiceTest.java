package domainchecker.services;

import com.tecnologiadevalor.domainchecker.services.DomainCheckerService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DomainCheckerServiceTest {

    private final DomainCheckerService service = new DomainCheckerService();

    @Test
    public void isAvailableDomainTest() {

        String domain1  = "tecnologiadevalor.com";
        String domain2 = "domainchecker.com";
        String domain3 = "fakegooglebrazilbitcoin.com";

        boolean isAvaliableDomain1 = service.isAvailableDomain(domain1);
        boolean isAvaliableDomain2 = service.isAvailableDomain(domain2);
        boolean isAvaliableDomain3 = service.isAvailableDomain(domain3);

        assertFalse(isAvaliableDomain1);
        assertFalse(isAvaliableDomain2);
        assertTrue(isAvaliableDomain3);
    }
}