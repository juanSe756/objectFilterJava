package co.edu.uptc.component;

public class Person {
    private String name;
    private String lastname;
    private String gender;
    private int age;

    public Person(String name, String lastname, String gender, int age) {
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name:" + name +
        ", lastname:" + lastname +
        ", gender:" + gender + ", age:" + age;
    }

}
