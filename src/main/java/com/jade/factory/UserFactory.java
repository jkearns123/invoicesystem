package com.jade.factory;

        import com.jade.domain.*;
        import com.jade.domain.User;
        import com.jade.util.Miscellaneous;

public class UserFactory {
    public static User getUser(Name name,Contact contact, Email email) {
        return new User.Builder().name(name).contact(contact).email(email)
                .userId(Miscellaneous.generateRandomId())
                .build();
    }
}
