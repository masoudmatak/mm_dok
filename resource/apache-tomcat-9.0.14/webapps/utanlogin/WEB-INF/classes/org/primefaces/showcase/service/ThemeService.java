/*
Owner and programmer: Masoud Mohammadi 2019
Copywrite is limited and it is only the owner of the program code
can allow the use of it in a system if legal overcoming occurs. 
All rights are reserved for the owner of the code.
This is part of a system design and implementation of this 
Document Management System is based on a particular application area. 
This implementation is based on observation of the use in certain industries. 
In the case of copyright infringement, the owner is entitled to legal 
action and will require legal action through court.
*/

package org.primefaces.showcase.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.showcase.domain.Theme;

@ManagedBean(name="themeService", eager = true)
@ApplicationScoped
public class ThemeService {
    
    private List<Theme> themes;
    
    @PostConstruct
    public void init() {
        themes = new ArrayList<>();
        themes.add(new Theme(0, "Nova-Light", "nova-light"));
        themes.add(new Theme(1, "Nova-Dark", "nova-dark"));
        themes.add(new Theme(2, "Nova-Colored", "nova-colored"));
        themes.add(new Theme(3, "Luna-Blue", "luna-blue"));
        themes.add(new Theme(4, "Luna-Amber", "luna-amber"));
        themes.add(new Theme(5, "Luna-Green", "luna-green"));
        themes.add(new Theme(6, "Luna-Pink", "luna-pink"));
        themes.add(new Theme(7, "Omega", "omega"));
    }
    
    public List<Theme> getThemes() {
        return themes;
    } 
}
