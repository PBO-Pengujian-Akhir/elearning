
package model;

public abstract class User {
    private final String idUser;
    private final String name;
    private final String password;
    private final String role;

    public User(String idUser, String name, String password, String role){
        this.idUser = idUser;
        this.name = name;
        this.password = password;
        this.role = role;
    }


    public abstract String getRole();
}
