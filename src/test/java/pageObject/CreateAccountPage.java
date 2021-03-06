package pageObject;

import elementMapper.CreateAccountElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Browser;

public class CreateAccountPage extends CreateAccountElementMapper {

    public CreateAccountPage() {
        PageFactory.initElements(Browser.getCurrentDriver(),this);
    }

    @Step("Preenche o email para registro")
    public void fillEmailToCreateAccount(){
        email_create.sendKeys("alextestecwi@gmail.com");
    }

    @Step("Clica no botão create account")
    public void clickSubmitCreateBtn(){
        SubmitCreate.click();
    }

    @Step("Seleciona o genero Mr ou Mrs")
    public void clickIdGender(){
        id_gender1.click();
    }

    @Step("Preenche o campo primeiro nome")
    public void fillCustomerFirstname(){
        customer_firstname.sendKeys("Alexandro");
    }

    @Step("Preenche o campo último nome")
    public void fillCustomerLastname(){
        customer_lastname.sendKeys("CwiTester");
    }

    @Step("Preenche a senha")
    public void fillPasswd(){
        passwd.sendKeys("123456");
    }

    @Step("Preenche o endereço")
    public  void fillAddressField(){
        address1.sendKeys("Manorglen 12");
    }

    public void fillAddressComplement(){
        address2.sendKeys("Apartment 01");
    }

    @Step("Preenche o nome da cidade")
    public void fillCityName(){
        city.sendKeys("Saint Leopold");
    }

    //Criando um objeto do tipo Select para selecionar
    //Dentro do combobox o estado desejado
    @Step("Seleciona o Estado")
    public void selectStateName(){
        Select select = new Select(id_state);
        select.selectByVisibleText("California");
    }

    @Step("Preenche o cep")
    public void fillZipCode(){
        postcode.sendKeys("90224");
    }

    @Step("Preenche o numero de celular")
    public void fillMobilePhoneField(){
        phone_mobile.sendKeys("992345678");
    }

    @Step("Clica para enviar os dados e criar a conta")
    public void clickSubmitAccountBtn(){
        submitAccount.click();
    }

    // Retorna o texto do Heading da pagina de criação de conta
    public String getTextPageHeading(){
        return pageHeading.getText();
    }

    //Retorna o texto do Subheading da pagina
    public String getTextPageSubHeading(){
        return pageSubHeading.getText();
    }

    //Função que valida se estamos na pagina de ciração de conta
    public boolean isCreateAccountPage(){
        return getTextPageHeading().contains("CREATE AN ACCOUNT");
    }

    // Retorna o texto do Heading da pagina da conta MY ACCOUNT
    public String getCreateAccountPageHeadingName(){
        return accountPageHeadingName.getText();
    }

    // Retorna o texto do info da pagina da conta Welcome to your account
    public String getCreateAccountInfoAccount(){
        return accountInfoAccount.getText();
    }

    //Função que valida se estamos na pagina da conta MY ACCOUNT
    public boolean isAccountPage(){
        return getCreateAccountPageHeadingName().contains("MY ACCOUNT");
    }

    //Função que valida se estamos na pagina da conta verificando se no campo de info contém Welcome to your account
    public boolean isMyAccountInfo(){
        return getCreateAccountInfoAccount().contains("Welcome to your account");
    }

    //Método de criação de conta
    //Aqui reune todas as funcões que a criação de conta necessita
    //Nos garante um codigo mais limpo sem a necessidade de chamar as funções individualmente
    //no teste principal
    public void createAccount(){

        clickIdGender();
        fillCustomerFirstname();
        fillCustomerLastname();
        fillPasswd();
        fillAddressField();
        fillAddressComplement();
        fillCityName();
        selectStateName();
        fillZipCode();
        fillMobilePhoneField();
        clickSubmitAccountBtn();

    }


}
