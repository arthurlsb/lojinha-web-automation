package modules.products;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import java.time.Duration;

@DisplayName("Products Web tests")
public class ProductsTest {

    private WebDriver browser;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver96\\chromedriver.exe");
        this.browser = new ChromeDriver();
        this.browser.manage().window().maximize();
        this.browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.browser.get("http://165.227.93.41/lojinha-web/v2/");
    }

    @Test
    @DisplayName("it is not allowed to register product with value equal to R$ 0")
    public void testIsNotAllowedRegisterProductWithValueEqualZero() {
        String displayedMessage = new LoginPage(this.browser)
                .informUser("admin")
                .informPassword("admin")
                .submitLoginForm()
                .openProductForm()
                .informProductName("XBOX")
                .informProductValue("000")
                .informProductColors("Preto, Branco")
                .submitProductFormWithError()
                .getErrorMessage();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", displayedMessage);
    }
    @Test
    @DisplayName("it is not allowed to register product with value greather than R$ 7000")
    public void testIsNotAllowedRegisterProductWithValueGreatherThan7000() {
        String displayedMessage = new LoginPage(this.browser)
                .informUser("admin")
                .informPassword("admin")
                .submitLoginForm()
                .openProductForm()
                .informProductName("XBOX")
                .informProductValue("700100")
                .informProductColors("Preto, Branco")
                .submitProductFormWithError()
                .getErrorMessage();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", displayedMessage);
    }

    @Test
    @DisplayName("it is allowed to add product that the value is between R$ 0.01 and R$ 7000")
    public void testIsPossibleToAddProductThatValueIsBetween001And700() {
        String displayedMessage = new LoginPage(this.browser)
                .informUser("admin")
                .informPassword("admin")
                .submitLoginForm()
                .openProductForm()
                .informProductName("XBOX")
                .informProductValue("700")
                .informProductColors("Preto, Branco")
                .submitProductForm()
                .getSucessMessage();

        Assertions.assertEquals("Produto adicionado com sucesso", displayedMessage);
    }

    @Test
    @DisplayName("it is allowed to register product with value equal to R$ 7000")
    public void testIsAllowedRegisterProductWithValueEqual70000() {
        String displayedMessage = new LoginPage(this.browser)
                .informUser("admin")
                .informPassword("admin")
                .submitLoginForm()
                .openProductForm()
                .informProductName("XBOX")
                .informProductValue("700000")
                .informProductColors("Preto, Branco")
                .submitProductFormWithError()
                .getErrorMessage();

        Assertions.assertEquals("Produto adicionado com sucesso", displayedMessage);
    }

    @AfterEach
    public void afterEach() {
        this.browser.quit();
    }

}
