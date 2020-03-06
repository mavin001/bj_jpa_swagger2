package com.bjblackhole.bj_jpa_swagger2.controller;

import com.bjblackhole.bj_jpa_swagger2.entity.StudentEntity;
import com.bjblackhole.bj_jpa_swagger2.model.ResultMap;
import com.bjblackhole.bj_jpa_swagger2.service.ClassService;
import com.bjblackhole.bj_jpa_swagger2.service.StudentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:StudentController
 * Package:com.bjblackhole.bj_jpa_swagger2.controller
 * Description:
 *
 * @Date:2020/03/04 0004 17:06
 * @Author:mavin001@163.com
 */
@Api(value = "student-controller", description = "学生管理")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    ClassService classService;

    @ApiOperation(value = "根据学生主键id查询学生", httpMethod = "POST")
    @ApiImplicitParam(paramType = "query", name = "studentId", value = "学生主键id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求已成功！（是否查询出数据还需自行判断）"),
            @ApiResponse(code = 500, message = "服务内部出错"),
            @ApiResponse(code = 404, message = "访问路径出错")
    })
    @PostMapping("/query")
    public ResultMap query(@RequestParam(value = "studentId") Long studentId) {
        ResultMap resultMap = ResultMap.error();
        try {
            resultMap = ResultMap.successData(studentService.selectOneByStudentId(studentId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    @ApiOperation(value = "添加学生信息", httpMethod = "POST")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求已成功！（是否查询出数据还需自行判断）"),
            @ApiResponse(code = 500, message = "服务内部出错"),
            @ApiResponse(code = 404, message = "访问路径出错")
    })
    @PostMapping("/add")
    public ResultMap add(@RequestBody StudentEntity studentEntity) {
        ResultMap resultMap = ResultMap.error();
        try {
            Boolean flag = studentService.add(studentEntity);
            if (flag) {
                resultMap = ResultMap.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    @ApiOperation(value = "根据学生主键id删除学生", httpMethod = "POST")
    @ApiImplicitParam(paramType = "query", name = "studentId", value = "学生主键id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求已成功！（是否查询出数据还需自行判断）"),
            @ApiResponse(code = 500, message = "服务内部出错"),
            @ApiResponse(code = 404, message = "访问路径出错")
    })
    @PostMapping("/delete")
    public ResultMap deleteStudent(@RequestParam(value = "studentId") Long studentId) {
        ResultMap resultMap = ResultMap.error();
        try {
            Boolean flag = studentService.deleteByStudentId(studentId);
            if (flag) {
                resultMap = ResultMap.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    @ApiOperation(value = "根据学生主键id查询学生班级", httpMethod = "POST")
    @ApiImplicitParam(paramType = "query", name = "studentId", value = "学生主键id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求已成功！（是否查询出数据还需自行判断）"),
            @ApiResponse(code = 500, message = "服务内部出错"),
            @ApiResponse(code = 404, message = "访问路径出错")
    })
    @PostMapping("/queryClassName")
    public ResultMap queryClassName(@RequestParam(value = "studentId") Long studentId) {
        ResultMap resultMap = ResultMap.error();
        try {
            System.out.println(studentId+"------------controller");
            resultMap = ResultMap.successData(studentService.selectClassNameByStudentId(studentId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }
}
