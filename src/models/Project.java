/***********************************************************************
 * Module:  Project.java
 * Author:  User
 * Purpose: Defines the Class Project
 ***********************************************************************/

package models;

import java.util.*;

public class Project {
   private String name;
   private Boolean selected;
   
   private java.util.List<WorkspaceModel> algorithms = null;
   
   public Project() {
	   
   }
   
   /** @param name */
   public Project(String name) {
      this.name = name;
      algorithms = new Vector<WorkspaceModel>();
   }
   
   public String getName() {
      return name;
   }
   
   /** @param newName */
   public void setName(String newName) {
      name = newName;
   }
   
   public Boolean isSelected() 
   {   
      if(selected)
    	  return true;
      
      return false;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<WorkspaceModel> getAlgorithms() {
      if (algorithms == null)
         algorithms = new java.util.Vector<WorkspaceModel>();
      return algorithms;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator<WorkspaceModel> getIteratorAlgorithms() {
      if (algorithms == null)
         algorithms = new java.util.Vector<WorkspaceModel>();
      return algorithms.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAlgorithms */
   public void setAlgorithms(java.util.List<WorkspaceModel> newAlgorithms) {
      removeAllAlgorithms();
      for (java.util.Iterator<WorkspaceModel> iter = newAlgorithms.iterator(); iter.hasNext();)
         addAlgorithms((WorkspaceModel)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newElementModel */
   public void addAlgorithms(WorkspaceModel newWorkspaceModel) {
      if (newWorkspaceModel == null)
         return;
      if (this.algorithms == null)
         this.algorithms = new java.util.Vector<WorkspaceModel>();
      if (!this.algorithms.contains(newWorkspaceModel))
         this.algorithms.add(newWorkspaceModel);
   }
   
   /** @pdGenerated default remove
     * @param oldElementModel */
   public void removeAlgorithms(WorkspaceModel oldWorkspaceModel) {
      if (oldWorkspaceModel == null)
         return;
      if (this.algorithms != null)
         if (this.algorithms.contains(oldWorkspaceModel))
            this.algorithms.remove(oldWorkspaceModel);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAlgorithms() {
      if (algorithms != null)
         algorithms.clear();
   }
   
   public Boolean algorithmExists(String algorithmName)
   {
	   Boolean algorithmExists = false;
	   
	   for(WorkspaceModel algorithm : algorithms)
	   {
		   if(algorithmName.equals(algorithm.getName()))
			   algorithmExists = true;
	   }
	   return algorithmExists;
   }
   public WorkspaceModel getAgorithm(String algorithmName)
   {
	   for(WorkspaceModel algorithm : algorithms)
	   {
		   if(algorithmName.equals(algorithm.getName()))
			  return algorithm;
	   }
	   return null;
   }
   
   public Boolean algorithmExists(WorkspaceModel algorithm)
   {
	   Boolean algorithmExists = false;
	   
	   for(WorkspaceModel a : algorithms)
	   {
		   if(a.equals(algorithm.getName()))
			   algorithmExists = true;
	   }
	   return algorithmExists;
   }
   public WorkspaceModel getLastAlgorithm()
   {
	   if(algorithms.size() > 0)
		   return algorithms.get(algorithms.size()-1);
	   return null;
   }

}