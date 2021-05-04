package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.Event;

public class JWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private JCardsPanel cards;
	private LoginPanel login;
	private TeacherInterface teacher;

	public JWindow(ActionListener actionListener) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(ConstantsGUI.TITLE_WINDOW);
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.PATH_APP_ICON)).getImage());
		setVisible(true);
		initWindow(actionListener);
	}

	private void initWindow(ActionListener actionListener) {
		cards = new JCardsPanel(actionListener);
		add(cards);

		login = new LoginPanel(actionListener);
		cards.add(login, ConstantsGUI.LOGIN_TEXT_CARDLAYOUT);

		teacher = new TeacherInterface(actionListener);
		cards.add(teacher, ConstantsGUI.STUDENT_TEXT_CARDLAYOUT);
	}

	public void changeCard(String nameCard) {
		cards.changeCardLayout(nameCard);
	}

	public void hidePassword() {
		login.hidePassword();
	}

	public void loginAccount() {
		login.loginAccount();
	}

	public String getLoginData() {
		return login.getLoginData();
	}

	public void resetLogin() {
		login.resetLogin();
	}

	public void changeCardStudent(String option) {
		teacher.changeCardStudent(option);
	}

	public void resertComboBoxCourses() {
		teacher.resertComboBoxCourses();
	}

	public boolean isCreate() {
		return login.isCreate();
	}

	public void setComboBoxCourses(String courses) {
		teacher.setComboBoxCourses(courses);
	}

	public String getNewCourse() {
		return teacher.getNewCourse();
	}

	public void enableAddCourse(boolean isEnable) {
		teacher.enableAddCourse(isEnable);
	}

	public void changeColorMenuBtn(Event event) {
		teacher.changeColorMenuBtn(event);
	}

	public void resetComboDeleteHomeCourses() {
		teacher.resetComboDeleteHomeCourses();
	}

	public void setVisibleConfirmDelete(boolean isVisible) {
		teacher.setVisibleConfirmDelete(isVisible);
	}

	public void setVisibleDeleteCourse(boolean isVisible) {
		teacher.setVisibleDeleteCourse(isVisible);
	}

	public void setVisibleDeleteHomework(boolean isVisible) {
		teacher.setVisibleDeleteHomework(isVisible);
	}

	public String getDeleteHomework() {
		return teacher.getDeleteHomework();
	}

	public String getDeleteCourse() {
		return teacher.getDeleteCourse();
	}

	public boolean getSelectedItemsCourse() {
		return teacher.getSelectedItemsCourse();
	}

	public void setEditBtnDeleteCourse(boolean isEditable) {
		teacher.setEditBtnDeleteCourse(isEditable);
	}

	public void setComboBoxDeleteCourses(String[] split) {
		teacher.setComboBoxDeleteCourses(split);
	}

	public void setComboBoxDeleteHomeworks(String[] homeworks) {
		teacher.setComboBoxDeleteHomeworks(homeworks);
	}

	public void resetFindHomework() {
		teacher.resetFindHomework();
	}

	public void resetComboDeleteCourses() {
		teacher.resetComboDeleteCourses();
	}

	public void removeSpecificCourse(String deleteCourse) {
		teacher.removeSpecificCourse(deleteCourse);
	}

	public void removeSpecificHomework(String deleteHomework) {
		teacher.removeSpecificHomework(deleteHomework);
	}

	public boolean getItemsDeleteHomework() {
		return teacher.getItemsDeleteHomework();
	}

	public void setEditBtnDeleteHomework(boolean isEditable) {
		teacher.setEditBtnDeleteHomework(isEditable);
	}

	public void setNameUser(String name) {
		teacher.setNameUser(name);
	}

	public void showConfirmCourse(boolean b) {
		teacher.showConfirmCourse(b);
	}

	public void addScheduleToField() {
		teacher.addScheduleToField();
	}

	public void showModifyCourse(boolean b) {
		teacher.showModifyCourse(b);
	}

	public String getCourseModify() {
		return teacher.getCourseModify();
	}

	public void setDataModify(String dataModify) {
		teacher.setDataModify(dataModify);
	}

	public void clearScheduleModify() {
		teacher.clearScheduleModify();
	}

	public String getModifyCourse() {
		return teacher.getModifyCourse();
	}
}