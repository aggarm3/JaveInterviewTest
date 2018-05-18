package com.sleepnumber.app.model;

import java.util.List;

/**
 * Object representing a tree node of a person.
 * Contains the {@link Person} and a List of {@link PersonTreeNode}'s
 * that represents everyone who reports directly to this person.
 */
public class PersonTreeNode {
    
    private Person person;
    private List<PersonTreeNode> directReports; // never null, but may be empty
    
    /**
     * Returns the person for this tree node.
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Returns all {@link PersonTreeNode}'s having this person as manager.
     * @return the list of persons tree nodes who directly report to this person.
     */
    public List<PersonTreeNode> getDirectReports() {
        return directReports;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    public void setDirectReports(List<PersonTreeNode> directReports) {
        this.directReports = directReports;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((directReports == null) ? 0 : directReports.hashCode());
        result = prime * result + ((person == null) ? 0 : person.hashCode());
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
        PersonTreeNode other = (PersonTreeNode) obj;
        if (directReports == null) {
            if (other.directReports != null)
                return false;
        } else if (!directReports.equals(other.directReports))
            return false;
        if (person == null) {
            if (other.person != null)
                return false;
        } else if (!person.equals(other.person))
            return false;
        return true;
    }
}