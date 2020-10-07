package models;

import java.util.Vector;

public class OpenWorkspacesModel extends AbstractSubject
{
	private java.util.List<WorkspaceModel> openWorkspaceModels = null;
	
	public OpenWorkspacesModel()
	{
		openWorkspaceModels = new Vector<WorkspaceModel>();
	}

	public java.util.List<WorkspaceModel> getOpenWorkspaceModels() {
	      if (openWorkspaceModels == null)
	         openWorkspaceModels = new java.util.ArrayList<WorkspaceModel>();
	      return openWorkspaceModels;
	   }
	   
	   /** @pdGenerated default iterator getter */
	   public java.util.Iterator<WorkspaceModel> getIteratorOpenWorkspaceModels() {
	      if (openWorkspaceModels == null)
	         openWorkspaceModels = new java.util.ArrayList<WorkspaceModel>();
	      return openWorkspaceModels.iterator();
	   }
	   
	   /** @pdGenerated default setter
	     * @param newOpenWorkspaceModels */
	   public void setOpenWorkspaceModels(java.util.List<WorkspaceModel> newOpenWorkspaceModels) {
	      removeAllOpenWorkspaceModels();
	      for (java.util.Iterator<WorkspaceModel> iter = newOpenWorkspaceModels.iterator(); iter.hasNext();)
	         addOpenWorkspaceModels((WorkspaceModel)iter.next());
	      notifySubscribers();
	   }
	   
	   
	   
	   /** @pdGenerated default add
	     * @param newWorkspaceModel */
	   public void addOpenWorkspaceModels(WorkspaceModel newWorkspaceModel) {
	      if (newWorkspaceModel == null)
	         return;
	      if (this.openWorkspaceModels == null)
	         this.openWorkspaceModels = new java.util.ArrayList<WorkspaceModel>();
	      if (!this.openWorkspaceModels.contains(newWorkspaceModel))
	      {
	    	 newWorkspaceModel.setIsOpen(true);
	         this.openWorkspaceModels.add(newWorkspaceModel);
	         notifySubscribers();
	      }
	   }
	   
	   /** @pdGenerated default remove
	     * @param oldWorkspaceModel */
	   public void removeOpenWorkspaceModels(WorkspaceModel oldWorkspaceModel) {
	      if (oldWorkspaceModel == null)
	         return;
	      if (this.openWorkspaceModels != null)
	         if (this.openWorkspaceModels.contains(oldWorkspaceModel))
	         {
	            this.openWorkspaceModels.remove(oldWorkspaceModel);
	            notifySubscribers();
	         }
	   }
	   
	   /** @pdGenerated default removeAll */
	   public void removeAllOpenWorkspaceModels() {
	      if (openWorkspaceModels != null)
	      {
	         openWorkspaceModels.clear();
	         notifySubscribers();
	      }
	   }
	   
	   public WorkspaceModel getWorkspaceModelAt(int index)
	   {
		   return openWorkspaceModels.get(index);
	   }
	   public WorkspaceModel getSelectedModel()
	   {
		   WorkspaceModel model = null;
		   for(WorkspaceModel m : openWorkspaceModels)
		   {
			   if(m.getIsSelected())
			   {
				   model = m;
			   }
		   }
		   return model;
	   }
	   
	   public WorkspaceModel getWorkspace(String workspaceName)
	   {
		   for(WorkspaceModel model : openWorkspaceModels)
		   {
			   if(workspaceName.equals(model.getName()))
				  return model;
		   }
		   return null;
	   }
	
}
