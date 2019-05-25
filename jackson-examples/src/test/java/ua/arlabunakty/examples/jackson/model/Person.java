package ua.arlabunakty.examples.jackson.model;

import java.util.Objects;
import java.util.Set;

public class Person {
    private String firstName;
    private String lastName;
    private Long ssn;
    private int age;
    private Address address;
    private Set<String> skills;
    private Set<String> languages;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getSsn() {
        return ssn;
    }

    public void setSsn(Long ssn) {
        this.ssn = ssn;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public Set<String> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<String> languages) {
        this.languages = languages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                Objects.equals(getFirstName(), person.getFirstName()) &&
                Objects.equals(getLastName(), person.getLastName()) &&
                Objects.equals(getSsn(), person.getSsn()) &&
                Objects.equals(getAddress(), person.getAddress()) &&
                Objects.equals(getSkills(), person.getSkills()) &&
                Objects.equals(getLanguages(), person.getLanguages());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getSsn(), getAge(), getAddress(), getSkills(), getLanguages());
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ssn=" + ssn +
                ", age=" + age +
                ", address=" + address +
                ", skills=" + skills +
                ", languages=" + languages +
                '}';
    }
}
