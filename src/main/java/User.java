public class User {
    String id;
    String password;
    int age;
    String name;

    public User(String id, String password, int age, String name) {
        this.id = id;
        this.password = password;
        this.age = age;
        this.name = name;
    }


    public boolean matchId(String newId) {
        if (newId == null) {
            return false;
        }
        return newId.equals(id);
    }

    public boolean matchPassword(String newPassword) {
        if (newPassword == null) {
            return false;
        }

        return newPassword.equals(password);
    }

    public void update() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
