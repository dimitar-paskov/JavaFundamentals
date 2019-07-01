package bankAccount;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BankAccountTest {

    private final BigDecimal DEFAULT_VALUE = new BigDecimal(1000);
    private final BigDecimal DEFAULT_NEGATIVE_VALUE = new BigDecimal(-0.1);
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS BankAccount

    private BankAccount bankAccount;

    @Before
    public void createBankAccount(){
        this.bankAccount = new BankAccount("Mitko", new BigDecimal(1000));
    }

    @Test
    public void getNameShouldReturnCorrectResult(){
        Assert.assertEquals("Mitko", bankAccount.getName());
    }

    @Test
    public void getBalanceShouldReturnCorrectResult(){

        Assert.assertEquals(DEFAULT_VALUE, this.bankAccount.getBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nameLessThanThreeShouldThrow(){
        this.bankAccount = new BankAccount("ad", DEFAULT_VALUE );
    }

    @Test(expected = IllegalArgumentException.class)
    public void nameMoreThan25ShouldThrow(){
        this.bankAccount = new BankAccount("123456789123465789123465789", DEFAULT_VALUE );
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBalanceToNegativeShouldThrow(){
        this.bankAccount = new BankAccount("adasd", DEFAULT_NEGATIVE_VALUE );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void depositeNegativeShouldThrow(){
        this.bankAccount.deposit(DEFAULT_NEGATIVE_VALUE);
    }

    @Test
    public void depositShouldReturnCorrectResult(){
        this.bankAccount.deposit(DEFAULT_VALUE);
        Assert.assertEquals(DEFAULT_VALUE.add(DEFAULT_VALUE), this.bankAccount.getBalance());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void withdrawNegativeShouldThrow(){
        this.bankAccount.withdraw(DEFAULT_NEGATIVE_VALUE);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void withdrawMoreThanAvailableShouldThrow(){
        this.bankAccount.withdraw(DEFAULT_VALUE.add(BigDecimal.ONE));
    }

    @Test
    public void withdrawShouldWorkCorrect(){
        this.bankAccount.withdraw(BigDecimal.ONE);
        Assert.assertEquals(DEFAULT_VALUE.subtract(BigDecimal.ONE), this.bankAccount.getBalance());
    }

    @Test
    public void withdrawShouldReturnCorrectResult(){
        BigDecimal returnedValue = this.bankAccount.withdraw(BigDecimal.ONE);
        Assert.assertEquals(BigDecimal.ONE, returnedValue);
    }


}