package com.example.scrollhidesticky.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PeopleRepo {

    public static List<Person> getPeople() {
        List<Person> people = new ArrayList<>(45);
        people.add(new Person("George", "Washington"));
        people.add(new Person("John", "Adams"));
        people.add(new Person("Thomas", "Jefferson"));
        people.add(new Person("James", "Madison"));
        people.add(new Person("James", "Monroe"));
        people.add(new Person("John Quincy", "Adams"));
        people.add(new Person("Andrew", "Jackson"));
        people.add(new Person("Martin", "Van Buren"));
        people.add(new Person("William", "Harrison"));
        people.add(new Person("John", "Tyler"));
        people.add(new Person("Zachary", "Taylor"));
        people.add(new Person("Millard", "Fillmore"));
        people.add(new Person("Franklin", "Pierce"));
        people.add(new Person("James", "Buchanan"));
        people.add(new Person("Abraham", "Lincoln"));
        people.add(new Person("Andrew", "Johnson"));
        people.add(new Person("Ulysses", "Grant"));
        people.add(new Person("Rutherford", "Hayes"));
        people.add(new Person("James", "Garfield"));
        people.add(new Person("Chester", "Arthur"));
        people.add(new Person("Grover", "Cleveland"));
        people.add(new Person("Benjamin", "Harrison"));
        people.add(new Person("William", "McKinley"));
        people.add(new Person("Theodore", "Roosevelt"));
        people.add(new Person("William", "Taft"));
        people.add(new Person("Woodrow", "Wilson"));
        people.add(new Person("Warren", "Harding"));
        people.add(new Person("Calvin", "Coolidge"));
        people.add(new Person("Herbert", "Hoover"));
        people.add(new Person("Harry", "Truman"));
        people.add(new Person("Dwight", "Eisenhower"));
        people.add(new Person("John", "Kennedy"));
        people.add(new Person("Lyndon", "Johnson"));
        people.add(new Person("Richard", "Nixon"));
        people.add(new Person("Gerald", "Ford"));
        people.add(new Person("Jimmy", "Carter"));
        people.add(new Person("Ronald", "Reagan"));
        people.add(new Person("George H.W.", "Bush"));
        people.add(new Person("Bill", "Clinton"));
        people.add(new Person("George W.", "Bush"));
        people.add(new Person("Barack", "Obama"));
        people.add(new Person("Donald", "Trump"));
        return people;
    }

    public static List<Person> getPeopleSorted() {
        List<Person> people = getPeople();
        Collections.sort(people);
        return people;
    }
}
