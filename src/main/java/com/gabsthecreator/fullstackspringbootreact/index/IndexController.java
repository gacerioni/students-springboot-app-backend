package com.gabsthecreator.fullstackspringbootreact.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    BuildProperties buildProperties;

    @RequestMapping("/")
    public String index() {

        return "<html>\n" + "<header><title>Gabs Bootcamp App</title>" +
                "<style>" +
                "table {\n" +
                "  font-family: arial, sans-serif;\n" +
                "  border-collapse: collapse;\n" +
                "  width: 100%;\n" +
                "}" +
                "td, th {\n" +
                "  border: 1px solid #dddddd;\n" +
                "  text-align: left;\n" +
                "  padding: 8px;\n" +
                "}" +
                "tr:nth-child(even) {\n" +
                "  background-color: #dddddd;\n" +
                "}" +
                "</style>" +
                "</header>\n" +
                "<body>\n" + "<h1>Hello, there!</h1><h2>Spring Boot App by Gabs!</h2>" +
                "<h3>App Metadata</h3>" +
                "<table>\n" +
                "  <tr>\n" +
                "    <th>Metadata</th>\n" +
                "    <th>Current Value</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>App Name</td>\n" +
                "    <td>" + buildProperties.getName() + "</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>App Version</td>\n" +
                "    <td>" + buildProperties.getVersion() + "</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>App Package</td>\n" +
                "    <td>" + buildProperties.getGroup() + "</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>API Endpoint</td>\n" +
                "    <td>/api/v1/students</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Health Endpoint</td>\n" +
                "    <td>/actuator/health</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Metrics Endpoint (Prometheus)</td>\n" +
                "    <td>/actuator/metrics</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Maintainer</td>\n" +
                "    <td>Gabriel Cerioni - <a href=https://www.linkedin.com/in/gabrielcerioni/ target=_blank>LinkedIn</a></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>GitHub Repo</td>\n" +
                "    <td><a href=https://github.com/gacerioni/students-springboot-app-backend target=_blank>students-springboot-app-backend</a></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>CRUD Front End - REACT</td>\n" +
                "    <td><a href=http://gabsdemostudents.harnesscse.com/ target=_blank>gabsdemostudents.harnesscse.com</a></td>\n" +
                "  </tr>\n" +
                "</table>" +
                "</body>\n" + "</html>";
    }
}
