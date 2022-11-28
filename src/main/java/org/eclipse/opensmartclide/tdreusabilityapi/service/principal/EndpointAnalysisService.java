package org.eclipse.opensmartclide.tdreusabilityapi.service.principal;

import org.eclipse.opensmartclide.tdreusabilityapi.controller.principal.entity.RequestBodyEndpoints;
import org.eclipse.opensmartclide.tdreusabilityapi.controller.principal.entity.RequestBodyEndpointsManual;
import org.eclipse.opensmartclide.tdreusabilityapi.domain.principal.Issue;
import org.eclipse.opensmartclide.tdreusabilityapi.domain.principal.Report;
import org.eclipse.opensmartclide.tdreusabilityapi.service.principal.analysis.Git;
import org.eclipse.opensmartclide.tdreusabilityapi.service.principal.analysis.LocalAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class EndpointAnalysisService {

    @Value("${org.eclipse.opensmartclide.sonarqube.url}")
    private String sonarQubeUrl;

    @Autowired
    private AnalysisService analysisService;

    public List<Report> getEndpointMetricsPrivateManual(RequestBodyEndpointsManual requestBodyEndpoints) {
        try {
            String projectKey= requestBodyEndpoints.getSonarQubeProjectKey();

            // Git Clone
            Git gitProject = new Git(requestBodyEndpoints.getGitUrl(), requestBodyEndpoints.getGitToken());
            gitProject.cloneGit();

            // Start new Local Analysis
            LocalAnalysis localAnalysis = new LocalAnalysis();

            // Get All Java Files
            System.out.println("Get all files");
            localAnalysis.getAllFiles(new File(gitProject.getLocalPath()));

            // Get Mappings
            System.out.println("Get all endpoints");
            try {
                localAnalysis.getGivenEndpointsFromAllFiles(requestBodyEndpoints.getRequestBodyEachEndpointList());
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Get Report
            List<Issue> allIssues = analysisService.getIssues(projectKey);
            List<Report> reportList= localAnalysis.getAllReportForAllEndpoints(gitProject.getLocalPath(), projectKey, allIssues);

            //delete clone
            FileSystemUtils.deleteRecursively(new File(gitProject.getLocalPath()));

            return reportList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Report> getEndpointMetricsPrivateAuto(RequestBodyEndpoints requestBodyEndpoints) {
        try {
            String projectKey= requestBodyEndpoints.getSonarQubeProjectKey();

            // Git Clone
            Git gitProject = new Git(requestBodyEndpoints.getGitUrl(), requestBodyEndpoints.getGitToken());
            gitProject.cloneGit();

            // Start new Local Analysis
            LocalAnalysis localAnalysis = new LocalAnalysis();

            // Get Mappings
            System.out.println("Get all endpoints");
            try {
                localAnalysis.getMappingsFromAllFiles(new File(gitProject.getLocalPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Get Report
            List<Issue> allIssues = analysisService.getIssues(projectKey);
            List<Report> reportList= localAnalysis.getAllReportForAllEndpoints(gitProject.getLocalPath(), projectKey, allIssues);

            //delete clone
            FileSystemUtils.deleteRecursively(new File(gitProject.getLocalPath()));

            return  reportList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
