import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class BankAccountTest {

    var bankAccount = BankAccount("Maksim", "Ponyavin", BigDecimal(500))

    @Test
    fun deposit() {
        var balance = bankAccount.deposit(BigDecimal(200))
        Assertions.assertEquals(balance, BigDecimal(700))

    }

    @org.junit.jupiter.api.Test
    fun withdraw() {
        var balance = bankAccount.withdraw(BigDecimal(-200))
        Assertions.assertEquals(balance, BigDecimal(300))
    }
}