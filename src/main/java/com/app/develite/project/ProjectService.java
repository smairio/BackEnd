package com.app.develite.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    
    @Autowired
    ProjectRepository projectRepository;



    //get all Projects
    public List<Project> getProjects(){
        return projectRepository.findAll();
    }

    //get project
    public Project getProjectByid(Long id){
        return projectRepository.findById(id).get();
    }

    //add project
    public Project addProjet(Project project){
        return projectRepository.save(project);
    }

    //delete Project
    public boolean deleteProject(Long id){
        if(projectRepository.existsById(id)){
            projectRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }    
    }


    //update Project 
    public Project updateProject(Long id , Project projectDetails){
        Project project = getProjectByid(id);

            if(project.getTitle() != projectDetails.getTitle()){
                project.setTitle(projectDetails.getTitle());
            }
            
            if(project.getClient() != projectDetails.getClient()){
                project.setClient(projectDetails.getClient());
            }

            if(project.getService() != projectDetails.getService()){
                project.setService(projectDetails.getService());
            }

            if(project.getDescription() != projectDetails.getDescription()){
                project.setDescription(projectDetails.getDescription());
            }

            if(project.getWebsite() != projectDetails.getWebsite()){
                project.setWebsite(projectDetails.getWebsite());
            }

            if( project.getStatus() != projectDetails.getStatus()){
                project.setStatus(projectDetails.getStatus());
            }

            if (project.getSubmit_date() != projectDetails.getSubmit_date()){
                project.setSubmit_date(projectDetails.getSubmit_date());
            }

            if (project.getStart_date() != projectDetails.getStart_date()){
                project.setStart_date(project.getStart_date());
            }

            if (project.getEnd_date() != projectDetails.getEnd_date()){
                project.setEnd_date(project.getEnd_date());
            }


        return projectRepository.save(project);
    }
}
