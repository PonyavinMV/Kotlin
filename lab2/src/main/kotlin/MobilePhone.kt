class MobilePhone(var phonenumber: Long, var contactlist : MutableList<Contact> = mutableListOf<Contact>()){

    fun addNewContact(NewPhoneContact: Contact = Contact("name", 8005553535)){
        contactlist.add(NewPhoneContact)
    }

    fun updateContact(OldUpdatePhoneContact: Contact = Contact("name",8005553535 ),
                      NewPhoneContact : Contact = Contact("name", 8005553535) ): Int {
        var objNomer = 0
        var ansCode = -1
        for (contacts in contactlist){
            if ((contacts == (OldUpdatePhoneContact)) && (objNomer == 0)){
                contacts.title = NewPhoneContact.title
                contacts.phoneNumber = NewPhoneContact.phoneNumber
                objNomer = 0
                ansCode = 1
            }
        }
        return ansCode
    }

    fun removeContact(RemovedContact : Contact = Contact("name", 8005553535)) : Int{
        if (contactlist.contains(RemovedContact)){
            println("Контакт успешно удален " + contactlist.remove(RemovedContact))
            return 0
        }
        else{
            println("Контакт не удален " + contactlist.remove(RemovedContact))
            return -1
        }
    }

    fun findContact(PhoneContact: Contact = Contact("name", 8005553535)): Int {
        if (contactlist.contains(PhoneContact)){
            return contactlist.indexOf(PhoneContact)
        }
        else {
            return -1
        }
    }

    fun queryContact(findquery : String): String {
        var question = "null"
        for (item in contactlist){
            if (findquery == item.title && question == "null" ){
                question = item.toString()
            }
        }
        return question
    }
}