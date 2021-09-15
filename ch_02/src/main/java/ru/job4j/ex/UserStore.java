package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws USerNotFoundException {
        for (int index = 0; index < users.length; index++) {
            if (users[index].getUsername().equals(login)) {
                return users[index];
            }
        }
        throw new USerNotFoundException("we did not find USer");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is not valid");
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        User[] users = {new User("Petr Arsentev", true)};
        User user = null;
        try {
            user = findUser(users, "Petr Arsentev");

            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException en) {
            en.printStackTrace();
        } catch (USerNotFoundException ea) {
            ea.printStackTrace();
        }
    }
}
