package com.google.gridworks.commands.project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gridworks.ProjectManager;
import com.google.gridworks.commands.Command;

public class DeleteProjectCommand extends Command {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            long projectID = Long.parseLong(request.getParameter("project"));
            
            ProjectManager.singleton.deleteProject(projectID);
            
            respond(response, "{ \"code\" : \"ok\" }");
            
        } catch (Exception e) {
            respondException(response, e);
        }
    }
}