package com.zjt.web;

import com.github.pagehelper.PageHelper;
import com.zjt.entity.*;
import com.zjt.mapper.ProjectImplementersMapper;
import com.zjt.model.JqgridBean;
import com.zjt.model.PageRusult;
import com.zjt.service.*;
import net.minidev.json.JSONArray;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 后台管理用户Controller
         *
         * @author zjt
        */
@Controller
@RequestMapping("/admin/project")
public class ProjectAdminController {

    @Resource
    private ProjectService projectService;

    @Resource
    private TuserService tuserService;

    @Resource
    private ProjectImplementersService projectImplementersService;

    @RequestMapping("/toList")
    @RequiresPermissions(value = {"项目列表"})
    public String tousermanage() {
        return "power/project";
    }

    /**
     * 分页查询项目信息
     */
    @ResponseBody
    @RequestMapping(value = "/list")
    @RequiresPermissions(value = {"项目管理","项目列表"})
    public Map<String, Object> list(JqgridBean jqgridbean
    ) throws Exception {
        LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();

        Example projectExample = new Example(Project.class);

        PageHelper.startPage(jqgridbean.getPage(), jqgridbean.getLength());
        List<Project> projectList = projectService.selectByExample(projectExample);
        PageRusult<Project> pageRusult =new PageRusult<Project>(projectList);


        resultmap.put("currpage", String.valueOf(pageRusult.getPageNum()));
        resultmap.put("totalpages", String.valueOf(pageRusult.getPages()));
        resultmap.put("totalrecords", String.valueOf(pageRusult.getTotal()));
        resultmap.put("datamap", projectList);

        return resultmap;
    }

    @ResponseBody
    @RequestMapping(value = "/addProject")
    @RequiresPermissions(value = {"项目管理"})
    public Map<String, Object> addProject(Project project) {
        LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();
        try {
            if (project.getProjectId() == null) {//新建
                //首先判断项目名是否可用
                Example projectExample = new Example(Project.class);
                projectExample.or().andEqualTo("projectName",project.getProjectName());
                List<Project> projectList = projectService.selectByExample(projectExample);
                if (projectList != null && projectList.size() > 0) {
                    resultmap.put("state", "fail");
                    resultmap.put("mesg", "当前项目名已存在");
                    return resultmap;
                }
                project.setProjectAddtime(LocalDateTime.now()+"");
                projectService.saveNotNull(project);
            } else {//编辑
                Project oldObject = projectService.selectByKey(project.getProjectId());
                if (oldObject == null) {
                    resultmap.put("state", "fail");
                    resultmap.put("mesg", "当前项目名不存在");
                    return resultmap;
                } else {
                    project.setProjectUpdatetime(LocalDateTime.now()+"");
                    projectService.updateNotNull(project);
                }
            }
            resultmap.put("state", "success");
            resultmap.put("mesg", "操作成功");
            return resultmap;
        } catch (Exception e) {
            e.printStackTrace();
            resultmap.put("state", "fail");
            resultmap.put("mesg", "操作失败，系统异常");
            return resultmap;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/selecProjectById")
    @RequiresPermissions(value = {"项目管理"})
    public Map<String, Object> selecProjectById(Project project) {
        LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();
        try {
            if (project.getProjectId() != null && !project.getProjectId().equals(0)) {
                project = projectService.selectByKey(project.getProjectId());
                if (project == null) {
                    resultmap.put("state", "fail");
                    resultmap.put("mesg", "无法找到该记录");
                    return resultmap;
                }
            } else {
                resultmap.put("state", "fail");
                resultmap.put("mesg", "无法找到该记录的id");
                return resultmap;
            }

            resultmap.put("project", project);
            resultmap.put("state", "success");
            resultmap.put("mesg", "获取成功");
            return resultmap;
        } catch (Exception e) {
            e.printStackTrace();
            resultmap.put("state", "fail");
            resultmap.put("mesg", "获取失败，系统异常");
            return resultmap;
        }
    }



    @ResponseBody
    @RequestMapping(value = "/deleteProject")
    @RequiresPermissions(value = {"项目管理"})
    public Map<String, Object> deleteProject(Project project) {
        LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();
        try {
            if (project.getProjectId() != null && !project.getProjectId().equals(0)) {
                project = projectService.selectByKey(project.getProjectId());
                if (project == null) {
                    resultmap.put("state", "fail");
                    resultmap.put("mesg", "删除失败,无法找到该记录");
                    return resultmap;
                } else {
                    projectService.delete(project.getProjectId());
                }
            } else {
                resultmap.put("state", "fail");
                resultmap.put("mesg", "删除失败");
            }


            resultmap.put("state", "success");
            resultmap.put("mesg", "删除成功");
            return resultmap;
        } catch (Exception e) {
            e.printStackTrace();
            resultmap.put("state", "fail");
            resultmap.put("mesg", "删除失败，系统异常");
            return resultmap;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/selecImplementer")
    @RequiresPermissions(value = {"项目管理"})
    public Map<String, Object> selecImplementer(ProjectImplementers projectImplementers) {
        LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();

        List<Tuser> userList = tuserService.selectAllImUser(projectImplementers.getImProjectId());
        resultmap.put("userList", userList);

        try {
            if (projectImplementers.getImProjectId() != null && !projectImplementers.getImProjectId().equals(0)) {
            List  implementer = projectImplementersService.selecImplementerById(projectImplementers.getImProjectId());
                if (implementer == null) {
                    resultmap.put("state", "fail");
                    resultmap.put("mesg", "无法找到该记录");
                    return resultmap;
                }
                resultmap.put("implementer", implementer);
            } else {
                resultmap.put("state", "fail");
                resultmap.put("mesg", "无法找到该记录的id");
                return resultmap;
            }
            resultmap.put("state", "success");
            resultmap.put("mesg", "获取成功");
            return resultmap;
        } catch (Exception e) {
            e.printStackTrace();
            resultmap.put("state", "fail");
            resultmap.put("mesg", "获取失败，系统异常");
            return resultmap;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/delImpl")
    @RequiresPermissions(value = {"项目管理"})
    public Map<String, Object> delImpl(ProjectImplementers projectImplementers) {
        LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();
        try {
            if(projectImplementers.getImId()!=null&&!projectImplementers.getImId().equals(0)){
                ProjectImplementers projectImplementer=projectImplementersService.selectByKey(projectImplementers.getImId());
                if(projectImplementer==null){
                    resultmap.put("state", "fail");
                    resultmap.put("mesg", "删除失败,无法找到该记录");
                    return resultmap;
                }else{
                    projectImplementersService.delete(projectImplementers.getImId());
                }
            }else{
                resultmap.put("state", "fail");
                resultmap.put("mesg", "删除失败");
            }
            resultmap.put("state", "success");
            resultmap.put("mesg", "删除成功");
            return resultmap;
        } catch (Exception e) {
            e.printStackTrace();
            resultmap.put("state", "fail");
            resultmap.put("mesg", "删除失败，系统异常");
            return resultmap;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/addImpl")
    @RequiresPermissions(value = {"项目管理"})
    public Map<String, Object> addupdateuser(ProjectImplementers projectImplementers) {
        LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();
        try {
            projectImplementersService.saveNotNull(projectImplementers);
            resultmap.put("state", "success");
            resultmap.put("mesg", "操作成功");
            return resultmap;
        } catch (Exception e) {
            e.printStackTrace();
            resultmap.put("state", "fail");
            resultmap.put("mesg", "操作失败，系统异常");
            return resultmap;
        }
    }
}
