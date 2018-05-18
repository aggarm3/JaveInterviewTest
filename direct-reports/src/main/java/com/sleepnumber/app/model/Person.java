package com.sleepnumber.app.model;

/**
 * Object to represent a person working at a company.
 * It consists of a name and a manager (also of type {@link Person}).
 * A null manager represents the CEO/president (top of the organization).
 */
public class Person {

    private String name;
    private Person manager;

    public Person(String name, Person manager) {
        this.name = name;
        this.manager = manager;
    }
    
    /**
     * Returns the name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the {@link Person} representing this person's manager.
     * Returns null when this person has no manager (ie top of the organization).
     */
    public Person getManager() {
        return manager;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((manager == null) ? 0 : manager.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (manager == null) {
            if (other.manager != null)
                return false;
        } else if (!manager.equals(other.manager))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}