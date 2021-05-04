package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controller.Event;

public class TeacherInterface extends JPanel {

	private static final long serialVersionUID = 1L;
	private MenuTeacher menu;
	private PanelInfoTeacher info;

	public TeacherInterface(ActionListener actionListener) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		menu = new MenuTeacher(actionListener);
		add(menu, BorderLayout.WEST);

		info = new PanelInfoTeacher(actionListener);
		add(info, BorderLayout.CENTER);
	}

	public void changeCardTeacher(String option) {
		info.changeCardTeacher(option);
	}

	public void setComboBoxCourses(String courses) {
		info.setComboBoxCourses(courses);
	}

	public void resertComboBoxCourses() {
		info.resertComboBoxCourses();
	}

	public String getNewCourse() {
		return info.getNewCourse();
	}

	public void enableAddCourse(boolean isEnable) {
		menu.enableAddCourse(isEnable);
	}

	public void changeColorMenuBtn(Event event) {
		menu.changeColorMenuBtn(event);
	}

	public void setVisibleConfirmDelete(boolean isVisible) {
		info.setVisibleConfirmDelete(isVisible);
	}

	public void setVisibleDeleteCourse(boolean isVisible) {
		info.setVisibleDeleteCourse(isVisible);
	}

	public String getDeleteCourse() {
		return info.getDeleteCourse();
	}

	public boolean getSelectedItemsCourse() {
		return info.getSelectedItemsCourse();
	}

	public void setEditBtnDeleteCourse(boolean isEditable) {
		info.setEditBtnDeleteCourse(isEditable);
	}

	public void setComboBoxDeleteCourses(String[] split) {
		info.setComboBoxDeleteCourses(split);
	}

	public void resetComboDeleteCourses() {
		info.resetComboDeleteCourses();
	}

	public void removeSpecificCourse(String deleteCourse) {
		info.removeSpecificCourse(deleteCourse);
	}

	public void setNameUser(String name) {
		info.setNameUser(name);
	}

	public void showConfirmCourse(boolean b) {
		info.showConfirmCourse(b);
	}

	public void addScheduleToField() {
		info.addScheduleToField();
	}

	public void showModifyCourse(boolean b) {
		info.showModifyCourse(b);
	}

	public String getCourseModify() {
		return info.getCourseModify();
	}

	public void setDataModify(String dataModify) {
		info.setDataModify(dataModify);
	}

	public void clearScheduleModify() {
		info.clearScheduleModify();
	}

	public String getModifyCourse() {
		return info.getModifyCourse();
	}
}
