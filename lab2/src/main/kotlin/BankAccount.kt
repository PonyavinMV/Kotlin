import java.math.BigDecimal
import java.time.temporal.TemporalAmount

class BankAccount(val firstname : String, val lastname: String, private val balance : BigDecimal) {

    fun deposit(amount: BigDecimal) : BigDecimal = balance.add(amount)

    fun withdraw(amount: BigDecimal) : BigDecimal = balance.add(amount)
}