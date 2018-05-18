package com.sleepnumber.app.converter;


import com.sleepnumber.app.model.Person;
import com.sleepnumber.app.model.PersonTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
/**
 * Instructions:
 *  Complete {@link #generateTree(Iterable)} method such that the unit test will run and pass.
 *  Create any additional methods as needed.
 */
public class PersonToPersonTreeNodeConverter {

    /**
     * Given an iterable of {@link Person}s, should produce the root person tree node (the CEO)
     * and each person's list of direct reports is correct all the way down the tree.
     */
   public PersonTreeNode generateTree(Iterable<Person> allEmployees) {
        PersonTreeNode treeNodeResult = new PersonTreeNode();
        List<PersonTreeNode> directReports = new ArrayList<PersonTreeNode>();
        ArrayList<Person> tempList = new ArrayList<Person>();
        allEmployees.forEach(tempList::add);
        for (Iterator<Person> i = allEmployees.iterator(); i.hasNext();) {
            Person item = i.next();
            Person manager = item.getManager();
           if(manager==null){
               treeNodeResult.setPerson(item);
               tempList.remove(item);
               treeNodeResult.setDirectReports(getDirectReportee(tempList, item));
           }
        }
        return treeNodeResult;
    }

    public List<PersonTreeNode> getDirectReportee(Iterable<Person> reminingEmployees, Person manager) {
        ArrayList<Person> tempListReport = new ArrayList<Person>();
        reminingEmployees.forEach(tempListReport::add);
        List<PersonTreeNode> directReports = new ArrayList<PersonTreeNode>();
        for (Iterator<Person> i = reminingEmployees.iterator(); i.hasNext(); ) {
            Person item = i.next();
            if (manager.equals(item.getManager())) {
                PersonTreeNode treeNode = new PersonTreeNode();
                treeNode.setPerson(item);
                ((ArrayList) tempListReport).remove(item);
                treeNode.setDirectReports(getDirectReportee(tempListReport, item));
                directReports.add(treeNode);
            }
        }
        return directReports;
    }
    
}