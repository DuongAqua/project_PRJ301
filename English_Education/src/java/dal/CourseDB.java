/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import model.Course;
import model.Schedule;
import model.Teacher;

/**
 *
 * @author Admin
 */
public class CourseDB extends DBContext {

    public static void main(String[] args) {
        CourseDB courseDB = new CourseDB();
        System.out.println("" + courseDB.getCourses().get(0).getTeacher().getImg());
    }

    public ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        try {

            String sql = "select c.*,s.[start], s.[end],\n"
                    + "teachername = t.[name], teacherposition =t.position,teachergender = t.gender, teacherimg = t.img , teacherinstruction = t.instruction, teacherachievement = t.achievement ,\n"
                    + "numOfStudent = count (distinct l.studentId)\n"
                    + "from Course c left join Schedule s on c.schedule = s.id\n"
                    + "left join Teacher t on c.teacherId = t.id\n"
                    + "left join Learn l on l.courseId = c.id\n"
                    + "group by c.id,c.[name], c.lesson, c.img, c.price, c.[week], c.instruction, c.[description], c.schedule, c.teacherId,\n"
                    + "s.[start], s.[end], \n"
                    + " t.[name], t.position, t.instruction, t.achievement , t.gender, t.img";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setInstruction(rs.getString("instruction"));
                c.setDescription(rs.getString("description"));
                c.setLesson(rs.getInt("lesson"));
                c.setWeek(rs.getInt("week"));
                c.setImg(rs.getString("img"));
                c.setPrice(rs.getDouble("price"));
                c.setNumOfStudent(rs.getInt("numOfStudent"));

                Schedule s = new Schedule();
                s.setId(rs.getInt("schedule"));
                s.setStart(Time.valueOf(rs.getString("start")));
                s.setEnd(Time.valueOf(rs.getString("end")));
                c.setSchedule(s);

                Teacher t = new Teacher();
                t.setId(rs.getInt("teacherid"));
                t.setName(rs.getString("teachername"));
                t.setPosition(rs.getString("teacherposition"));
                t.setGender(rs.getBoolean("teachergender"));
                t.setImg(rs.getString("teacherimg"));
                t.setInstruction(rs.getString("teacherinstruction"));
                t.setAchievement("teacherachievement");
                c.setTeacher(t);
                
                courses.add(c);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return courses;
    }

    public Course getCourse(String id) {
       
        try {

            String sql = " select c.*, s.[start], s.[end],\n"
                    + "teachername = t.[name], teacherposition =t.position,teachergender = t.gender, teacherimg = t.img , teacherinstruction = t.instruction, teacherachievement = t.achievement ,\n"
                    + "numOfStudent = count (distinct l.studentId)\n"
                    + "from Course c left join Schedule s on c.schedule = s.id\n"
                    + "left join Teacher t on c.teacherId = t.id\n"
                    + "left join Learn l on l.courseId = c.id\n"
                    + "where c.id = ?\n"
                    + "group by c.id,c.[name], c.lesson, c.img, c.price, c.[week], c.instruction, c.[description], c.schedule, c.teacherId,\n"
                    + "s.[start], s.[end], \n"
                    + " t.[name], t.position, t.instruction, t.achievement , t.gender, t.img";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(id));
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setInstruction(rs.getString("instruction"));
                c.setDescription(rs.getString("description"));
                c.setLesson(rs.getInt("lesson"));
                c.setWeek(rs.getInt("week"));
                c.setImg(rs.getString("img"));
                c.setPrice(rs.getDouble("price"));
                c.setNumOfStudent(rs.getInt("numOfStudent"));

                Schedule s = new Schedule();
                s.setId(rs.getInt("schedule"));
                s.setStart(Time.valueOf(rs.getString("start")));
                s.setEnd(Time.valueOf(rs.getString("end")));
                c.setSchedule(s);

                Teacher t = new Teacher();
                t.setId(rs.getInt("teacherid"));
                t.setName(rs.getString("teachername"));
                t.setPosition(rs.getString("teacherposition"));
                t.setGender(rs.getBoolean("teachergender"));
                t.setImg(rs.getString("teacherimg"));
                t.setInstruction(rs.getString("teacherinstruction"));
                t.setAchievement("teacherachievement");
                c.setTeacher(t);
                
                return c;
                
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
