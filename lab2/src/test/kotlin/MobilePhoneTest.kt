import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class MobilePhoneTest {

    val phonenumber : MobilePhone = MobilePhone(89232312145)

    @Test
    fun addNewContact() {
        var testphonenumber = Contact("Андрей", 89235424902)
        phonenumber.addNewContact(testphonenumber)
        assertTrue(phonenumber.contactlist.component1().equals(testphonenumber))
    }

    @Test
    fun updateContact() {
        var testphonenumber = Contact("Андрей", 89235424902)
        var testupdatephonenubmer2 = Contact("Стас", 89038922135)
        phonenumber.addNewContact(testphonenumber)
        phonenumber.updateContact(testphonenumber, testupdatephonenubmer2)
        assertTrue(phonenumber.contactlist.component1().equals(testupdatephonenubmer2))
    }

    @Test
    fun removeContact() {
        var testphonenumber = Contact("Андрей", 89235424902)
        var testupdatephonenubmer2 = Contact("Стас", 89038922135)
        phonenumber.addNewContact(testphonenumber)
        phonenumber.addNewContact(testupdatephonenubmer2)
        phonenumber.removeContact(testphonenumber)
        assertTrue(phonenumber.contactlist.component1().equals(testupdatephonenubmer2))
    }

    @Test
    fun findContact() {
        var testphonenumber = Contact("Андрей", 89235424902)
        var testupdatephonenubmer2 = Contact("Стас", 89038922135)
        phonenumber.addNewContact(testphonenumber)
        phonenumber.addNewContact(testupdatephonenubmer2)
        phonenumber.findContact(testphonenumber)
        assertTrue(phonenumber.contactlist.component1().equals(testphonenumber))
    }
}