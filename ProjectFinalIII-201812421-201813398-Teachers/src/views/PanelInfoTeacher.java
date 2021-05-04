package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelInfoTeacher extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel welcome;
	private JPanel welcomePanel, containerWelcome;
	private AddCoursePanel addCourse;
	private ModifyCoursePanel modifyCourse;
	private DeleteCourse deleteCourse;
	private JCardsPanel cards;

	public PanelInfoTeacher(ActionListener actionListener) {
		setBackground(Color.WHITE);
		cards = new JCardsPanel(actionListener);
		initWelcomePanel();
		initCards(actionListener);
	}

	private void initCards(ActionListener actionListener) {
		addCourse = new AddCoursePanel(actionListener);
		cards.add(addCourse, ConstantsGUI.ADD_COURSE_TEXT_CARDLAYOUT);

		modifyCourse = new ModifyCoursePanel(actionListener);
		cards.add(modifyCourse, ConstantsGUI.MODIFY_COURSE_TEXT_CARDLAYOUT);

		deleteCourse = new DeleteCourse(actionListener);
		cards.add(deleteCourse, ConstantsGUI.DELETE_COURSE_TEXT_CARDLAYOUT);

		add(cards);
	}

	private void initWelcomePanel() {
		containerWelcome = new JPanel(new BorderLayout());
		containerWelcome.setBackground(ConstantsGUI.DARK_BLUE);

		welcomePanel = new JPanel(new GridLayout(1, 2));
		welcomePanel.setBackground(ConstantsGUI.DARK_BLUE);
		JLabel img = new JLabel(new ImageIcon(getClass().getResource(ConstantsGUI.PATH_APP_ICON)));
		welcomePanel.add(img);

		welcome = new JLabel(ConstantsGUI.WELCOME_MESSAGE);
		welcome.setFont(ConstantsGUI.DEFAULT_FONT_WELCOME_MESSAGE);
		welcome.setForeground(Color.WHITE);
		welcomePanel.add(welcome);

		containerWelcome.add(welcomePanel, BorderLayout.CENTER);
		cards.add(containerWelcome);
	}

	public void changeCardTeacher(String nameCard) {
		cards.changeCardLayout(nameCard);
	}

	public void setComboBoxCourses(String courses) {
		addCourse.setComboBoxCourses(courses);
		modifyCourse.setComboBoxCourses(courses);
	}

	public void resertComboBoxCourses() {
		addCourse.resetComboBoxCourses();
		modifyCourse.resetComboBoxCourses();
	}

	public String getNewCourse() {
		return addCourse.getNewCourse();
	}

	public void setVisibleConfirmDelete(boolean isVisible) {
		deleteCourse.setVisibleConfirmDelete(isVisible);
	}

	public void setVisibleDeleteCourse(boolean isVisible) {
		deleteCourse.setVisibleDeleteCourse(isVisible);
	}

	public String getDeleteCourse() {
		return deleteCourse.getDeleteCourse();
	}

	public boolean getSelectedItemsCourse() {
		return deleteCourse.getSelectedItemsCourse();
	}

	public void setEditBtnDeleteCourse(boolean isEditable) {
		deleteCourse.setEditBtnDeleteCourse(isEditable);
	}

	public void setComboBoxDeleteCourses(String[] split) {
		deleteCourse.setComboBoxDeleteCourses(split);
	}

	public void resetComboDeleteCourses() {
		deleteCourse.resetComboDeleteCourses();
	}

	public void removeSpecificCourse(String deleteCourses) {
		deleteCourse.removeSpecificCourse(deleteCourses);
	}

	public void setNameUser(String name) {
		JLabel nameLabel = new JLabel(name);
		nameLabel.setFont(ConstantsGUI.DEFAULT_FONT_USER_WELCOME);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBorder(ConstantsGUI.BORDER_NAME_LABEL_USER_WELCOME);
		containerWelcome.add(nameLabel, BorderLayout.SOUTH);
	}

	public void showConfirmCourse(boolean b) {
		addCourse.showConfirmCourse(b);
	}

	public void addScheduleToField() {
		addCourse.addScheduleToField();
		modifyCourse.addScheduleToField();
	}

	public void showModifyCourse(boolean b) {
		modifyCourse.showModifyCourse(b);
	}

	public String getCourseModify() {
		return modifyCourse.getCourseModify();
	}

	public void setDataModify(String dataModify) {
		modifyCourse.setDataModify(dataModify);
	}

	public void clearScheduleModify() {
		addCourse.clearScheduleModify();
		modifyCourse.clearScheduleModify();
	}

	public String getModifyCourse() {
		return modifyCourse.getModifyCourse();
	}
}