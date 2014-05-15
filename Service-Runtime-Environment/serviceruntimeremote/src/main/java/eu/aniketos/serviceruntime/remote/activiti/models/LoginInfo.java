package eu.aniketos.serviceruntime.remote.activiti.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginInfo {
    public String userId;
    public String password;
}
